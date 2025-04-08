package autonoma.Cine.models;

import java.util.*;

// Clase que representa una factura generada al vender varias boletas
public class Factura {
    private List<Boleta> boletas; // Lista de boletas incluidas en la factura
    private int total;            // Total a pagar por la factura

    // Constructor que inicializa la lista de boletas y el total
    public Factura() {
        this.boletas = new ArrayList<>();
        this.total = 0;
    }

    // Metodo para agregar una boleta a la factura y actualizar el total
    public void agregarBoleta(Boleta boleta) {
        boletas.add(boleta);                         // Agrega la boleta a la lista
        total += boleta.getValorFinal();             // Suma su valor al total
    }

    // Metodo que imprime en consola los detalles de la factura
    public void imprimirFactura() {
        System.out.println("\\n--- FACTURA ---");
        for (Boleta b : boletas) {
            System.out.println(b.getDetalle());      // Imprime el detalle de cada boleta
        }
        System.out.println("TOTAL A PAGAR: $" + total);
    }

    // Metodo para obtener el total acumulado (opcional)
    public int getTotal() {
        return total;
    }
}
