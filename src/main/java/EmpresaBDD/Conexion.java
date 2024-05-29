package EmpresaBDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion implements GestionDietas{
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/empresa?allowPublicKeyRetrieval=true";
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
            String sql = "CREATE TABLE IF NOT EXISTS `dietas` (\n"
                    + "  `id` int NOT NULL AUTO_INCREMENT,\n"
                    + "  `empleado` varchar(45) NOT NULL,\n"
                    + "  `departamento` int NOT NULL,\n"
                    + "  `cantidad` varchar(1000) NOT NULL,\n"
                    + "  `concepto` varchar(100) NOT NULL,\n"
                    + "  PRIMARY KEY (`id`)\n"
                    + ")";
            Conexion().createStatement().execute(sql);
           return "Se ha creado la tabla";
        } catch (Exception e) {
            return "No se ha podido crear la tabla";
        }
    }

    public void rellenarTabla (){
        try {
            String sql = "INSERT INTO `dietas` (`empleado`, `departamento`, `cantidad`, `concepto`) VALUES ('Pedro', '2', '3000', 'Desayuno')";
            Conexion().createStatement().execute(sql);
            System.out.println("Se ha insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
