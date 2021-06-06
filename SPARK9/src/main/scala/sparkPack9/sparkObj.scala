package sparkPack9

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import sys.process._

object sparkObj {
  
  def main(args:Array[String]):Unit={ 
val conf = new SparkConf().setAppName("ES").setMaster("local[*]")
val sc = new SparkContext(conf)
sc.setLogLevel("ERROR")
}
  
}