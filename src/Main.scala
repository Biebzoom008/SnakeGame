

object Main {
  def main(args: Array[String]): Unit = {


    //Creation of the grid and the snake
    val grid : Grid = new Grid ()

    while (grid.gameRunning) {
      menuScreen()
      if (grid.playing == true){
        game()
      } else while (grid.playing == false) {
        Thread.sleep(1000)
      }

    }

    Thread.sleep(10000)
    sys.exit()
    def menuScreen () : Unit = {
      for (x <- 0 until grid.width){
        for (y <- 0 until grid.height) {
          grid.display.setPixel(x,y,grid.backgroundGreen)
        }
      }
      grid.display.drawString(grid.width/4 + 45,grid.height/2,"START",grid.blue,40)
    }

    def restartScreen () : Unit = {
      for (x <- 0 until grid.width){
        for (y <- 0 until grid.height) {
          grid.display.setPixel(x,y,grid.backgroundGreen)
        }
      }
      grid.display.drawString(grid.width/4 + 45,grid.height/2,"RESTART",grid.blue,40)
      grid.restartScreen = true
    }
    def game () : Unit = {

      //Drawing the background and header
      grid.display.drawBackground()
      grid.drawBackGround(grid.backgroundGreen)
      grid.drawGrid(grid.green, grid.lightGreen)

      //Creates a first strawberry in a random position
      var randomX : Int = (Math.random()*15).toInt
      var randomY : Int = ((Math.random()*15).toInt)
      grid.drawEmpty(randomX,randomY)
      grid.food.foodGrid(randomX)(randomY)= 1

      grid.display.drawForeground()
      grid.display.drawTransformedPicture(grid.cornerSize * 30 + randomX*grid.cellSize + 15, grid.headerSize * 30 + randomY*grid.cellSize + 45, 0, 0.05, "/res/strawberry.png")
      grid.drawHeader(grid.headerGreen)
      grid.scoreDisplay(grid.headerGreen)
      grid.display.drawForeground()


      try{while(!grid.tailDeath){
        grid.move()
        grid.drawGame()
        var random : Int = (Math.random()*5).toInt

        if(random > 1){
          grid.food.createFood()
        } else {
          grid.food.createFood2()

        }
        grid.food.eat()


        Thread.sleep(300)
      }
        grid.deathScreen()
      } catch {
        case e : ArrayIndexOutOfBoundsException => grid.deathScreen()
      }
    }
    }

}

