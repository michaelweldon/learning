package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // math expressions
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ..... side effects
  println(aVariable)

  // Instructions (DO SOMETHING) vs Expressions (GIVE A VALUE)
  // Instructions (executed) vs Expressions (evaluated)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }
  // loops are discouraged in scala
  // looping is very specific to imperative programming
  // so ..NEVER USE WHILE LOOPS IN SCALA.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // examples of side effects: println(), whiles, reassigning vars -> expressions returning unit

  // Code blocks

  // code blocks are a special kind of expressions because they have some special properties.

  // code blocks are expressions like everything else in scala
  // the value of the code block is its last expression

  // code blocks can have auxiliary vars/vals/defs declared inside them
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2)  "hello" else "goodbye"
  }

  // 1. what is the difference between "hello world" vs println("hello world")?
  //    - "hello world" === String literal and println("hello world") === expression (returning unit)


  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)

}
