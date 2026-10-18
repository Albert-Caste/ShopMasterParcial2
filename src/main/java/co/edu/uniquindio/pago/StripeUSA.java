package co.edu.uniquindio.pago;

public class StripeUSA {

    private String nombreComercio;
    private String claveComercio;
    private String correoCliente;
    private String moneda;

    public StripeUSA(String nombreComercio, String claveComercio) {
        this.nombreComercio = nombreComercio;
        this.claveComercio = claveComercio;
        this.moneda = "USD";
    }

    public String chargeInDollars(
            double montoUSD,
            String correoCliente,
            String claveComercio) {

        if (!this.claveComercio.equals(claveComercio)) {
            return "Error: clave del comercio inválida.";
        }

        this.correoCliente = correoCliente;

        return "Pago procesado correctamente en StripeUSA."
                + "\nComercio: " + nombreComercio
                + "\nCliente: " + this.correoCliente
                + "\nMonto: " + montoUSD + " " + moneda;
    }
}
