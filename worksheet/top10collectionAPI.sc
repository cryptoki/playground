import section10.Section10._

words.head
words.tail.take(5)
words.isEmpty
words.nonEmpty
words.foreach(println)

words.filter(_.nonEmpty).take(5)
words.drop(4).take(5)
words.find(_ == "Scala")
words.exists(_=="type-safe")
words.contains("type-safe")

words.reverse.take(5)
words.takeWhile(_!="Java").contains("Java")
words.zipWithIndex.take(5).find(_._2 == 3)

val lengths = words.map(_.length).take(5)
val listAndLength = words.zip(lengths)
listAndLength.unzip

lengths.sum
lengths.min
lengths.max

words.maxBy(_.length)
words.filter(_.nonEmpty).forall(_.length > 0)
lengths.sorted
words.sortBy(_.length).take(25)
words.partition(_.length >5)
words.length
words.distinct.length
words.toSet.size

words.groupBy(_.length)