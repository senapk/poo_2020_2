import java.util.ArrayList;

abstract class Pet{
    String nome;
    public Pet(String nome){
        this.nome = nome;
    }
    String getNome(){
        return nome;
    }
    abstract void receberCarinho(); //eh abstrata
}

interface Adoravel{
    int conquistar();
}

class Cachorro extends Pet{
    public Cachorro(String nome){
        super(nome);
    }
    void latir(){
        System.out.println("uâu");
    }
    public void receberCarinho() {
        System.out.print("virei de barriga pra cima: ");
        latir();
    }
    int conquistar(){
        return 0;
    }
}

class Gato extends Pet implements Adoravel{
    int fofura;
    public Gato(String nome, int fofura){
        super(nome);
        this.fofura = fofura;
    }
    void miar(){
        System.out.println("móóu");
    }
    public void receberCarinho() {
        System.out.print("estou me esfregando nas suas pernas: ");
        miar();
    }
    public int conquistar() {
        return fofura;
    }
}

class GatoNinja extends Gato{
    int poder;
    public GatoNinja(String nome, int poder){
        super(nome, -99);
        this.poder = poder;
    }
    String getNome(){
        return "ninja jedi master: " + super.getNome();
    }
    public void receberCarinho() {
        super.receberCarinho();
        System.out.println("Cortei suas pernas com meu sabrinho de led");
    }

    void matar(Pet pet){
        pet.nome = "RIP ... " + pet.nome;
    }

    void miar(){
        System.out.println("Nhaum!!!!!!");
    }
}

public class Animais{
    public static void main(String[] args) {
        ArrayList<Pet> animais = new ArrayList<>();
        animais.add(new Cachorro("Vamp"));
        animais.add(new Cachorro("Wash"));
        animais.add(new GatoNinja("Babe Yoda", 500));
        animais.add(new Gato("Noodle", 27));
        for(Pet pet : animais){
            System.out.println("Fazendo carinho no:" + pet.getNome());
            pet.receberCarinho();
        }

        Adoravel adoravel = new Gato("Giba", 50);
        adoravel.conquistar();
        if(adoravel instanceof Gato){
            System.out.println("sou um gato");
            Gato gato = (Gato) adoravel;
            gato.receberCarinho();
        }
        Pet gato = new Gato("rui", 88);
        GatoNinja gato2 = new GatoNinja("ninja americano", 5);
        gato2.matar(gato);
        System.out.println(gato.getNome());
        Pet pet2 = gato2;
        System.out.println(pet2.getNome());        
    }
}
