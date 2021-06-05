package sparkPack1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._



object sparkObj_1605_Task3 {
  def main(args: Array[String]): Unit = {
    	val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
					val sc = new SparkContext(conf)
					sc.setLogLevel("ERROR")
    
					val int_list1=List(1,2,3,4)
					println("===List1 data=========")
					int_list1.foreach(println)
					
					val int_list2=List(4,5,6,7)
					println("===List2 data=========")
					int_list2.foreach(println)
					
					val int_list_union= int_list1.union(int_list2)
					
					println("===Union data=========")
					
					int_list_union.foreach(println)
					
					
					
		
					
					
					
  }
  
}