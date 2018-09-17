Type parameterization allows you to write generic classes and traits. For
example, sets are generic and take a type parameter: they are defined as
Set[T]. As a result, any particular set instance might be a Set[String],
a Set[Int], etc., but it must be a set of something. Unlike Java, which
allows raw types, Scala requires that you specify type parameters. Variance
defines inheritance relationships of parameterized types, such as whether a
Set[String], for example, is a subtype of Set[AnyRef].

The chapter contains three parts. The first part develops a data structure
for purely functional queues. The second part develops techniques to
hide internal representation details of this structure. The final part explains
variance of type parameters and how it interacts with information hiding.