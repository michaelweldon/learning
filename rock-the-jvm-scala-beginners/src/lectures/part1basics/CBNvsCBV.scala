package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  /*
  So this is what this little funky arrow (=>) does differently.
  It delays the evaluation of the expression passed (System.nanoTime()) as a parameter
  and it's used literally every time it's used in the function definition.
   */
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // System.nanoTime() gets called once and its single returned value is used throughout calledByValue()
  calledByName(System.nanoTime()) // System.nanoTime() gets called as many times as x is used in calledByName(), passed as a literal

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinite(), 34)
  printFirst(34, infinite())

  // TAKEAWAYS
  /*
  Call by value:
    - value is computed before call
    - same value is used everywhere in the function

  -- BY CONTRAST --

  Call by name:
    - expression is passed literally
    - expression is evaluated at every use within the function

   */


}
