package sparkPack1

object sparkObj {
def main(args:Array[String]):Unit={ 

val int_val= List(1,2,3,4,5,6,7,8)
println("Raw Data")
int_val.foreach(println)

val filter_list=int_val.filter(x=>x>4)
println("Filter Data")
filter_list.foreach(println)

println("Another condition")

val filter_list_filter= filter_list.filter(x=>x<6)

filter_list_filter.foreach(println)
  
val list_multiply=filter_list.map(x=>x*4)

println("Multiply condition")

list_multiply.foreach(println)



}
}