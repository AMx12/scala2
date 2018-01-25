def footLong(one: String, two: String): Unit = { var oneSet: Set[String] = Set(); var twoSet: Set[String] = Set()
  var num: Int = 0
  for(i<-0 to one.length) { num += 1
    for (j <- num to one.length) {
      oneSet += one.toLowerCase().substring(i, j)
      twoSet += two.toLowerCase().substring(i, j)
    }
  }
  println((oneSet&twoSet).maxBy(_.length))
}
footLong("powqeipaksdavioihhoih", "pojqdpnlkasdavidpaohpdqwojferb")

def sixInch(one: String, two: String): String=(one.inits.flatMap(_.tails).toSet&two.inits.flatMap(_.tails).toSet).maxBy(_.length)
println(sixInch("powqeipaksdavioihhoih", "pojqdpnlkasdavidpaohpdqwojferb"))