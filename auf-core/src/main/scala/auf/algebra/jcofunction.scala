package auf.algebra

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{AbapClassException, AbapException, JCoDestination, JCoFunction, JCoFunctionTemplate, JCoParameterList}

object jcofunction {

  trait JCoFunctionAlg[F[_]] {
    // public abstract java.lang.String getName();
    def getName: F[String]
    // public abstract com.sap.conn.jco.JCoParameterList getImportParameterList();
    def getImportParameterList: F[JCoParameterList]
    // public abstract com.sap.conn.jco.JCoParameterList getExportParameterList();
    def getExportParameterList: F[JCoParameterList]
    // public abstract com.sap.conn.jco.JCoParameterList getChangingParameterList();
    def getChangingParameterList: F[JCoParameterList]
    // public abstract com.sap.conn.jco.JCoParameterList getTableParameterList();
    def getTableParameterList: F[JCoParameterList]
    // public abstract com.sap.conn.jco.AbapException[] getExceptionList();
    def getExceptionList: F[Array[AbapException]]
    // public abstract com.sap.conn.jco.AbapException getException(java.lang.String);
    def getException(a: String): F[AbapException]
    // public abstract void setAbapClassExceptionMode(com.sap.conn.jco.AbapClassException$Mode);
    def setAbapClassExceptionMode(a: AbapClassException.Mode): F[Unit]
    // public abstract boolean isAbapClassExceptionEnabled();
    def isAbapClassExceptionEnabled: F[Boolean]
    // public abstract void execute(com.sap.conn.jco.JCoDestination) throws com.sap.conn.jco.JCoException;
    def execute(a: JCoDestination): F[Unit]
    // public abstract void execute(com.sap.conn.jco.JCoDestination, java.lang.String) throws com.sap.conn.jco.JCoException;
    def execute(a: JCoDestination, b: String): F[Unit]
    // public abstract void execute(com.sap.conn.jco.JCoDestination, java.lang.String, java.lang.String) throws com.sap.conn.jco.JCoException;
    def execute(a: JCoDestination, b: String, c: String): F[Unit]
    // public abstract java.lang.String toXML();
    def toXML: F[String]
    // public abstract com.sap.conn.jco.JCoFunctionTemplate getFunctionTemplate();
    def getFunctionTemplate: F[JCoFunctionTemplate]
  }

  type JCoFunctionK[M[_], A] = Kleisli[M, JCoFunction, A]

  class JCoFunctionInterpreter[M[_]](implicit M: Async[M]) extends JCoFunctionAlg[JCoFunctionK[M, ?]] {

    type F[A] = JCoFunctionK[M, A]

    def getName: F[String] =
      Kleisli(f => M.delay(f.getName))

    def getImportParameterList: F[JCoParameterList] =
      Kleisli(f => M.delay(f.getImportParameterList))

    def getExportParameterList: F[JCoParameterList] =
      Kleisli(f => M.delay(f.getExportParameterList))

    def getChangingParameterList: F[JCoParameterList] =
      Kleisli(f => M.delay(f.getChangingParameterList))

    def getTableParameterList: F[JCoParameterList] =
      Kleisli(f => M.delay(f.getTableParameterList))

    def getExceptionList: F[Array[AbapException]] =
      Kleisli(f => M.delay(f.getExceptionList))

    def getException(a: String): F[AbapException] =
      Kleisli(f => M.delay(f.getException(a)))

    def setAbapClassExceptionMode(a: AbapClassException.Mode): F[Unit] =
      Kleisli(f => M.delay(f.setAbapClassExceptionMode(a)))

    def isAbapClassExceptionEnabled: F[Boolean] =
      Kleisli(f => M.delay(f.isAbapClassExceptionEnabled))

    def execute(a: JCoDestination): F[Unit] =
      Kleisli(f => M.delay(f.execute(a)))

    def execute(a: JCoDestination, b: String): F[Unit] =
      Kleisli(f => M.delay(f.execute(a, b)))

    def execute(a: JCoDestination, b: String, c: String): F[Unit] =
      Kleisli(f => M.delay(f.execute(a, b, c)))

    def toXML: F[String] =
      Kleisli(f => M.delay(f.toXML))

    def getFunctionTemplate: F[JCoFunctionTemplate] =
      Kleisli(f => M.delay(f.getFunctionTemplate))

  }

}
