// sbt run SierpinksiTriangles

object SierpinksiTriangles {
  def drawTriangles(n: Int) {
    val triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
  }

  def combine(triangles: List[List[List[String]]]): List[List[String]] = triangles(0) match {
    case Nil => List()
    case _ => triangles.flatMap(_(0)) :: combine(triangles.map(_.drop(1)))
  }

  def drawUnderscoreSquare(size: Int): List[List[String]] = drawUnderscoreRectangle(size, size)

  def drawUnderscoreRectangle(width: Int, height: Int): List[List[String]] = height match {
    case 0 => List()
    case _ => drawString(width, "_") :: drawUnderscoreRectangle(width, height - 1)
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
    //drawTriangles(1)

    var triangle: List[List[String]] = List()
    var n = 0

    // #0
    n = 0
    //triangle = drawTriangle(63)
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
    // 1 triangle
    printTriangle(triangle)
    println

    // #1
    n = 1
    //triangle = drawTriangle(31)
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
    // 1 triangle  2 rectangles
    // 2 triangles 1 rectangle
    printTriangle(combine(List(drawUnderscoreSquare(16), triangle, drawUnderscoreRectangle(16, 16))))
    printTriangle(combine(List(triangle, drawUnderscoreRectangle(1, 31), triangle)))
    println

    // #2
    n = 2
    //triangle = drawTriangle(15)
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
    // 1 triangle  2 rectangles
    // 2 triangles 1 rectangle
    // 4 triangles
    printTriangle(combine(List(
      drawUnderscoreRectangle(24, 8),
      triangle,
      drawUnderscoreRectangle(24, 8)
    )))
    printTriangle(combine(List(
      drawUnderscoreRectangle(16, 8), triangle,
      drawUnderscoreRectangle(1, 8),
      triangle, drawUnderscoreRectangle(16, 8)
    )))
    printTriangle(combine(List(
      drawUnderscoreSquare(8), triangle, drawUnderscoreSquare(8),
      drawUnderscoreRectangle(1, 8),
      drawUnderscoreSquare(8), triangle, drawUnderscoreSquare(8)
    )))
    printTriangle(combine(List(
      triangle, drawUnderscoreRectangle(1, 8), triangle,
      drawUnderscoreRectangle(1, 8),
      triangle, drawUnderscoreRectangle(1, 8), triangle
    )))
    println
  }
}
