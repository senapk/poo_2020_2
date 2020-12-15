import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

class ArrayT{
    public static void main(String[] args) {
        //Array estático
        String[] dds = {"seg", "ter", "qua", "qui", "sex", "sab", "dom"};
        for(String dia : dds) //for each
            System.out.print(dia + " ");
        System.out.println("");

        for(int i = 0; i < dds.length; i++) //.lenght
            System.out.print(dds[i] + " "); //[] para leitura ou escrita
        System.out.println("");

        for(int i = 0; i < dds.length; i++) //.lenght
            dds[i] = "!" + dds[i] + "!"; //[] para leitura ou escrita

        for(int i = 0; i < dds.length; i++) //.lenght
            System.out.print(dds[i] + " "); 
        System.out.println("");

        System.out.println(dds);

        System.out.println(Arrays.asList(dds)); //conversao de Array para Lista
    }
}

class ListaTest{
    public static void main(String[] args) {
        String[] dds = {"seg", "ter", "qua", "qui", "sex", "sab", "dom"};//array
        List<String> lista_dds = Arrays.asList(dds); //collection
        System.out.println(lista_dds);
     
        //esse objeto não suporta adicao
        List<String> cores = Arrays.asList("blue", "yellow", "pink", "silver", "gold");
        System.out.println(cores);
    }
}   

class ArrayListTest1{
    public static void main(String[] args) {
        List<String> cores = Arrays.asList("blue", "yellow", "pink", "silver", "gold");
        
        ArrayList<String> alCores = new ArrayList<>();
        alCores.add("red");
        alCores.add("blue");
        alCores.add("green");
        
        alCores.addAll(cores); //inserindo varios

        System.out.println(alCores);

        String nome = "Brangantino";
        ArrayList<String> times = new ArrayList<String>(Arrays.asList(nome, "Ferroviario", "Santos"));
        System.out.println(times);
        
        for(String time : times)
            time = time + "!";

        System.out.println(times);

        //for(int i = 0; i < times.size(); i++) //nao funciona com []
        //    times.set(i, times.get(i) + "!");
        
        System.out.println(times);
        times.add("Ceara");
        System.out.println(times);
        System.out.println(times.contains(nome));

        System.out.println("One" == "One");//true
        System.out.println("One" == new String("One")); //false
        System.out.println("One".equals(new String("One"))); //true

        times.remove(nome);
        System.out.println(times);

        times.remove(2);
        System.out.println(times);
        
        times.add(nome);
        System.out.println(times);

        int pos = times.indexOf(nome);
        System.out.println(pos);

        Collections.sort(times);
        System.out.println(times);
    }
}   

class Pessoa{
    String nome;
    public Pessoa(String nome){
        this.nome = nome;
    }
    public String toString(){
        return nome;
    }
}

public class ArrayTest{
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Jose"));
        Pessoa maria = new Pessoa("Maria");
        pessoas.add(maria);
        pessoas.add(new Pessoa("Jesus"));
        System.out.println(pessoas);

        ArrayList<Pessoa> amigos = new ArrayList<>(Arrays.asList(new Pessoa("Jose"),
                                        new Pessoa("Antonio"), new Pessoa("Pedro"), 
                                        new Pessoa("Ricardo")));
        System.out.println(amigos);

        //amigos.addAll(pessoas);
        for(Pessoa pessoa : pessoas)
            amigos.add(pessoa);

        System.out.println(amigos);

        //to com raiva do ricardo
        amigos.remove(3);

        System.out.println(amigos);

        for(int i = 0; i < amigos.size(); i++){
            if(amigos.get(i).nome.equals("Maria")){
                amigos.remove(i);
                break;// EH MUITO IMPORTANTE
            }
        }
        System.out.println(amigos);

        amigos.add(0, new Pessoa("Bebe Yoda"));

        System.out.println(amigos);

        for(int i = 0; i < amigos.size(); i++){
            if(amigos.get(i).nome.equals("Bebe Yoda")){
                //opcao 1 - substitui o objeto pessoa por outro
                //amigos.set(i, new Pessoa("Grogu"));
                //opcao 2 - aproveita o objeto e substitui o nome
                amigos.get(i).nome = "Grogu";
                break;// EH MUITO IMPORTANTE
            }
        }
        System.out.println(amigos);
    }
} 