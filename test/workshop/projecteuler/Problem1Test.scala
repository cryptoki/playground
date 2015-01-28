package workshop.projecteuler

import org.scalatest.FlatSpec

/**
 * Created by hoppel on 28.01.15.
 */
class Problem1Test extends FlatSpec {

  "sum up range 0 to below 10" should "be 23" in {
    val sum = Problem1.problem1(10)
    assert(sum == 23)
  }

  "sum up range 0 to below 1000" should "be 233168" in {
    val sum = Problem1.problem1(1000)
    assert(sum == 233168)
  }

}
