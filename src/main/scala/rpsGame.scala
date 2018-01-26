object rpsGame {
  var pRCounter: Int = 0
  var pPCounter: Int = 0
  var pSCounter: Int = 0
  var pWin: Int = 0
  var aWin: Int = 0
  var firstMove: Boolean = true
  var quit: Boolean = true
  var move: String = ""
  var wins: String = ""
  var message: String = ""
def main(args: Array[String]):Unit = {
  var player: String = null
  while(quit){
    println("\n\nPlayer please enter Rock, Paper or Scissors\n or Q to quit.")
    player = scala.io.StdIn.readLine().toLowerCase()
    println("Player: "+playerMove(player))
    aiPicker(playerMove(player))
    println("AI: " + move)
    wins = checker(playerMove(player), move)
    if (wins == "P") pWin+=1
    if (wins == "A") aWin+=1
    message = winText(wins)
    println(message + "\n Score:\n  Player: " + pWin + "\n  AI: " + aWin)
  }
}

  def winText(result: String): String = result match{
    case ("P") => "Player wins!"
    case ("A") => "AI wins!"
    case ("D") => "It's a draw! :("
    case ("W") => "Stop trying to break the game, R P or S please!!"
  }

  def checker(pMove: String, aMove: String): String = (pMove, aMove) match{
    case (p,a) if (p == "Rock" && a == "Scissors") || (p == "Paper" && a == "Rock") || (p == "Scissors" && a == "Paper") => "P"
    case (p,a) if (a == "Rock" && p == "Scissors") || (a == "Paper" && p == "Rock") || (a == "Scissors" && p == "Paper") => "A"
    case (p,a) if p == a => "D"
    case (p,_) if p == "WRONG CHARACTER" => "W"
  }

  def playerMove(move: String): String = move.charAt(0) match {
    case 'r' => "Rock"
    case 'p' => "Paper"
    case 's' => "Scissors"
    case _ => "WRONG CHARACTER"
  }

  def aiPicker(pMove: String): String = {
    while (firstMove) {
      import scala.util.Random
      val A = Array("Rock", "Paper", "Scissors")
      move = Random.shuffle(A.toList).head
      firstMove = false
      move
    }
    if (pMove == "Rock") pRCounter += 1
    if (pMove == "Paper") pPCounter += 1
    if (pMove == "Scissors") pSCounter += 1
    if (pRCounter > pPCounter && pRCounter > pSCounter) move = "Paper"
    if (pPCounter > pRCounter && pPCounter > pSCounter) move = "Scissors"
    if (pSCounter > pPCounter && pSCounter > pRCounter) move = "Rock"
  move
  }
}
