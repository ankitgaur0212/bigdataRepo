package sparkPack5

import org.apache.spark._
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.io.File
import org.apache.spark.sql.functions._

object sparkObj_0506_Task3 {

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

    println("=============write  Data-RDBMS================")

    val sqldf = df.limit(20).write.format("jdbc").option("url", "jdbc:mysql://mysql56.cki8jgd5zszv.ap-south-1.rds.amazonaws.com:3306/batch28")
      .option("driver", "com.mysql.jdbc.Driver").option("dbtable", "ankitg_tab").option("user", "root").option("password", "Aditya908").save()
println("=============write  Data-RDBMS-completed================")
  }
}