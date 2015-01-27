val i = 3

val ergebnis =
i match {
  case 1 => "bla 1"
  case 2 => "bla 2"
  case blafoo => s"blubber $blafoo"
}

ergebnis

val x: Any = 42
x match {
  case i: Int if i == 42 => s"thanks for the fish"
  case i: Int => s"thank for the integer $i"
  case f: Float => s"thanks for the float $f"
  case notRecognized => s"i don't know the type $notRecognized"
}


val cmd = "stop"
val blafoo = cmd match {
  case "start" => "starting"
  case "stop" | "quit" => "stopping"
}
blafoo