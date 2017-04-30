package com.asagaama.spark


import org.apache.spark.SparkContext
import org.apache.spark.SparkConf


/**
  * Created by Amine Sagaama on 30/04/2017.
  */
object StandApp {


  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("My App").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val inputFile = "/Users/ebiz/Documents/spark/spark-2.1.0-bin-hadoop2.7/README.md"
    val outputFile = "/Users/ebiz/Documents/spark/test.txt"
    val input = sc.textFile(inputFile)
    val words = input.flatMap(line => line.split(" "))
    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y }
    counts.saveAsTextFile(outputFile)
  }


}
