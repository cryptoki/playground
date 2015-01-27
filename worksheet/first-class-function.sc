def square(a:Int) = a*a
def squareWithBlock(a:Int): Int = {
  a*a
}

// first class function
val squareFunction = (a: Int) => a*a
square(2)
squareWithBlock(2)
squareFunction(2)

val rect= (a: Int, b:Int) => a*b

def addOne(f: Int => Int, arg : Int) = f(arg) + 1
addOne(squareFunction, 2)

import scala.reflect.io.File
import java.util.Scanner

val f = File("/etc/pf.os")
val scanner = new Scanner(f.bufferedReader())

def withScanner(f: File, op: Scanner => Unit): Unit = {
  val scanner = new Scanner(f.bufferedReader())
  try {
    op(scanner)
  }
  finally {
    scanner.close()
  }
}

withScanner(File("/etc/pf.os"), {
  scanner => {
    val pid = scanner.next();
    println(s"pid $pid")
  }
})