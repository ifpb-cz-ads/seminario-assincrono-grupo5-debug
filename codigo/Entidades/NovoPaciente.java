package Entidades;

import java.time.LocalDate;

public class NovoPaciente extends Pessoa{
        private String sintomas;
        private NivelUrgencia urgencia;

        public Paciente(String nome, String cpf, LocalDate nascimento, String sintomas, NivelUrgencia urgencia) {
            super(nome, cpf, nascimento);
            this.sintomas = sintomas;
            this.urgencia = urgencia;
        }

        public Paciente() {
            super();
        }

        public String getSintomas() {
            return sintomas;
        }

        public void setSintomas(String sintomas) {
            this.sintomas = sintomas;
        }

        public NivelUrgencia getUrgencia() {
            return urgencia;
        }

        public void setUrgencia(NivelUrgencia urgencia) {
            this.urgencia = urgencia;
        }

        @Override
        public String toString() {
            return "Paciente{" +
                    "sintomas='" + sintomas + '\'' +
                    ", urgencia=" + urgencia +
                    '}';
        }
    }

}
