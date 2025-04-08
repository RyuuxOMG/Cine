package autonoma.Cine.main;

import autonoma.Cine.models.*;
import autonoma.Cine.exceptions.*;

import java.util.*;

// Clase principal que ejecuta todo el sistema del cine desde consola
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        List<Funcion> funciones = new ArrayList<>();
        List<Boleta> boletasPendientes = new ArrayList<>();

        // Cargar funciones predefinidas
        funciones.add(new Funcion("Primera", 50));
        funciones.add(new Funcion("Tarde", 10));
        funciones.add(new Funcion("Noche", 0));

        int opcion;
        do {
            // Mostrar el menú principal
            System.out.println("\n--- MENU CINE ---");
            System.out.println("1. Vender boleta");
            System.out.println("2. Generar factura");
            System.out.println("3. Agregar pelicula");
            System.out.println("4. Agregar usuario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // Limpiar buffer

            try {
                switch (opcion) {
                    case 1: {
                        // Vender boleta
                        System.out.print("Nombre de la pelicula: ");
                        String nombrePelicula = entrada.nextLine();
                        Pelicula pelicula = null;
                        for (Pelicula p : peliculas) {
                            if (p.getNombre().equalsIgnoreCase(nombrePelicula)) {
                                pelicula = p;
                                break;
                            }
                        }
                        if (pelicula == null) throw new PeliculaNoExisteException("La pelicula no existe.");

                        System.out.print("Nombre del usuario: ");
                        String nombreUsuario = entrada.nextLine();
                        Usuario usuario = null;
                        for (Usuario u : usuarios) {
                            if (u.getNombre().equalsIgnoreCase(nombreUsuario)) {
                                usuario = u;
                                break;
                            }
                        }
                        if (usuario == null) throw new UsuarioNoExisteException("El usuario no existe.");

                        System.out.println("Seleccione una funcion:");
                        for (int i = 0; i < funciones.size(); i++) {
                            Funcion f = funciones.get(i);
                            System.out.println((i + 1) + ". " + f.getNombre() + " (" + f.getPorcentajeDescuento() + "% desc)");
                        }
                        System.out.print("Opcion: ");
                        int fopcion = entrada.nextInt();
                        entrada.nextLine();

                        Funcion funcion;
                        if (fopcion < 1 || fopcion > funciones.size()) {
                            System.out.println("Funcion invalida. Se asigna por defecto la funcion Noche.");
                            funcion = funciones.get(funciones.size() - 1);
                        } else {
                            funcion = funciones.get(fopcion - 1);
                        }

                        Boleta boleta = new Boleta(pelicula, funcion, usuario);
                        boletasPendientes.add(boleta);
                        System.out.println("Boleta agregada con exito.");
                        break;
                    }
                    case 2: {
                        // Generar factura
                        if (boletasPendientes.isEmpty()) {
                            System.out.println("No hay boletas para facturar.");
                            break;
                        }
                        Factura factura = new Factura();
                        for (Boleta b : boletasPendientes) {
                            factura.agregarBoleta(b);
                        }
                        factura.imprimirFactura();
                        boletasPendientes.clear();
                        break;
                    }
                    case 3: {
                        // Agregar pelicula
                        System.out.print("Nombre de la pelicula: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Costo base: ");
                        int costo = entrada.nextInt();
                        entrada.nextLine();
                        peliculas.add(new Pelicula(nombre, costo));
                        System.out.println("Pelicula agregada con exito.");
                        break;
                    }
                    case 4: {
                        // Agregar usuario
                        System.out.print("Nombre del usuario: ");
                        String nombre = entrada.nextLine();
                        System.out.print("Tipo (Nino, Adulto, Mayor): ");
                        String tipo = entrada.nextLine();
                        usuarios.add(new Usuario(nombre, tipo));
                        System.out.println("Usuario agregado con exito.");
                        break;
                    }
                    case 0:
                        System.out.println("Gracias por usar el sistema.");
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);
    }
}
