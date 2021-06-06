package sparkPack1


object sparkObj_listStr {
  def main(args:Array[String]):Unit={ 
  val list_str=List("zeyobron","zeyo","analytics","sai","zeyobrona","","zeyobron1")
      
     list_str.foreach(println)
     
     println("======filter=========")
     
  val list_str_fil=list_str.filter(x=>x.contains("zeyo"))
  
  val list_str_fil_eq=list_str.filter(x=>x.equals("zeyo"))
  
  println("======filter-filter=========")
     
    list_str_fil.foreach(println)
    
    println("======filter-equals=========")
    
    list_str_fil_eq.foreach(println)
    
    println("======Concat=========")
    
    val list_str_fil_concat=list_str_fil.map(x=>x+"ankit")
    list_str_fil_concat.foreach(println)
    
}
}