package sparkPack1

object sparkObj_sc1 {
  def main(args: Array[String]): Unit = {

    val data_str = List(

      "State->Andhra~City->Vijayawada",
      "State->TamilNadu~City->Chennai",
      "State->Maharashtra~City->Mumbai")

    data_str.foreach(println)

    println("=====raw data==============")

    val flatdata = data_str.flatMap((x => x.split("~")))
    flatdata.foreach(println)

    println("=====filter data==============")

    val flatdata_States = flatdata.filter((x => x.contains("State")))

    val flatdata_City = flatdata.filter((x => x.contains("City")))

    println("=====filter data--states==============")
    flatdata_States.foreach(println)

    println("=====filter data--City==============")

    flatdata_City.foreach(println)

    val flatData_rep = flatdata_States.map(x => x.replace("State->", ""))
    println("=====Replace-State==============")

    flatData_rep.foreach(println)

    val flatData_rep_city = flatdata_City.map(x => x.replace("City->", ""))

    println("=====Replace-City==============")

    flatData_rep_city.foreach(println)

  }
}