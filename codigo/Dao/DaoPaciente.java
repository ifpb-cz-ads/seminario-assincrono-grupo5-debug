package Dao;
import Entidades.NovoPaciente;
import Interface.IntefacePaciente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPaciente implements  IntefacePaciente{
    private final File arquivo;
    public DaoPaciente(){

        arquivo = new File("Paciente.bin");

        if (!arquivo.exists()) {

            try {
                arquivo.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro no arquivo");
            }

        }

    }

    @Override
    public boolean addPaciente(NovoPaciente paciente) throws IOException, ClassNotFoundException{

        List<NovoPaciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<NovoPaciente>) in.readObject();
        } else {
            listaPaciente = new ArrayList<>();
        }

        for(NovoPaciente p : listaPaciente){
            if(p.getCpf().equals(paciente.getCpf())){
                return false;
            }
        }


        if (listaPaciente.add(paciente)) {
            try (ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(arquivo))) {
                out.writeObject(listaPaciente);
            }

            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean RemovePaciente(String cpf) throws IOException, ClassNotFoundException{

        List<NovoPaciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<NovoPaciente>) in.readObject();
        } else {
            return false;
        }


        for(int i=0; i<listaPaciente.size(); i++){

            if(listaPaciente.get(i).getCpf().equals(cpf)){
                listaPaciente.remove(i);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
                out.writeObject(listaPaciente);
                out.close();
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean atualizarPaciente(String cpf, NovoPaciente paciente) throws IOException, ClassNotFoundException{
        List<NovoPaciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<NovoPaciente>) in.readObject();
        } else {
            listaPaciente = new ArrayList<>();
        }

        for(int i=0; i<listaPaciente.size(); i++){
            if(listaPaciente.get(i).getCpf().equals(cpf)){
                listaPaciente.get(i).setNascimento(paciente.getNascimento());
                listaPaciente.get(i).setNome(paciente.getNome());
                listaPaciente.get(i).setSintomas(paciente.getSintomas());
                listaPaciente.get(i).setUrgencia(paciente.getUrgencia());

                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream(arquivo));
                out.writeObject(listaPaciente);
                out.close();
                return true;
            }
        }

        return false;
    }

    @Override
    public NovoPaciente buscarPacienteCpf(String cpf) throws IOException, ClassNotFoundException{
        for(NovoPaciente p : listarPaciente()){
            if(p.getCpf().equals(cpf))
                return p;
        }
        return null;
    }

    @Override
    public List<NovoPaciente> listarPaciente() throws IOException, ClassNotFoundException{
        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            return (List<NovoPaciente>) in.readObject();
        } else {
            return new ArrayList<>();
        }
    }
}
