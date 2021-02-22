import java.util.ArrayList;
import java.util.List;

class Bispo extends Peao {
    public String getNome(){
        return "🨃" + nome;
    }
    public Player selectTarget(List<Player> lista) {
        ArrayList<Player> aux = new ArrayList<>();
        for(Player jog : lista)
            if(jog != this && jog.isAlive())
                aux.add(jog);

        if(aux.size() == 0)
            return null;
        Player fraco = aux.get(0);
        for(Player jog : aux)
            if(jog.getHp() < fraco.getHp())
                fraco = jog;
        return fraco;
    }
    public void attack(Player other){
        if(other != null && other.isAlive()){
            other.receiveDamage(st, this);
            if(other.getHp() <= 0){
                System.out.print( " Bispo ganhou força");
                this.st += 5;
            }
        }
    }
}