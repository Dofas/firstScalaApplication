import Tree._

object Calculator {
  private type Environment = String => Int

  private def eval(tree: Tree, environment: Environment): Int = tree match {
    case Sum(leftValue, rightValue) => eval(leftValue, environment) + eval(rightValue, environment)
    case Var(stringFromEnvironment) => environment(stringFromEnvironment)
    case Const(constValue) => constValue
  }

  private def derive(t: Tree, stringToCheck: String): Tree = t match {
    case Sum(leftValue, rightValue) => Sum(derive(leftValue, stringToCheck), derive(rightValue, stringToCheck))
    case Var(stringFromEnvironment) if stringToCheck == stringFromEnvironment => Const(1)
    case _ => Const(0)
  }

  def main(array: Array[String]): Unit = {
    val expression: Tree = Sum(Sum(Var("x"), Var("x")),Sum(Const(7),Var("y")))
    val environment: Environment = {case "x" => 5 case "y" => 7}
    println("Expression: " + expression)
    println("Evaluation with x=5 y=7: " + eval(expression, environment))
    println("Derivative relative to x:\n " + derive(expression, "x"))
    println("Derivative relative to y:\n " + derive(expression, "y"))
  }
}
