package lectures.part2oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(imposter)) // returns false

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}

// class parameters are NOT FIELDS
// note that name is a class parameter but it's not a class member that you can access
// to convert a class parameter to a member field: add the val or var keyword for the parameter. eg val age: Int
class Person(name: String, val age: Int = 0) { // constructor

  // body
  val x = 2
  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  // The frustration with auxilary constructors is that the implementation of a secondary constructor has
  // to be another constructor and nothing else. Now this limitation makes the auxiliary constructor is quite
  // impractical because they're only used in practice for default parameters. Which we can already achieve with default values
  // in the primary constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/* Exercise 1

  Novel and a Writer
  Writer: first name, surname, year
    - method fullname
  Novel: name, year of release, author
  - authorAge (at year of release)
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surname: String, val dob: Int) {
  def fullname: String = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge: Int = yearOfRelease - author.dob
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(release: Int): Novel = new Novel(name, release, author)
}

/* Exercise 2

  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Counter(val count: Int = 0) {
  // returning a new instance === immutability
  def increment: Counter = {
    println("Incrementing...")
    new Counter(count + 1)
  }

  def decrement: Counter = {
    println("Decrementing...")
    new Counter(count - 1)
  }

  def increment(n: Int): Counter = {
    if (n <= 0) this
    else {
      increment.increment(n - 1)
    }
  }

  def decrement(n: Int): Counter =  {
    if (n <= 0) this
    else {
      decrement.decrement(n - 1)
    }
  }

  def print = println(count)
}
