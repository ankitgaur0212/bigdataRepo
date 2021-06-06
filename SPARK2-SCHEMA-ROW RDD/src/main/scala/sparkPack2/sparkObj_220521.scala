package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj_220521_schemardd {
  case class columns(category:String,product:String,city:String,state:String,spendby:String)
  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

     val txnsdata = sc.textFile("file:///E:/data/input/txns")
     
     println()
    println()
    println("=========RAW DATA=================")

    txnsdata.take(10).foreach(println)
    
    
    val txnssplit= txnsdata.map(x=>x.split(","))
    
    //val mapsplit = txn.map(x=>x.split(","))
    
    println()
    println()
    println("=========SPLIT  DATA=================")

    txnssplit.take(10).foreach(println)
    
     println("=========Class DATA=================")
     
     val colrdd = txnssplit.map(x=>columns(x(4),x(5),x(6),x(7),x(8)))
     
     
         colrdd.take(10).foreach(println)
         
         
      println("=========Filter DATA=================")
      
      
     val filtdata=colrdd.filter(x=>x.spendby.contains("cash"))
     
     filtdata.take(10).foreach(println)
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}