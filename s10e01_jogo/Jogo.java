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
        if(hp < 5)
            hp -= qtd/5;
        else
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
    public void charge(Jogador other){
        if(other != null && other.isAlive()){
            other.receiveDamame(st, this);
            if(other.getHp() <= 0){
                this.st += 5;
            }
        }
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

    List<Jogador> players;
    Scanner scanner = new Scanner(System.in);

    public Jogo(){
        this.players = new ArrayList<>();
        for(int i = 0; i < 6; i++)
            players.add(new Peao());
        players.add(new Cavalo());
        players.add(new Torre());
        players.add(new Bispo());
        players.add(new Rainha());
        Collections.shuffle(players); //embaralha
    }

    public void showPlayers(){
        for(Jogador player : players)
            System.out.print(player + " ");
        System.out.println("");
    }
    public void roundFight(){
        for(Jogador player : players){
            if(!player.isAlive())
                continue;
            Jogador target = player.selectTarget(this.players);
            player.charge(target);
            System.out.println(player + " --> " + target);
        }
    }

    void removeDeadBodies(){
        List<Jogador> aux = new ArrayList<Jogador>();
        for(Jogador player : players)
            if(player.isAlive())
                aux.add(player);
        players = aux;
    }

    public void play(){
        showPlayers();
        while(players.size() > 1){
            System.out.print("Pronto para o mói de peia?: (y/n) ");
            scanner.next();
            roundFight();
            showPlayers();
            removeDeadBodies();
        }
    }
    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.play();
    }
}