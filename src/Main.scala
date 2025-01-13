import java.awt.Color
import hevs.graphics.FunGraphics

object Main {
  def main(args: Array[String]): Unit = {

    //Colors used in the program
    val blue : Color = new Color(100,175,255)
    val lightGreen : Color = new Color (178, 215, 95)
    val green : Color = new Color (157, 201, 82)
    val backgroundGreen : Color = new Color(100, 136, 64)
    val headerGreen : Color = new Color(85, 115, 54)

    //Creation of the grid and the snake
    var grid : Grid = new Grid ()
    var snake : Snake = new Snake()


    //Drawing the background and header
    grid.drawBackGround(backgroundGreen)
    grid.drawHeader(headerGreen)

    while(true){
      for (x <- grid.cornerSize until grid.numCellsX - grid.cornerSize) {
        for (y <- grid.headerSize + grid.cornerSize until grid.numCellsY - grid.cornerSize) {
          // Alterne les couleurs en fonction de la position
          var isItTheSame : Boolean = snake.position(0) == x && snake.position(1) == y
          if (((x + y) % 2 == 0) && !isItTheSame)   {
            grid.drawCell(x, y, lightGreen) // vert clair
          } else if(!((x + y) % 2 == 0) && !isItTheSame){
            grid.drawCell(x, y, green) // Vert foncé
          }
        }
      }
      grid.drawCell(snake.position(0),snake.position(1), blue)
    }
  }


}

