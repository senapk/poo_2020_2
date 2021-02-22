import java.util.Random;
class GeradorDeNomes{
    Random random;
    String vogais = "aeiouy";
    String consoantes = "bcdfghjklmnpqrstvwxz";

    public GeradorDeNomes(){
        random = new Random();
    }

    String randVogal(){
        return "" + vogais.charAt(random.nextInt(vogais.length()));
    }

    String randConsoante(){
        return "" + consoantes.charAt(random.nextInt(consoantes.length()));
    }

    String gerar(int nLetras){
        String nome = "";
        int inicio = random.nextInt(2);
        for(int i = 0; i < nLetras; i++){
            if(i % 2 == inicio)
                nome += i == 0 ? this.randVogal().toUpperCase() : this.randVogal();
            else
                nome += i == 0 ? this.randConsoante().toUpperCase() : randConsoante();
        }
        return nome;
    }

    public static void main(String[] args) {
        GeradorDeNomes gerador = new GeradorDeNomes();
        System.out.println(gerador.gerar(4));
        System.out.println(gerador.gerar(4));
        System.out.println(gerador.gerar(6));
        System.out.println(gerador.gerar(6));
        System.out.println(gerador.gerar(8));
        System.out.println(gerador.gerar(8));
    }
}