package workshop.projecteuler

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all
 * the multiples of 3 or 5 below 1000.
 *
 * Created by hoppel on 28.01.15.
 */
object Problem1 {
  def problem1(below: Int) : Int = {
    Range.apply(0, below).filter(x => (x%3 == 0 || x%5 == 0 )).sum
  }
}
