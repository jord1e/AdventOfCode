package nl.jrdie.aoc2021
package three

import two.Day2Part2.getClass
import two.{Day2, Submarine}

import scala.io.Source
import scala.util.{Failure, Success, Using}

object Day3Part1 extends App {
  val bitsTest = Using(Source.fromURL(getClass.getResource("/day3/input.txt"))) { source =>
    val report = source
      .getLines()

    Day3.findBits(report)
  }

  bitsTest match {
    case Failure(exception) => print("Fout", exception)
    case Success(bits) =>
      println(s"Success! ${bits}")
      println(s"${Day3.gammaRate(bits) * Day3.epsilonRate(bits)}")
  }
}
