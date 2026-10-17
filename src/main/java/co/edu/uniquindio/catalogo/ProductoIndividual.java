package co.edu.uniquindio.catalogo;

public class ProductoIndividual implements ComponenteCatalogo{

    private String nombre;
    private double precio;

    public ProductoIndividual (String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
    }



    @Override
    public double calcularPrecio() {
        return this.precio;
    }

    @Override
    public void detallarElementoCatalogo() {

        System.out.println("Producto: " + nombre + "\n" +
                           "Precio: " + precio);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
