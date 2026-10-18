package co.edu.uniquindio.pedidos;

public class PrioritarioFragil extends PedidoDecorator{
    public PrioritarioFragil(Pedido pedido){
        super(pedido);
    }

    //Sobreescritura de métodos
    @Override
    public String getDescripcion(){
        return pedido.getDescripcion()+ "+  Manejo Prioritario Frágil";
    }
    @Override
    public double getCosto(){
        return pedido.getCosto()+25000;
    }

}
