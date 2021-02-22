class Rainha extends Bispo {
    public String getNome(){
        return "♛" + nome;
    }
    public void attack(Player other){
        if(other != null && other.isAlive()){
            other.receiveDamage(st, this);
            if(other.getHp() <= 0){
                System.out.print( " Rainha recuperou life.");
                this.hp += 10;
            }
        }
    }
    
}