import java.util.ArrayList;
import java.util.TreeMap;

class Transaction {
    int id;
    String codename;
    float value;

    public Transaction(int id, String codename, float value) {
        this.codename = codename;    
        this.id = id;    
        this.value = value;        
    }

    public String toString() {
        return "" + id + ":" + codename + ":" + value;
    }
}

class Client {
    String codename;
    float limit;
    float balance;

    public Client(String codename, float limit) {
        this.codename = codename;    
        this.limit = limit;    
        this.balance = 0;        
    }

    public String toString() {
        return "" + codename + " " + balance + "/" + limit;
    }
}

class Agiota{
    float balance;
    TreeMap<String, Client> clientes;
    int nextId;
    TreeMap<Integer, Transaction> transacoes;

    //TreeMap ou HashMap
    //TreeMap -> Arvore -> Chave Ordenável -> Menos memória -> desempenho pior
    //HashMap -> Hash -> Chave Hashavel -> Mais memória -> desem melhor
    public Agiota(float balance){
        this.balance = balance;
        this.clientes = new TreeMap<>();
        this.transacoes = new TreeMap<>();
        this.nextId = 0;
    }

    public void addTransaction(String codename, float value){
        this.transacoes.put(this.nextId, new Transaction(this.nextId, codename, value));
        this.nextId += 1;
    }

    public void addCli(String codename, float limit){
        if(this.clientes.containsKey(codename)){
            System.out.println("fail: usuario ja existe");
            return;
        }
        this.clientes.put(codename, new Client(codename, limit));
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("Clientes\n");
        for(Client client : this.clientes.values())
            saida.append("- " + client + "\n");
        saida.append("Transacoes\n");
        for(Transaction transaction : this.transacoes.values())
            saida.append("- " + transaction + "\n");
        return saida.toString();
    }

    public void lend(String codename, float value){
        Client client = clientes.get(codename);
        if(client == null)
            System.out.println("fail: cliente não existe");
        else if(this.balance < value)
            System.out.println("fail: agiota sem dinheiro");
        else if(value > (client.limit - client.balance))
            System.out.println("fail: limite de cliente excedido");
        else {
            this.balance -= value;
            client.balance += value;
            this.addTransaction(codename, -value);
        }
    }

    public void receive(String codename, float value){
        Client client = clientes.get(codename);
        if(client == null)
            System.out.println("fail: cliente não existe");
        else if(value > client.balance)
            System.out.println("fail: muito dinheiro");
        else {
            this.balance += value;
            client.balance -= value;
            this.addTransaction(codename, value);
        }
    }

    public void lucrar(){
        for(Client client : this.clientes.values()){
//            this.addTransaction(client.id, value);
            client.balance *= 1.10;
        }
    }

    public void kill(String codename){
        if(this.clientes.containsKey(codename)){
            this.clientes.remove(codename);
            ArrayList<Integer> indices = new ArrayList<>();
            for(Transaction tr : this.transacoes.values())
                if(tr.codename.equals(codename))
                    indices.add(tr.id);
            for(Integer indice : indices)
                this.transacoes.remove(indice);
        }
    }


}

public class Solver{
    public static void main(String[] args) {
        Agiota ag = new Agiota(500);
        ag.addCli("maria", 500);
        ag.addCli("josue", 100);
        ag.addCli("josua", 600);
        ag.addCli("josui", 300);
        ag.addCli("maria", 300); //fail

        ag.lend("maria", 300);
        ag.lend("josue", 50);
        ag.lend("maria", 100);

        System.out.println(ag); //check

        ag.lend("bruno", 30);//fail
        ag.lend("maria", 60);//fail
        ag.lend("josue", 30);//fail

        System.out.println(ag); //check

        // ag.receive("maria", 1000);//fail
        // ag.receive("maria", 350);
        // ag.receive("josue", 1);
        // ag.receive("maria", 10);

        // System.out.println(ag); //check

        ag.kill("maria");

        // System.out.println(ag); //check
    }
}