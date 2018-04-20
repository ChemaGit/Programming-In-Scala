This chapter introduces case classes and pattern matching, twin constructs
that support you when writing regular, non-encapsulated data structures.
These two constructs are particularly helpful for tree-like recursive data.

Case classes are Scala’s way to allow pattern matching on objects without
requiring a large amount of boilerplate. Generally, all you need to do is add
a single case keyword to each class that you want to be pattern matchable.