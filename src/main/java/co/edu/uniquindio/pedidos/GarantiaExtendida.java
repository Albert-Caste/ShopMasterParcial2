package co.edu.uniquindio.pedidos;

public class GarantiaExtendida extends PedidoDecorator {
    final double PORCENTAJE=0.1;
    //Constructor
    public GarantiaExtendida(Pedido pedido){
        super(pedido);
    }

    //Sobreescritura de métodos
    @Override
    public String getDescripcion(){
        return pedido.getDescripcion()+ "+ Póliza de Garantía Extendida";
    }
    @Override
    public double getCosto(){
        return pedido.getCosto()+(pedido.getCosto()*PORCENTAJE);
    }
}
