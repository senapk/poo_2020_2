import java.util.ArrayList;
import java.util.List;

class Mercenario extends Cavalo {
    int pocaoDaCura = 1;
    public Mercenario(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return "⚔" + nome;
    }

    public Player selectTarget(List<Player> lista) {
        ArrayList<Player> menosEu = new ArrayList<>();
        for(Player jog : lista)
            if(jog != this && jog.isAlive())
                menosEu.add(jog);

        if(menosEu.size() == 0)
            return null;

        ArrayList<Player> menosMerc = new ArrayList<>();
            for(Player jog : menosEu)
                if(!(jog instanceof Mercenario))
                    menosMerc.add(jog);

        if(menosMerc.size() != 0)
            return menosMerc.get(random.nextInt(menosMerc.size()));
        return menosEu.get(random.nextInt(menosEu.size()));
    }

    public void attack(Player other) {
        if(other != null && other.isAlive()) {
            if(other instanceof Peao) { 
                other.receiveDamage(st * 2, this);
                System.out.print(" Metendo a peia no peao.");
            }else{
                other.receiveDamage(st, this);
            }
        }
    }

    public void receiveDamage(int qtd, Player other) {
        //chance de 50% de receber o dobro de dano de um peao
        if(other instanceof Peao) {
            int chance = random.nextInt(2);
            if(chance == 0){
                hp -= qtd;
            }else{
                hp -= 2 * qtd;
                System.out.print(" Peao causou o dobro de dano.");
            }
        }else if(other != null){
            hp -= qtd;
        }
        if(hp < 5 && pocaoDaCura > 0) {
            System.out.print(" Recobrando 10 de vida.");
            hp += 10;
            this.pocaoDaCura -= 1;
        }
    }
}