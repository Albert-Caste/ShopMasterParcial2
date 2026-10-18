package co.edu.uniquindio.pedidos;

import co.edu.uniquindio.catalogo.ComponenteCatalogo;

public class PedidoBase implements Pedido{
    private ComponenteCatalogo componenteCatalogo;

    //Constructor
    public PedidoBase (ComponenteCatalogo componenteCatalogo){
        this.componenteCatalogo=componenteCatalogo;
    }
    //Sobreescritura de métodos

    @Override
    public String getDescripcion() {
        return "Pedido base";
    }
    @Override
    public double getCosto(){
        return componenteCatalogo.calcularPrecio();
    }

}
