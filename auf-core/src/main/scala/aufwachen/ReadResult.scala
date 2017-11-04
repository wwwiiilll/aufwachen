package aufwachen

sealed trait ReadResult[+A] {

  def get: A

  def isSuccess: Boolean
  def isError: Boolean = !isSuccess

  def fold[X](error: String => X, success: A => X): X

  def map[B](f: A => B): ReadResult[B] = this match {
    case ReadSuccess(a) => ReadSuccess(f(a))
    case e: ReadError => e
  }

  def flatMap[B](f: A => ReadResult[B]): ReadResult[B] = this match {
    case ReadSuccess(a) => f(a)
    case e: ReadError => e
  }

  def getOrElse[AA >: A](orElse: => AA): AA =
    if (isSuccess) this.get else orElse

  def orElse[AA >: A](other: => ReadResult[AA]): ReadResult[AA] =
    if (isSuccess) this else other

  def zip[B](that: ReadResult[B]): ReadResult[(A, B)] = (this, that) match {
    case (ReadSuccess(a), ReadSuccess(b)) => ReadSuccess((a, b))
    case (ReadError(e1), ReadError(e2)) => ReadError(e1 + e2)
    case (ReadError(e), _) => ReadError(e)
    case (_, ReadError(e)) => ReadError(e)
  }

  def toOption: Option[A] =
    if (isSuccess) Option(this.get) else None

  def toEither: Either[String, A] = this match {
    case ReadSuccess(a) => Right(a)
    case ReadError(m) => Left(m)
  }

}

final case class ReadSuccess[A](value: A) extends ReadResult[A] {
  override def get: A = value
  override def isSuccess: Boolean = true
  override def fold[X](error: String => X, success: A => X): X = success(value)
}

final case class ReadError(message: String) extends ReadResult[Nothing] {
  override def get: Nothing = throw new NoSuchElementException("ReadError.get")
  override def isSuccess: Boolean = false
  override def fold[X](error: String => X, success: Nothing => X): X = error(message)
}

object ReadResult {

  @inline def success[A](a: A): ReadResult[A] = ReadSuccess(a)

  @inline def error[A](message: String): ReadResult[A] = ReadError(message)

}
