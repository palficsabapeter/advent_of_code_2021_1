import scala.io.Source

object Main extends App {
  val bs = Source.fromResource("input.txt")
  val count = bs.getLines.map(_.toInt).foldLeft((0, 0)) { (countAndPrev, cur) =>
    countAndPrev match {
      case (0, 0) => (0, cur)
      case _      => if (cur > countAndPrev._2) (countAndPrev._1 + 1, cur)
                     else (countAndPrev._1, cur)
    }
  }._1

  bs.close()
  println(count)
}
