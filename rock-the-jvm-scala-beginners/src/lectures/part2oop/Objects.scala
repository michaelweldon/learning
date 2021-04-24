package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (scala does not know the concept of static)
  /* for example class-level functionality in java:
    public class Person { <-- we dont do this in scala, again scala does not know the concept of static
        public static final int N_EYES = 2;
    }
    s.o.p("Eyes: " + Person.N_EYES)
  */

  // scala instead gives us a "static like" functionality using objects
  // objects can be defined in a similar way that classes can with the exception that objects do not receive parameters.

  // when we define the object person we are defining its 'type' but also
  // the types only instance
  object Person {
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    def apply(mother: Person, father: Person, childName: String): Person = new Person(childName)
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // the Person 'object' and the Person 'class' separates the instance-level functionality
  // from the static/class-level functionality
  // This pattern is called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // prints true - both pointing to the same singleton object instance

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // prints false - both pointing to different instances of Person 'class'

  val bobbie = Person(mary, john, "Bobbie") // <-- calls apply method


  // Scala Applications = Scala object with 'def main(args: Array[String]): Unit'
  /*
     Now the method needs to have this exact definition returning unit because all scala applications
     are <<< turned into Java Virtual Machine applications >>> whose entry point has to be public static
     void main with an array of string as a parameter.

     'extends App' gives us the main method for free
   */

  val k = 6.67e-11

}
