package nl.jrdie.aoc2021
package two

import two.Day2Part1.getClass

import scala.io.Source
import scala.util.{Failure, Success, Using}

object Day2Part2 extends App {
  val submarine = Using(Source.fromURL(getClass.getResource("/day2/input.txt"))) { source =>
    val depths = source
      .getLines()

    val course = Day2.readCourse(depths)
    Day2.simulateSubmarineWithAim(course)
  }

  submarine match {
    case Failure(exception) => print("Fout", exception)
    case Success(Submarine(position)) =>
      println(s"Success! ${position.depth * position.x}")
  }
}
