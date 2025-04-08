package autonoma.Cine.models;

// Clase que representa una funcion de cine (horario de exhibicion)
public class Funcion {
    private String nombre;
    private int porcentajeDescuento;

    // Constructor que recibe el nombre de la funcion y el porcentaje de descuento
    public Funcion(String nombre, int porcentajeDescuento) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Metodo para obtener el nombre de la funcion (ej: Primera, Tarde, Noche)
    public String getNombre() {
        return nombre;
    }

    // Metodo para obtener el porcentaje de descuento asociado a la funcion
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
