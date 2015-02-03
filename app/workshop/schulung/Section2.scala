package workshop.schulung

import scala.annotation.tailrec
import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object Section2 {

  val toUpperCase = (s: String) => s.toUpperCase

  // Arrays

  def loud(input: Array[String]): Array[String] = input.map(toUpperCasePackage)
  def loud4(input: Array[String]): Array[String] = input.map(toUpperCase)
  def loud3(input: Array[String]): Array[String] = input.map(_.toUpperCase)

  def loud2(input: Array[String]): Array[String] = for (element <- input) yield element.toUpperCase

  def concatenate(input: Array[String]): String = {
    var result = "";
    input.foreach({ (x: String) => result += (x + " ")})
    result.trim
  }

  def concatenate2(input: Array[String]): String = input.mkString(" ")

  // Seq and List

  def loud(input: Seq[String]): Seq[String] = input.map(_.toUpperCase)

  def extractWords2(input: Seq[String]): Seq[String] = {
    val result = new ListBuffer[String]()
    input.map((x: String) => {
      x.split(" ").foreach((a: String) => {
        result += a
      })
    })
    result
  }

  def extractWords3(input: Seq[String]): Seq[String] = {
    val buffer = new ListBuffer[String]()
    for (element <- input; word <- element.split(" ")) {
      buffer += word
    }
    buffer.toSeq
  }

  def extractWords4(input: Seq[String]): Seq[String] = {
    val buffer = new ListBuffer[String]()
    for {
      element <- input
      word <- element.split(" ")
    }
    yield buffer += word
    buffer.toSeq
  }

  def extractWords8(input: Seq[String]): Seq[String] = {
    for {
      element <- input
      word <- element.split(" ")
    }
    yield word
  }

  def extractWords9(input: Seq[String]): Seq[String] = {
    val list : List[String] = Nil
    input.foldLeft(list)((acc, a) => {
      (acc ++ a.split(" "))
    })
  }
  def extractWords(input: Seq[String]): Seq[String] = {
    val list : List[String] = Nil
    (list /: input)(_ ++ _.split(" "))
  }


  def extractWords5(input: Seq[String]): Seq[String] = {
    val bla : Seq[String] = mutable.Seq[String]();

    def loop(input: Seq[String]) : Seq[String] = {
      println(s"loop $input")

      input match {
        case Nil => {
          println( "  -> nil")
          bla
        }
        case head +: tail => {
          println( "  -> add")
          head.split(" ") ++ loop(tail)
        }
      }
    }

    loop(input)
  }

  def extractWords6(input: Seq[String]): Seq[String] = {
    input match {
      case head +: tail => head.split(" ") ++ extractWords6(tail)
      case Nil => List.empty
    }
  }

  def extractWords7(input: Seq[String]): Seq[String] = {
    @tailrec
    def loop(acc: Seq[String], input: Seq[String]) : Seq[String] = {
      println(s"loop $input")
      acc.foreach(println)

      input match {
        case Nil => {
          println( "  -> nil")
          acc
        }
        case head +: tail => {
          println( "  -> add")
          loop(acc ++ head.split(" "), tail)
        }
      }
    }

    val bla = loop(List(), input)
    println("RESULT")
    bla.foreach(println)
    bla
  }

  // Map

  def loud1(input: Map[String, String]): Map[String, String] = input.map(x => x._1.toUpperCase -> x._2.toUpperCase)
  def loud2(input: Map[String, String]): Map[String, String] = {
    for (element <- input)
    yield element._1.toUpperCase -> element._2.toUpperCase
  }
  def loud(input: Map[String, String]): Map[String, String] = {
    for ((key, value) <- input)
    yield key.toUpperCase -> value.toUpperCase
  }

  def counts1(input: Seq[String]): Map[String, Int] = {
    val resultMap = new mutable.HashMap[String, Int]()
    for {
      element <- input
      word : String <- element.split(" ")
    }
    yield
      if (resultMap.contains(word))
        resultMap(word) += 1
      else
        resultMap.+=( word -> 1 )
    resultMap.toMap
  }

  def counts(input: Seq[String]): Map[String, Int] = {
    var result: Map[String, Int] = Map()
    for (word <- extractWords(input)) {
      val count = result.getOrElse(word, 0) + 1
      result += word -> count
    }
    result
  }

  val triedCharacter = mutable.HashMap[Int, Char]()
  def addTriedCharacter(wordId: Int, character: Char): Unit = triedCharacter.+=(wordId -> character)

  def isCharacterAlreadyTried(wordId: Int, character: Char): Boolean = {
    triedCharacter.filter(_._1 == wordId).filter(_._2 == character).nonEmpty
  }


  //  val triedCharacter2 = mutable.Hash
}
