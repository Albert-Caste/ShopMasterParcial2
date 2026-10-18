package co.edu.uniquindio.pedidos;

public class EmpaqueRegalo extends PedidoDecorator{
    //Constructor
    public EmpaqueRegalo(Pedido pedido){
        super(pedido);
    }
    //Sobreescritura de métodos
    @Override
    public String getDescripcion(){
        return pedido.getDescripcion()+ "+ Empaque de Regalo Premium";
    }
    @Override
    public double getCosto(){
        return pedido.getCosto()+15000;
    }
}
