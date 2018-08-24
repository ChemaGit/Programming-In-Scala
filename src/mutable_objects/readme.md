It is also perfectly possible to define objects with
mutable state in Scala. Such mutable objects often come up naturally when
you want to model objects in the real world that change over time.
This chapter explains what mutable objects are and what Scala provides
in terms of syntax to express them. We will also introduce a larger case
study on discrete event simulation, which involves mutable objects, as well
as building an internal DSL for defining digital circuits to simulate.