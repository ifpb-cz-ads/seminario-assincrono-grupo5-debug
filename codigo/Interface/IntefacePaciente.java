package Interface;
import Entidades.Paciente;

import java.io.IOException;
import java.util.List;

public interface IntefacePaciente {

    public boolean addPaciente(Paciente paciente) throws IOException, ClassNotFoundException;
    public boolean RemovePaciente(String cpf)throws IOException, ClassNotFoundException;
    public boolean atualizarPaciente(String cpf, Paciente paciente)throws IOException, ClassNotFoundException;
    public Paciente buscarPacienteCpf(String cpf)throws IOException, ClassNotFoundException;
    public List<Paciente> listarPaciente()throws IOException, ClassNotFoundException;

}
