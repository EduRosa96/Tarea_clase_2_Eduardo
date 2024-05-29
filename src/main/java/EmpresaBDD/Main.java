package EmpresaBDD;

public class Main {

    public static void main(String[] args) {
        GestionDietas gestor = new Conexion();
        System.out.println(gestor.Conexion());
        System.out.println(gestor.crearTabla());
        gestor.rellenarTabla();
        gestor.mostrarDietas();
    }
}
