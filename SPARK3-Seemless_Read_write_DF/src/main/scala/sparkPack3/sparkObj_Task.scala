package sparkPack3

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj_Task {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._

    val df_csv_old = spark.read.format("csv").option("header", "true").load("E:/BigData/usdata.csv")

    val df_csv = spark.read.format("csv").option("header", "true").option("inferSchema", "true").load("E:/BigData/usdata.csv")

    df_csv_old.printSchema()

    df_csv.printSchema()

    df_csv.show(10, false)

    df_csv.write.format("com.databricks.spark.avro").option("header", "true").save("E:/BigData/usdata_avro_infer_1")

  }
}