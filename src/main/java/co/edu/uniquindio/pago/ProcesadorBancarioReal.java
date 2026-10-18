package co.edu.uniquindio.pago;

public class ProcesadorBancarioReal implements ProcesadorPago {
    private String idUsuario;
    private final AdaptadorStripe adaptadorStripe;

    //Constructor
    public ProcesadorBancarioReal (String idUsuario){
            this.idUsuario=idUsuario;
            String claveComercio="shopmaster_demo";
            StripeUSA stripe = new StripeUSA("ShopMaster", claveComercio);
            this.adaptadorStripe= new AdaptadorStripe(stripe, claveComercio);
    }

    @Override
    public String realizarPagoEnPesos(String usuario, double valorAPagar){
        return adaptadorStripe.realizarPagoEnPesos(usuario, valorAPagar
        );
    }

}
