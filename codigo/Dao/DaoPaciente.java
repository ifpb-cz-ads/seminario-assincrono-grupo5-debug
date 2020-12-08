package Dao;
import Entidades.Paciente;
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
    public boolean addPaciente(Paciente paciente) throws IOException, ClassNotFoundException{

        List<Paciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<Paciente>) in.readObject();
        } else {
            listaPaciente = new ArrayList<>();
        }

        for(Paciente p : listaPaciente){
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

        List<Paciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<Paciente>) in.readObject();
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
    public boolean atualizarPaciente(String cpf, Paciente paciente) throws IOException, ClassNotFoundException{
        List<Paciente> listaPaciente;

        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            listaPaciente = (List<Paciente>) in.readObject();
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
    public Paciente buscarPacienteCpf(String cpf) throws IOException, ClassNotFoundException{
        for(Paciente p : listarPaciente()){
            if(p.getCpf().equals(cpf))
                return p;
        }
        return null;
    }

    @Override
    public List<Paciente> listarPaciente() throws IOException, ClassNotFoundException{
        if (arquivo.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(arquivo));

            return (List<Paciente>) in.readObject();
        } else {
            return new ArrayList<>();
        }
    }
}
