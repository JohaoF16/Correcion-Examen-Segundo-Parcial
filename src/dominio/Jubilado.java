
package dominio;

public abstract class Jubilado {
    private String cedula;
    private String nombres;
    private final double SALARIOBASE=400;
    private int aniosAporte;
    private double pesioni;

    public Jubilado(String cedula, String nombres, int aniosAporte) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.aniosAporte = aniosAporte;
    }
    public abstract void calcularPension();
    public void calculaPensioni(){
        if(this.aniosAporte<=10){
            this.pesioni = this.SALARIOBASE*0.5;
        }else if(this.aniosAporte>10 && this.aniosAporte<=20){
            this.pesioni = this.SALARIOBASE*0.6;
        }else if(this.aniosAporte>20 && this.aniosAporte<=30){
            this.pesioni = this.SALARIOBASE*0.7;
        }else if(this.aniosAporte>30 && this.aniosAporte<=35){
            this.pesioni = this.SALARIOBASE*0.8;
        }else if(this.aniosAporte>35 && this.aniosAporte<=39){
            this.pesioni = this.SALARIOBASE*0.9;
        }else if(this.aniosAporte>=40){
            this.pesioni = SALARIOBASE;
        }else{
            System.out.println("No cumple con el numero de aportes");
        }
    }
    public double getPensioni(){
        return this.pesioni;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public double getSALARIOBASE() {
        return SALARIOBASE;
    }

    public int getAniosAporte() {
        return aniosAporte;
    }

    @Override
    public String toString(){
        return this.cedula+"\t\t"+this.nombres.toUpperCase()+"\t\t"+this.aniosAporte+"\t\t\t"+this.pesioni;
    }
    
    
}