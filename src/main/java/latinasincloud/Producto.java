package latinasincloud;

public class Producto {
    // private static -> para variables compartidas por todos los objetos
    // private -> para variables de instancia, diferentes por objeto
    private static int cont = 1;

    private int id = 0;
    private String nombre;
    private int precio;
    private int stock;

    public Producto(String nombre, int precio, int stock) {
        this.id = cont++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void vender(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            int precioTotal = this.precio * cantidad;
            System.out.println("Venta realizada por $" + precioTotal);
        } else {
            System.out.println("No hay suficiente stock para vender");
        }
    }

    public void mostrar() {
        System.out.println("ID:" + id + "| Producto: " + nombre + "| Precio: $" + precio + "| Stock: " + stock);
    }
}
