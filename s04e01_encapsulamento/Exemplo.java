class Pokemon{
    private int vida;// só dentro dos metodos da classe
    private int vidaMax; //package
    private boolean alive;

    public Pokemon(int vidaMax){
        this.vida = vidaMax;
        this.vidaMax = vidaMax;
        this.alive = true;
    }

    private void setVida(int value){
        vida = value;
        if(vida <= 0){
            vida = 0;
            System.out.println("Seu pet morreu de cansaço");
            this.alive = false;
        }
        if(vida > vidaMax)
            vida = vidaMax;
    }

    boolean testarMorto(){
        if(this.alive)
            return false;
        System.out.println("Voce nao pode interagir com um pet morto");
        return true;
    }

    public void brincar(){
        if(testarMorto())
            return;
        this.setVida(this.getVida() - 2);
    }

    public int getVida(){
        return vida;
    }

    public boolean isAlive(){
        return this.alive;
    }

    public String toString() {
        return vida + "/" + vidaMax;
    }
}

public class Exemplo{
    public static void main(String[] args) {
        Pokemon buba = new Pokemon(30);
        while(buba.isAlive()){
            buba.brincar();
            System.out.println(buba);
        }
    }
}