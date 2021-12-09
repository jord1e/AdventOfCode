package nl.jrdie.aoc2021
package two

sealed trait SubmarineAction {
  def applyToSubmarine(submarine: Submarine): Submarine

  def applyWithAim(submarine: Submarine): Submarine
}

case class MoveForwardAction(units: Int) extends SubmarineAction {
  override def applyToSubmarine(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(x = submarine.position.x + units))

  override def applyWithAim(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(
      x = submarine.position.x + units,
      depth = submarine.position.depth + (submarine.position.aim * units)
    ))
}

case class MoveUpAction(units: Int) extends SubmarineAction {
  override def applyToSubmarine(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(depth = submarine.position.depth - units))

  override def applyWithAim(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(aim = submarine.position.aim - units))
}

case class MoveDownAction(units: Int) extends SubmarineAction {
  override def applyToSubmarine(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(depth = submarine.position.depth + units))

  override def applyWithAim(submarine: Submarine): Submarine =
    submarine.copy(position = submarine.position.copy(aim = submarine.position.aim + units))
}
