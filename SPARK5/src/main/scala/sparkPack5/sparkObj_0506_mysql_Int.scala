package sparkPack5

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark._
import org.apache.spark.sql.SparkSession

object sparkObj_0506_mysql_Int {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._

    val sqldf = spark.read.format("jdbc").option("url", "jdbc:mysql://mysql56.cki8jgd5zszv.ap-south-1.rds.amazonaws.com:3306/zeyodb")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("dbtable", "web_customer")
      .option("user", "root")
      .option("password", "Aditya908").load()

    sqldf.show(10)
    sqldf.printSchema()

  }

}