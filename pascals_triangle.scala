object Solution {

    def main(args: Array[String]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
         */
        val k = readLine().toInt
        //println(pascal(0).mkString(" "))
        //println(pascal(1).mkString(" "))
        //println(pascal(2).mkString(" "))
        //println(pascal(3).mkString(" "))
        //triangle(k - 1).foreach(row: List[Int] => println(row.mkString(" ")))
        for (row <- triangle(k - 1))
          println(row.mkString(" "))
    }

    def triangle(n: Int): List[List[Int]] = n match {
      case -1 => List()
      case _ => triangle(n - 1) ++ List(pascal(n))
    }

  def pascal(n: Int): List[Int] = pascalRow(n, n)

    def pascalRow(n: Int, r: Int): List[Int] = r match {
      case -1 => List()
      case _ => pascalRow(n, r - 1) ++ List(pascalCell(n, r))
    }

  def pascalCell(n: Int, r: Int): Int = (factorial(n) / (factorial(r) * factorial(n - r)))

    def factorial(n: Int): Int = {
      if  (n <= 1) {
        return 1
      }
      else {
        return n * factorial(n - 1)
      }
    }
}
