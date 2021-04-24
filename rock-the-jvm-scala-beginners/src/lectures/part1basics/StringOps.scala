package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // prints l
  println(str.substring(7, 11)) // prints I am
  println(str.split(" ").toList) // prints List(Hello,, I, am, learning, Scala)
  println(str.startsWith("Hello")) // prints true
  println(str.replace(" ", "-")) // prints Hello,-I-am-learning-Scala
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //  +: -> prepend   :+ -> append
  println(str.reverse)
  println(str.take(2)) // prints he (takes first n characters)

  // Scala-specific: String interpolators.

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting)

  // F-interpolators - act as s"" interpolators only the can also recieve printf like formats
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
