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
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
    printTriangle(triangle)
    println

    // n = 1
    // val interval = (32 / scala.math.pow(2, n - 1)).toInt
    // val rows = List(interval)
    // val indexesOfTrianglesAtRow = triangle(rows(0))

    // #1
    n = 1
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
    printTriangle(combine(List(drawUnderscoreSquare(16), triangle, drawUnderscoreRectangle(16, 16))))
    printTriangle(combine(List(triangle, drawUnderscoreRectangle(1, 31), triangle)))
    println

    // #2
    n = 2
    triangle = drawTriangle(scala.math.pow(2, 6 - n).toInt - 1)
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


    // #1
    // row 32, col 31

    // #2
    // row 32, col 15
    // row 32, col 47
    // row 16, col 31

    // #3
    // row 32
    // row 32
    // row 32
    // row 32
    // row 24
    // row 24
    // row 16
    // row 16
    // row 8

    // #4
    // 8


    // take previous number of triangle and then append double that
    // 0 => 1
    // 1 => 1, 2
    // 2 => 1, 2, 2, 4
    // 3 => 1, 2, 2, 4, 2, 4, 4, 8
    // 4 => 1, 2, 2, 4, 2, 4, 4, 8, 2, 4, 4, 8, 4, 8, 8, 16
    // println(numberOfTrianglesPerRow(0).mkString(", "))
    // println(numberOfTrianglesPerRow(1).mkString(", "))
    // println(numberOfTrianglesPerRow(2).mkString(", "))
    // println(numberOfTrianglesPerRow(3).mkString(", "))
    // println(numberOfTrianglesPerRow(4).mkString(", "))

    println(multiples(3).mkString(", "))

    val numRows = numberOfTrianglesPerRow(n).length
    for (row <- 0 to (numRows - 1)) {
      printTriangle(
        drawRow(n, row, multiples(n)(row), triangle)
      )
    }
  }

  def drawRow(n: Int, row: Int, padding: Int, triangle: List[List[String]]): List[List[String]] = {
    val numberOfTriangles = numberOfTrianglesPerRow(n)(row)
    drawUnderscoreRectangle(padding, scala.math.pow(2, 5 - n))
    List()
  }

  def multiples(n: Int, m: Int = 32): List[Int] = m match {
    case 0 => List()
    case _ => {
      val interval = (32 / scala.math.pow(2, n)).toInt
      (m - interval) :: multiples(n, m - interval)
    }
  }

  def numberOfTrianglesPerRow(n: Int, current: List[Int] = List(1)): List[Int] = n match {
    case 0 => current
    case _ => numberOfTrianglesPerRow(n - 1, current ++ current.map(_ * 2))
  }
}
