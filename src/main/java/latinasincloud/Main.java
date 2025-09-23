package latinasincloud;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> Productos = new ArrayList<>();

        int opcionNum;
        int precioNum;
        int stockNum;

        do {
            System.out.println("########## Bienvenido a la tienda ##########");
            System.out.println("[1] Añadir producto");
            System.out.println("[2] Listar todos los productos");
            System.out.println("[3] Vender producto");
            System.out.println("[4] Salir del programa");
            System.out.print("Ingrese la opción a realizar: ");

            while (true) {
                String opcion = scanner.nextLine();
                try {
                    opcionNum = Integer.parseInt(opcion);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese una opción valida (1,2,3,4): ");
                }
            }
            switch(opcionNum) {
                case 1: // Añadir productos
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    while (true) {
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = scanner.nextLine();
                        try {
                            precioNum = Integer.parseInt(precio);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número: ");
                        }
                    }
                    while (true) {
                        System.out.print("Ingrese el stock del producto: ");
                        String stock = scanner.nextLine();
                        try {
                            stockNum = Integer.parseInt(stock);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número: ");
                        }
                    }

                    if (precioNum >= 0 && stockNum >= 0) {
                        Producto nuevo = new Producto(nombre, precioNum, stockNum);
                        Productos.add(nuevo);
                        System.out.println("Producto añadido exitosamente con ID: " + nuevo.getId());
                    } else {
                        System.out.println("Tanto precio como stock deben ser positivos.");
                    }
                    break;

                case 2: // Listar productos
                    if (Productos.isEmpty()) {
                        System.out.println("No hay productos en el inventario");
                    } else {
                        System.out.println("\n Lista de productos:");
                        for (Producto p : Productos) {
                            p.mostrar();
                        }
                    }
                    break;
                case 3: // Vender productos
                    System.out.println("Ingrese el ID del producto a vender: ");
                    int id = scanner.nextInt();

                    Producto productoEncontrado = null;
                    for (Producto p : Productos) {
                        if (p.getId() == id) {
                            productoEncontrado = p;
                            break;
                        }
                    }

                    if (productoEncontrado != null) {
                        System.out.println("Cantidad a vender: ");
                        int cantidad = scanner.nextInt();
                        productoEncontrado.vender(cantidad);
                    } else {
                        System.out.print("No se encontro producto con ese ID ");
                    }
                    break;

                case 4: // Salir
                    System.out.println("Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no valida");
            }
        }while(opcionNum != 4);


    }
}