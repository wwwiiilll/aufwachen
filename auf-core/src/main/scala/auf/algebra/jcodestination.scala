package auf.algebra

import java.util.Properties

import cats.data.Kleisli
import cats.effect.Async

import com.sap.conn.jco.{JCoAttributes, JCoCustomDestination, JCoDestination, JCoFunctionUnitState, JCoRepository, JCoThroughput, JCoUnitIdentifier}
import com.sap.conn.jco.monitor.JCoDestinationMonitor

object jcodestination {

  trait JCoDestinationAlg[F[_]] {
    // public abstract java.lang.String getDestinationName();
    def getDestinationName: F[String]
    // public abstract java.lang.String getDestinationID();
    def getDestinationID: F[String]
    // public abstract char getType();
    def getType: F[Char]
    // public abstract java.lang.String getApplicationServerHost();
    def getApplicationServerHost: F[String]
    // public abstract java.lang.String getSAPRouterString();
    def getSAPRouterString: F[String]
    // public abstract java.lang.String getGatewayHost();
    def getGatewayHost: F[String]
    // public abstract java.lang.String getGatewayService();
    def getGatewayService: F[String]
    // public abstract java.lang.String getSystemNumber();
    def getSystemNumber: F[String]
    // public abstract java.lang.String getLogonGroup();
    def getLogonGroup: F[String]
    // public abstract java.lang.String getMessageServerHost();
    def getMessageServerHost: F[String]
    // public abstract java.lang.String getMessageServerService();
    def getMessageServerService: F[String]
    // public abstract java.lang.String getR3Name();
    def getR3Name: F[String]
    // public abstract java.lang.String getTPHost();
    def getTPHost: F[String]
    // public abstract java.lang.String getTPName();
    def getTPName: F[String]
    // public abstract java.lang.String getSncLibrary();
    def getSncLibrary: F[String]
    // public abstract java.lang.String getSncMode();
    def getSncMode: F[String]
    // public abstract java.lang.String getSncMyName();
    def getSncMyName: F[String]
    // public abstract java.lang.String getSncPartnerName();
    def getSncPartnerName: F[String]
    // public abstract java.lang.String getSncQOP();
    def getSncQOP: F[String]
    // public abstract java.lang.String getSncSSO();
    def getSncSSO: F[String]
    // public abstract java.lang.String getAliasUser();
    def getAliasUser: F[String]
    // public abstract java.lang.String getClient();
    def getClient: F[String]
    // public abstract java.lang.String getLanguage();
    def getLanguage: F[String]
    // public abstract java.lang.String getUser();
    def getUser: F[String]
    // public abstract java.lang.String getLogonCheck();
    def getLogonCheck: F[String]
    // public abstract java.lang.String getExternalIDData();
    def getExternalIDData: F[String]
    // public abstract java.lang.String getExternalIDType();
    def getExternalIDType: F[String]
    // public abstract int getPeakLimit();
    def getPeakLimit: F[Int]
    // public abstract int getPoolCapacity();
    def getPoolCapacity: F[Int]
    // public abstract long getExpirationTime();
    def getExpirationTime: F[Long]
    // public abstract long getExpirationCheckPeriod();
    def getExpirationCheckPeriod: F[Long]
    // public abstract long getMaxGetClientTime();
    def getMaxGetClientTime: F[Long]
    // public abstract java.util.Properties getProperties();
    def getProperties: F[Properties]
    // public abstract com.sap.conn.jco.JCoAttributes getAttributes() throws com.sap.conn.jco.JCoException;
    def getAttributes: F[JCoAttributes]
    // public abstract com.sap.conn.jco.JCoRepository getRepository() throws com.sap.conn.jco.JCoException;
    def getRepository: F[JCoRepository]
    // public abstract java.lang.String getRepositoryUser();
    def getRepositoryUser: F[String]
    // public abstract com.sap.conn.jco.JCoCustomDestination createCustomDestination();
    def createCustomDestination: F[JCoCustomDestination]
    // public abstract void confirmTID(java.lang.String) throws com.sap.conn.jco.JCoException;
    def confirmTID(a: String): F[Unit]
    // public abstract java.lang.String createTID() throws com.sap.conn.jco.JCoException;
    def createTID: F[String]
    // public abstract void confirmFunctionUnit(com.sap.conn.jco.JCoUnitIdentifier) throws com.sap.conn.jco.JCoException;
    def confirmFunctionUnit(a: JCoUnitIdentifier): F[Unit]
    // public abstract com.sap.conn.jco.JCoFunctionUnitState getFunctionUnitState(com.sap.conn.jco.JCoUnitIdentifier) throws com.sap.conn.jco.JCoException;
    def getFunctionUnitState(a: JCoUnitIdentifier): F[JCoFunctionUnitState]
    // public abstract void setThroughput(com.sap.conn.jco.JCoThroughput);
    def setThroughput(a: JCoThroughput): F[Unit]
    // public abstract com.sap.conn.jco.JCoThroughput getThroughput();
    def getThroughput: F[JCoThroughput]
    // public abstract void removeThroughput();
    def removeThroughput: F[Unit]
    // public abstract void ping() throws com.sap.conn.jco.JCoException;
    def ping: F[Unit]
    // public abstract boolean isValid();
    def isValid: F[Boolean]
    // public abstract void changePassword(java.lang.String, java.lang.String) throws com.sap.conn.jco.JCoException;
    def changePassword(a: String, b: String): F[Unit]
    // public abstract com.sap.conn.jco.monitor.JCoDestinationMonitor getMonitor() throws com.sap.conn.jco.JCoRuntimeException;
    def getMonitor: F[JCoDestinationMonitor]
    // public abstract com.sap.conn.jco.monitor.JCoDestinationMonitor getRepositoryDestinationMonitor();
    def getRepositoryDestinationMonitor: F[JCoDestinationMonitor]
  }

