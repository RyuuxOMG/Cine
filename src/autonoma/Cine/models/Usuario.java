package autonoma.Cine.models;

// Clase que representa un usuario del sistema (cliente)
public class Usuario {
    private String nombre;
    private String tipo;

    // Constructor que recibe el nombre y el tipo de usuario (Nino, Adulto, Mayor)
    public Usuario(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Metodo para obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener el tipo de usuario
    public String getTipo() {
        return tipo;
    }

    // Metodo para obtener el descuento asociado al tipo de usuario
    public int getDescuento() {
        switch (tipo.toLowerCase()) {
            case "nino":
                return 500;
            case "mayor":
                return 1000;
            default:
                return 0; // Adulto u otros
        }
    }
}