class Complex(real: Double, imaginary: Double) {
//  def re(): Double = real
//  def im(): Double = imaginary
  private def re: Double = real
  private def im: Double = imaginary
  override def toString(): String =
    "" + re + (if (im >= 0) "+" else "") + im + "i"
}
