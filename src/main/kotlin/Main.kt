fun main(){
  val suitGameImpl = SuitGameImpl()
  suitGameImpl.showWelcomeMessage()
  suitGameImpl.showMessageTurnPlayer(true)
  suitGameImpl.readPlayerInput(true)
  suitGameImpl.showMessageTurnPlayer(false)
  suitGameImpl.readPlayerInput(false)
}