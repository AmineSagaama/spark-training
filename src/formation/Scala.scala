package formation

case class Person(name:String, age:Int)


trait MonTrait {
  def f() = println("cookie")
}

class X {
  def g() = println("coucou")
}

object MonApplication {
  def main(args:Array[String]) : Unit = {
    val person = Person("Moi", 10)
    val person2 = person.copy(age=11)
    println(person)
    println(person2)

    val xMontrait = new X with MonTrait

    class Y extends X with MonTrait { override def f() = println("youhu")}
    val yMontrait = new Y
  }
}
