package sparkPack1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj_1605_Task2 {
  def main(args: Array[String]): Unit = {
    	val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
					val sc = new SparkContext(conf)
					sc.setLogLevel("ERROR")
					
		
					
					val data=sc.textFile("file:///E:/data/input/usdata.csv")
					
					
					println("=========FIle Data============")
					data.take(10).foreach(println)
					
					val Flat_data= data.flatMap(x=>x.split(","))
					
					println("=========FIle Data-Flatten============")
					
					Flat_data.take(10).foreach(println)
					
					Flat_data.saveAsTextFile("file:///E:/data/output/usdata_output.txt")
					
					println("Data Loaded")		
					
					
					
					
					
  }		
					
					
}