package sparkPack1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj_1605_Task1 {
  def main(args: Array[String]): Unit = {
    	val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
					val sc = new SparkContext(conf)
					sc.setLogLevel("ERROR")
    
    val data= sc.textFile("file:///E:/data/input/txns")
    
    println("========Raw Data=========")
    
    data.foreach(println)
    
    val data_fil=data.filter(x=>x.contains("Gymnastics"))
        
      println("========filter Data=========")
    
    data_fil.foreach(println) 
    
    data_fil.saveAsTextFile("file:///E:/data/output/gymdata_dir")
    
    println
    
    
    
  }
  
  
  
}