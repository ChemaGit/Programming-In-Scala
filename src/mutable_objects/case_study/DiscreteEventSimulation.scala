package mutable_objects.case_study

/**
 * You'll see the design and implementation of a simulator for digital
 * circuits.
 * We'll present a simple but general framework for discrete event simulation.
 * The idea of such simulations is to model physical objects by simulated objects,
 * and use the simulation framework to model physical time.
 * The various aspects of the example are structured into four software
 * layers: one for the simulation framework, another for the basic circuit simulation
 * package, a third for a library of user-defined circuits, and the last layer
 * for each simulated circuit itself.
 */

/**
 * A language for digital circuits.
 * A digital circuit is built from wires and function boxes. Wires carry signals, 
 * which are transformed by function boxes. Signal are represented by booleans:
 * true for signal-on and false for signal-off. 
 * 	- An inverter, which negates its signal.
 *  - An and gate, which sets its output to the conjunction of its inputs.
 *  - An or-gate, which sets its output to the disjunction of its inputs.
 * These gates are sufficient to build all other function boxes. Gates have 
 * delays, so an output of a gate will change only some time after its inputs change.  
 * 
 * First, there is a class Wire for wires.
 * Second, there are three procedures which "make" the basic gates we need:
 *   - inverter
 *   - andGate
 *   - orGate
 * What's unusual, is that these procedures construct the gates as a side effect, 
 * instead of returning the constructed gates as a result.  
 * More complicated function boxes can be built from the basic gates.
 * For instance, the halfAdder method takes two inputs, a and b, and produces a sum, s, defined
 * by "s = (a + b) % 2" and a carry, c, defined by "c = (a + b) / 2". 
 * You can use the halfAdder to construct more complicated circuits.
 * For instance a fullAdder which takes two inputs,
 * a and b, as well as a carry-in, cin, and which produces a sum output
 * defined by "sum = (a + b + cin) % 2" and a carry-out output defined by
 * "cout = (a + b + cin) / 2".
 */

/**
 * The Simulation API
 * It consists of class Simulation
 */
object DiscreteEventSimulation extends App{
  
  abstract class Simulation {
    //A discrete event simulation performs user-defined actions at specified times.
    type Action = () => Unit
    //An action that needs to be executed at a specified time
    case class WorkItem(time: Int, action: Action)
    
    //The current simulated time is kept in a private variable
    private var curtime: Int = 0
    def currentTime: Int = curtime    
    //The Simulation class keeps an agenda of all remaining work items that have not yet been executed.
    private var agenda: List[WorkItem] = List()
    //The agenda list will be kept in the proper sorted order by the insert method
    private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
      if(ag.isEmpty || item.time < ag.head.time) item :: ag
      else ag.head :: insert(ag.tail, item)
    }
    
    def afterDelay(delay: Int)(block: => Unit) = {
      val item = WorkItem(currentTime + delay, () => block)
      agenda = insert(agenda, item)
    }
    
    /**
     * The next method decomposes the current agenda with a pattern match into
		 * a front item, item, and a remaining list of work items, rest. It removes the
		 * front item from the current agenda, sets the simulated time curtime to the
		 * work item’s time, and executes the work item’s action.
     */
    private def next() = {
      (agenda: @unchecked /*to disable the warning for empty list. That case never happens*/) match {
        case item :: rest =>
          agenda = rest
          curtime = item.time
          item.action()
      }
    }
    /**
     * This method repeatedly takes the first item in the agenda, removes it from
     * the agenda and executes it. It does this until there are no more items left in
     * the agenda to execute.
     */
    def run() = {
      afterDelay(0) {
        println("*** simulation started, time = " + currentTime + " ***")
      }
      while (!agenda.isEmpty) next()
    }
  }
  
  /**
   * Circuit Simulation
   * The circuit DSL consists of a class for wires and methods that create and-gates, orgates, and inverters
   */
  abstract class BasicCircuitSimulation extends Simulation {
    def InverterDelay: Int
    def AndGateDelay: Int
    def OrGateDelay: Int
    
    class Wire {
      private var sigVal = false
      private var actions: List[Action] = List()
      
      def getSignal = sigVal
      
      def setSignal(s: Boolean) =
        if(s != sigVal) {
          sigVal = s
          actions foreach(_ ())
        }
      
      def addAction(a: Action) = {
        actions = a :: actions
        a()
      }
    }
    
    def inverter(input: Wire, output: Wire) = {
      def inverterAction() = {
        val inputSig = input.getSignal
        afterDelay(InverterDelay) {
          output setSignal !inputSig
        }
      }
      input addAction inverterAction
    }
    
    def andGate(a1: Wire, a2: Wire, output: Wire) = {
      def andAction() = {
        val a1Sig = a1.getSignal
        val a2Sig = a2.getSignal
        afterDelay(AndGateDelay) {
          output setSignal (a1Sig & a2Sig)
        }
      }
      a1 addAction andAction
      a2 addAction andAction
    }
    
    def orGate(o1: Wire, o2: Wire, output: Wire) = {
      def orAction() = {
        val o1Sig = o1.getSignal
        val o2Sig = o2.getSignal
        afterDelay(OrGateDelay) {
          output setSignal (o1Sig | o2Sig)
        }
      }
      o1 addAction orAction
      o2 addAction orAction
    }
    
    def probe(name: String, wire: Wire) = {
      def probeAction() = {
        println(name + " " + currentTime + " new-value = " + wire.getSignal)
      }
      wire addAction probeAction
    }
  }
  
  abstract class CircuitSimulation extends BasicCircuitSimulation {
    def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) = {
      val d, e = new Wire
      orGate(a, b, d)
      andGate(a, b, c)
      inverter(c, e) 
      andGate(d, e, s)
    }
    
    def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) = {
      val s, c1, c2 = new Wire
      halfAdder(a, cin, s, c1)
      halfAdder(b, s, sum, c2)
      orGate(c1, c2, cout)
    }
  }
  
  object MySimulation extends CircuitSimulation {
    def InverterDelay = 1
    def AndGateDelay = 3
    def OrGateDelay = 5
  }
  
  import MySimulation._
  val input1, input2, sum, carry = new Wire
  
  probe("sum", sum)
  
  probe("carry", carry)
  
  halfAdder(input1, input2, sum, carry)
  
  input1 setSignal true
  
  run()
  
  input2 setSignal true
  
  run()
  
  /**
   * This chapter brought together two techniques that seem disparate at first:
   * mutable state and higher-order functions. Mutable state was used to simulate
   * physical entities whose state changes over time. Higher-order functions were
   * used in the simulation framework to execute actions at specified points in
   * simulated time. They were also used in the circuit simulations as triggers that
   * associate actions with state changes.
   */  
  
  /**
   * If you feel like staying a bit longer, you might want to try more simulation
   * examples. You can combine half-adders and full-adders to create larger
   * circuits, or design new circuits from the basic gates defined so far and simulate them.
   */  
}