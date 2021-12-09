package nl.jrdie.aoc2021

import scala.io.Source
import scala.util.Using

object Day1Part1 {
  def main(args: Array[String]): Unit = {
    val answerTimesIncreased = Using(Source.fromURL(getClass.getResource("/day1/part1-input.txt"))) { source =>
      val depths = source
        .getLines()
        .map(_.toInt)

      Day1.timesIncreased(depths)
    }

    println(answerTimesIncreased)
  }
}
