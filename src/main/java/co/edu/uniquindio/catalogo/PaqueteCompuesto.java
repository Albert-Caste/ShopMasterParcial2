package co.edu.uniquindio.catalogo;

import java.util.ArrayList;
import java.util.List;

public class PaqueteCompuesto implements ComponenteCatalogo {

    private String nombreCombo;
    private List<ComponenteCatalogo> listaCombos;
    private double descuento;

    public PaqueteCompuesto(String nombreCombo, double descuento){
        this.nombreCombo = nombreCombo;
        this.descuento = descuento;
        listaCombos = new ArrayList<>();
    }

    public void agregarCombo(ComponenteCatalogo compParaAgregar){
        listaCombos.add(compParaAgregar);
    }

    public void eliminarCombo(ComponenteCatalogo compParaEliminar){
        listaCombos.remove(compParaEliminar);

    }




    @Override
    public double calcularPrecio() {

        double precioCombo = 0;

        for (ComponenteCatalogo ct : listaCombos){
            precioCombo += ct.calcularPrecio();
        }

        precioCombo =precioCombo*(1-descuento/100);

        return precioCombo;
    }

    @Override
    public void detallarElementoCatalogo() {
        System.out.println("Nombre combo: " + nombreCombo + "\n" +
                "Incluye: " + "\n");

        for (ComponenteCatalogo cat : listaCombos){
            cat.detallarElementoCatalogo();
        }

        System.out.println("Precio: " + calcularPrecio());



    }



}
