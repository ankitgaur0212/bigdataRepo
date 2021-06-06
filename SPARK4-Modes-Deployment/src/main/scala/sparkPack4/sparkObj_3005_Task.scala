package sparkPack4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj_3005_Task {
  
  
  def main(args:Array[String]):Unit={ 
   val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
  
val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")
val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
    val src = args(0)
    val dest = args(1)
val mode1=args(2)
val writeformat=args(3)
val sourceformat=args(4)

    
    val df_csv = spark.read.format(sourceformat).option("header", "true").load(src)
    
    df_csv.write.format(writeformat).mode(mode1).save(dest)
    
    println("Data write complete")
  }
}