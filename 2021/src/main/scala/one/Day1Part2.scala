package nl.jrdie.aoc2021
package one

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.Using

object Day1Part2 {
  def main(args: Array[String]): Unit = {
    val answerTimesIncreased = Using(Source.fromURL(getClass.getResource("/day1/part1-input.txt"))) { source =>
      val slidingDepths = source
        .getLines()
        .map(_.toInt)

      val slidingQueue = mutable.Queue[Int]()
      val listOfSums = ArrayBuffer[Int]()
      for (depth <- slidingDepths) {
        slidingQueue.enqueue(depth)
        if (slidingQueue.length == 3) {
          var sums = 0
          for (windowDepth <- slidingQueue) {
            sums += windowDepth
          }
          slidingQueue.dequeue()
          listOfSums.addOne(sums)
        }
      }

      Day1.timesIncreased(listOfSums.iterator)
    }

    println(answerTimesIncreased)
  }
}
