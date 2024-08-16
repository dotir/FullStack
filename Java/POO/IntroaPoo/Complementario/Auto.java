package POO.IntroaPoo.Complementario;

public class Auto {
    String marca;
    String modelo;
    int anio;

    //constructor marca, modelo y anio
    public Auto(String marca, String modelo, int anio){
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    //constructor marca y modelo
    public Auto(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    //contructor solo marca
    public Auto(String marca){
        this.marca = marca;
    }

    //constructor vacio
    public Auto(){
    }

    //metodo imprimir datos
    public void imprimirDatos(){
        //validar si esta vacio no mostrar
        if(marca != null){
            System.out.println("Marca: " + marca);
        }
        if(modelo != null){
            System.out.println("Modelo: " + modelo);
        }
        if(anio != 0){
            System.out.println("Año: " + anio);
        }
    }
}
