object Timer {

  def main(args: Array[String]): Unit = {
    oncePerSecond(timeFlies)
//    or with lambda
//    oncePerSecond(() =>
//      println("time flies func 1"))
  }

  private def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread.sleep(1000)
    }
  }

  private def timeFlies(): Unit = {
    println("time flies func 1")
  }
}
