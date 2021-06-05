package sparkPack5

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
    
 /*   val xmldf = spark.read.format("com.databricks.spark.xml").option("rowTag","note").load("file:///E:/BigData/data/note.xml")
	xmldf.show()
	xmldf.printSchema()*/

	
	
	val xmldf1 = spark.read.format("com.databricks.spark.xml").option("rowTag","book").load("file:///E:/BigData/data/book.xml")
	xmldf1.show(3)
	xmldf1.printSchema()
	
	
	/*val xmldf2 = spark.read.format("com.databricks.spark.xml").option("rowTag","POSLog").load("file:///E:/BigData/data/transactions.xml")
	xmldf2.show(3)
	xmldf2.printSchema()*/
	
/*	xmldf1.write.format("parquet").partitionBy("genre").save("file:///E:/BigData/data/output/book")
	println("partion creaetd for book.xml")*/
	
	val sqldf = spark.read.format("jdbc").option("url", "jdbc:mysql://mysql56.cki8jgd5zszv.ap-south-1.rds.amazonaws.com:3306/zeyodb")
    .option("driver", "com.mysql.jdbc.Driver")
    .option("dbtable", "web_customer")
    .option("user", "root")
    .option("password", "Aditya908").load()
    
    sqldf.show()
    sqldf.printSchema()
    
    
}

  
}