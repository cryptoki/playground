package workshop.projecteuler

import org.scalatest.FlatSpec

/**
 * Created by hoppel on 29.01.15.
 */
class Problem2Test extends FlatSpec {

  "sum fibs less 10" should "be 5" in {
    val count = Problem2.problem2(10)
    assert(count == 10)
  }

  "sum fibs less 4 million" should "be 4613732" in {
    val count = Problem2.problem2(4000000)
    assert(count == 4613732)
  }

}
