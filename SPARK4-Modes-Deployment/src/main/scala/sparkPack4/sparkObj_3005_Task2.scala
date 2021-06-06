package sparkPack4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj_3005_Task2 {
  
  def main(args:Array[String]):Unit={ 
   val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
   val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")
val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
    
    //val df = spark.read.load("file:///E:/BigData/data/devices.json")
    
    //df.show()
    
    //println("JSON Read successfull")
    
    
    //val df1 = spark.read.load("file:///E:/BigData/data/part_orc.orc")
    
      //df1.show()
    
    //println("ORC Read successfull")
    
    val df2 = spark.read.load("file:///E:/BigData/data/part_par.parquet")
    
      df2.show()
    
    println("PARQUET Read successfull")
    
    //val df3 = spark.read.load("file:///E:/BigData/data/usdata.csv")
    
      //df3.show()
    
    //println("CSV Read successfull")
    
    
    
}}