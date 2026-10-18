package co.edu.uniquindio.pedidos;

public abstract class PedidoDecorator implements Pedido {
    protected Pedido pedido;

    //Constructor
    public PedidoDecorator (Pedido pedido){
        this.pedido=pedido;
    }

    //Sobreescritura de métodos
    @Override
    public String getDescripcion(){
        return pedido.getDescripcion();
    }


    @Override
    public double getCosto(){
        return pedido.getCosto();
    }
}
