package test;
import dominio.JubiladoDiscapacidad;
import dominio.JubiladoVejez;
import dominio.Jubilado;
import dominio.JubiladoPatronal;
import java.util.ArrayList;
import java.util.Scanner;

public class TestJubilado {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Jubilado> jubilados = new ArrayList<>();

    public static void main(String[] args) {
        int op = 0;        
        String cedula, nombres;
        int anios;
        do {
            op = menu(op);
            if (op != 5 && op != 4) {
                entrada.nextLine();
                System.out.print("Cedula: ");
                cedula = entrada.nextLine();
                System.out.print("Nombres: ");
                nombres = entrada.nextLine();
                System.out.print("Años Aporte: ");
                anios = entrada.nextInt();
                datos(op, cedula, nombres, anios);
                
            }
            if(op==4){
                
                System.out.println("♠JUBILADOS POR VEJEZ♠");
                System.out.println("Cédula\t\tNombre\t\tAños de Aporte\t\tPensión Inicial\t\tPensión Final");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();                  
                    if (jub instanceof JubiladoVejez) {
                        System.out.println(jub);
                    }
                }
                System.out.println("\n");
                System.out.println("♣JUBILADOS POR INVALIDEZ♣");
                System.out.println("Cédula\t\tNombre\t\tAños de Aporte\t\tPensión Inicial\t\tPorc. Discapacidad\tPensión Final");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoDiscapacidad) {
                        System.out.println(jub);
                    }
                }
                System.out.println("\n");
                System.out.println("♦JUBILADOS PATRONALES♦");
                System.out.println("Cédula\t\tNombre\t\tAños de Aporte\t\tPensión Inicial\t\tTipo Empresa\t\tPensión Final");
                for (Jubilado jub : jubilados) {
                    jub.calculaPensioni();
                    jub.calcularPension();
                    if (jub instanceof JubiladoPatronal) {
                        ((JubiladoPatronal) jub).bonoSueldo();
                        System.out.println(jub);
                    } 
                }
                System.out.println("\n");
            }
        } while (op != 5);
    }

    public static int menu(int op) {
        System.out.println("Menu Jubilado");
        System.out.print("1. Vejez\n2. Invalidez\n3. Patronal\n4. Reporte\n5. Salir\nEscoja una Opcion: ");
        op = entrada.nextInt();
        System.out.println("");
        return op;
    }

    public static void datos(int op, String cedula, String nombres, int anios) {
        double porcentaje;
        int tipo;
        switch (op) {
            case 1:
                System.out.println("");
                jubilados.add(new JubiladoVejez(cedula, nombres, anios));                
                break;
            case 2:
                System.out.print("Porcentaje de discapacidad: ");
                porcentaje = entrada.nextDouble();
                System.out.println("");
                jubilados.add(new JubiladoDiscapacidad(cedula, nombres, anios, porcentaje));
                break;
            case 3:
                System.out.print("Porcentaje de Inflación: ");
                porcentaje = entrada.nextDouble();
                System.out.print("Tipo de Empresa <<1>> Pública <<2>> Privada: ");
                tipo = entrada.nextInt();
                System.out.println("");
                jubilados.add(new JubiladoPatronal(cedula, nombres, anios, porcentaje, tipo));
        }
    }
}