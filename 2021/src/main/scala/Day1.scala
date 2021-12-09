package nl.jrdie.aoc2021

object Day1 {
  def timesIncreased(depths: Iterator[Int]): Int = {
    var timesIncreased = 0
    var previousDepth = depths.next()

    for (depth <- depths) {
      if (depth > previousDepth) {
        timesIncreased += 1
      }
      previousDepth = depth
    }

    timesIncreased
  }
}
