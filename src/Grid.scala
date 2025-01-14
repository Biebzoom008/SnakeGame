import hevs.graphics.FunGraphics

import java.awt.Color
import java.awt.event.{KeyAdapter, KeyEvent}

class Grid (){
  class Snake () {
    val position: Array[Int] = Array(7,10)
    var up : Boolean = false
    var down : Boolean =  false
    var right : Boolean = false
    var left : Boolean = false

  }

  //Size of the display
  val width : Int = 512
  val height : Int = 600
  val hi : Int = 2
  val cellSize : Int = 30

  //Size of header and space on the sides. Size in number of cells it represents
  val cornerSize : Int = 1
  val headerSize : Int = 3

  //Number of cells in the
  val numCellsX : Int = width/cellSize
  val numCellsY : Int = height/cellSize

  //elements in the grid
  val gridElement : Array[Array[Int]] = Array.fill(15,15)(1)


  //Colors used in the program
  val blue : Color = new Color(100,175,255)
  val lightGreen : Color = new Color (178, 215, 95)
  val green : Color = new Color (157, 201, 82)
  val backgroundGreen : Color = new Color(100, 136, 64)
  val headerGreen : Color = new Color(85, 115, 54)
  val transparent : Color = new Color(255,255,255,0)


  //Creation of the display here to make everything cleaner
  val display : FunGraphics = new FunGraphics(width, height)
  val snake : Snake = new Snake ()


  //if condition to stop the snake from going outside the grid
  //it also changes the value of one of the positions for the auto moving snake
  display.setKeyManager(new KeyAdapter() { // Will be called when a key has been pressed
    override def keyPressed(e: KeyEvent): Unit = {
      if (e.getKeyChar == 'a') println("The key 'A' was pressed")
      if (e.getKeyCode == KeyEvent.VK_RIGHT && snake.position(0)< 15) {
        snake.position(0) += 1
        snake.left = false
        snake.down = false
        snake.up = false
        snake.right = true
      }
      if (e.getKeyCode == KeyEvent.VK_LEFT && snake.position(0)> 1) {
        snake.position(0) -= 1
        snake.down = false
        snake.up = false
        snake.right = false
        snake.left = true
      }
      if (e.getKeyCode == KeyEvent.VK_UP && snake.position(1)>4) {
        snake.position(1) -= 1
        snake.left = false
        snake.down = false
        snake.right = false
        snake.up = true
      }
      if (e.getKeyCode == KeyEvent.VK_DOWN && snake.position(1)<18) {
        snake.position(1) += 1
        snake.left = false
        snake.up = false
        snake.right = false
        snake.down = true
      }
    }
  })




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


  //Draws the grid unless there is the snake (early iteration of the snake head)
  def drawGrid () : Unit = {
    {
      display.drawBackground()
      for (x <- cornerSize until numCellsX - cornerSize) {
        for (y <- headerSize + cornerSize until numCellsY - cornerSize) {
          // Alterne les couleurs en fonction de la position
          if (((x + y) % 2 == 0) )   {
            drawCell(x, y, lightGreen) // vert clair
          } else if(!((x + y) % 2 == 0) ){
            drawCell(x, y, green) // Vert foncé
          }
        }
      }
    }
  }

  def move() : Unit = {
    if (snake.up == true && snake.position(1)>4){
      snake.position(1) -= 1
    } else if (snake.down == true && snake.position(1)<18) {
      snake.position(1) += 1
    } else if (snake.right == true && snake.position(0)< 15){
      snake.position(0) += 1
    } else if (snake.left==true &&snake.position(0)> 1){
      snake.position(0) -= 1
    }

  }

  def drawGame() : Unit = {
    display.drawForeground()
    gridElement(snake.position(0))(snake.position(1)) +=1
    for(x <- gridElement.indices){
      for (y <- gridElement(x).indices){
        if (gridElement(x)(y)>1){
          drawCell(x+cornerSize,y+headerSize+1,blue)
        }
      }
    }
  }


}
