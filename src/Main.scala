

object Main {
  def main(args: Array[String]): Unit = {



    //Creation of the grid and the snake
    val grid : Grid = new Grid ()



    //Drawing the background and header
    grid.drawBackGround(grid.backgroundGreen)
    grid.drawHeader(grid.headerGreen)


    grid.display.drawForeground()
    grid.display.drawTransformedPicture(grid.cornerSize*30, grid.headerSize*30,0,0.05,"/res/strawberry.png")
    grid.display.drawTransformedPicture(grid.cornerSize*30*3, grid.headerSize*30*3,0,0.05,"/res/weirdStraw.jpg")
    grid.display.syncGameLogic(60)

    while(true){
      grid.move()
      grid.drawGame()
      Thread.sleep(700)

    }
  }


}

