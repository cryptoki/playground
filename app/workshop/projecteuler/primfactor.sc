import scala.annotation.tailrec

Range.apply(1, 100).filter( x => {
  Range.apply(2, x-1).filter( y => x % y == 0).size == 0
})

lazy val prims : Stream[Int] = 1 #:: 2 #:: prims.filter(x => {
  Range.apply(2, x-1).filter( y => x % y == 0).size == 0
}).map( z => z)

prims take 10 foreach println

def smallestFactor(n: Int) = Range(2, math.sqrt(n).toInt).find(n % _ == 0)
val blafoo = smallestFactor(81)


(2 to math.sqrt(81).toInt).find( 81 % _ == 0)


def listOfPrims(maximum: Int) : Stream[Int] = {
  Range(1, maximum).filter( x => {
    Range(2, Math.sqrt(maximum).toInt).filter( y => x%y == 0).size == 0
  }).toStream
}

listOfPrims(100) foreach(println)


def factors(n: Long): List[Long] =
  (2 to math.sqrt(n).toInt).find(n % _ == 0)
    .map(i => i.toLong :: factors(n / i)).getOrElse(List(n))

factors(100000)