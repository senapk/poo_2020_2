


public class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int bucho, int maxBucho, int nPatas){ //parametros
        this.bucho = bucho;
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            System.out.println("Ouch! Perdi uma pata");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(0, 20, 4);
        System.out.println(deadlango);

        
        for(int i = 0; i < 25; i++)
            deadlango.comer();
        System.out.println(deadlango);
        
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        System.out.println(deadlango);

        for(int i = 0; i < 25; i++)
            deadlango.andar();
        System.out.println(deadlango);
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        deadlango.regenerar();
        System.out.println(deadlango);
        // deadlango.acidentar();
        // deadlango.regenerar();
        // deadlango.bucho = 0;
        // deadlango.maxBucho = 20;
        // deadlango.nPatas = 4;


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();


        // deadlango.comer();

        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();

    }
}


        // deadlango.comer();
        // deadlango.andar();
        // deadlango.acidentar();
        // deadlango.regenerar();

