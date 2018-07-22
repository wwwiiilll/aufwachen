package auf.algebra

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoListMetaData, JCoParameterFieldIterator, JCoParameterList}

object jcoparameterlist {

  trait JCoParameterListAlg[F[_]] extends jcorecord.JCoRecordAlg[F] {
    // public abstract com.sap.conn.jco.JCoListMetaData getListMetaData();
    def getListMetaData: F[JCoListMetaData]
    // public abstract com.sap.conn.jco.JCoParameterFieldIterator getParameterFieldIterator();
    def getParameterFieldIterator: F[JCoParameterFieldIterator]
    // public abstract boolean isActive(int);
    def isActive(a: Int): F[Boolean]
    // public abstract boolean isActive(java.lang.String);
    def isActive(a: String): F[Boolean]
    // public abstract void setActive(int, boolean);
    def setActive(a: Int, b: Boolean): F[Unit]
    // public abstract void setActive(java.lang.String, boolean);
    def setActive(a: String, b: Boolean): F[Unit]
  }

  type JCoParameterListK[M[_], A] = Kleisli[M, JCoParameterList, A]

  class JCoParameterListInterpreter[M[_]](
    override implicit val M: Async[M]
  ) extends JCoParameterListAlg[JCoParameterListK[M, ?]] with jcorecord.JCoRecordInterpreter[JCoParameterList, M] {

    def getListMetaData: F[JCoListMetaData] =
      Kleisli(v => M.delay(v.getListMetaData))

    def getParameterFieldIterator: F[JCoParameterFieldIterator] =
      Kleisli(v => M.delay(v.getParameterFieldIterator))

    def isActive(a: Int): F[Boolean] =
      Kleisli(v => M.delay(v.isActive(a)))

    def isActive(a: String): F[Boolean] =
      Kleisli(v => M.delay(v.isActive(a)))

    def setActive(a: Int, b: Boolean): F[Unit] =
      Kleisli(v => M.delay(v.setActive(a, b)))

    def setActive(a: String, b: Boolean): F[Unit] =
      Kleisli(v => M.delay(v.setActive(a, b)))

  }

}
