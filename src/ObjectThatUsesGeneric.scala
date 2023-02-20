object ObjectThatUsesGeneric {
  def main(args: Array[String]): Unit = {
    val intFromGeneric = new Generic[Int]
    intFromGeneric.set(10)
    println("Value is: " + intFromGeneric.get)
  }
}
