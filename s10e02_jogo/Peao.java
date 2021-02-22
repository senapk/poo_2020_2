import java.util.Random;
import java.util.List;

class Peao implements Player{
    protected String nome;
    int st;
    int hp;
    Random random;
    Peao(){
        random = new Random();
        nome = new GeradorDeNomes().gerar(random.nextInt(2) + 2);
        st = random.nextInt(5) + 5;
        hp = random.nextInt(30) + 20;
    }
    public String getNome() {
        return "👷" + nome;
    }
    public boolean isAlive() {
        return hp > 0;
    }
    public Player selectTarget(List<Player> lista) {
        Random random = new Random();
        return lista.get(random.nextInt(lista.size()));
    }
    public void attack(Player other) {
        if(other != null && other.isAlive())
            other.receiveDamage(st, this);
    }
    public void receiveDamage(int qtd, Player other) {
        hp -= qtd;
    }
    public int getHp(){
        return hp;
    }
    public String toString(){
        return getNome() + ":" + st + ":" + hp;
    }
}