// sbt run < sample.in

object Solution {

  def r(p: String, q: String, s: String = ""): String = p.length match {
    case 0 => s
    case _ => r(
      p.drop(1),
      q.drop(1),
      s.concat(p(0).toString.concat(q(0).toString))
    )
  }

  def main(args: Array[String]) {
    val p = readLine()
    val q = readLine()
    println(r(p, q))
  }
}
