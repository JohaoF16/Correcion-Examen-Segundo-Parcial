
package dominio;

public class JubiladoPatronal extends Jubilado implements Finanzas{
    private double inflacion;
    private int tipoe;
    private double pensionp;
    
    public JubiladoPatronal(String cedula, String nombres, int aniosAporte,double inflacion,int tipoe) {
        super(cedula, nombres, aniosAporte);
        this.inflacion = inflacion;
        this.tipoe = tipoe;
    }

    @Override
    public void calcularPension() {
        this.pensionp = getPensioni()+(getSALARIOBASE()*inflacion);
    }

    @Override
    public void bonoSueldo() {
        if(this.tipoe ==1){
            this.pensionp = this.pensionp*1.05;
        }else{
            this.pensionp = this.pensionp*1.10;
        }
    }
    @Override
    public String toString(){
        return super.toString()+"\t\t\t"+this.tipoe+"\t\t\t"+this.pensionp;
    }
    
    
}