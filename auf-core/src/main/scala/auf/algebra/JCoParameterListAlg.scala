package auf.algebra

import com.sap.conn.jco.{JCoListMetaData, JCoParameterFieldIterator}

trait JCoParameterListAlg[F[_]] extends JCoRecordAlg[F] {
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
