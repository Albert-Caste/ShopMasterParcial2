package co.edu.uniquindio.catalogo;

public class CatalogoInicial {

    private final CatalogoFacade catalogo;

    public CatalogoInicial(CatalogoFacade catalogo) {
        this.catalogo = catalogo;
    }


    public PaqueteCompuesto crearInventarioIndividual() {

        ComponenteCatalogo monitor =
                catalogo.crearProducto("Monitor", "01", 800000);

        ComponenteCatalogo teclado =
                catalogo.crearProducto("Teclado", "02", 200000);

        ComponenteCatalogo liquido =
                catalogo.crearProducto("Liquido de limpieza", "03", 15000);

        ComponenteCatalogo pano =
                catalogo.crearProducto("Pano de limpieza", "04", 25000);

        PaqueteCompuesto invetarioIndividual =
                catalogo.crearPaquete("invetarioIndividual");

        catalogo.agregar(invetarioIndividual, monitor);
        catalogo.agregar(invetarioIndividual, teclado);
        catalogo.agregar(invetarioIndividual, liquido);
        catalogo.agregar(invetarioIndividual, pano);



        return invetarioIndividual;
    }


    public PaqueteCompuesto crearComboGamer() {

        ComponenteCatalogo monitor =
                catalogo.crearProducto("Monitor", "01", 800000);

        ComponenteCatalogo teclado =
                catalogo.crearProducto("Teclado", "02", 200000);

        ComponenteCatalogo liquido =
                catalogo.crearProducto("Liquido de limpieza", "03", 20000);

        ComponenteCatalogo pano =
                catalogo.crearProducto("Pano de limpieza", "04", 10000);

        PaqueteCompuesto kit =
                catalogo.crearPaquete("Kit de Limpieza");

        catalogo.agregar(kit, liquido);
        catalogo.agregar(kit, pano);

        PaqueteCompuesto combo =
                catalogo.crearPaquete("Combo Gamer");

        catalogo.agregar(combo, monitor);
        catalogo.agregar(combo, teclado);
        catalogo.agregar(combo, kit);

        return combo;
    }


}

