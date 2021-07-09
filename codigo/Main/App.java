package Main;

import Entidades.NivelUrgencia;
import Entidades.NovoPaciente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class App {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse("01/04/2000",formatter);
        NovoPaciente p = new NovoPaciente("Antonio","115.354.455-55",nascimento,"Febre, tosse, corpo dolorido",NivelUrgencia.BAIXO);
        System.out.println(p);
        System.out.println("Paciente:"+p.getNome());
        System.out.println("CPF:"+p.getCpf());
        System.out.println("Sintomas:"+p.getSintomas());
        System.out.println("Nivel de Urgencia:"+p.getUrgencia());
        for (int i =0;i<3;i++){
            System.out.println(i*i);
        }
    }
}
