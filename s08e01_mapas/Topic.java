/*
import java.util.ArrayList;
import java.util.Scanner;

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
		return this.name +":"+ this.idade+" ";
    }
    
    boolean ehPreferencial(){
        return this.idade > this.idadePref;
    }
}

public class Topic {
	
	ArrayList<Pass> cadeiras = new ArrayList<>();
	int qtdPref;
	Topic(int lotacao, int qtdPref){
		for(int i = 0; i < lotacao; i++) {
			this.cadeiras.add(null);
		}
		this.qtdPref =qtdPref;
    }
    
    private int findPos(String id){
        for(int i = 0; i < this.cadeiras.size(); i++) 
			if(cadeiras.get(i) != null && this.cadeiras.get(i).name.equals(id)) 
				return i;
		return -1;
    }

    private int findNullPos(int inicio, int fim){
        for(int i = inicio; i < fim; i++) 
            if(cadeiras.get(i) == null)
                return i;
        return -1;
    }

	void subir(String id, int idade){
        if (this.findPos(id) == -1){
            System.out.println("O passageiro ja esta no trem");
            return;
        }
        Pass pass = new Pass(id, idade);
        int pos = -1;
		if(pass.ehPreferencial()) {
            pos = findNullPos(0, this.cadeiras.size());
		}else {
            pos = findNullPos(this.qtdPref, this.cadeiras.size());
            if(pos == -1)
                pos = findNullPos(0, this.qtdPref);	
		}
        if(pos == -1){ 
            System.out.println(id + " esta lotado!");
            return;
        }
        cadeiras.set(pos, pass);		
	}
	
	void descer(String name) {
		int position = -1;
		for(int i = 0; i < cadeiras.size(); i++) {
			if(cadeiras.get(i) != null && cadeiras.get(i).name.equals(name)) {
				position = i;
			}
		}
		if(position >= 0) {
			this.cadeiras.set(position, null);
        }
    }
    
	@Override
	public String toString() {
		String passengers = "";
		for(int i = 0; i < cadeiras.size(); i++) {
            Pass pass = this.cadeiras.get(i);
            passengers += (i < this.qtdPref) ? "@" : "=";
            passengers += (pass == null ? "" : pass) + " ";		
		}
		return "[" + passengers +" ]";
    }
    
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Topic topic;
		
		while(true) {
			String start = scan.nextLine();
			String[] wordStart = start.split(" ");
			if(wordStart[0].equals("init")) {
				topic = new Topic(Integer.parseInt(wordStart[1]), Integer.parseInt(wordStart[2]));
				break;
			}else {
				System.out.println("inicie o projeto com: init quantidadeCadeiras quantidadeCadeirasPreferenciais");	
			}
			
		}
		while(true) {
			String command = scan.nextLine();
			String[] word = command.split(" ");
			if(word[0].equals("show")) {
				System.out.println(topic);
			}else if(word[0].equals("entrar")){
				topic.subir(word[1], Integer.parseInt(word[2]));
			}else if(word[0].equals("descer")){
				topic.descer(word[1]);
			}else if(word[0].equals("end")){
				break;
			}
		}
		scan.close();
	}

}
*/