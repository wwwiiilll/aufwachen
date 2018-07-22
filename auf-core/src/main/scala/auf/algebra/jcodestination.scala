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
      Kleisli(d => M.delay(d.getDestinationName))

    def getDestinationID: F[String] =
      Kleisli(d => M.delay(d.getDestinationID))

    def getType: F[Char] =
      Kleisli(d => M.delay(d.getType))

    def getApplicationServerHost: F[String] =
      Kleisli(d => M.delay(d.getApplicationServerHost))

    def getSAPRouterString: F[String] =
      Kleisli(d => M.delay(d.getSAPRouterString))

    def getGatewayHost: F[String] =
      Kleisli(d => M.delay(d.getGatewayHost))

    def getGatewayService: F[String] =
      Kleisli(d => M.delay(d.getGatewayService))

    def getSystemNumber: F[String] =
      Kleisli(d => M.delay(d.getSystemNumber))

    def getLogonGroup: F[String] =
      Kleisli(d => M.delay(d.getLogonGroup))

    def getMessageServerHost: F[String] =
      Kleisli(d => M.delay(d.getMessageServerHost))

    def getMessageServerService: F[String] =
      Kleisli(d => M.delay(d.getMessageServerService))

    def getR3Name: F[String] =
      Kleisli(d => M.delay(d.getR3Name))

    def getTPHost: F[String] =
      Kleisli(d => M.delay(d.getTPHost))

    def getTPName: F[String] =
      Kleisli(d => M.delay(d.getTPName))

    def getSncLibrary: F[String] =
      Kleisli(d => M.delay(d.getSncLibrary))

    def getSncMode: F[String] =
      Kleisli(d => M.delay(d.getSncMode))

    def getSncMyName: F[String] =
      Kleisli(d => M.delay(d.getSncMyName))

    def getSncPartnerName: F[String] =
      Kleisli(d => M.delay(d.getSncPartnerName))

    def getSncQOP: F[String] =
      Kleisli(d => M.delay(d.getSncQOP))

    def getSncSSO: F[String] =
      Kleisli(d => M.delay(d.getSncSSO))

    def getAliasUser: F[String] =
      Kleisli(d => M.delay(d.getAliasUser))

    def getClient: F[String] =
      Kleisli(d => M.delay(d.getClient))

    def getLanguage: F[String] =
      Kleisli(d => M.delay(d.getLanguage))

    def getUser: F[String] =
      Kleisli(d => M.delay(d.getUser))

    def getLogonCheck: F[String] =
      Kleisli(d => M.delay(d.getLogonCheck))

    def getExternalIDData: F[String] =
      Kleisli(d => M.delay(d.getExternalIDData))

    def getExternalIDType: F[String] =
      Kleisli(d => M.delay(d.getExternalIDType))

    def getPeakLimit: F[Int] =
      Kleisli(d => M.delay(d.getPeakLimit))

    def getPoolCapacity: F[Int] =
      Kleisli(d => M.delay(d.getPoolCapacity))

    def getExpirationTime: F[Long] =
      Kleisli(d => M.delay(d.getExpirationTime))

    def getExpirationCheckPeriod: F[Long] =
      Kleisli(d => M.delay(d.getExpirationCheckPeriod))

    def getMaxGetClientTime: F[Long] =
      Kleisli(d => M.delay(d.getMaxGetClientTime))

    def getProperties: F[Properties] =
      Kleisli(d => M.delay(d.getProperties))

    def getAttributes: F[JCoAttributes] =
      Kleisli(d => M.delay(d.getAttributes))

    def getRepository: F[JCoRepository] =
      Kleisli(d => M.delay(d.getRepository))

    def getRepositoryUser: F[String] =
      Kleisli(d => M.delay(d.getRepositoryUser))

    def createCustomDestination: F[JCoCustomDestination] =
      Kleisli(d => M.delay(d.createCustomDestination))

    def confirmTID(a: String): F[Unit] =
      Kleisli(d => M.delay(d.confirmTID(a)))

    def createTID: F[String] =
      Kleisli(d => M.delay(d.createTID))

    def confirmFunctionUnit(a: JCoUnitIdentifier): F[Unit] =
      Kleisli(d => M.delay(d.confirmFunctionUnit(a)))

    def getFunctionUnitState(a: JCoUnitIdentifier): F[JCoFunctionUnitState] =
      Kleisli(d => M.delay(d.getFunctionUnitState(a)))

    def setThroughput(a: JCoThroughput): F[Unit] =
      Kleisli(d => M.delay(d.setThroughput(a)))

    def getThroughput: F[JCoThroughput] =
      Kleisli(d => M.delay(d.getThroughput))

    def removeThroughput: F[Unit] =
      Kleisli(d => M.delay(d.removeThroughput))

    def ping: F[Unit] =
      Kleisli(d => M.delay(d.ping))

    def isValid: F[Boolean] =
      Kleisli(d => M.delay(d.isValid))

    def changePassword(a: String, b: String): F[Unit] =
      Kleisli(d => M.delay(d.changePassword(a, b)))

    def getMonitor: F[JCoDestinationMonitor] =
      Kleisli(d => M.delay(d.getMonitor))

    def getRepositoryDestinationMonitor: F[JCoDestinationMonitor] =
      Kleisli(d => M.delay(d.getRepositoryDestinationMonitor))

  }

}
