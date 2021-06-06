package sparkPack3

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


/*val df = spark.read.format("csv").load("E:/BigData/usdata.csv")

df.take(10).foreach(println)*/

val df = spark.read.format("parquet").load("E:/BigData/part_par.parquet")

df.show(10,false)


//val df_orc = spark.read.format("orc").load("E:/BigData/part_orc.orc")

//df_orc.show(10,false)

//val df_csv = spark.read.format("csv").load("E:/BigData/usdata.csv")

//df_csv.show(10,false)

/*val df_json = spark.read.format("json").load("E:/BigData/devices.json")

df_json.show(10,false)


df_json.write.format("json").mode("error").option("header", "true").save("E:/BigData/json")*/

//df_csv.write.format("csv").mode("error").option("header", "true").save("E:/BigData/usdata")

//df_orc.write.format("orc").mode("error").option("header", "true").save("E:/BigData/orcdata")

//df.write.format("parquet").mode("error").option("header", "true").save("E:/BigData/parquetdata")

df.write.format("com.databricks.spark.avro").mode("error").option("header", "true").save("E:/BigData/avrodata")




}
  
}