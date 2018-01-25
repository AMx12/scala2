import scala.collection.immutable.ListSet
def seqDaveed(one: String, two: String): Unit = {
  var listOne: ListSet[String] = ListSet()
  var listTwo: ListSet[String] = ListSet()
  var num: Int = 0
  var num2: Int = 0
  for(i<-0 to one.length){ num+=1
    for(j<-num to one.length) listOne += one.toLowerCase().substring(i,j)
  }
  for(i<-0 to two.length){ num2+=1
    for(j<-num2 to two.length) listTwo += two.toLowerCase().substring(i,j)
  }
  println((listOne&listTwo).maxBy(_.length))
}
seqDaveed("abcd", "abcowiehiowerho")