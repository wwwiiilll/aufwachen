package auf.algebra

import java.io.{InputStream, Reader, Writer}
import java.math.{BigDecimal, BigInteger}
import java.util.Date

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoAbapObject, JCoFieldIterator, JCoMetaData, JCoRecord, JCoStructure, JCoTable}

object jcorecord {

  trait JCoRecordAlg[F[_]] {
    // public abstract com.sap.conn.jco.JCoMetaData getMetaData();
    def getMetaData: F[JCoMetaData]
    // public abstract void clear();
    def clear: F[Unit]
    // public abstract int copyFrom(com.sap.conn.jco.JCoRecord);
    def copyFrom(a: JCoRecord): F[Int]
    // public abstract int getFieldCount();
    def getFieldCount: F[Int]
    // public abstract java.lang.Object getValue(int);
    def getValue(a: Int): F[AnyRef]
    // public abstract java.lang.Object getValue(java.lang.String);
    def getValue(a: String): F[AnyRef]
    // public abstract java.lang.String getString(int);
    def getString(a: Int): F[String]
    // public abstract char getChar(int);
    def getChar(a: Int): F[Char]
    // public abstract byte getByte(int);
    def getByte(a: Int): F[Byte]
    // public abstract byte getByte(java.lang.String);
    def getByte(a: String): F[Byte]
    // public abstract float getFloat(int);
    def getFloat(a: Int): F[Float]
    // public abstract float getFloat(java.lang.String);
    def getFloat(a: String): F[Float]
    // public abstract short getShort(int);
    def getShort(a: Int): F[Short]
    // public abstract int getInt(int);
    def getInt(a: Int): F[Int]
    // public abstract long getLong(int);
    def getLong(a: Int): F[Long]
    // public abstract java.math.BigInteger getBigInteger(int);
    def getBigInteger(a: Int): F[BigInteger]
    // public abstract double getDouble(int);
    def getDouble(a: Int): F[Double]
    // public abstract java.math.BigDecimal getBigDecimal(int);
    def getBigDecimal(a: Int): F[BigDecimal]
    // public abstract java.util.Date getDate(int);
    def getDate(a: Int): F[Date]
    // public abstract java.util.Date getTime(int);
    def getTime(a: Int): F[Date]
    // public abstract byte[] getByteArray(int);
    def getByteArray(a: Int): F[Array[Byte]]
    // public abstract char[] getCharArray(int);
    def getCharArray(a: Int): F[Array[Char]]
    // public abstract java.io.InputStream getBinaryStream(int);
    def getBinaryStream(a: Int): F[InputStream]
    // public abstract java.io.Reader getCharacterStream(int);
    def getCharacterStream(a: Int): F[Reader]
    // public abstract com.sap.conn.jco.JCoTable getTable(int);
    def getTable(a: Int): F[JCoTable]
    // public abstract com.sap.conn.jco.JCoStructure getStructure(int);
    def getStructure(a: Int): F[JCoStructure]
    // public abstract java.lang.String toXML(int);
    def toXML(a: Int): F[String]
    // public abstract java.lang.String toXML(java.lang.String);
    def toXML(a: String): F[String]
    // public abstract java.lang.String toXML();
    def toXML: F[String]
    // public abstract java.io.Writer write(int, java.io.Writer) throws java.io.IOException;
    def write(a: Int, b: Writer): F[Writer]
    // public abstract java.io.Writer write(java.lang.String, java.io.Writer) throws java.io.IOException;
    def write(a: String, b: Writer): F[Writer]
    // public abstract void setValue(int, java.lang.String);
    def setValue(a: Int, b: String): F[Unit]
    // public abstract java.lang.String getClassNameOfValue(java.lang.String);
    def getClassNameOfValue(a: String): F[String]
    // public abstract java.lang.String getString(java.lang.String);
    def getString(a: String): F[String]
    // public abstract char getChar(java.lang.String);
    def getChar(a: String): F[Char]
    // public abstract short getShort(java.lang.String);
    def getShort(a: String): F[Short]
    // public abstract int getInt(java.lang.String);
    def getInt(a: String): F[Int]
    // public abstract long getLong(java.lang.String);
    def getLong(a: String): F[Long]
    // public abstract java.math.BigInteger getBigInteger(java.lang.String);
    def getBigInteger(a: String): F[BigInteger]
    // public abstract double getDouble(java.lang.String);
    def getDouble(a: String): F[Double]
    // public abstract java.math.BigDecimal getBigDecimal(java.lang.String);
    def getBigDecimal(a: String): F[BigDecimal]
    // public abstract java.util.Date getDate(java.lang.String);
    def getDate(a: String): F[Date]
    // public abstract java.util.Date getTime(java.lang.String);
    def getTime(a: String): F[Date]
    // public abstract byte[] getByteArray(java.lang.String);
    def getByteArray(a: String): F[Array[Byte]]
    // public abstract char[] getCharArray(java.lang.String);
    def getCharArray(a: String): F[Array[Char]]
    // public abstract java.io.InputStream getBinaryStream(java.lang.String);
    def getBinaryStream(a: String): F[InputStream]
    // public abstract java.io.Reader getCharacterStream(java.lang.String);
    def getCharacterStream(a: String): F[Reader]
    // public abstract com.sap.conn.jco.JCoTable getTable(java.lang.String);
    def getTable(a: String): F[JCoTable]
    // public abstract com.sap.conn.jco.JCoStructure getStructure(java.lang.String);
    def getStructure(a: String): F[JCoStructure]
    // public abstract void setValue(int, char);
    def setValue(a: Int, b: Char): F[Unit]
    // public abstract void setValue(int, char[]);
    def setValue(a: Int, b: Array[Char]): F[Unit]
    // public abstract void setValue(int, char[], int, int);
    def setValue(a: Int, b: Array[Char], c: Int, d: Int): F[Unit]
    // public abstract void setValue(int, short);
    def setValue(a: Int, b: Short): F[Unit]
    // public abstract void setValue(int, int);
    def setValue(a: Int, b: Int): F[Unit]
    // public abstract void setValue(int, long);
    def setValue(a: Int, b: Long): F[Unit]
    // public abstract void setValue(int, double);
    def setValue(a: Int, b: Double): F[Unit]
    // public abstract void setValue(int, byte[]);
    def setValue(a: Int, b: Array[Byte]): F[Unit]
    // public abstract void setValue(int, com.sap.conn.jco.JCoStructure);
    def setValue(a: Int, b: JCoStructure): F[Unit]
    // public abstract void setValue(int, com.sap.conn.jco.JCoTable);
    def setValue(a: Int, b: JCoTable): F[Unit]
    // public abstract void setValue(int, java.lang.Object);
    def setValue(a: Int, b: AnyRef): F[Unit]
    // public abstract void setValue(java.lang.String, java.lang.String);
    def setValue(a: String, b: String): F[Unit]
    // public abstract void setValue(java.lang.String, char[]);
    def setValue(a: String, b: Array[Char]): F[Unit]
    // public abstract void setValue(java.lang.String, char[], int, int);
    def setValue(a: String, b: Array[Char], c: Int, d: Int): F[Unit]
    // public abstract void setValue(java.lang.String, char);
    def setValue(a: String, b: Char): F[Unit]
    // public abstract void setValue(java.lang.String, short);
    def setValue(a: String, b: Short): F[Unit]
    // public abstract void setValue(java.lang.String, int);
    def setValue(a: String, b: Int): F[Unit]
    // public abstract void setValue(java.lang.String, long);
    def setValue(a: String, b: Long): F[Unit]
    // public abstract void setValue(java.lang.String, double);
    def setValue(a: String, b: Double): F[Unit]
    // public abstract void setValue(int, float);
    def setValue(a: Int, b: Float): F[Unit]
    // public abstract void setValue(java.lang.String, float);
    def setValue(a: String, b: Float): F[Unit]
    // public abstract void setValue(int, java.math.BigDecimal);
    def setValue(a: Int, b: BigDecimal): F[Unit]
    // public abstract void setValue(java.lang.String, java.math.BigDecimal);
    def setValue(a: String, b: BigDecimal): F[Unit]
    // public abstract void setValue(int, byte);
    def setValue(a: Int, b: Byte): F[Unit]
    // public abstract void setValue(java.lang.String, byte);
    def setValue(a: String, b: Byte): F[Unit]
    // public abstract void setValue(java.lang.String, byte[]);
    def setValue(a: String, b: Array[Byte]): F[Unit]
    // public abstract void setValue(java.lang.String, com.sap.conn.jco.JCoStructure);
    def setValue(a: String, b: JCoStructure): F[Unit]
    // public abstract void setValue(java.lang.String, com.sap.conn.jco.JCoTable);
    def setValue(a: String, b: JCoTable): F[Unit]
    // public abstract void setValue(java.lang.String, java.lang.Object);
    def setValue(a: String, b: AnyRef): F[Unit]
    // public abstract com.sap.conn.jco.JCoAbapObject getAbapObject(java.lang.String);
    def getAbapObject(a: String): F[JCoAbapObject]
    // public abstract com.sap.conn.jco.JCoAbapObject getAbapObject(int);
    def getAbapObject(a: Int): F[JCoAbapObject]
    // public abstract void setValue(java.lang.String, com.sap.conn.jco.JCoAbapObject);
    def setValue(a: String, b: JCoAbapObject): F[Unit]
    // public abstract void setValue(int, com.sap.conn.jco.JCoAbapObject);
    def setValue(a: Int, b: JCoAbapObject): F[Unit]
    // public abstract boolean isInitialized(java.lang.String);
    def isInitialized(a: String): F[Boolean]
    // public abstract boolean isInitialized(int);
    def isInitialized(a: Int): F[Boolean]
    // public abstract com.sap.conn.jco.JCoFieldIterator getFieldIterator();
    def getFieldIterator: F[JCoFieldIterator]
  }

