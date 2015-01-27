val greatStrings = new Array[String](3)
greatStrings(0) = "Hello"
greatStrings(1) = ","
greatStrings(2) = "world!"

for (i <- 0 to 2) {
  println(greatStrings(i))
}


1 + 2
1.+(2)

// das gleiche
// -> (xyz) = "" -> bedeutet in Scala eine update Funktion
greatStrings(1) = "blafoo"
greatStrings.update(1, "blafoo")

// das gleiche
greatStrings(2)
greatStrings.apply(2)

// das gleiche
val greatString2 = Array("Hello", ", ", "world!")
val greatString3 = Array.apply("Hello", ", ", "world!")

greatString3 foreach println
