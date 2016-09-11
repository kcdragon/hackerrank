// sbt run SierpinksiTriangles

object SierpinksiTriangles {
  def drawTriangles(n: Int) {
    // #0 - triangle base size is (63 - 0) / 1 = 63
    // #1 - triangle base size is (63 - 1) / 2 = 31
    // #2 - triangle base size is (63 - 3) / 4 = 15
    // #3 - triangle base size is                 7
    // #4 - triangle base size is                 3
    // #5 - triangle base size is                 1
    // #n - triangle base size is (2 ^ (6 - n)) - 1

    // #0
    printTriangle(drawTriangle(63))
    println

    // #1
    printTriangle(combineTriangles(combineTriangles(underscoreSquare(16, 16), drawTriangle(31)), underscoreSquare(16, 16)))
    printTriangle(combineTriangles(drawTriangle(31), drawTriangle(31)))
    println

    // #2
    printTriangle(combineTriangles(combineTriangles(underscoreSquare(8, 8), drawTriangle(15)), underscoreSquare(8, 8)))
    printTriangle(combineTriangles(drawTriangle(15), drawTriangle(15)))
    println
  }

  def combineTriangles(triangle1: List[List[String]], triangle2: List[List[String]]): List[List[String]] = triangle1 match {
    case Nil => List()
    case _ => (triangle1(0) ++ triangle2(0)) :: combineTriangles(triangle1.drop(1), triangle2.drop(1))
  }

  def underscoreSquare(size: Int, height: Int): List[List[String]] = height match {
    case 0 => List()
    case _ => drawString(size, "_") :: underscoreSquare(size, height - 1)
  }

  def printTriangle(triangle: List[List[String]]) {
    for (row <- triangle) println(row.mkString(""))
  }

  def drawTriangle(baseSize: Int, padding: Int = 0): List[List[String]] = {
    if (baseSize <= 0) {
      List()
    }
    else {
      drawTriangle(baseSize - 2, padding + 1) ++ List(drawString(padding, "_") ++ drawString(baseSize, "1") ++ drawString(padding, "_"))
    }
  }

  def drawString(n: Int, s: String): List[String] = n match {
    case 0 => List()
    case _ => s :: drawString(n - 1, s)
  }

  def main(args: Array[String]) {
    //drawTriangles(readInt())
    drawTriangles(1)
  }
}
