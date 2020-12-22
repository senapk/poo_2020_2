import java.util.ArrayList;

class Crianca{
    String nome;
    int idade;
    public Crianca(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String toString(){
        return nome + ":" + idade;
    }
}

class PulaPula{
    ArrayList<Crianca> esperando;
    ArrayList<Crianca> brincando;
    public PulaPula(){
        this.esperando = new ArrayList<>();
        this.brincando = new ArrayList<>();
    }
    public void chegar(Crianca crianca){
        esperando.add(0, crianca);
    }

    //tira da fila de espera e coloca na fila brincando
    public void entrar(){
        if(esperando.isEmpty())
            return;
        //obtive a crianca
        Crianca primeira = esperando.get(esperando.size() - 1);
        //retirei do vetor esperando
        esperando.remove(esperando.size() - 1);
        //adicionei na primeira posicao do vetor brincando
        brincando.add(0, primeira);
    }

    //tira da fila de brincando e coloca na fila de espera
    public void sair(){

    }

    public Crianca remover(String nome){
        for(Crianca crianca : esperando){
            if(crianca.nome.equals(nome)){
                Crianca aux = crianca;
                esperando.remove(crianca);
                return aux;
            }
        }
        for(Crianca crianca : brincando){
            if(crianca.nome.equals(nome)){
                Crianca aux = crianca;
                esperando.remove(crianca);
                return aux;
            }
        }
        return null;
    }

    public String toString(){
        return "=>" + esperando + " => " + brincando;
    }

    public static void main(String[] args) {
        PulaPula pp = new PulaPula();
        pp.chegar(new Crianca("Ana", 5));
        pp.chegar(new Crianca("Livia", 4));
        pp.chegar(new Crianca("Rubia", 3));
        System.out.println(pp);
        pp.entrar();
        pp.entrar();
        System.out.println(pp);
        
    }
}