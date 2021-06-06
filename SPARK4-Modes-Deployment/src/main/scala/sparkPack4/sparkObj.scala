package sparkPack4

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj {
 
  def main(args:Array[String]):Unit={ 
val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")

val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
val df_csv = spark.read.format("csv").option("header", "true").load("E:/BigData/usdata.csv")

//df_csv.write.format("parquet").save("E:/BigData/Parquet_Mode")
//df_csv.write.format("parquet").save("E:/BigData/Parquet_Mode")
//df_csv.write.format("parquet").mode("append").save("E:/BigData/Parquet_Mode")
//df_csv.write.format("parquet").mode("overwrite").save("E:/BigData/Parquet_Mode")
df_csv.write.format("parquet").mode("ignore").save("E:/BigData/Parquet_Mode")


}

}