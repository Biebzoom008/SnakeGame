import hevs.graphics.FunGraphics

import java.awt.Color

class Grid (){

  class Snake () {
    val position: Array[Int] = Array(7,10)
  }
  //Size of the display
  val width : Int = 512
  val height : Int = 600

  val cellSize : Int = 30

  //Size of header and space on the sides. Size in number of cells it represents
  val cornerSize : Int = 1
  val headerSize : Int = 3

  //Number of cells in the
  val numCellsX : Int = width/cellSize
  val numCellsY : Int = height/cellSize


  //Colors used in the program
  val blue : Color = new Color(100,175,255)
  val lightGreen : Color = new Color (178, 215, 95)
  val green : Color = new Color (157, 201, 82)
  val backgroundGreen : Color = new Color(100, 136, 64)
  val headerGreen : Color = new Color(85, 115, 54)


  //Creation of the display here to make everything cleaner
  val display : FunGraphics = new FunGraphics(width, height)
  val snake : Snake = new Snake ()



  //Function that draws a cell of size cellSize starting at the position (x,y) and of color c
  def drawCell(x: Int, y: Int, c: Color): Unit = {
    val startX = x * cellSize
    val startY = y * cellSize

    for (x <- 0 until cellSize) {
      for (y <- 0 until cellSize) {
        display.setPixel(startX + x, startY + y, c)
      }
    }
  }

  def drawBackGround(c: Color): Unit = {
    for (x <- 0 until width) {
      for (y <- 0 until height) {
        display.setPixel(x, y, c)
      }
    }
  }


  def drawHeader(c: Color): Unit = {
    for (x <- 0 until width) {
      for (y <- 0 until headerSize * cellSize) {
        display.setPixel(x, y, c)
      }
    }
  }


  def drawGrid () : Unit = {
    {
      for (x <- cornerSize until numCellsX - cornerSize) {
        for (y <- headerSize + cornerSize until numCellsY - cornerSize) {
          // Alterne les couleurs en fonction de la position
          var isItTheSame : Boolean = snake.position(0) == x && snake.position(1) == y
          if (((x + y) % 2 == 0) && !isItTheSame)   {
            drawCell(x, y, lightGreen) // vert clair
          } else if(!((x + y) % 2 == 0) && !isItTheSame){
            drawCell(x, y, green) // Vert foncé
          }
        }
      }
      drawCell(snake.position(0),snake.position(1), blue)
    }
  }


}
