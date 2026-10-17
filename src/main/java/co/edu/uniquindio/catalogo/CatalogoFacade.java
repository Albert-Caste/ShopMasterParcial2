package co.edu.uniquindio.catalogo;

public class CatalogoFacade {

    public ComponenteCatalogo crearProducto(
            String nombre, String codigo, double precio) {

        return new ProductoIndividual(nombre,codigo, precio);
    }

    public PaqueteCompuesto crearPaquete(String nombre) {
        return new PaqueteCompuesto(nombre);
    }

    public void agregar(
            PaqueteCompuesto paquete,
            ComponenteCatalogo componente) {

        paquete.agregarCombo(componente);
    }
}