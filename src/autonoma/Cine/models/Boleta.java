package autonoma.Cine.models;

// Clase que representa una boleta (entrada individual al cine)
public class Boleta {
    private Pelicula pelicula;
    private Funcion funcion;
    private Usuario usuario;
    private int valorFinal;

    // Constructor que recibe la pelicula, la funcion y el usuario
    public Boleta(Pelicula pelicula, Funcion funcion, Usuario usuario) {
        this.pelicula = pelicula;
        this.funcion = funcion;
        this.usuario = usuario;
        this.valorFinal = calcularValorFinal();
    }

    // Metodo privado que calcula el valor final de la boleta
    private int calcularValorFinal() {
        int costo = pelicula.getCostoBase();

        // Aplicar descuento por funcion (porcentaje)
        int descuentoFuncion = costo * funcion.getPorcentajeDescuento() / 100;
        costo -= descuentoFuncion;

        // Aplicar descuento por tipo de usuario (valor fijo)
        int descuentoUsuario = usuario.getDescuento();
        costo -= descuentoUsuario;

        // Asegurar que el valor final nunca sea menor que 0
        if (costo < 0) {
            costo = 0;
        }

        return costo;
    }

    // Metodo que retorna el resumen de la boleta
    public String getDetalle() {
        return "Pelicula: " + pelicula.getNombre() +
               " | Funcion: " + funcion.getNombre() +
               " | Usuario: " + usuario.getNombre() +
               " | Valor: $" + valorFinal;
    }

    // Metodo para obtener el valor final de la boleta
    public int getValorFinal() {
        return valorFinal;
    }
}
