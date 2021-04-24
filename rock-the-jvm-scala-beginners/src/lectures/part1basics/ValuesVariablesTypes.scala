package lectures.part1basics

object ValuesVariablesTypes extends  App{

  val x: Int = 42 // compiler infers  types if you don't explicit define tht this is an Int
  println(x)

  // VALS ARE IMMUTABLE
  // x = 2 shows error "Reassignment to val"

  val aString: String = "hello"
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 5273985273895237L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  // VARS ARE MUTABLE
  aVariable = 5 // side effects

}
