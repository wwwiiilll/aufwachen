package auf.algebra

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoRecordMetaData, JCoRecordFieldIterator, JCoTable}

object jcotable {

  trait JCoTableAlg[F[_]] extends jcorecord.JCoRecordAlg[F] {
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

  type JCoTableK[M[_], A] = Kleisli[M, JCoTable, A]

  class JCoTableInterpreter[M[_]](
    override implicit val M: Async[M]
  ) extends JCoTableAlg[JCoTableK[M, ?]] with jcorecord.JCoRecordInterpreter[JCoTable, M] {

    def getRecordMetaData: F[JCoRecordMetaData] =
      Kleisli(v => M.delay(v.getRecordMetaData))

    def ensureBufferCapacity(a: Int): F[Unit] =
      Kleisli(v => M.delay(v.ensureBufferCapacity(a)))

    def trimToRows: F[Unit] =
      Kleisli(v => M.delay(v.trimToRows))

    def isEmpty: F[Boolean] =
      Kleisli(v => M.delay(v.isEmpty))

    def isFirstRow: F[Boolean] =
      Kleisli(v => M.delay(v.isFirstRow))

    def isLastRow: F[Boolean] =
      Kleisli(v => M.delay(v.isLastRow))

    def getNumRows: F[Int] =
      Kleisli(v => M.delay(v.getNumRows))

    def getNumColumns: F[Int] =
      Kleisli(v => M.delay(v.getNumColumns))

    def deleteAllRows: F[Unit] =
      Kleisli(v => M.delay(v.deleteAllRows))

    def firstRow: F[Unit] =
      Kleisli(v => M.delay(v.firstRow))

    def lastRow: F[Unit] =
      Kleisli(v => M.delay(v.lastRow))

    def nextRow: F[Boolean] =
      Kleisli(v => M.delay(v.nextRow))

    def previousRow: F[Boolean] =
      Kleisli(v => M.delay(v.previousRow))

    def getRow: F[Int] =
      Kleisli(v => M.delay(v.getRow))

    def setRow(a: Int): F[Unit] =
      Kleisli(v => M.delay(v.setRow(a)))

    def appendRow: F[Unit] =
      Kleisli(v => M.delay(v.appendRow))

    def appendRows(a: Int): F[Unit] =
      Kleisli(v => M.delay(v.appendRows(a)))

    def insertRow(a: Int): F[Unit] =
      Kleisli(v => M.delay(v.insertRow(a)))

    def deleteRow: F[Unit] =
      Kleisli(v => M.delay(v.deleteRow))

    def deleteRow(a: Int): F[Unit] =
      Kleisli(v => M.delay(v.deleteRow(a)))

    def getRecordFieldIterator: F[JCoRecordFieldIterator] =
      Kleisli(v => M.delay(v.getRecordFieldIterator))

  }

}
