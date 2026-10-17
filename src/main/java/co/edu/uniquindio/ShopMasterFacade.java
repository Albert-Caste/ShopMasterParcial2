package co.edu.uniquindio;

import co.edu.uniquindio.catalogo.CatalogoFacade;
import co.edu.uniquindio.catalogo.CatalogoInicial;
import co.edu.uniquindio.catalogo.ComponenteCatalogo;

public class ShopMasterFacade {

    CatalogoFacade fachadaCatalogo = new CatalogoFacade();

    CatalogoInicial catalogoInicial = new CatalogoInicial(fachadaCatalogo);

    ComponenteCatalogo inventarioInicial = catalogoInicial.crearInventarioIndividual();
    ComponenteCatalogo comboGamer = catalogoInicial.crearComboGamer();



}
