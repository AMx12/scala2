def game(): Unit ={
  var quit: Boolean = false
  while(quit == false){
    println("Player please enter R, P or S!")
    println(checker(aiPicker(playerMove(scala.io.StdIn.readLine().toLowerCase)),playerMove(scala.io.StdIn.readLine().toLowerCase)))

  }
}
game()

def checker(pMove: String, aMove: String): String = (pMove, aMove) match{
case (_,_) if (pMove == "Rock" && aMove == "Paper" || pMove == "Paper" && aMove == "Scissors" || pMove == "Scissors" && aMove == "Rock" ) => "Player Wins! :D"
case (_,_) if (aMove == "Rock" && pMove == "Paper" || aMove == "Paper" && pMove == "Scissors" || aMove == "Scissors" && pMove == "Rock" ) => "AI Wins! D:"
case (_,_) if (pMove ==  aMove) => "It's A Draw! :@"
}

def playerMove(move: String): String = move match {
  case "r" => "Rock"
  case "p" => "Paper"
  case "s" => "Scissors"
  case _ => "Please enter R, P or S"
}

def aiPicker(pMove: String): String = {
  var pRCounter: Int = 0
  var pPCounter: Int = 0
  var pSCounter: Int = 0
  var move: String = ""
  if (pMove == "Rock") pRCounter+=1
  if (pMove == "Paper") pPCounter+=1
  if (pMove == "Scissors") pSCounter+=1
  if (pRCounter > pPCounter && pRCounter > pSCounter) move = "Paper"
  if (pPCounter > pRCounter && pPCounter > pSCounter) move = "Scissors"
  if (pSCounter > pPCounter && pSCounter > pRCounter) move = "Rock"
  move
}