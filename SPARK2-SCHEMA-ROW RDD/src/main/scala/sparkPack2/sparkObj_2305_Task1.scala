package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.Row
import org.apache.spark.sql.types._

object sparkObj_2305_Task1 {

  case class schema(txno:String, txndate:String, custno:String, amount:String, category:String,product:String, city:String, state:String, spendby:String)

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._

    val txnsdata = sc.textFile("file:///E:/data/input/txns")

    val mapsplit = txnsdata.map(x => x.split(","))

    /*====TASK1===========adding 1 with the column
    val rdd_value = mapsplit.map(x=>(x(4),1))

    rdd_value.take(10).foreach(println)

    //val rdd_value: RDD[(String, Int)]
     output
     (Exercise & Fitness,1)
(Gymnastics,1)
(Team Sports,1)*/

    // =====TASK2======Schema RDD to Dataframe================
//
     val schemardd = mapsplit.map(x=>schema(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))



    schemardd.take(10)foreach(println)


    val dataf=schemardd.toDF()

    dataf.createOrReplaceTempView("txndf")

    val datafilter=spark.sql("select * from txndf where product like '%Gymnastics %' and txno>40000")

    datafilter.show()
    

    /*=====TASK3=====Row RDD conversion to Dataframe====================
     * val rowrdd = mapsplit.map(x => Row(x(0), x(1), x(2), x(3), x(4), x(5), x(6), x(7), x(8)))

    val schema_struct = StructType(Array(
      StructField("txnno", StringType, true),
      StructField("txndate", StringType, true),
      StructField("custno", StringType, true),
      StructField("amount", StringType, true),
      StructField("category", StringType, true),
      StructField("product", StringType, true),
      StructField("city", StringType, true),
      StructField("state", StringType, true),
      StructField("spendby", StringType, true)))

    val rowrddf = spark.createDataFrame(rowrdd, schema_struct)

    rowrddf.createOrReplaceTempView("txns_row")

    val rowdffilter = spark.sql("select * from txns_row where product like '%Gymnastics %' and txnno>40000")

    rowdffilter.show()*/

  }
}