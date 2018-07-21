package auf.algebra

import com.sap.conn.jco.{JCoRecordMetaData, JCoRecordFieldIterator}

trait JCoTableAlg[F[_]] extends JCoRecordAlg[F] {
  // public abstract com.sap.conn.jco.JCoRecordMetaData getRecordMetaData();
  def getRecordMetaData: F[JCoRecordMetaData]
  // public abstract void ensureBufferCapacity(int);
  def ensureBufferCapacity(a: Int): F[Unit]
  // public abstract void trimToRows();
  def trimToRows: F[Unit]
  // public abstract boolean isEmpty();
  def isEmpty: F[Boolean]
  // public abstract boolean isFirstRow();
  def isFirstRow: F[Boolean]
  // public abstract boolean isLastRow();
  def isLastRow: F[Boolean]
  // public abstract int getNumRows();
  def getNumRows: F[Int]
  // public abstract int getNumColumns();
  def getNumColumns: F[Int]
  // public abstract void clear();
  def clear: F[Unit]
  // public abstract void deleteAllRows();
  def deleteAllRows: F[Unit]
  // public abstract void firstRow();
  def firstRow: F[Unit]
  // public abstract void lastRow();
  def lastRow: F[Unit]
  // public abstract boolean nextRow();
  def nextRow: F[Boolean]
  // public abstract boolean previousRow();
  def previousRow: F[Boolean]
  // public abstract int getRow();
  def getRow: F[Int]
  // public abstract void setRow(int);
  def setRow(a: Int): F[Unit]
  // public abstract void appendRow();
  def appendRow: F[Unit]
  // public abstract void appendRows(int);
  def appendRows(a: Int): F[Unit]
  // public abstract void insertRow(int);
  def insertRow(a: Int): F[Unit]
  // public abstract void deleteRow();
  def deleteRow: F[Unit]
  // public abstract void deleteRow(int);
  def deleteRow(a: Int): F[Unit]
  // public abstract com.sap.conn.jco.JCoRecordFieldIterator getRecordFieldIterator();
  def getRecordFieldIterator: F[JCoRecordFieldIterator]
}
