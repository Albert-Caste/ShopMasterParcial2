package co.edu.uniquindio;

public class Main {

    public static void main(String[] args) {

        ShopMasterFacade tienda = new ShopMasterFacade();

        tienda.ejecutarCompraRapida("cliente_vip", "123");

        tienda.ejecutarCompraServidor("cliente_normal", "456");

        tienda.ejecutarCompraMouse("BLOQUEADO", "789");
    }
}
