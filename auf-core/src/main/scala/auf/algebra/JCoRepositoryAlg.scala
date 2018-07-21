package auf.algebra

import java.io.{Reader, Writer}

import com.sap.conn.jco.{JCoClassMetaData, JCoFunction, JCoFunctionTemplate, JCoListMetaData, JCoRecordMetaData, JCoRequest}
import com.sap.conn.jco.monitor.JCoRepositoryMonitor

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
