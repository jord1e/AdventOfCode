package nl.jrdie.aoc2021
package two

object Day2 {
  def simulateSubmarine(course: Iterator[SubmarineAction]): Submarine = {
    course.foldLeft(Submarine()) {
      (submarine, action) => action.applyToSubmarine(submarine)
    }
  }

  def simulateSubmarineWithAim(course: Iterator[SubmarineAction]): Submarine = {
    course.foldLeft(Submarine()) {
      (submarine, action) => action.applyWithAim(submarine)
    }
  }

  def readCourse(course: Iterator[String]): Iterator[SubmarineAction] = {
    course
      .flatMap(mapAction)
  }

  def mapAction(action: String): Option[SubmarineAction] = {
    action.split(' ') match {
      case Array(action, value) => {
        val units = value.toIntOption
        units match {
          case Some(value) => action match {
            case "forward" => Some(MoveForwardAction(value))
            case "up" => Some(MoveUpAction(value))
            case "down" => Some(MoveDownAction(value))
            case _ => None
          }
          case None => None
        }
      }
      case Array(action) => None
      case _ => None
    }
  }
}
