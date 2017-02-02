val i = 10
val j = i+3

import java.util.Date

val date = new Date()


implicit class RichString(s:String) {
  def adds(i:Int): String = {
    s + i
  }
}

val maString = "hello World"
maString.adds(0)

val tuple : (Int, String, Double) = (1, "coucou", 3.5)

val (aa, bb, cc) = (1, "coucou", 3.5)

def f() : (Int, String) = (1, "hello")

val (ii, s) = f()

tuple._2

def carreCube(i:Int): (Int, Int) = {
  (i*i, i*i*i)
}

val (a, b) = carreCube(10)

val map = scala.collection.mutable.Map("key1" -> "value1")

val kv = "key2"-> "value2"

map += kv

