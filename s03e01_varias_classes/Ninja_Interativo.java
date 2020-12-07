import java.util.Scanner;
import java.util.Random;

class NinjaPersonagem {
    int vida;
    int chakra;
    int especial;
    int agilidade;
    
    NinjaPersonagem (int vida, int chakra, int especial, int agilidade){ 
        this.vida = vida;
        this.chakra = chakra;
        this.especial = especial;
        this.agilidade = agilidade;
    }

    void levarDano(int levarDano){           //Subtrai a vida dos personagens de acordo com os ataques
        vida -= levarDano;
    }

    boolean estaVivo(){               //Verifica se algum deles ainda estão vivo
        if(vida > 0)
            return true;
        return false;
    }

    boolean diminuirAgilidade(){         //Decrementa agilidade no método ataque
        if(agilidade > 5){
            agilidade -= 10;
            return true;
        }
        return false;
    }

    boolean ativarEspecial(){          //Permiti fazer golpe especial de acordo com o nivel de chakra
        if(especial  == 10 && chakra >= 90){
            especial -= 10;
            chakra -= 60;
            return true;
        }
        return false;
    }

    boolean recuperarVida(){    //Permiti recuperar vida de acordo com a quantidade de chakra
        if(chakra >= 10 && chakra <= 40 && vida <= 70){
            vida += 30;
            chakra -= 20;
            agilidade += 5;
            return true;
        }else if(chakra >= 50 && chakra <= 70 && vida <= 80){
            vida += 20;
            chakra -= 10;
            agilidade += 10;
            return true;
        }else if(chakra >= 80 && chakra < 100 && vida <= 90){
            vida += 10;
            chakra -= 5;
            agilidade += 20;
            return true;
        }
        return false;
    }

    boolean recuperarChakra(){     //Permiti recuperar chakra de acordo com a quantidade de vida
        if(vida >= 10 && vida <= 40 && chakra <= 70){
            chakra += 30;
            agilidade += 5;
            return true;
        }else if(vida >= 50 && vida <= 70 && chakra <= 80){
            chakra += 20;
            agilidade += 10;
            return true;
        }else if(vida >= 80 && vida < 100 && chakra <= 90){
            chakra += 10;
            agilidade += 20;
            return true;
        }
        return false;
    }

    int ataque(int ataque){      //Executa o ataque conforme a quantidade de chakra
        if(ataque == 1 && chakra >= 5){
            chakra -= 5;
            agilidade -= 5;
            return 10;
        }else if(ataque == 2 && chakra >= 10){
            chakra -= 10;
            agilidade -= 10;
            return 20;
        }else if(ataque == 3 && chakra >= 15){
            chakra -= 20;
            agilidade -= 20;
            return 30;
        }
        return 0;
    }

    public String toString(){   //Imprime informações dos pesonagens
        return "Vida: " + vida + "/100" + " Chakra: " + chakra;
    }

    public static void main(String[] args) {
        NinjaPersonagem Naruto = new NinjaPersonagem(100, 100, 10, 50);
        NinjaPersonagem Sasuke = new NinjaPersonagem(100, 100, 10, 50);
        
        System.out.println(Naruto);
        System.out.println(Sasuke);
    }
}

public class Ninja_Interativo {
    static void sasukeInterativo(NinjaPersonagem Sasuke, NinjaPersonagem Naruto, Random aleatorio){

        int movimentoSasuke = aleatorio.nextInt(6);     //Escolhe aleatoriamente os movimentos do Sasuke

        switch (movimentoSasuke){
            case 0:       //Recuperar vida
                if(Sasuke.recuperarChakra() == true){         //Verifica se é possivel recuperar chakra
                    System.out.println("Sasuke recuperou chakra!");
                }else{ 
                    System.out.println("Seu oponente é muito forte, mas ele não é pareo pra você!");
                }break;
               
            case 1:       //Recuperar chakra
                if(Sasuke.recuperarVida() == true){         //Verifica se é possivel recuperar vida
                    System.out.println("Sasuke recuperou vida!");
                }else{
                    System.out.println("SAKURA: - Naruto idiota! Não machuque o meu Sasuke!");
                }break;
            
            case 2:
                if(Sasuke.ativarEspecial() == true){         //Verifica se é possivel executar especial
                    Naruto.levarDano(50);
                    System.out.println("Sasuke usou um jutsu avançado.");
                }else{
                    System.out.println("SASUKE: - Onde está sua determinação, idiota?!");
                }break;
                
            default:       //Ataques
                int ataqueSasuke = aleatorio.nextInt(4);    
               
                if(ataqueSasuke != 0){       //Gera um ataque aleatório e verifica se é possivel ser executado
                    Naruto.levarDano(Sasuke.ataque(ataqueSasuke));
                    System.out.println("Sasuke atacou e você sofreu levarDano!");
                }else{
                    System.out.println("Que sorte! Sasuke errou o golpe.");
                }break;
        }
    }

