import java.util

trait Serializeable {
  def serialize: String
}
trait JsonAble extends Serializeable {
  override def serialize() = {
    """{
      | "mock": "json"
      | }
    """.stripMargin
  }
}
trait BlaAble extends Serializeable {
  override def serialize: String = "bla"
}

trait Bla2Able extends Serializeable {
  // es wird nur einmal geparst -> quasi nur einmal zur compilezeit erstellt
  // => wird für Konstanten verwendet
  val serialize: String = "blubber"
}

val list2 = new util.ArrayList[Int]() with BlaAble with JsonAble
list2.add(1)
// Achtung, durch override kann Bevorzugung klar gemacht werden
// ohne override gibt es einen Compile Fehler
list2.serialize