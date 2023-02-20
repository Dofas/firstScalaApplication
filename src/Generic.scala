class Generic[T] {
  private var contents: T = _
  def set(value: T): Unit = { contents = value }
  def get(): T = contents
}
