import hevs.graphics.FunGraphics

import java.awt.Color

class Grid (){

  //Size of the display
  val width : Int = 512
  val height : Int = 600

  val cellSize : Int = 30

  //Size of header and space on the sides. Size in number of cells it represents
  val cornerSize : Int = 1
  val headerSize : Int = 3

  //Number of cells in the grid
  val numCellsX : Int = width/cellSize
  val numCellsY : Int = height/cellSize

  //Creation of the display here to make everything cleaner
  val display : FunGraphics = new FunGraphics(width, height)



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

}
