package sparkPack2

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._
import org.apache.spark.sql.SparkSession


object sparkObj_2305_dataframes {
  
  case class columns(txno:String, txndate:String, custno:String, amount:String, category:String,product:String, city:String, state:String, spendby:String)

  
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
				
    
    val txnsdata = sc.textFile("file:///E:/data/input/txns")
    
    
    val splitmap = txnsdata.map(x=>x.split(","))
    
    val schemardd= splitmap.map(x=>columns(x(0),x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))
    
    
    val DataF=schemardd.toDF()
    
    DataF.show()
    
    
    DataF.createOrReplaceTempView("txnsdf")
    
    
    val cashdf= spark.sql("select * from txnsdf where spendby like '%cash%'")
    
    cashdf.show()
    
    
    

    

  
  
  
  
  }
}