  trait JCoRecordInterpreter[A <: JCoRecord, M[_]] {

    type F[B] = Kleisli[M, A, B]

    implicit def M: Async[M]

    def getMetaData: F[JCoMetaData] =
      Kleisli(v => M.delay(v.getMetaData))

    def clear: F[Unit] =
      Kleisli(v => M.delay(v.clear))

    def copyFrom(a: JCoRecord): F[Int] =
      Kleisli(v => M.delay(v.copyFrom(a)))

    def getFieldCount: F[Int] =
      Kleisli(v => M.delay(v.getFieldCount))

    def getValue(a: Int): F[AnyRef] =
      Kleisli(v => M.delay(v.getValue(a)))

    def getValue(a: String): F[AnyRef] =
      Kleisli(v => M.delay(v.getValue(a)))

    def getString(a: Int): F[String] =
      Kleisli(v => M.delay(v.getString(a)))

    def getChar(a: Int): F[Char] =
      Kleisli(v => M.delay(v.getChar(a)))

    def getByte(a: Int): F[Byte] =
      Kleisli(v => M.delay(v.getByte(a)))

    def getByte(a: String): F[Byte] =
      Kleisli(v => M.delay(v.getByte(a)))

    def getFloat(a: Int): F[Float] =
      Kleisli(v => M.delay(v.getFloat(a)))

