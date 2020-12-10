package Interface;
import Entidades.NovoPaciente;

import java.io.IOException;
import java.util.List;

public interface IntefacePaciente {

    public boolean addPaciente(NovoPaciente paciente) throws IOException, ClassNotFoundException;
    public boolean RemovePaciente(String cpf)throws IOException, ClassNotFoundException;
    public boolean atualizarPaciente(String cpf, NovoPaciente paciente)throws IOException, ClassNotFoundException;
    public NovoPaciente buscarPacienteCpf(String cpf)throws IOException, ClassNotFoundException;
    public List<NovoPaciente> listarPaciente()throws IOException, ClassNotFoundException;

}
