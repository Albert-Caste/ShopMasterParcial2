package co.edu.uniquindio.catalogo;

public class ProductoIndividual implements ComponenteCatalogo {
    private String nombre;
    private double precio;

    //Constructor
    public ProductoIndividual(String nombre, double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    //Sobreescritura de métodos
    @Override
    public String getNombre(){
        return this.nombre;
    }
    @Override
    public void add(ComponenteCatalogo componenteCatalogo){
        throw new UnsupportedOperationException("No es posible agregar elementos a un producto individual de la tienda");
    }
    @Override
    public void print(){
        System.out.println("Artículo: "+nombre+" --> Precio: "+precio);
    }
    @Override
    public double getPrecio(){
        return this.precio;
    }

}