    def getFloat(a: String): F[Float] =
      Kleisli(v => M.delay(v.getFloat(a)))

    def getShort(a: Int): F[Short] =
      Kleisli(v => M.delay(v.getShort(a)))

    def getInt(a: Int): F[Int] =
      Kleisli(v => M.delay(v.getInt(a)))

    def getLong(a: Int): F[Long] =
      Kleisli(v => M.delay(v.getLong(a)))

    def getBigInteger(a: Int): F[BigInteger] =
      Kleisli(v => M.delay(v.getBigInteger(a)))

    def getDouble(a: Int): F[Double] =
      Kleisli(v => M.delay(v.getDouble(a)))

    def getBigDecimal(a: Int): F[BigDecimal] =
      Kleisli(v => M.delay(v.getBigDecimal(a)))

    def getDate(a: Int): F[Date] =
      Kleisli(v => M.delay(v.getDate(a)))

    def getTime(a: Int): F[Date] =
      Kleisli(v => M.delay(v.getTime(a)))

    def getByteArray(a: Int): F[Array[Byte]] =
      Kleisli(v => M.delay(v.getByteArray(a)))

    def getCharArray(a: Int): F[Array[Char]] =
      Kleisli(v => M.delay(v.getCharArray(a)))

    def getBinaryStream(a: Int): F[InputStream] =
      Kleisli(v => M.delay(v.getBinaryStream(a)))

    def getCharacterStream(a: Int): F[Reader] =
      Kleisli(v => M.delay(v.getCharacterStream(a)))

