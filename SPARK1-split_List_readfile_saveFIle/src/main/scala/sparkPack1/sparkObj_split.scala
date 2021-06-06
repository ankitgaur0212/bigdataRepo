package sparkPack1

object sparkObj_split {
  def main(args: Array[String]): Unit = {

    println("==============Raw data=================")

    val list_str = List("sai,aditya", "ankit,gaur", "sai,zeyo", "sai,zeyobron", "rahul,modi")

    list_str.foreach(println)

    println("==============Flatten data=================")

    val list_str_Flatt = list_str.flatMap(x => x.split(","))

    list_str_Flatt.foreach(println)

    val list_str_Flatt_Rep = list_str_Flatt.map(x => x.replace("sai", "NA"))

    println("==============Flatten data=================")

    list_str_Flatt_Rep.foreach(println)

  }

}