object rpsGame {
def main(args: Array[String]):Unit = {
  var quit: Boolean = true
  var player: String = ""
  while(quit){
    println("Player please enter R, P or S!")
    player = scala.io.StdIn.readLine().toLowerCase()
    println(playerMove(player))
    println(aiPicker(playerMove(player)))
    println(winText(checker(playerMove(player), aiPicker(playerMove(player)))))
    println()
    println()
  }
}

  def winText(result: String): String ={
    var pCounter: Int = 0
    var aCounter: Int = 0
    var message: String = ""
    if (result == "P")
      pCounter+=1
      message = "Player wins! \n Score: \nPlayer " + pCounter + "\nAI " + aCounter
    if (result == "A")
      aCounter+=1
      message = "AI wins! \n Score: \nPlayer " + pCounter + "\nAI " + aCounter
    if (result == "D")message = "Draw! \n Score: \nPlayer " + pCounter + "\nAI " + aCounter
    if (result == "W") message = "Stop trying to break the game, R, P or S please!!!! \nScore: \n Player " + pCounter + "\n AI " + aCounter

    message
  }

  def checker(pMove: String, aMove: String): String = (pMove, aMove) match{
    case (_,_) if pMove == "Rock" && aMove == "Scissors" || pMove == "Paper" && aMove == "Rock" || pMove == "Scissors" && aMove == "Paper" => "P"
    case (_,_) if aMove == "Rock" && pMove == "Scissors" || aMove == "Paper" && pMove == "Rock" || aMove == "Scissors" && pMove == "Paper" => "A"
    case (_,_) if pMove == aMove => "D"
    case (_,_) if pMove == "WRONG CHARACTER" => "W"
  }

  def playerMove(move: String): String = move match {
    case "r" => "Rock"
    case "p" => "Paper"
    case "s" => "Scissors"
    case _ => "WRONG CHARACTER"
  }

  def aiPicker(pMove: String): String = {

    var move: String = ""
    var first: Boolean = true
    while (first) {
      import scala.util.Random
      val A = Array("Rock", "Paper", "Scissors")
      move = Random.shuffle(A.toList).head
      first = false
    }
    while (first) {
      var pRCounter: Int = 0
      var pPCounter: Int = 0
      var pSCounter: Int = 0
    if (pMove == "Rock") pRCounter += 1
    if (pMove == "Paper") pPCounter += 1
    if (pMove == "Scissors") pSCounter += 1
    if (pRCounter > pPCounter && pRCounter > pSCounter) move = "Paper"
    if (pPCounter > pRCounter && pPCounter > pSCounter) move = "Scissors"
    if (pSCounter > pPCounter && pSCounter > pRCounter) move = "Rock"
  }
  move
  }
}
