package sparkPack5

import org.apache.spark._
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.io.File
import org.apache.spark.sql.functions._

object sparkObj_0506_Task4 {
   def main(args: Array[String]): Unit = {
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

    val df = spark.read.schema(struct_schema).format("csv").load("file:///E:/data/input/txns")

    df.show(10)
    
    val part_df= df.write.format("parquet").option("header", "true").mode("overwrite").partitionBy("category","spendby").save("file:///E:/BigData/data/output/part_parquet")
    
    println("=============File with partition is completed================")
    
    
   }
}