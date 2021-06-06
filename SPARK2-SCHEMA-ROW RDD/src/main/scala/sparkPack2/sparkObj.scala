package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val usdata = sc.textFile("file:///E:/data/input/usdata.csv")

    println()
    println()
    println("=========RAW DATA=================")

    usdata.take(10).foreach(println)

    val datafil = usdata.filter(x => x.contains(",LA"))

    println("=========Filter DATA=================")

    datafil.take(10).foreach(println)

    val DataReplace = datafil.map(x => x.replaceAll(",", "~"))
    println("=========Replace DATA=================")

    DataReplace.take(10).foreach(println)

    val FlatMap = DataReplace.flatMap(x => x.split("~"))

    println("=========Flat Data DATA=================")

    FlatMap.take(10).foreach(println)

    val concat = FlatMap.map(x => "zeyo," + x + ",zeyo")

    println("=========concat data=================")

    concat.foreach(println)

    concat.coalesce(1).saveAsTextFile("file:///E:/data/output/usdata")

  }

}