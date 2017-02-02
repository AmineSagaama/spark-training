/**
  * Created by hayssams on 19/01/2017.
  */

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD


object Hi {

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

  def optionExample(sc: SparkContext) = {
    val x: Option[Int] = None
    // liste de zero element
    val y: Option[Int] = Some(10) //zero de 1 element

    val z: Option[Int] = if (10 / 2 == 3) None else Some(100)
    val t = z.map(x => x * 2)
    z.toString

    val maListe = List(List("hello", "world"), None, List("Coucou"))
  }


  def iris(sc: SparkContext) = {
    val lines: RDD[String] = sc.textFile("/Users/ebiznext/Downloads/iris.csv")
    case class Iris(id: String, sepalLength: Double, sepalWidth: Double, petalLength: Double, petalWidth: Double, espece: String)

    def splitLine(line: String): Array[String] = {
      line.split(',')
    }

    def irisObject(colonnes: Array[String]): Option[Iris] = {
      val id = colonnes(0).replaceAll("\"", "")
      val sepalLength = colonnes(1)
      val sepalWidth = colonnes(2)
      val petalLength = colonnes(3)
      val petalWidth = colonnes(4)
      val espece = colonnes(5).replaceAll("\"", "")

      if (id == "")
        None
      else
        Some(Iris(id, sepalLength.toDouble, sepalWidth.toDouble, petalLength.toDouble, petalWidth.toDouble, espece))
    }

    val okLines = lines.flatMap(x => irisObject(splitLine(x)))
    okLines.foreach(println)

    println(okLines.distinct().count())
    val listEspece = okLines.map(x => x.espece)
    println(listEspece.distinct().count())

    val occEspece = listEspece.countByValue()
    println(occEspece)

    val listPetalLength = okLines.map(x => x.petalLength)
    val sum = listPetalLength.reduce((x,y) => x+y)
    println(sum / okLines.count())
  }

  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("Mon Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    flatmapExemple(sc)
    iris(sc)
  }


}