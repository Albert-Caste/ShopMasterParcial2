package co.edu.uniquindio;
import co.edu.uniquindio.catalogo.PaqueteCompuesto;
import co.edu.uniquindio.catalogo.ProductoIndividual;
import co.edu.uniquindio.pedidos.*;

public class Main {
    public static void main(String[] args) {
        PaqueteCompuesto kitLimpieza = new PaqueteCompuesto("Kit de Limpieza");
        kitLimpieza.add(new ProductoIndividual("Paño", 25000));
        kitLimpieza.add(new ProductoIndividual("Limpiador", 15000));

        PaqueteCompuesto comboGamer = new PaqueteCompuesto("Combo Setup Gamer");
        comboGamer.add(new ProductoIndividual("Monitor", 800000));
        comboGamer.add(new ProductoIndividual("Teclado", 200000));
        comboGamer.add(kitLimpieza);

        comboGamer.print();
        //Pedido Inicial +  Servicios Opcionales
        Pedido pedido = new PedidoBase(comboGamer);
        pedido = new GarantiaExtendida(pedido);
        pedido = new EmpaqueRegalo(pedido);

        System.out.println(pedido.getDescripcion());
        System.out.printf("Total con Servicios Opcionales: $%,.0f%n", pedido.getCosto());
    }

    }
