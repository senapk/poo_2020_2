import java.util.ArrayList;

class Fone{
    String label;
    String number;

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public static boolean validate(String number){
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++)
            if(validos.indexOf(number.charAt(i)) == -1)
                return false;
        return true;
    }
    public String toString(){
        return label + ":" + number;
    }
}

class Contato{
    String nome;
    ArrayList<Fone> fones;

    public Contato(String nome){
        this.nome = nome;
        this.fones = new ArrayList<>();
    }

    public void addFone(String label, String number){//vai má!
        if(Fone.validate(number))
            fones.add(new Fone(label, number));
    }

    Fone getFone(int index){//bora
        if(index >= 0 && index < fones.size()) {
            return fones.get(index);
        }
        System.out.println("Indice invalido");
        return null;
    }
    
    Fone getFone(String label) { //se nao encontrar, retorna null
        for(Fone fone : fones)
            if(fone.label.equals(label))
                return fone;
        return null;
    }
    boolean rmFone(int index){
        if(index < 0 || index >= fones.size())
            return false;
        fones.remove(index);
        return true;
    }

    boolean rmFone(String number){
        if(!Fone.validate(number)){
            System.out.println("Digite um numero valido");
            return false;
        }
        for(Fone fone : fones){
            if(fone.number.equals(number)){
                Crianca sair = fone;
                fones.remove(fone);
                return sair;//apos remove
            }
        }
        return false;
    }

    public String toString(){
        String saida = this.nome;
        int i = 0;
        for(Fone fone : fones){
            saida += " [" + i + ":" + fone + "]";
            i++;
        }
        return saida;
    }

    public static void main(String[] args) {
        Contato contato = new Contato("David");
        contato.addFone("oi", "88");
        contato.addFone("tim", "99");
        contato.addFone("claro", "97");
        System.out.println(contato);
        System.out.println(contato.getFone(1));//tim
        System.out.println(contato.getFone("claro"));//claro:97
        contato.rmFone("99");
        System.out.println(contato);
        contato.rmFone(0);
        System.out.println(contato);
    }
}