    static void imprimir(){
        System.out.println("\nNARUTO: - SASUKEEE!!!\nSASUKE: - NARUTOOO!!!");
        System.out.println("SAKURA: - Kakashi sensei! Faça alguma coisa!");
        System.out.println("KAKASHI: - Deixe eles lutarem, vamos ver onde isso vai dar...");
        System.out.println("\nAtaque 1 - Dedo secreto da aldeia da folha");
        System.out.println("Ataque 2 - Jutsu multiclones da sombras");
        System.out.println("Ataque 3 - Rasengan");
        System.out.println("Especial");
        System.out.println("Chakra");
        System.out.println("Vida");
    }

    public static void main(String[] args){

        NinjaPersonagem Naruto = new NinjaPersonagem(100, 100, 10, 50);
        NinjaPersonagem Sasuke = new NinjaPersonagem(100, 100, 10, 50);

        Scanner input = new Scanner(System.in);         //Inicializando scanner
        Random aleatorio = new Random();                //Inicializando gerador de numeros aleatorios
        imprimir();
        
        while(Naruto.estaVivo() == true && Sasuke.estaVivo() == true){            //loop para continuidade do jogo

            System.out.println("\nNaruto, escolha sua ação:");
            String line = input.nextLine();                               //Leitura de entrada-string
            String[] tipo = line.split(" ");
            System.out.println("\n");

            if(line.equals("end")){
                System.out.println("SASUKE: - O que foi Naruto? Está com medo?!\n");
                break;

            }else if(tipo[0].equals("ataque")){        
                if(aleatorio.nextBoolean() == true && Sasuke.diminuirAgilidade() == true){      //Gera aleatoriedade para movimento e verifica se desvio é possivel
                    System.out.println("Sasuke desviou.");
                }else{
                    Sasuke.levarDano(Naruto.ataque(Integer.parseInt(tipo[1])));              //Sasuke sofre levarDano de acordo com o ataque de Naruto
                    System.out.println("Sasuke sofreu levarDano!");
                }

            }else if(tipo[0].equals("chakra")){
                if(Naruto.recuperarChakra() == true){   
                    System.out.println("Você recuperou seu chakra.");
                }else{
                    System.out.println("Não foi possivel recuperar seu chakra.");
                }

            }else if(tipo[0].equals("vida")){
                if(Naruto.recuperarVida() == true){
                    System.out.println("Você recuperou sua vida.");
                }else{
                    System.out.println("Não foi possui recuperar sua vida.");
                }

            }else if(tipo[0].equals("especial")){
                if(aleatorio.nextBoolean() == true && Sasuke.diminuirAgilidade() == true){      //Gera aleatoriedade para movimento e verifica se desvio é possivel
                    System.out.println("Sasuke desviou.");
                }else if(Naruto.ativarEspecial() == true){          //Verifica se é possivel executar especial
                    Sasuke.levarDano(50);
                    System.out.println("Você usou um jutsu avançado.");
                }else{
                    System.out.println("Não foi possivel executar sua habilidade especial.");
                }

            }else
                System.out.println("fail: comando invalido");
            
            sasukeInterativo(Sasuke, Naruto, aleatorio);

            System.out.println("Sasuke " + Sasuke);
            System.out.println("Naruto " + Naruto);
        }

        if(Naruto.estaVivo() == true && Sasuke.estaVivo() == false){
            System.out.println("\nVOCÊ GANHOU!");
            System.out.println("KAKASHI: - Parabéns, apesar das poucas habilidades, foi uma ótima luta.\n\n");
        }else if(Sasuke.estaVivo() == true && Naruto.estaVivo() == false){  
            System.out.println("\nVOCÊ PERDEU!"); 
            System.out.println("KAKASHI: - É Naruto, não foi dessa vez...\n\n");
        }else if(Naruto.estaVivo() == false && Sasuke.estaVivo() == false){
            System.out.println("\nAMBOS PERDERAM!");
            System.out.println("KAKASHI: - Só não consigo entender como. Crianças...\n\n");
        }
        input.close();
    }
}