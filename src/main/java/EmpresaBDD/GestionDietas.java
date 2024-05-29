package EmpresaBDD;

import java.sql.Connection;

public interface GestionDietas {

    public Connection Conexion();
    public String crearTabla();
    public void rellenarTabla();
}
