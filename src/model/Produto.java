
package model;


public class Produto {
    private int id_produ;
    private String nome_produ;
    private String categoria;
    private int cod_produ;
    private float valor;

    public Produto() {
    }

    public int getId_produ() {
        return id_produ;
    }

    public void setId_produ(int id_produ) {
        this.id_produ = id_produ;
    }

    public String getNome_produ() {
        return nome_produ;
    }

    public void setNome_produ(String nome_produ) {
        this.nome_produ = nome_produ;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCod_produ() {
        return cod_produ;
    }

    public void setCod_produ(int cod_produ) {
        this.cod_produ = cod_produ;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Produto(int id_produ, String nome_produ, String categoria, int cod_produ, float valor) {
        this.id_produ = id_produ;
        this.nome_produ = nome_produ;
        this.categoria = categoria;
        this.cod_produ = cod_produ;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "id_produ=" + id_produ + ", nome_produ=" + nome_produ + ", categoria=" + categoria + ", cod_produ=" + cod_produ + ", valor=" + valor + '}';
    }

   
    
}
