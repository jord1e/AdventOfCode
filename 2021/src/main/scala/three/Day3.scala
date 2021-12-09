package nl.jrdie.aoc2021
package three

object Day3 {
  def findBits(report: Iterator[String]): Map[Int, Map[Char, Int]] = {
    report.foldLeft(Map[Int, Map[Char, Int]]()) {
      (positionMap, bits) => {
        bits.zipWithIndex.foldLeft(positionMap) {
          (bitAtPos, columnAndChar) => {
            columnAndChar match {
              case (bitChar, column) =>
                val pos = bitAtPos.getOrElse(column, Map[Char, Int]())
                val newPos = pos updated(bitChar, pos.getOrElse(bitChar, 0) + 1)
                bitAtPos updated(column, newPos)
            }
          }
        }
      }
    }
  }

  def gammaRate(bits: Map[Int, Map[Char, Int]]): Int = {
    val binary = bits.foldLeft(" " * bits.keys.max) {
      (finalString, myMapAndIndex) =>
        myMapAndIndex match {
          case (column, bitMap) =>
            val toInsert = bitMap.maxBy(_._2)._1
            finalString.splitAt(column) match {
              case (left, "") => left + toInsert
              case (left, right) => left + toInsert + right.substring(1)
            }
        }
    }
    Integer.parseInt(binary, 2)
  }

  def epsilonRate(bits: Map[Int, Map[Char, Int]]): Int = {
    val binary = bits.foldLeft(" " * bits.keys.max) {
      (finalString, myMapAndIndex) =>
        myMapAndIndex match {
          case (column, bitMap) =>
            val toInsert = bitMap.minBy(_._2)._1
            finalString.splitAt(column) match {
              case (left, "") => left + toInsert
              case (left, right) => left + toInsert + right.substring(1)
            }
        }
    }
    Integer.parseInt(binary, 2)
  }
}
