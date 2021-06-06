package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark.sql.Row

object sparkObj_2305 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val txnsdata = sc.textFile("file:///E:/data/input/txns")

    val mapsplit = txnsdata.map(x => x.split(","))

    val rowrdd = mapsplit.map(x => Row(x(0), x(1), x(2), x(3), x(4), x(5), x(6), x(7), x(8)))

    val filrdd = rowrdd.filter(x => x(0).toString().toInt > 40000)

    println("=============ROW RDD======================")

    filrdd.take(10).foreach(println)

  }

}