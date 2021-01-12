import java.util.ArrayList;
import java.util.Collections;

class Pessoa implements Comparable<Pessoa>{
    String id;
    String fone;
    public Pessoa(String id, String fone){
        this.id = id;
        this.fone = fone;
    }
    public String toString(){
        return this.id + ":" + this.fone;
    }

    public int compareTo(Pessoa other){
        return id.compareTo(other.id);
    }
}

class Sala{
    ArrayList<Pessoa> cadeiras;
    public Sala(int tamanho){
        cadeiras = new ArrayList<>(Collections.nCopies(tamanho, null));
        Pessoa pessoa = null;
        
        // for(int i = 0; i < tamanho; i++){
        //     cadeiras.add(pessoa);
        // }
    }

    public void reservar(String id, String fone, int index){
        if(index < 0 || index >= cadeiras.size()){ 
            System.out.println("Indice inválido");
            return;
        }
        if(cadeiras.get(index) != null){
            System.out.println("Cadeira ocupada");
            return;
        }

        for(Pessoa cadeira : cadeiras){
            if(cadeira != null && cadeira.id.equals(id)){
                System.out.println("Já existem está pessoa na sala de cinema");
                return;
            }
        }
        cadeiras.set(index, new Pessoa(id, fone));
    }

    public void cancelar(String id){
        boolean encontrei = false;
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i) != null && cadeiras.get(i).id.equals(id)){
                cadeiras.set(i, null);
                encontrei = true;
                break;
            }
        }
        if(encontrei)
            System.out.println("reserva cancelada");
        else
            System.out.println("Id não encontrado");
    }

    public String toString(){
        String saida = "[ ";
        for(Pessoa pessoa : cadeiras){
            if(pessoa == null)
                saida += "- ";
            else
                saida += pessoa + " ";
        }
        return saida + "]";
    }
}

public class Cinema{
    public static void main(String[] args) {
        Sala sala = new Sala(6);
        System.out.println(sala);
        sala.reservar("david", "85", -1);
        sala.reservar("david", "85", 6);
        sala.reservar("david", "85", 5);
        sala.reservar("david", "86", 4);
        System.out.println(sala);
        sala.reservar("Josué", "85", 4);
        sala.reservar("Aluizio", "85", 3);
        System.out.println(sala);
    }
}



class Cinema1{
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("A", "1"));
        pessoas.add(new Pessoa("B", "2"));
        pessoas.add(new Pessoa("C", "3"));

        System.out.println(pessoas);

        for(Pessoa pessoa : pessoas)
            pessoa.id = pessoa.id + "!";

        System.out.println(pessoas);

        for(Pessoa pessoa : pessoas)
            pessoa = new Pessoa("X", "Z");

        System.out.println(pessoas);

        for(int i = 0; i < pessoas.size(); i++)
            pessoas.set(i, new Pessoa("W", "W"));
        
        System.out.println(pessoas);
    }
}

// Collection ou Container

// String[] array = new String[5];

// ArrayList<String> lista = new ArrayList<>(10);


// add(5)
// size = 0, capacidade = 10
// [ 5 ] - - - - - - - - -    }
}

// Collection ou Container

// String[] array = new String[5];

// ArrayList<String> lista = new ArrayList<>(10);


// add(5)
// size = 0, capacidade = 10
// [ 5 ] - - - - - - - - -    }
}

// Collection ou Container

// String[] array = new String[5];

// ArrayList<String> lista = new ArrayList<>(10);


// add(5)
// size = 0, capacidade = 10
// [ 5 ] - - - - - - - - -    }
}

// Collection ou Container

// String[] array = new String[5];

// ArrayList<String> lista = new ArrayList<>(10);


// add(5)
// size = 0, capacidade = 10
// [ 5 ] - - - - - - - - -