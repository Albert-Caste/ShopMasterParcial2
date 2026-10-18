package co.edu.uniquindio;

import co.edu.uniquindio.catalogo.CatalogoFacade;
import co.edu.uniquindio.catalogo.CatalogoInicial;
import co.edu.uniquindio.catalogo.ComponenteCatalogo;
import co.edu.uniquindio.pago.ProcesadorPago;
import co.edu.uniquindio.pago.ProxySeguridadPago;
import co.edu.uniquindio.pedidos.EmpaqueRegalo;
import co.edu.uniquindio.pedidos.GarantiaExtendida;
import co.edu.uniquindio.pedidos.Pedido;
import co.edu.uniquindio.pedidos.PedidoBase;

public class ShopMasterFacade {

    private final CatalogoFacade fachadaCatalogo;
    private final CatalogoInicial catalogoInicial;

    public ShopMasterFacade() {
        this.fachadaCatalogo = new CatalogoFacade();
        this.catalogoInicial = new CatalogoInicial(fachadaCatalogo);
    }

    public void ejecutarCompraRapida(
            String usuario, String idUsuario) {

        // 1. Crear el combo con sus productos y subcombos.
        ComponenteCatalogo comboGamer =
                catalogoInicial.crearComboGamer();

        System.out.println("\n=== ÁRBOL DE PRODUCTOS ===");
        comboGamer.detallarElementoCatalogo();;

        // 2. Crear el pedido base.
        Pedido pedido = new PedidoBase(comboGamer);
        double costoBase = pedido.getCosto();

        // 3. Agregar garantía extendida.
        pedido = new GarantiaExtendida(pedido);
        double costoConGarantia = pedido.getCosto();

        // 4. Agregar empaque de regalo.
        pedido = new EmpaqueRegalo(pedido);
        double total = pedido.getCosto();

        // 5. Mostrar el cálculo.
        System.out.println("\n=== RESUMEN DE COMPRA ===");
        System.out.println(pedido.getDescripcion());

        System.out.printf(
                "Costo base: $%,.0f COP%n", costoBase
        );

        System.out.printf(
                "Garantía extendida (10%%): $%,.0f COP%n",
                costoConGarantia - costoBase
        );

        System.out.printf(
                "Empaque premium: $%,.0f COP%n",
                total - costoConGarantia
        );

        System.out.printf(
                "TOTAL: $%,.0f COP%n", total
        );

        // 6. Pasar obligatoriamente por el proxy.
        ProcesadorPago procesador = new ProxySeguridadPago(
                usuario, idUsuario, "CLIENTE"
        );

        System.out.println("\n=== PROCESAMIENTO DEL PAGO ===");

        System.out.println(
                procesador.realizarPagoEnPesos(usuario, total)
        );
    }
}
