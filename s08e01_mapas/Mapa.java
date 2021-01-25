import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.Arrays;

class Pass {
	String name;
	int idade;
    final int idadePref = 60;
    
	Pass(String id, int idade){
		this.name = id;
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return this.name +":"+ this.idade;
    }
    
    boolean ehPreferencial(){
        return this.idade > this.idadePref;
    }
}

public class Mapa {
    public static void main(String[] args) {
		TreeMap<String, Pass> pessoas = new TreeMap<>();
		pessoas.put("Camila", new Pass("Camila", 18));
		pessoas.put("David", new Pass("David", 36));

		pessoas.put("Josue", new Pass("Josue", 19));
		pessoas.put("Josue", new Pass("Josue", 40));
		
		System.out.println(pessoas);
		
		System.out.println(pessoas.containsKey("Camila"));

		
		Pass passJosue = pessoas.get("Josue");
		Pass passFernando = pessoas.get("Fernando"); //null


		TreeSet<Integer> conj = new TreeSet<>(Arrays.asList(4, 3, 1, 2, 1, 1, 1, 2, 3));
		System.out.println(conj);
		//Set = sem repeticao
		for(String key : pessoas.keySet())
			System.out.println(pessoas.get(key));

		for(Pass pass : pessoas.values()){
			pass.idade += 1;
			System.out.println(pass);
		}

		for(Entry<String, Pass> par : pessoas.entrySet())
			System.out.println(par.getKey() + " " + par.getValue());

		pessoas.remove("David");
	}
}
