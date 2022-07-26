package Principal;
import Modelo.Conexion;
import Modelo.DatosModeloDB;
import Vistas.*;

public class Main {

    
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConnection();
        
        DatosModeloDB datosModeloDB = new DatosModeloDB();
        //datosModeloDB.getDepartamentosEmpresa("99999999-");
        datosModeloDB.pruebaFunciones();
        
        Login login = new Login();
        
        login.setVisible(true);
    }
    
}
