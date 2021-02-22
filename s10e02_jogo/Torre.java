class Torre extends Cavalo {
    public String getNome(){
        return "🗼" + nome;
    }
    public void receiveDamage(int qtd, Player other) {
        if(hp < 5){
            System.out.print( " Torre ativou o escudo.");
            hp -= qtd/5;
        }else
            hp -= qtd/2;
    }
}