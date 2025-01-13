import java.awt.Color
import hevs.graphics.FunGraphics

object Main {
  def main(args: Array[String]): Unit = {



    //Creation of the grid and the snake
    var grid : Grid = new Grid ()



    //Drawing the background and header
    grid.drawBackGround(grid.backgroundGreen)
    grid.drawHeader(grid.headerGreen)

    while(true){
     grid.drawGrid()
    }
  }


}

