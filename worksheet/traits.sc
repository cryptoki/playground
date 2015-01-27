import java.util

trait ForEachAble[A] {
  def iterator: java.util.Iterator[A]

  def forEach(f: A => Unit) = {
    var iter = iterator
    while(iter.hasNext) {
      f(iter.next())
    }
  }
}

val list = new util.ArrayList[Int]() with ForEachAble[Int]
list.add(1)
list.add(2)

list.forEach(println)


trait JsonAble {
  def toJson() = {
    """{
      | "mock": "json"
      | }
    """.stripMargin
  }
}

val list2 = new util.ArrayList[Int]() with JsonAble
list2.toJson()