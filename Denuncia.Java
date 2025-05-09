public class Denuncia {
    private String correo;
    private String nombre;
    private String cedula;
    private String fechaHechos;
    private String descripcion;

    public Denuncia(String correo, String nombre, String cedula, String fechaHechos, String descripcion) {
        this.correo = correo;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaHechos = fechaHechos;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Denuncia registrada:\n" +
               "Nombre: " + nombre + "\n" +
               "Correo: " + correo + "\n" +
               "Cédula: " + cedula + "\n" +
               "Fecha de los hechos: " + fechaHechos + "\n" +
               "Descripción: " + descripcion;
    }
}
