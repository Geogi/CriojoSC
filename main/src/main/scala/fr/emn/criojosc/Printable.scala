package fr.emn.criojosc

trait Printable {
  def printed: String
}

trait OptNamedPrintedFallback extends OptNamed with Printable {
  override def toString = name.getOrElse(printed)
}
