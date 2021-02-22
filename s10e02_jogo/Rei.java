import java.util.Random;

public class Rei extends Bispo {

  protected int hearts = 3;
  protected int ultRound = 3;

  @Override
  public String getNome() {
    return "🤴";
  }

  public int criticalDamage(int st) {
    System.out.print(" Metendo crítico do rei.");
    Random rand = new Random();
    return (int) (st * ((double) rand.nextInt(100) / 100) + st);
  }

  @Override
  public void receiveDamage(int qtd, Player other) {
    if (this.ultRound-- == 0) {
      this.ultRound = 3;
      System.out.print(" Ativando escudo supreeeeeemo.");
      return;
    }
    this.hp -= qtd;
    if (hp <= 0 && hearts-- > 0) {
      System.out.print(" Gastou uma vida.");
      this.hp += 20;
    }
    if(random.nextInt(101) < 2){
        System.out.print(" Ataque cardiaco fulminante.");
        hp -= 1000;
    }
  }

  @Override
  public void attack(Player other) {
    if (other != null && other.isAlive()) {
      Random rand = new Random();
      if (rand.nextInt(10) == 1) {
        other.receiveDamage(criticalDamage(st), this);
      } else
        other.receiveDamage(st, this);

      if (!other.isAlive()) {
        this.hp += 1;
        this.st += 2;
      }
    }
  }

}