    def getTable(a: Int): F[JCoTable] =
      Kleisli(v => M.delay(v.getTable(a)))

    def getStructure(a: Int): F[JCoStructure] =
      Kleisli(v => M.delay(v.getStructure(a)))

    def toXML(a: Int): F[String] =
      Kleisli(v => M.delay(v.toXML(a)))

    def toXML(a: String): F[String] =
      Kleisli(v => M.delay(v.toXML(a)))

    def toXML: F[String] =
      Kleisli(v => M.delay(v.toXML))

    def write(a: Int, b: Writer): F[Writer] =
      Kleisli(v => M.delay(v.write(a, b)))

    def write(a: String, b: Writer): F[Writer] =
      Kleisli(v => M.delay(v.write(a, b)))

    def setValue(a: Int, b: String): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def getClassNameOfValue(a: String): F[String] =
      Kleisli(v => M.delay(v.getClassNameOfValue(a)))

    def getString(a: String): F[String] =
      Kleisli(v => M.delay(v.getString(a)))

    def getChar(a: String): F[Char] =
      Kleisli(v => M.delay(v.getChar(a)))

    def getShort(a: String): F[Short] =
      Kleisli(v => M.delay(v.getShort(a)))

    def getInt(a: String): F[Int] =
      Kleisli(v => M.delay(v.getInt(a)))

    def getLong(a: String): F[Long] =
      Kleisli(v => M.delay(v.getLong(a)))

    def getBigInteger(a: String): F[BigInteger] =
      Kleisli(v => M.delay(v.getBigInteger(a)))

    def getDouble(a: String): F[Double] =
      Kleisli(v => M.delay(v.getDouble(a)))

    def getBigDecimal(a: String): F[BigDecimal] =
      Kleisli(v => M.delay(v.getBigDecimal(a)))

    def getDate(a: String): F[Date] =
      Kleisli(v => M.delay(v.getDate(a)))

    def getTime(a: String): F[Date] =
      Kleisli(v => M.delay(v.getTime(a)))

    def getByteArray(a: String): F[Array[Byte]] =
      Kleisli(v => M.delay(v.getByteArray(a)))

    def getCharArray(a: String): F[Array[Char]] =
      Kleisli(v => M.delay(v.getCharArray(a)))

    def getBinaryStream(a: String): F[InputStream] =
      Kleisli(v => M.delay(v.getBinaryStream(a)))

    def getCharacterStream(a: String): F[Reader] =
      Kleisli(v => M.delay(v.getCharacterStream(a)))

    def getTable(a: String): F[JCoTable] =
      Kleisli(v => M.delay(v.getTable(a)))

    def getStructure(a: String): F[JCoStructure] =
      Kleisli(v => M.delay(v.getStructure(a)))

    def setValue(a: Int, b: Char): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Array[Char]): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Array[Char], c: Int, d: Int): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b, c, d)))

    def setValue(a: Int, b: Short): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Int): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Long): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Double): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Array[Byte]): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: JCoStructure): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: JCoTable): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: AnyRef): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: String): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Array[Char]): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Array[Char], c: Int, d: Int): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b, c, d)))

    def setValue(a: String, b: Char): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Short): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Int): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Long): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Double): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Float): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Float): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: BigDecimal): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: BigDecimal): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: Byte): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Byte): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: Array[Byte]): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: JCoStructure): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: JCoTable): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: String, b: AnyRef): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def getAbapObject(a: String): F[JCoAbapObject] =
      Kleisli(v => M.delay(v.getAbapObject(a)))

    def getAbapObject(a: Int): F[JCoAbapObject] =
      Kleisli(v => M.delay(v.getAbapObject(a)))

    def setValue(a: String, b: JCoAbapObject): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def setValue(a: Int, b: JCoAbapObject): F[Unit] =
      Kleisli(v => M.delay(v.setValue(a, b)))

    def isInitialized(a: String): F[Boolean] =
      Kleisli(v => M.delay(v.isInitialized(a)))

    def isInitialized(a: Int): F[Boolean] =
      Kleisli(v => M.delay(v.isInitialized(a)))

    def getFieldIterator: F[JCoFieldIterator] =
      Kleisli(v => M.delay(v.getFieldIterator))

  }

}
