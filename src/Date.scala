trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean =  (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}

class Date(y: Int, m: Int, d: Int) extends Ord {
  private def year: Int = y
  private def month: Int = m
  private def day: Int = d

  override def toString: String = s"$year-$month-$day"

  override def equals(that: Any): Boolean = that match {
    case date: Date => date.day == day && date.month == month && date.year == year
    case _ => false
  }

  def <(that: Any): Boolean = that match {
    case date: Date =>
      (year < date.year) ||
        (year == date.year && (month < date.month ||
          (month == date.month && day == date.day)))
    case _ => sys.error("cannot compare " + that + "and a Date")
  }
}