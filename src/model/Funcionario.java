
package model;

/**
 *
 * @author ifms
 */
public class Funcionario {
    private int id_func;
    private String nome_func;
    private String cod_func;

    public Funcionario() {
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getNome_func() {
        return nome_func;
    }

    public void setNome_func(String nome_func) {
        this.nome_func = nome_func;
    }

    public String getCod_func() {
        return cod_func;
    }

    public void setCod_func(String cod_func) {
        this.cod_func = cod_func;
    }

    public Funcionario(int id_func, String nome_func, String cod_func) {
        this.id_func = id_func;
        this.nome_func = nome_func;
        this.cod_func = cod_func;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id_func=" + id_func + ", nome_func=" + nome_func + ", cod_func=" + cod_func + '}';
    }

 
   
}
