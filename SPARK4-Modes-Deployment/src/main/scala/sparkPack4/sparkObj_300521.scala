package sparkPack4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj_300521 {
  
  def main(args:Array[String]):Unit={ 
val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")
val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
    
    //val df_csv = spark.read.format("csv").option("header", "true").load("E:/BigData/usdata.csv")
    val df_csv = spark.read.format("csv").option("header", "true").load("file:///home/cloudera/data/usdata.csv")
    
    df_csv.write.format("com.databricks.spark.avro").mode("append").save("hdfs:/user/cloudera/avro_dir_spark")
    
    //df_csv.show("10",false)
    
    println("Data write complete")
    
}
}