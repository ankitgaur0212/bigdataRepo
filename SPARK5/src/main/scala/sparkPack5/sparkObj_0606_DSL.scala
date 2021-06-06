package sparkPack5

import org.apache.spark._
import org.apache.spark.sql.Row
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import java.io.File
import org.apache.spark.sql.functions._

object sparkObj_0606_DSL {
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
    
   //select and Filter on df 
    val df1=df.select("txnno", "txndate","amount","category","product","spendby").filter(col("txnno")> 50000 && col("spendby")==="cash")
    df1.show(10)
    
    
   //filter with product like  Weightlifting%
    val df2= df1.filter(col("product").like("Weightlifting%"))
 df2.show(10)   
  //withcolumn - on top of the column 
 val txndf= df.withColumn("category", expr("split(category,' ')[0]")) 			 					
 txndf.show(10)
    
 //withcolumn - new col in end
 val txndf1= df.withColumn("cat1", expr("split(category,' ')[0] as cat1")) 			 					
 txndf1.show(10)
 
 //defaul values -> withColumn
 
 val txndf2=txndf1.withColumn("spendby", lit(1))
 txndf2.show(10)
 
 
 //case conditions ->withColumn
 
 //val txndf3=txndf1.withColumn("cat1", expr("if cat1='Exercise' || cat1='Gymnastics' then 1 else 0"))
//txndf3.show(10)
 
 val txndf3=txndf1.withColumn("cat1",expr("case when (cat1=('Exercise')) || (cat1=('Gymnastics')) then 1 else 0 end "))
txndf3.show(10)
 
 
 
  }
}