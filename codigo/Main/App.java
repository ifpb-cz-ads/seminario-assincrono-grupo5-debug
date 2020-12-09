package Main;

import Entidades.NivelUrgencia;
import Entidades.NovoPaciente;


public class App {
    public static void main(String[] args) {
        NovoPaciente p = new NovoPaciente();
        p.setSintomas("Febre, tosse, corpo dolorido");
        p.setUrgencia(NivelUrgencia.BAIXO);
        p.setNome("Antonio");
        p.setCpf("115.354.455-55");
        System.out.println(p);
    }
}
