package auf.algebra

import java.util.Properties

import com.sap.conn.jco.{JCoAttributes, JCoCustomDestination, JCoFunctionUnitState, JCoRepository, JCoThroughput, JCoUnitIdentifier}
import com.sap.conn.jco.monitor.JCoDestinationMonitor

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
