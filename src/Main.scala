import java.time.LocalDate
import java.time.format.{DateTimeFormatter, FormatStyle}
import java.util.Locale._

object Main {
  private val nums = Array(1, 2, 3, 4, 5)
  private val doubledNums = nums.map(_ * 2)
  private val filteredNums = nums.filter(_ > 2)

  def main(args: Array[String]): Unit = {
    val now = LocalDate.now
    val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(UK)
    val number1 = 1.+(2) * 3
    val number2 = 1.+(2.*(3))
    val complex = new Complex(1.5, 2.3)
    println(df.format(now))
    println(number1, number2)
    println(complex.toString())

    val hulk = new DavidBanner with Angry with Green with Big
    println("hulk is: " + hulk)
    doubledNums.foreach(println(_))
    filteredNums.foreach(println(_))
  }
}
