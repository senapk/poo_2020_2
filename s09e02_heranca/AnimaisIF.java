// import java.util.ArrayList;

// interface Pet{
//     String getNome();
//     void receberCarinho();
// }

// interface Adoravel{
//     int conquistar();
// }

// class Cachorro implements Pet{
//     String nome;
//     public Cachorro(String nome){
//         this.nome = nome;
//     }
//     void latir(){
//         System.out.println("uâu");
//     }
//     public void receberCarinho() {
//         System.out.print("virei de barriga pra cima: ");
//         latir();
//     }
//     public String getNome() {
//         return nome;
//     }
//     int conquistar(){
//         return 0;
//     }
// }

// class Gato implements Pet, Adoravel{
//     String id;
//     int fofura;
//     public Gato(String nome, int fofura){
//         this.id = nome;
//         this.fofura = fofura;
//     }
//     void miar(){
//         System.out.println("móóu");
//     }
//     public void receberCarinho() {
//         System.out.print("estou me esfregando nas suas pernas: ");
//         miar();
//     }
//     public String getNome() {
//         return id;
//     }

//     @Override
//     public int conquistar() {
//         return fofura;
//     }
// }

// public class Animais{
//     public static void main(String[] args) {
//         ArrayList<Pet> animais = new ArrayList<>();
//         animais.add(new Cachorro("Vamp"));
//         animais.add(new Cachorro("Wash"));
//         animais.add(new Gato("Tobi", 52));
//         animais.add(new Gato("Noodle", 27));
//         for(Pet pet : animais){
//             System.out.println("Fazendo carinho no:" + pet.getNome());
//             pet.receberCarinho();
//         }

//         Adoravel adoravel = new Gato("Giba", 50);
//         adoravel.conquistar();
//         if(adoravel instanceof Gato){
//             System.out.println("sou um gato");
//             Gato gato = (Gato) adoravel;
//             gato.receberCarinho();
//         }
//     }
// }