  type JCoDestinationK[F[_], A] = Kleisli[F, JCoDestination, A]

  class JCoDestinationInterpreter[M[_]](implicit M: Async[M]) extends JCoDestinationAlg[JCoDestinationK[M, ?]] {

    type F[A] = JCoDestinationK[M, A]

    def getDestinationName: F[String] =
      Kleisli(v => M.delay(v.getDestinationName))

    def getDestinationID: F[String] =
      Kleisli(v => M.delay(v.getDestinationID))

    def getType: F[Char] =
      Kleisli(v => M.delay(v.getType))

    def getApplicationServerHost: F[String] =
      Kleisli(v => M.delay(v.getApplicationServerHost))

    def getSAPRouterString: F[String] =
      Kleisli(v => M.delay(v.getSAPRouterString))

    def getGatewayHost: F[String] =
      Kleisli(v => M.delay(v.getGatewayHost))

    def getGatewayService: F[String] =
      Kleisli(v => M.delay(v.getGatewayService))

    def getSystemNumber: F[String] =
      Kleisli(v => M.delay(v.getSystemNumber))

    def getLogonGroup: F[String] =
      Kleisli(v => M.delay(v.getLogonGroup))

    def getMessageServerHost: F[String] =
      Kleisli(v => M.delay(v.getMessageServerHost))

    def getMessageServerService: F[String] =
      Kleisli(v => M.delay(v.getMessageServerService))

    def getR3Name: F[String] =
      Kleisli(v => M.delay(v.getR3Name))

    def getTPHost: F[String] =
      Kleisli(v => M.delay(v.getTPHost))

    def getTPName: F[String] =
      Kleisli(v => M.delay(v.getTPName))

    def getSncLibrary: F[String] =
      Kleisli(v => M.delay(v.getSncLibrary))

    def getSncMode: F[String] =
      Kleisli(v => M.delay(v.getSncMode))

    def getSncMyName: F[String] =
      Kleisli(v => M.delay(v.getSncMyName))

    def getSncPartnerName: F[String] =
      Kleisli(v => M.delay(v.getSncPartnerName))

    def getSncQOP: F[String] =
      Kleisli(v => M.delay(v.getSncQOP))

    def getSncSSO: F[String] =
      Kleisli(v => M.delay(v.getSncSSO))

    def getAliasUser: F[String] =
      Kleisli(v => M.delay(v.getAliasUser))

    def getClient: F[String] =
      Kleisli(v => M.delay(v.getClient))

    def getLanguage: F[String] =
      Kleisli(v => M.delay(v.getLanguage))

    def getUser: F[String] =
      Kleisli(v => M.delay(v.getUser))

    def getLogonCheck: F[String] =
      Kleisli(v => M.delay(v.getLogonCheck))

    def getExternalIDData: F[String] =
      Kleisli(v => M.delay(v.getExternalIDData))

    def getExternalIDType: F[String] =
      Kleisli(v => M.delay(v.getExternalIDType))

    def getPeakLimit: F[Int] =
      Kleisli(v => M.delay(v.getPeakLimit))

    def getPoolCapacity: F[Int] =
      Kleisli(v => M.delay(v.getPoolCapacity))

    def getExpirationTime: F[Long] =
      Kleisli(v => M.delay(v.getExpirationTime))

    def getExpirationCheckPeriod: F[Long] =
      Kleisli(v => M.delay(v.getExpirationCheckPeriod))

    def getMaxGetClientTime: F[Long] =
      Kleisli(v => M.delay(v.getMaxGetClientTime))

    def getProperties: F[Properties] =
      Kleisli(v => M.delay(v.getProperties))

    def getAttributes: F[JCoAttributes] =
      Kleisli(v => M.delay(v.getAttributes))

    def getRepository: F[JCoRepository] =
      Kleisli(v => M.delay(v.getRepository))

    def getRepositoryUser: F[String] =
      Kleisli(v => M.delay(v.getRepositoryUser))

    def createCustomDestination: F[JCoCustomDestination] =
      Kleisli(v => M.delay(v.createCustomDestination))

    def confirmTID(a: String): F[Unit] =
      Kleisli(v => M.delay(v.confirmTID(a)))

    def createTID: F[String] =
      Kleisli(v => M.delay(v.createTID))

    def confirmFunctionUnit(a: JCoUnitIdentifier): F[Unit] =
      Kleisli(v => M.delay(v.confirmFunctionUnit(a)))

    def getFunctionUnitState(a: JCoUnitIdentifier): F[JCoFunctionUnitState] =
      Kleisli(v => M.delay(v.getFunctionUnitState(a)))

    def setThroughput(a: JCoThroughput): F[Unit] =
      Kleisli(v => M.delay(v.setThroughput(a)))

    def getThroughput: F[JCoThroughput] =
      Kleisli(v => M.delay(v.getThroughput))

    def removeThroughput: F[Unit] =
      Kleisli(v => M.delay(v.removeThroughput))

    def ping: F[Unit] =
      Kleisli(v => M.delay(v.ping))

    def isValid: F[Boolean] =
      Kleisli(v => M.delay(v.isValid))

    def changePassword(a: String, b: String): F[Unit] =
      Kleisli(v => M.delay(v.changePassword(a, b)))

    def getMonitor: F[JCoDestinationMonitor] =
      Kleisli(v => M.delay(v.getMonitor))

    def getRepositoryDestinationMonitor: F[JCoDestinationMonitor] =
      Kleisli(v => M.delay(v.getRepositoryDestinationMonitor))

  }

}
