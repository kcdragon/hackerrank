object Solution {
  def rotateString(string: String, rotationsLeft: Int): List[String] = rotationsLeft match {
    case 0 => List()
    case _ => (string.substring(1) ++ string(0).toString) :: rotateString(string.substring(1) ++ string(0).toString, rotationsLeft - 1)
  }

  def main(args: Array[String]) {
    val numberOfTests = readLine().toInt
    for (t <- 1 to numberOfTests) {
      val string = readLine()
      println(rotateString(string, string.length).mkString(" "))
    }
  }
}
