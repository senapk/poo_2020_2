/*
class Moeda
+ valor: float
+ volume: int

class Item
+ descricao: String
+ volume: int

class Porco
+ itens: String
+ valor: float
+ volume: int
+ volumeMax: int
+ estaQuebrado: boolean
--
+ adicionarDinheiro(moeda: Moeda): bool
+ adicionarCoisa(item: Item): bool
+ estaQuebrado(): bool
+ quebrar(): bool
+ pegarDinheiro(): float
+ pegarCoisas(): String
*/

enum Moeda {
    M10(0.10f, 1),
    M25(0.25f, 2),
    M50(0.50f, 3),
    M100(1f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + "\nVolume: " + valor + "\n";
    }
}

class Item {
    String descricao;
    int volume;

    Item(String descricao, int volume) {
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString() {
        return "Descricao:" + descricao + "\nVolume: " + volume + "\n";
    }
}



class Porco{
    String itens = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;
    
    Porco(int volumeMax) {
        this.volumeMax = volumeMax;
    }

    boolean adicionarDinheiro(Moeda moeda){
        if(estaQuebrado == true){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(moeda.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }

    boolean adicionarItem(Item item) {
        if(estaQuebrado == true){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(this.volume + item.volume > volumeMax) {
            System.out.println("Objeto insuportável no cofre");
            return false;
        }
        this.volume += item.volume;
        if(this.itens.equals(""))
            this.itens = item.descricao;            
        else
            this.itens += ", " + item.descricao;
        return true;
    }   
    boolean quebrar(){
        if(estaQuebrado)
            return false;
        estaQuebrado = true;
        return true;
    }
    float pegarDinheiro(){
        if(!estaQuebrado){
            System.out.println("Voce deve quebrar o cofre primeiro");
            return 0.0f;
        }
        float aux = this.valor;
        this.valor = 0;
        return aux;
    }
    String pegarCoisas(){
        if(!estaQuebrado){
            System.out.println("Voce deve quebrar o cofre primeiro");
            return "";
        }
        String aux = this.itens;
        this.itens = "";
        return aux;
    }
    public String toString() {
        return itens + ":" + valor +":" + volume + "/" + volumeMax + ":" + estaQuebrado;
    }
}

public class Riquinho{
    public static void main(String[] args) {
        Porco porco = new Porco(25);
        System.out.println(porco);
        porco.adicionarDinheiro(Moeda.M100);
        porco.adicionarDinheiro(Moeda.M25);
        System.out.println(porco);
        porco.adicionarItem(new Item("cordao de ouro", 10));
        System.out.println(porco);
        porco.adicionarItem(new Item("piper", 4));
        System.out.println(porco);
        porco.adicionarItem(new Item("bacon", 6));
        System.out.println(porco);
    }
}