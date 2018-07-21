package auf.algebra

import com.sap.conn.jco.{AbapClassException, AbapException, JCoDestination, JCoFunctionTemplate, JCoParameterList}

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
