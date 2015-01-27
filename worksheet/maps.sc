import scala.collection.mutable

val treasureMap = new mutable.HashMap[Int, String]()
treasureMap += 1 -> "Go to Island"
val tuple = Tuple2(2, "Test")
treasureMap += tuple

treasureMap.update(1, "Irland")
treasureMap.toMap

val romanumeral = Map( 1 -> "I", 2 -> "II", 3 -> "III", 4 -> "IV")
romanumeral(4)

val bla = treasureMap.foreach(a => a._2.toUpperCase)
for (ele <- treasureMap) yield (ele._1 -> ele._2.toUpperCase)