package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // each call of the recursive function uses what we call a stack frame.
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }

  println(factorial(10))
  //  println(factorial(5000))
  // if we try to run this recusrively 5000 times we get a StackOverflowError, so how do we overcome this limitation?

  // lets try a new implementation of the above using a new concept - tail recursio n
  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    // basically TAIL RECURSION is when the recursive call is the last line in the function
    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * 3 * 4 * ... * 10)
    = 1 * 2 * 3 * 4 * ... * 10
   */

  println(anotherFactorial(20000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
    1.  Concatenate a string n times
    2.  IsPrime function tail recursive
    3.  Fibonacci function, tail recursive.
   */

  /*
  Below is an example of Tail Recursion (concatenateTailrec) vs Recursion (concatenate)
  concatenate() is not a recursive call because the last line is not concatenate()  (its just String + String where the second string value is the recursive call)
  concatenateTailrec is tail recursive and rather than concatenating the string on the last line like the concatenate function, the state is held in the
  accumulator parameter and the concatenation is performed in the parameter assignment -> concatenateTailrec(aString, n-1, -----> aString + accumulator <-----)

  Since the state is held in the parms you're not going to have a huge call stack to manage each call and state

  ACCUMULATORS NEED TO HAVE THE SAME RETURN TYPE AS THE INTENDED RETURN TYPE OF THE FUNCTION!!!

   */
  @tailrec
  def concatenateTailrec(aString: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aString, n-1, aString + accumulator)

  def concatenate(aString: String, n: Int): String =
    if (n <= 0) aString
    else aString + concatenate(aString, n-1)

  println(concatenateTailrec("hello", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      if(i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}



