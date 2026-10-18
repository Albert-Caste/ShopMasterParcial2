package co.edu.uniquindio.catalogo;

import java.util.ArrayList;
import java.util.List;

public class PaqueteCompuesto implements ComponenteCatalogo {

    private String nombreCombo;
    private List<ComponenteCatalogo> listaCombos;


    public PaqueteCompuesto(String nombreCombo){
        this.nombreCombo = nombreCombo;
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

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public List<ComponenteCatalogo> getListaCombos() {
        return listaCombos;
    }

    public void setListaCombos(List<ComponenteCatalogo> listaCombos) {
        this.listaCombos = listaCombos;
    }
}
