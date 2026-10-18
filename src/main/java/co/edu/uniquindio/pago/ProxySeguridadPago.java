package co.edu.uniquindio.pago;

public class ProxySeguridadPago implements ProcesadorPago {
    private static final double MONTO_MAX=5000000;
    private String nombreUsuario;
    private String idUsuario;
    private String rolUsuario;
    private ProcesadorBancarioReal procesadorBancarioReal;

    //Constructor
    public ProxySeguridadPago(String nombreUsuario, String idUsuario, String rolUsuario){
        this.nombreUsuario=nombreUsuario;
        this.idUsuario=idUsuario;
        this.rolUsuario=rolUsuario;
    }

    @Override
    public String realizarPagoEnPesos(String usuario, double valorAPagar) {
        // 1. Auditoría obligatoria (Smart Reference / Logging)
        System.out.println("[INICIO PROCESAMIENTO DE PAGO] Solicitud de '" + nombreUsuario + " para el procesamiento de la transacción");
        // Validaciones antes de crear o llamar al procesador real.
        if (usuario == null || usuario.trim().isEmpty()) {
            return "[TRANSACCIÓN RECHAZADA] Usuario no válido.";
        }
        if (!usuario.equalsIgnoreCase(nombreUsuario)) {
            return "[TRANSACCIÓN RECHAZADA] El usuario no coincide.";
        }
        // 2. Control de acceso por rol (Protection Proxy)
        if ("BLOQUEADO".equalsIgnoreCase(usuario.trim())) {
            return "[TRANSACCIÓN RECHAZADA] Usuario bloqueado.";
        }

        if (!Double.isFinite(valorAPagar) || valorAPagar <= 0) {
            return "[TRANSACCIÓN RECHAZADA] Monto no válido.";
        }

        if (valorAPagar > MONTO_MAX) {
            return "[TRANSACCIÓN RECHAZADA] Supera $5.000.000 COP.";
        }
        // Carga Diferida / Lazy Loading (Virtual Proxy)
        if (procesadorBancarioReal == null) {
            procesadorBancarioReal = new ProcesadorBancarioReal(idUsuario);
        }
        // Delegación al objeto real
        String resultado = procesadorBancarioReal.realizarPagoEnPesos(
                usuario, valorAPagar
        );

        return resultado
                + "\n[AUDITORÍA: Transacción aprobada para "
                + usuario + "]";

    }

}
