import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
public class Vetores{
    public static void main(String[] args) {
        //------------------------------------------------
        //Arrays
        String[] dds = {"seg", "ter", "qua", "qui", "sex"};
        System.out.println(dds); //[Ljava.lang.String;@379619aa
        
        //criando explicitamente e imprimindo percorrendo com for each
        String[] cores = new String[3];
        cores[0] = "azul";
        cores[1] = "verde";
        cores[2] = "vermelho";

        for(String cor : cores) //for each
            System.out.print(cor + " ");
        System.out.println("");//quebra de linha

        //alterando com acesso indexado
        for(int i = 0; i < cores.length; i++)
            cores[i] = "!" + cores[i]; //obtendo e alterando com []

        //mostrando de outra forma
        System.out.println(Arrays.asList(cores));//???? de onde vem esse arrays
    


        //-----------------------------------------------------------
        //List
        List<String> animais = Arrays.asList("gato", "rato", "sapo"); //multi parametro
        System.out.println(animais); //[gato, rato, sapo]


        String[] pessoas = {"josé", "joão", "zeca"};
        List<String> listaPessoas = Arrays.asList(pessoas); //criando a partir de um Array
        System.out.println(listaPessoas);
        
        
        System.out.println(Arrays.asList("um", "dois", "três")); //inline
        

        //----------------------------------------------------------
        //ArrayList

        ArrayList<String> lista = new ArrayList<>();
        lista.add("banana");
        lista.add("uva");
        lista.add("pera");
        System.out.println(lista);

        //inicializando com vários
        ArrayList<String> arlist = new ArrayList<>(Arrays.asList("um", "dois", "tres"));
        System.out.println(arlist);

        //adicionando varios
        arlist.addAll(Arrays.asList("quatro", "cinco", "seis")); 
        System.out.println(arlist);

        arlist.add(0, "Zero"); //adicionando na posição 0
        arlist.set(5, "CINCO"); //setando o elemento da posição 5 para novo valor

        //colocando um ! no fim de cada entrada do vetor
        for(int i = 0; i < arlist.size(); i++)
            arlist.set(i, arlist.get(i) + "!"); //obs: não se usa o [] para acessar o elemento
        
        System.out.println(arlist);

        String value = arlist.remove(2); //removendo indice 2
        System.out.println(value); //"dois!"
        
        boolean result = arlist.remove("seis"); //removendo o objeto "seis"
        System.out.println(result); //false: seis não existe, existe o "seis!"

        result = arlist.remove("seis!");
        System.out.println(result);//true

        System.out.println(arlist); // [Zero!, um!, tres!, quatro!, CINCO!]

        System.out.println(arlist.contains("quatro!"));//true

        System.out.println(arlist.indexOf("CINCO!"));// qual o indice do objeto "CINCO!": 4
        
        System.out.println(arlist.indexOf("UM!"));// qual o indice do objeto "UM!": -1
        
        //ordena utilizando o critério default para o tipo
        //String por default são ordenadas utilizando-se a comparação lexicográfica
        Collections.sort(arlist);

        System.out.println(arlist);
    }
}