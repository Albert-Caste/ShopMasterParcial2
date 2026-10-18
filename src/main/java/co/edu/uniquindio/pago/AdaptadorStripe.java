package co.edu.uniquindio.pago;

public class AdaptadorStripe implements ProcesadorPago {

    private StripeUSA stripe;
    private String claveComercio;

    private static final double TASA_CAMBIO = 4000.0;

    public AdaptadorStripe(StripeUSA stripe, String claveComercio) {
        this.stripe = stripe;
        this.claveComercio = claveComercio;
    }

    @Override
    public String realizarPagoEnPesos(String usuario, double montoCOP) {

        double montoUSD = montoCOP / TASA_CAMBIO;
        String correoCliente = usuario + "@shopmaster.com";

        return stripe.chargeInDollars(
                montoUSD,
                correoCliente,
                claveComercio
        );
    }
}
