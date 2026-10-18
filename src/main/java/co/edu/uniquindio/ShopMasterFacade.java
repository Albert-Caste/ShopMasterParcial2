package co.edu.uniquindio;

import co.edu.uniquindio.catalogo.*;
import co.edu.uniquindio.pedidos.*;
import co.edu.uniquindio.pago.*;

public class ShopMasterFacade {

    private final CatalogoFacade catalogo;
    private final CatalogoInicial catalogoInicial;

    public ShopMasterFacade() {
        catalogo = new CatalogoFacade();
        catalogoInicial = new CatalogoInicial(catalogo);
    }

    // CASO 1: Combo + garantía + empaque.
    public void ejecutarCompraRapida(
            String usuario, String idUsuario) {

        System.out.println("\n=== CASO 1: COMPRA EXITOSA ===");

        ComponenteCatalogo combo =
                catalogoInicial.crearComboGamer();

        combo.detallarElementoCatalogo();

        Pedido pedido = new PedidoBase(combo);
        double base = pedido.getCosto();

        pedido = new GarantiaExtendida(pedido);
        double conGarantia = pedido.getCosto();

        pedido = new EmpaqueRegalo(pedido);

        System.out.printf("Costo base: $%,.0f COP%n", base);

        System.out.printf(
                "Garantía extendida (10%%): $%,.0f COP%n",
                conGarantia - base
        );

        System.out.printf(
                "Empaque premium: $%,.0f COP%n",
                pedido.getCosto() - conGarantia
        );

        procesarCompra(usuario, idUsuario, pedido);
    }

    // CASO 2: Servidor + manejo prioritario frágil.
    public void ejecutarCompraServidor(
            String usuario, String idUsuario) {

        System.out.println("\n=== CASO 2: RECHAZO POR MONTO ===");

        ComponenteCatalogo servidor = catalogo.crearProducto(
                "Servidor Empresarial", "05", 6000000
        );

        servidor.detallarElementoCatalogo();

        Pedido pedido = new PedidoBase(servidor);
        double base = pedido.getCosto();

        pedido = new PrioritarioFragil(pedido);

        System.out.printf(
                "Manejo prioritario frágil: $%,.0f COP%n",
                pedido.getCosto() - base
        );

        procesarCompra(usuario, idUsuario, pedido);
    }

    // CASO 3: Mouse para un usuario reportado.
    public void ejecutarCompraMouse(
            String usuario, String idUsuario) {

        System.out.println("\n=== CASO 3: USUARIO REPORTADO ===");

        ComponenteCatalogo mouse = catalogo.crearProducto(
                "Mouse", "06", 150000
        );

        mouse.detallarElementoCatalogo();

        Pedido pedido = new PedidoBase(mouse);

        procesarCompra(usuario, idUsuario, pedido);
    }

    // Flujo común: todo cobro pasa por el proxy.
    private void procesarCompra(
            String usuario, String idUsuario, Pedido pedido) {

        System.out.println(pedido.getDescripcion());

        System.out.printf(
                "TOTAL: $%,.0f COP%n", pedido.getCosto()
        );

        ProcesadorPago procesador = new ProxySeguridadPago(
                usuario, idUsuario, "CLIENTE"
        );

        System.out.println(
                procesador.realizarPagoEnPesos(
                        usuario, pedido.getCosto()
                )
        );
    }
}