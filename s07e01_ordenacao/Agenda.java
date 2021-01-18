import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;


class Pessoa{
    String id;
    int idade;

    public Pessoa(String id, int idade){
        this.id = id;
        this.idade = idade;
    }
    public String toString(){
        return this.id + ":" + this.idade;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Pessoa))
            return false;
        Pessoa other = (Pessoa) obj;
        return this.id.equals(other.id);
    }
}

class ComparadorPessoas implements Comparator<Pessoa>{

    @Override
    // < 0 se arg0 eh menor
    // > 0 se arg0 eh maior
    // == 0 se são iguais
    public int compare(Pessoa arg0, Pessoa arg1) {
        if(arg0 == null)
            return -1;
        if(arg1 == null)
            return 1;
        int resultado = arg0.id.compareTo(arg1.id);
        if (resultado != 0)
            return resultado;
        return Integer.compare(arg0.idade, arg1.idade);
    }
}

class ComparadorPessoaPorIdade implements Comparator<Pessoa>{
    @Override
    public int compare(Pessoa arg0, Pessoa arg1) {
        if(arg0 == null)
            return -1;
        if(arg1 == null)
            return 1;
        return Integer.compare(arg0.idade, arg1.idade);
    }
}

public class Agenda{
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Miguel", 3));
        pessoas.add(new Pessoa("Ana", 9));
        pessoas.add(new Pessoa("Ana", 8));
        pessoas.add(new Pessoa("Ana", 5));
        pessoas.add(new Pessoa("Joao", 1));
        pessoas.add(null);

        // System.out.println(new Pessoa("Rui", 8).equals(new Pessoa("Rui", 4)));

        System.out.println(pessoas.contains(new Pessoa("miguel", 0)));

        // Pessoa procurada = null;
        // for(Pessoa pessoa : pessoas){
        //     if(pessoa.id.equals("Ana")){
        //         procurada = pessoa;
        //         break;
        //     }
        // }
        // System.out.println(procurada);

        // Collections.sort(pessoas, new ComparadorPessoas());
        // // Collections.sort(pessoas);//usa o compareTo da propria pessoa
        
        // System.out.println(pessoas);
    
        // ArrayList<String> lista = new ArrayList<>(Arrays.asList("b", "c", "x", "d", "a"));
        // Collections.sort(lista);
        // System.out.println(lista);


    
    }
}