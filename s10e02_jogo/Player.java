import java.util.List;

interface Player{
    String getNome();
    boolean isAlive();
    int getHp();
    Player selectTarget(List<Player> lista);
    void attack(Player other);
    void receiveDamage(int qtd, Player other);
}
