import java.util.*;

interface Jogador{
    String getNome();
    boolean isAlive();
    int getHp();
    Jogador selectTarget(List<Jogador> lista);
    void charge(Jogador other);
    void receiveDamame(int qtd, Jogador other);
}

class Peao implements Jogador{
    protected String nome;
    int st;
    int hp;
    Peao(){
        String vogais = "aeiou";
        String consoantes = "BCDFGHJKLMNPQRSTVWXYZ";
        Random random = new Random();
        nome = "" + consoantes.charAt(random.nextInt(consoantes.length())) +
                    vogais.charAt(random.nextInt(vogais.length())) +
                    vogais.charAt(random.nextInt(vogais.length()));
        st = random.nextInt(5) + 5;
        hp = random.nextInt(30) + 20;
    }
    public String getNome() {
        return nome;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public Jogador selectTarget(List<Jogador> lista) {
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
    public void charge(Jogador other) {
        if(other != null && other.isAlive())
            other.receiveDamame(st, this);
    }
    public void receiveDamame(int qtd, Jogador other) {
        hp -= qtd;
    }
    public int getHp(){
        return hp;
    }
    public String toString(){
        return getNome() + ":" + st + ":" + hp;
    }
}

class Cavalo extends Peao {
    public String getNome(){
        return "C_" + super.getNome();
    }
    public Jogador selectTarget(List<Jogador> lista) {
        if(lista.size() == 1 && lista.get(0) == this)
            return null;
        Random random = new Random();
        while(true){
            Jogador chosen = lista.get(random.nextInt(lista.size()));
            if(chosen != this)
                return chosen;
        }
    }
    public void receiveDamame(int qtd, Jogador other) {
        hp -= qtd;
        if(other != null)
            other.receiveDamame(st, null);
    }
    public String toString(){
        return  super.toString();
    }
}

class Torre extends Cavalo {
    public String getNome(){
        return "T_" + nome;
    }
    public void receiveDamame(int qtd, Jogador other) {
        hp -= qtd/2;
    }
}

class Bispo extends Peao {
    public String getNome(){
        return "B_" + nome;
    }
    public Jogador selectTarget(List<Jogador> lista) {
        ArrayList<Jogador> aux = new ArrayList<>();
        for(Jogador jog : lista)
            if(jog != this && jog.isAlive())
                aux.add(jog);

        if(aux.size() == 0)
            return null;
        Jogador fraco = aux.get(0);
        for(Jogador jog : aux)
            if(jog.getHp() < fraco.getHp())
                fraco = jog;
        return fraco;
    }
}

class Rainha extends Bispo {
    public String getNome(){
        return "R_" + nome;
    }
    public void charge(Jogador other){
        if(other != null && other.isAlive()){
            other.receiveDamame(st, this);
            if(other.getHp() <= 0){
                this.hp += 10;
            }
        }
    }
    
}

public class Jogo{
                    //jogadores vira atributo
    public void play(List<Jogador> jogadores){
        //vira atributo
        Scanner scanner = new Scanner(System.in);

        //mostrar jogadores
        for(Jogador player : jogadores)
                System.out.print(player + " ");
            System.out.println("");

        while(jogadores.size() > 1){
            System.out.print("Pronto para o mói de peia?: (y/n) ");
            scanner.next();

            //lutar
            for(Jogador player : jogadores){
                if(!player.isAlive())
                    continue;
                Jogador target = player.selectTarget(jogadores);
                player.charge(target);
                System.out.println(player + " --> " + target);
            }

            //mostrar jogadores
            for(Jogador player : jogadores)
                System.out.print(player + " ");
            System.out.println("");

            //remover mortors
            List<Jogador> aux = new ArrayList<Jogador>();
            for(Jogador player : jogadores)
                if(player.isAlive())
                    aux.add(player);
            jogadores = aux;
        }
        scanner.close();
    }
    public static void main(String[] args) {
        ArrayList<Jogador> lista = new ArrayList<>();
        for(int i = 0; i < 6; i++)
            lista.add(new Peao());
        lista.add(new Cavalo());
        lista.add(new Torre());
        lista.add(new Bispo());
        lista.add(new Rainha());
        Jogo jogo = new Jogo();
        jogo.play(lista);
    }
}