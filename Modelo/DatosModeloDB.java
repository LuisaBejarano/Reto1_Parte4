package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DatosModeloDB {

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    DatosDB datosDB;

    public ArrayList<DatosDB> getDepartamentosEmpresa(String nitEmpresa) {

        String query = "SELECT dep.idDepartamento, dep.nombreDep FROM departamento AS dep INNER JOIN empresa AS emp ON dep.FK_nit = emp.nit WHERE emp.nit = ?';";
        System.out.println(query);

        ArrayList listaDepartamentos = new ArrayList();
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                datosDB = new DatosDB();
                datosDB.setIdDepartamento(rs.getInt("idDepartamento"));
                datosDB.setNombreDep(rs.getString("nombreDep"));
                listaDepartamentos.add(datosDB);
                System.out.println(listaDepartamentos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de departamentos.", "", JOptionPane.ERROR_MESSAGE);
        }
        return listaDepartamentos;
    }
    
    //Si se tuviesen varias empresas si es necesario esta función
    public ArrayList<DatosDB> getEmpresa(String nitEmpresa) {
        String query = "SELECT * FROM `empresa`;";

        ArrayList listaEmpresas = new ArrayList();
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                datosDB = new DatosDB();
                datosDB.setNit(rs.getString("nit"));
                datosDB.setNombreEmpresa(rs.getString("nombreEmpresa"));
                listaEmpresas.add(datosDB);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de empresa.", "", JOptionPane.ERROR_MESSAGE);
        }
        return listaEmpresas;
    }
    
    public void pruebaFunciones(){
        System.out.println(getEmpresa("88888888-"));
        System.out.println(getDepartamentosEmpresa("88888888-"));
        System.out.println(getDepartamentosEmpresa("99999999-"));
    }
}
