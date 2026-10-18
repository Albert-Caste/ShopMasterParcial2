package co.edu.uniquindio.catalogo;

public interface ComponenteCatalogo {
    String getNombre();
    double getPrecio();
    void add(ComponenteCatalogo componenteCatalogo);
    void print();
}
