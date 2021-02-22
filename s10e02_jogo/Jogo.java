import java.util.*;

public class Jogo{

    List<Player> players;
    Scanner scanner = new Scanner(System.in);

    public Jogo(){
        this.players = new ArrayList<>();
        for(int i = 0; i < 4; i++)
            players.add(new Peao());
        players.add(new Cavalo());
        players.add(new Torre());
        players.add(new Bispo());
        players.add(new Rainha());
        players.add(new Mercenario("Davi"));
        players.add(new Mercenario("Sena"));
        players.add(new Mercenario("Guth"));
        players.add(new Rei());
        Collections.shuffle(players); //embaralha
    }

    public void rjust(String data, int size){
        for(int i = 0; i < (size - data.length()); i++)
            System.out.print("_");
        System.out.print(data);
    }
    public void ljust(String data, int size){
        System.out.print(data);
        for(int i = 0; i < (size - data.length()); i++)
            System.out.print("_");
    }


    public void showPlayers(){
        for(Player player : players)
            System.out.print(player + " ");
        System.out.println("");
    }
    public void roundFight(){
        for(Player player : players){
            if(!player.isAlive())
                continue;
            Player target = player.selectTarget(this.players);
            rjust("" + player, 12);
            System.out.print(" --> ");
            ljust("" + target, 12);
            player.attack(target);
            System.out.println("");
        }
    }

    void removeDeadBodies(){
        List<Player> aux = new ArrayList<Player>();
        for(Player player : players)
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