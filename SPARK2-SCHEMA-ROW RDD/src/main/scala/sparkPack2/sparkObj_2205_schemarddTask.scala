package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj_2205_schemarddTask1 {

  case class schema(txnno: String, txndate: String, custno: String, amount: String, category: String, product: String, city: String, state: String, spendby: String)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val txnsdata = sc.textFile("file:///E:/data/input/txns")

    println()
    println()
    println("=========RAW DATA=================")

    txnsdata.take(10).foreach(println)

    println("=========SPLIT DATA=================")

    val splitdat = txnsdata.map(x => x.split(","))

    splitdat.take(10).foreach(println)

    println("=========Class DATA=================")

    val classdata = splitdat.map(x => schema(x(0), x(1), x(2), x(3), x(4), x(5), x(6), x(7), x(8)))

    classdata.take(10).foreach(println)

    println("=========Filter DATA=================")

    val Filtdata = classdata.filter(x => x.product.contains("Gymnastics") & x.spendby.contains("cash"))

    Filtdata.foreach(println)

  }
}