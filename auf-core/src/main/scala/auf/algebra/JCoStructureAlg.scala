package auf.algebra

import com.sap.conn.jco.{JCoRecordFieldIterator, JCoRecordMetaData}

trait JCoStructureAlg[F[_]] extends JCoRecordAlg[F] {
  // public abstract com.sap.conn.jco.JCoRecordMetaData getRecordMetaData();
  def getRecordMetaData: F[JCoRecordMetaData]
  // public abstract com.sap.conn.jco.JCoRecordFieldIterator getRecordFieldIterator();
  def getRecordFieldIterator: F[JCoRecordFieldIterator]
}
