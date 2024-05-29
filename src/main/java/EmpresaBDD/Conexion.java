package EmpresaBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexion implements GestionDietas {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3308/empresa?allowPublicKeyRetrieval=true";
    private static final String USUARIO = "root";
    private static final String CLAVE = "1234";


    public Connection Conexion() {
        Connection conexion = null;
        try {
            Class.forName(DRIVER);
            System.out.println("Conexión exitosa");
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
        }
        return conexion;
    }

    public String crearTabla() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS `dietas` (\n" +
                            "  id int NOT NULL AUTO_INCREMENT,\n"
                            + "  empleado varchar(45) ,\n"
                            + "  departamento varchar(1000) ,\n"
                            + "  cantidad varchar(1000) ,\n"
                            + "  concepto varchar(10),\n"
                            + "  PRIMARY KEY (id)\n"
                            + ")";
            Conexion().createStatement().execute(sql);
            return "Se ha creado la tabla";
        } catch (Exception e) {
            return "No se ha podido crear la tabla";
        }
    }

    public void rellenarTabla() {
        try {
            String sql = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Pedro', 'ventas', '30', 'Almuerzo')";
            Conexion().createStatement().execute(sql);
            String sql2 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Jose', 'informática', '30', 'Almuerzo')";
            Conexion().createStatement().execute(sql2);
            String sql3 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Juan', 'recursos humanos', '15', 'Desayuno')";
            Conexion().createStatement().execute(sql3);
            String sql4 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Maria', 'recursos humanos', '10', 'Desayuno')";
            Conexion().createStatement().execute(sql4);
            String sql5 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Pedro', 'ventas', '20', 'Cena')";
            Conexion().createStatement().execute(sql5);
            String sql6 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Jose', 'informatica', '15', 'Cena')";
            Conexion().createStatement().execute(sql6);
            String sql7 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Juan', 'recursos humanos', '10', 'Cena')";
            Conexion().createStatement().execute(sql7);
            String sql8 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Maria', 'recursos humanos', '5', 'Cena')";
            Conexion().createStatement().execute(sql8);
            String sql9 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Pedro', 'ventas', '10', 'Cena')";
            Conexion().createStatement().execute(sql9);
            String sql10 = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Jose', 'informatica', '45', 'Cena')";
            Conexion().createStatement().execute(sql10);
            System.out.println("Se ha insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarDietas() {
        Conexion conexion = new Conexion();
        try {
            String sql = "SELECT empleado, departamento, cantidad, concepto " +
                    "FROM dietas " +
                    "WHERE departamento = 'informática' AND cantidad > 30;";

            ResultSet rs = conexion.Conexion().createStatement().executeQuery(sql);
            while (rs.next()) {
                System.out.println(((ResultSet) rs).getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
