package auf.algebra

import java.io.{Reader, Writer}

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoClassMetaData, JCoFunction, JCoFunctionTemplate, JCoListMetaData, JCoRecordMetaData, JCoRepository, JCoRequest}
import com.sap.conn.jco.monitor.JCoRepositoryMonitor

object jcorepository {

  trait JCoRepositoryAlg[F[_]] {
    // public abstract java.lang.String getName();
    def getName: F[String]
    // public abstract com.sap.conn.jco.JCoFunctionTemplate getFunctionTemplate(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getFunctionTemplate(a: String): F[JCoFunctionTemplate]
    // public abstract com.sap.conn.jco.JCoFunction getFunction(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getFunction(a: String): F[JCoFunction]
    // public abstract com.sap.conn.jco.JCoRequest getRequest(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getRequest(a: String): F[JCoRequest]
    // public abstract com.sap.conn.jco.JCoListMetaData getFunctionInterface(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getFunctionInterface(a: String): F[JCoListMetaData]
    // public abstract com.sap.conn.jco.JCoRecordMetaData getRecordMetaData(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getRecordMetaData(a: String): F[JCoRecordMetaData]
    // public abstract com.sap.conn.jco.JCoRecordMetaData getStructureDefinition(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getStructureDefinition(a: String): F[JCoRecordMetaData]
    // public abstract com.sap.conn.jco.JCoClassMetaData getClassMetaData(java.lang.String) throws com.sap.conn.jco.JCoException;
    def getClassMetaData(a: String): F[JCoClassMetaData]
    // public abstract void removeFunctionTemplateFromCache(java.lang.String);
    def removeFunctionTemplateFromCache(a: String): F[Unit]
    // public abstract void removeRecordMetaDataFromCache(java.lang.String);
    def removeRecordMetaDataFromCache(a: String): F[Unit]
    // public abstract void removeClassMetaDataFromCache(java.lang.String);
    def removeClassMetaDataFromCache(a: String): F[Unit]
    // public abstract java.lang.String[] getCachedFunctionTemplateNames();
    def getCachedFunctionTemplateNames: F[Array[String]]
    // public abstract java.lang.String[] getCachedRecordMetaDataNames();
    def getCachedRecordMetaDataNames: F[Array[String]]
    // public abstract java.lang.String[] getCachedClassMetaDataNames();
    def getCachedClassMetaDataNames: F[Array[String]]
    // public abstract boolean isUnicode();
    def isUnicode: F[Boolean]
    // public abstract void clear();
    def clear: F[Unit]
    // public abstract com.sap.conn.jco.monitor.JCoRepositoryMonitor getMonitor();
    def getMonitor: F[JCoRepositoryMonitor]
    // public abstract void load(java.io.Reader) throws java.io.IOException;
    def load(a: Reader): F[Unit]
    // public abstract void save(java.io.Writer) throws java.io.IOException;
    def save(a: Writer): F[Unit]
  }

  type JCoRepositoryK[F[_], A] = Kleisli[F, JCoRepository, A]

  class JCoRepositoryInterpreter[M[_]](implicit M: Async[M]) extends JCoRepositoryAlg[JCoRepositoryK[M, ?]] {

    type F[A] = JCoRepositoryK[M, A]

    def getName: F[String] =
      Kleisli(v => M.delay(v.getName))

    def getFunctionTemplate(a: String): F[JCoFunctionTemplate] =
      Kleisli(v => M.delay(v.getFunctionTemplate(a)))

    def getFunction(a: String): F[JCoFunction] =
      Kleisli(v => M.delay(v.getFunction(a)))

    def getRequest(a: String): F[JCoRequest] =
      Kleisli(v => M.delay(v.getRequest(a)))

    def getFunctionInterface(a: String): F[JCoListMetaData] =
      Kleisli(v => M.delay(v.getFunctionInterface(a)))

    def getRecordMetaData(a: String): F[JCoRecordMetaData] =
      Kleisli(v => M.delay(v.getRecordMetaData(a)))

    def getStructureDefinition(a: String): F[JCoRecordMetaData] =
      Kleisli(v => M.delay(v.getStructureDefinition(a)))

    def getClassMetaData(a: String): F[JCoClassMetaData] =
      Kleisli(v => M.delay(v.getClassMetaData(a)))

    def removeFunctionTemplateFromCache(a: String): F[Unit] =
      Kleisli(v => M.delay(v.removeFunctionTemplateFromCache(a)))

    def removeRecordMetaDataFromCache(a: String): F[Unit] =
      Kleisli(v => M.delay(v.removeRecordMetaDataFromCache(a)))

    def removeClassMetaDataFromCache(a: String): F[Unit] =
      Kleisli(v => M.delay(v.removeClassMetaDataFromCache(a)))

    def getCachedFunctionTemplateNames: F[Array[String]] =
      Kleisli(v => M.delay(v.getCachedFunctionTemplateNames))

    def getCachedRecordMetaDataNames: F[Array[String]] =
      Kleisli(v => M.delay(v.getCachedRecordMetaDataNames))

    def getCachedClassMetaDataNames: F[Array[String]] =
      Kleisli(v => M.delay(v.getCachedClassMetaDataNames))

    def isUnicode: F[Boolean] =
      Kleisli(v => M.delay(v.isUnicode))

    def clear: F[Unit] =
      Kleisli(v => M.delay(v.clear))

    def getMonitor: F[JCoRepositoryMonitor] =
      Kleisli(v => M.delay(v.getMonitor))

    def load(a: Reader): F[Unit] =
      Kleisli(v => M.delay(v.load(a)))

    def save(a: Writer): F[Unit] =
      Kleisli(v => M.delay(v.save(a)))

  }

}
