package co.edu.uniquindio.catalogo;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaqueteCompuesto implements ComponenteCatalogo {
    private String nombre;
    private List <ComponenteCatalogo> componenteCatalogos;

    //Constructor
    public PaqueteCompuesto (String nombre){
       this.nombre=nombre;
       this.componenteCatalogos=new ArrayList<>();
    }

    //Sobreescritura de métodos
    @Override
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public void add(ComponenteCatalogo componenteCatalogo){
        componenteCatalogos.add(componenteCatalogo);
    }

    @Override
    public void print(){
        System.out.println("\n[ PAQUETE] ===>"+ nombre);
        System.out.println("----------------------------------------");
        for (ComponenteCatalogo componente: componenteCatalogos){
            componente.print();
        }
        System.out.println("\n TOTAL: "+nombre+ " $"+getPrecio());
        System.out.println("----------------------------------------");
    }

    @Override
    public double getPrecio(){
        double total=0;

        for(ComponenteCatalogo componente: componenteCatalogos){
            total+=componente.getPrecio();
        }
        return total;
    }

}
