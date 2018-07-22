package auf.algebra

import com.sap.conn.jco.{JCoCustomDestination, JCoDestination}

object jcocustomdestination {

  trait JCoCustomDestinationAlg[F[_]] {
    // public abstract void setRepositoryDestination(com.sap.conn.jco.JCoDestination) throws com.sap.conn.jco.JCoException;
    def setRepositoryDestination(a: JCoDestination): F[Unit]
    // public abstract com.sap.conn.jco.JCoCustomDestination$SncConfigurationData getSNCConfiguration();
    def getSNCConfiguration: F[JCoCustomDestination.SncConfigurationData]
    // public abstract com.sap.conn.jco.JCoCustomDestination$UserData getUserLogonData();
    def getUserLogonData: F[JCoCustomDestination.UserData]
    // public abstract void setTrace(boolean);
    def setTrace(a: Boolean): F[Unit]
    // public abstract void setCodepage(java.lang.String);
    def setCodepage(a: String): F[Unit]
    // public abstract void setUseSapGui(boolean);
    def setUseSapGui(a: Boolean): F[Unit]
  }

}
