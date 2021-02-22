import java.util.ArrayList;
import java.util.TreeMap;

import javax.management.RuntimeErrorException;

class Pessoa{
    private String nome;
    private boolean meia;

    public Pessoa(String nome, boolean pagaMeia){
        this.nome = nome;
        this.meia = pagaMeia;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean getMeia(){
        return this.meia;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("[" + nome + ", ");
        saida.append((meia ? "meia" : "inteira") + "\n");
        return saida.toString();
    }
}

class DuplicatedKeyException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    DuplicatedKeyException(String message){
        super(message);
    }
}

class MissingKeyException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    MissingKeyException(String tipo, String chave){
        super(tipo + " " + chave + " nao existe no repositorio");
    }
}

class Evento{
    private String nome;
    private TreeMap<String, Setor> repSetores;

    public Evento(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    void addSetor(Setor setor){
        if(this.repSetores.containsKey(setor.getNome()))
            throw new DuplicatedKeyException("fail: setor " + setor.getNome() + " ja existente");
        this.repSetores.put(setor.getNome(), new Setor(setor.getNome(), setor.getPreco(), setor.getCapacidade()));
    }

    public String toString() {
        return "[" + nome + "]\n";
    }
}

class Venda{
    private Pessoa cliente;
    private Evento evento;
    private Setor setor;
    private double valor;

    public Venda(Pessoa cliente, Evento evento, Setor setor, double valor){
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;
        this.valor = valor;
    }

    public String toString(){
        return "[" + this.cliente.getNome() + ", " + this.evento.nome + ", " + this.setor.nome + ", " + this.valor + "]";
    }
}

class Setor{
    private String nome;
    private double preco;
    private int qtd;
    private int capacidade;

    public String getNome(){
        return this.nome;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    void vender(){
        //
        this.qtd++;
    }

    public Setor(String nome, double preco, int capacidade){
        this.nome = nome;
        this.preco = preco;
        this.capacidade = capacidade;
}



public class Bilheteria{
    private ArrayList<Venda> repVendas;
    private TreeMap<String, Pessoa> repPessoas;
    private TreeMap<String, Evento> repEvento;
    private double caixa;

    void vender(String cliente, String idEvento, String idSetor) {
        Pessoa pessoa = getPessoa(cliente);
        Evento evento = getEvento(idEvento);
        Setor setor = evento.getSetor(idSetor);
        if(setor.qtd == setor.capacidade)
            throw new SetorLotadoException()
        setor.qtd += 1;
        repVendas.add(new Venda())
    }

    double getCaixa(){
        return this.caixa;
    }

    void showVendas(){

    }
    
    void showPessoas(){
        for(Pessoa pessoa : this.repPessoas.values()){
            System.out.println(pessoa);
        }
    }

    void showEventos(){
        for(Evento evento : this.repEvento.values()){
            System.out.println(evento);
        }
    }

    void addPessoa(String nome, boolean meia){
        if(this.repPessoas.containsKey(nome)){
            System.out.println("fail: pessoa " + nome + " ja existe");
            return;
        }
        this.repPessoas.put(nome, new Pessoa(nome, meia));
    }

    void addEvento(String idEvento){

    }

    Pessoa getPessoa(String idPessoa){
        Pessoa pessoa = repPessoas.get(idPessoa);
        if(pessoa != null)
            return pessoa;
        throw new MissingKeyException("Pessoa", idPessoa);
    }

    Evento getEvento(String idEvento) throws MissingKeyException{
        Evento evento = repEvento.get(idEvento);
        if(evento != null)
            return evento;
        throw new MissingKeyException("Evento", idEvento);
    }

    void addSetor(String idEvento, String idSetor, double preco, int capacidade){
        Evento evento = getEvento(idEvento);
        evento.addSetor(new Setor(idSetor, preco, capacidade));

    }

    public static void main(String[] args) {
        while(true){
            try{
                bilheteria.addEvento(....)
            }catch(RuntimeException e){
                System.out.println(e);
            }
        }
    }
}