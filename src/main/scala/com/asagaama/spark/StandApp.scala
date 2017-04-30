package com.asagaama.spark


import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


/**
  * Created by Amine Sagaama on 30/04/2017.
  */
object StandApp {

  def flatmapExemple(sc: SparkContext) = {
    val liste: List[String] = List(
      "hello World",
      "Coucou",
      "tttt"
    )
    val listCount = liste.map(x => x.size)
    listCount.foreach(x => println(x))

    val ligne = "coucou coucou"
    val listeMots: Array[String] = ligne.split(' ')
    val listDeListeDeMots = liste.map(x => x.split(' '))
    val listeDeMots = listDeListeDeMots.flatMap(x => x)
    listeDeMots.foreach(x => println(x))


    def pair(x: String): Option[String] = if (x.size % 2 == 0) Some(x) else None

    val listeDeMotsDeLongeurPaire = listeDeMots.flatMap(x => if (x.size % 2 == 0) Some(x) else None)
    listeDeMotsDeLongeurPaire.foreach(println)

  }

  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("My App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    flatmapExemple(sc)
  }


}
