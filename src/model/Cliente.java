
package model;

/**
 *
 * @author ifms
 */
public class Cliente {
    private int id_cli;
    private String nome_cli;
    private String cpf;
    private String fone;
    private String nome_pet;
    private String tipo_pet;
    private int idade_pet;

    public Cliente() {
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public void setNome_pet(String nome_pet) {
        this.nome_pet = nome_pet;
    }

    public String getTipo_pet() {
        return tipo_pet;
    }

    public void setTipo_pet(String tipo_pet) {
        this.tipo_pet = tipo_pet;
    }

    public int getIdade_pet() {
        return idade_pet;
    }

    public void setIdade_pet(int idade_pet) {
        this.idade_pet = idade_pet;
    }

    public Cliente(int id_cli, String nome_cli, String cpf, String fone, String nome_pet, String tipo_pet, int idade_pet) {
        this.id_cli = id_cli;
        this.nome_cli = nome_cli;
        this.cpf = cpf;
        this.fone = fone;
        this.nome_pet = nome_pet;
        this.tipo_pet = tipo_pet;
        this.idade_pet = idade_pet;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cli=" + id_cli + ", nome_cli=" + nome_cli + ", cpf=" + cpf + ", fone=" + fone + ", nome_pet=" + nome_pet + ", tipo_pet=" + tipo_pet + ", idade_pet=" + idade_pet + '}';
    }

}
