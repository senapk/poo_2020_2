import java.util.Random;
import java.util.List;

class Cavalo extends Peao {
    public String getNome(){
        return "🐴" + nome;
    }
    public Player selectTarget(List<Player> lista) {
        if(lista.size() == 1 && lista.get(0) == this)
            return null;
        Random random = new Random();
        while(true){
            Player chosen = lista.get(random.nextInt(lista.size()));
            if(chosen != this)
                return chosen;
        }
    }
    public void receiveDamage(int qtd, Player other) {
        hp -= qtd;
        if(other != null){
            System.out.print( " Cavalo mordeu de volta.");
            other.receiveDamage(st, null);
        }
    }
    public String toString(){
        return  super.toString();
    }
}