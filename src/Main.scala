import java.awt.Color
import hevs.graphics.FunGraphics

object Main {
  def main(args: Array[String]): Unit = {



    //Creation of the grid and the snake
    var grid : Grid = new Grid ()



    //Drawing the background and header
    grid.drawBackGround(grid.backgroundGreen)
    grid.drawHeader(grid.headerGreen)

    grid.drawGrid()

    grid.display.drawForeground()
    grid.display.drawTransformedPicture(grid.cornerSize*30, grid.headerSize*30,0,0.05,"/res/strawberry.png")
    grid.display.drawTransformedPicture(grid.cornerSize*30*3, grid.headerSize*30*3,0,0.05,"/res/weirdStraw.jpg")
    grid.display.syncGameLogic(60)
    while(true){
      Thread.sleep(1000)
      grid.move()
      grid.drawCell(grid.snake.position(0),grid.snake.position(1),grid.blue)

    }
  }


}

