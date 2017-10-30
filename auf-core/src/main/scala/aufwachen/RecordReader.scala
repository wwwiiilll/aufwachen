package aufwachen

import scala.annotation.implicitNotFound

import java.util.Date

import com.sap.conn.jco.JCoRecord

@implicitNotFound("No implicit reader found for type ${A}, try implementing RecordReader[${A}]")
trait RecordReader[A] { self =>

  def read(rec: JCoRecord): ReadResult[A]

  def map[B](f: A => B): RecordReader[B] =
    RecordReader[B] { rec => self.read(rec).map(f) }

  def flatMap[B](f: A => RecordReader[B]): RecordReader[B] =
    RecordReader[B] { rec => self.read(rec).flatMap(a => f(a).read(rec)) }

}

object RecordReader {

  import ReadResult._

  def apply[A](f: JCoRecord => ReadResult[A]): RecordReader[A] = new RecordReader[A] {
    override def read(rec: JCoRecord): ReadResult[A] = f(rec)
  }

  def pure[A](a: => A): RecordReader[A] = apply { _ => success(a) }

  @inline def of[A](implicit rr: RecordReader[A]): RecordReader[A] = rr

}

object RecordParsers {

  import ReadResult._

  def str(index: Int): RecordReader[String] = RecordReader { rec => success(rec.getString(index)) }
  def str(name: String): RecordReader[String] = RecordReader { rec => success(rec.getString(name)) }

  def char(index: Int): RecordReader[Char] = RecordReader { rec => success(rec.getChar(index)) }
  def char(name: String): RecordReader[Char] = RecordReader { rec => success(rec.getChar(name)) }

  def bool(index: Int): RecordReader[Boolean] = char(index).map(_ == 'X')
  def bool(name: String): RecordReader[Boolean] = char(name).map(_ == 'X')

  def byte(index: Int): RecordReader[Byte] = RecordReader { rec => success(rec.getByte(index)) }
  def byte(name: String): RecordReader[Byte] = RecordReader { rec => success(rec.getByte(name)) }

  def short(index: Int): RecordReader[Short] = RecordReader { rec => success(rec.getShort(index)) }
  def short(name: String): RecordReader[Short] = RecordReader { rec => success(rec.getShort(name)) }

  def int(index: Int): RecordReader[Int] = RecordReader { rec => success(rec.getInt(index)) }
  def int(name: String): RecordReader[Int] = RecordReader { rec => success(rec.getInt(name)) }

  def long(index: Int): RecordReader[Long] = RecordReader { rec => success(rec.getLong(index)) }
  def long(name: String): RecordReader[Long] = RecordReader { rec => success(rec.getLong(name)) }

  def float(index: Int): RecordReader[Float] = RecordReader { rec => success(rec.getFloat(index)) }
  def float(name: String): RecordReader[Float] = RecordReader { rec => success(rec.getFloat(name)) }

  def double(index: Int): RecordReader[Double] = RecordReader { rec => success(rec.getDouble(index)) }
  def double(name: String): RecordReader[Double] = RecordReader { rec => success(rec.getDouble(name)) }

  def date(index: Int): RecordReader[Date] = RecordReader { rec => success(rec.getDate(index)) }
  def date(name: String): RecordReader[Date] = RecordReader { rec => success(rec.getDate(name)) }

  def time(index: Int): RecordReader[Date] = RecordReader { rec => success(rec.getTime(index)) } // TBH what?
  def time(name: String): RecordReader[Date] = RecordReader { rec => success(rec.getTime(name)) }

}
