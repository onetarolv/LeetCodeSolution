package medium

import scala.collection.mutable

/**
 * Created by engry on 2017/11/29.
 * 347. Top K Frequent Elements
 */
object ScalaTopKFrequentElements {
  def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
    val countMap = new mutable.HashMap[Int, Int]()
    nums.foreach { num =>
      countMap(num) = countMap.getOrElse(num, 0) + 1
    }
    implicit val ordering = new Ordering[Int] {
      override def compare(x: Int, y: Int): Int = {
        y.compareTo(x)
      }
    }
    val res = countMap.toList.sortBy(x => x._2).take(k).map(_._1)
    res
  }
  def main(args: Array[String]): Unit = {
    val arr = Array(1,1,3,3,4,4,4,4,2,2,2,2)
    val res = topKFrequent(arr, 2)
    res.foreach(println)
  }
}
