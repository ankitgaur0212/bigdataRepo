package sparkPack5

import org.apache.spark._
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.io.File
import org.apache.spark.sql.functions._



object sparkObj_0506_Task2 {
  
  def main(args:Array[String]):Unit={ 
val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")
val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
  val struct_schema = StructType(Array(
      StructField("txnno", StringType, true),
      StructField("txndate", StringType, true),
      StructField("custno", StringType, true),
      StructField("amount", StringType, true),
      StructField("category", StringType, true),
      StructField("product", StringType, true),
      StructField("city", StringType, true),
      StructField("state", StringType, true),
      StructField("spendby", StringType, true)))

      println("=============RAW Data================")
    val df = spark.read.format("csv").schema(struct_schema).option("header", "true").load("file:///E:/BigData/data/txns")
    df.show(10)
    df.printSchema()
    
    val sel_col=df.limit(10).select("txnno", "category","product","city","state")
    println("=============Select columns================")
    sel_col.show(10)
    
    println("=============Filter Data================")
    val sel_col_Fil= sel_col.filter(col("category")===("Gymnastics"))
    
    sel_col_Fil.show(10)
    
    
    sel_col_Fil.write.format("parquet").option("header", "true").save("file:///E:/BigData/data/output/parquet_sel_fil")
    
    
    
  }
}