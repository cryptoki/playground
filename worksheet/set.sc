import scala.collection.mutable.HashSet

val jetSet = HashSet[String]()
val jetSet2 = HashSet("Hello", ", ", "world!")

jetSet += "Hello"
jetSet += ("Boeing", "Airbus")


jetSet.contains("Hello")
jetSet.contains("Cessnar"
)