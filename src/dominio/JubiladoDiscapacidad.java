
package dominio;

public class JubiladoDiscapacidad extends Jubilado {
    private double porcentaje;
    private double pensiond;
    public JubiladoDiscapacidad(String cedula, String nombres, int aniosAporte,double porcentaje) {
        super(cedula, nombres, aniosAporte);
        this.porcentaje = porcentaje;
    }

    @Override
    public void calcularPension(){
        this.pensiond = getPensioni() + (getSALARIOBASE()*this.porcentaje);
        
    }
    public double getPorcentaje() {
        return porcentaje;
    }

    public double getPensiond() {
        return pensiond;
    }
    public void bonoSueldo(){
        
    }
    @Override
    public String toString(){
        return super.toString()+"\t\t\t"+this.porcentaje+"\t\t\t"+this.pensiond;
    }
    
}