package auf.algebra

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoRecordFieldIterator, JCoRecordMetaData, JCoStructure}

object jcostructure {

  trait JCoStructureAlg[F[_]] extends jcorecord.JCoRecordAlg[F] {
    // public abstract com.sap.conn.jco.JCoRecordMetaData getRecordMetaData();
    def getRecordMetaData: F[JCoRecordMetaData]
    // public abstract com.sap.conn.jco.JCoRecordFieldIterator getRecordFieldIterator();
    def getRecordFieldIterator: F[JCoRecordFieldIterator]
  }

  type JCoStructureK[M[_], A] = Kleisli[M, JCoStructure, A]

  class JCoStructureInterpreter[M[_]](
    override implicit val M: Async[M]
  ) extends JCoStructureAlg[JCoStructureK[M, ?]] with jcorecord.JCoRecordInterpreter[JCoStructure, M] {

    def getRecordMetaData: F[JCoRecordMetaData] =
      Kleisli(v => M.delay(v.getRecordMetaData))

    def getRecordFieldIterator: F[JCoRecordFieldIterator] =
      Kleisli(v => M.delay(v.getRecordFieldIterator))

  }

}
