package latinasincloud;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto>listaProductos = new ArrayList<>();

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
            switch(opcionNum){
                case 1: // Añadir productos
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();

                    while(true){
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = scanner.nextLine();
                        try {
                            precioNum = Integer.parseInt(precio);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número: ");
                        }
                    }
                    while(true){
                        System.out.print("Ingrese el stock del producto: ");
                        String stock = scanner.nextLine();
                        try {
                            stockNum = Integer.parseInt(stock);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Debe ingresar un número: ");
                        }
                    }

                    if(precioNum >= 0 && stockNum >= 0){
                        Producto nuevo = new Producto(nombre, precioNum, stockNum);
                        listaProductos.add(nuevo);
                        System.out.println("Producto añadido exitosamente con ID: " + nuevo.getId());
                    }
                    else{
                        System.out.println("Tanto precio como stock deben ser positivos.");
                    }
                    break;

                //case 2: // Listar productos
                //case 3: // Vender productos
                //case 4: // Salir
                //default:
            }
        }while(opcionNum != 4);


    }
}