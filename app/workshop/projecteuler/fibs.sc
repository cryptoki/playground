val fibs: Stream[BigInt] =
  BigInt(0) #:: BigInt(1) #:: BigInt(2) #:: fibs


val hallo : BigInt = 1

Range.apply(0,10)

val bla : Stream[Int]=
  0 #:: 1 #:: bla.zip(bla.tail).map(x => {
    println(x)
    x._1 + x._2
  })


bla take 10 foreach println



