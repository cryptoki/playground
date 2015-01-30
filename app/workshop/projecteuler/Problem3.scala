package workshop.projecteuler

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Created by hoppel on 30.01.15.
 */
object Problem3 {

  def problem3 = {
    Range.apply(1, 100).filter( x => {
      Range.apply(2, x-1).filter( y => x % y == 0).size == 0
    })
  }
}
