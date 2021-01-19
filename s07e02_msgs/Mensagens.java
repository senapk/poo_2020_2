import java.util.*;

class Msg{
    int id;
    String sender;
    String text;
    public Msg(int id, String sender, String text){
        this.id = id;
        this.sender = sender;
        this.text = text;
    }
    public String toString(){
        return "" + id + ":" + sender + ":" + text;
    }
}

class Usuario{
    String username;
    ArrayList<Msg> inbox;
    int contNaoLidos;

    public Usuario(String username){
        this.username = username;
        inbox = new ArrayList<Msg>();
        contNaoLidos = 0;
    }

    public void sendMsg(int idMsg, Usuario dest, String text){
        dest.inbox.add(new Msg(idMsg, username, text));
        dest.contNaoLidos += 1;
    }

    public ArrayList<Msg> getInbox(){
        ArrayList<Msg> output = new ArrayList<>();
        for(int i = inbox.size() - this.contNaoLidos; i < inbox.size(); i++)
            output.add(inbox.get(i));
        contNaoLidos = 0;
        return output;
    }
}

class Sistema{
    ArrayList<Usuario> usuarios;
    int idNextMsg;
    
    public Sistema(){
        this.usuarios = new ArrayList<>();
    }

    void addUser(String username){
        if(this.getUser(username) != null){
            System.out.println("Username ja existe");
            return;
        }
        usuarios.add(new Usuario(username));
    }

    Usuario getUser(String username){
        for(Usuario usuario : usuarios)
            if(usuario.username.equals(username))
                return usuario;
        return null;
    }

    void sendMsg(String sender, String receiver, String text){
        Usuario one = this.getUser(sender);
        Usuario two = this.getUser(receiver);
        if(one == null){
            System.out.println("Usuario " + sender + " nao existe");
            return;
        }
        if(two == null){
            System.out.println("Usuario " + receiver + " nao existe");
            return;
        }
        one.sendMsg(idNextMsg, two, text);
        idNextMsg += 1;
    }

    String readMsgs(String username){
        Usuario one = this.getUser(username);
        if(one == null){
            System.out.println("Usuario " + username + " nao existe");
            return "inbox vazio\n";
        }
        String saida = "";
        for(Msg msg : one.getInbox())
            saida += msg + "\n";
        return saida;
    }
}

public class Mensagens{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.addUser("pedro");
        sistema.addUser("edvaldo");
        sistema.addUser("yago");

        sistema.sendMsg("yago", "pedro", "ou me paga o que me deve ou morre!!!!!!");
        System.out.print(sistema.readMsgs("pedro"));
        sistema.sendMsg("pedro", "edvaldo", "corre carniça, to em risco de vida");
        System.out.print(sistema.readMsgs("pedro"));
        System.out.print(sistema.readMsgs("edvaldo"));
        sistema.sendMsg("edvaldo", "pedro", "ja to na esquina, corre que eu passo de moto");
        System.out.print(sistema.readMsgs("pedro"));

        // Usuario pedro = new Usuario("pedro");
        // Usuario edivaldo = new Usuario("edivaldo");

        // pedro.sendMsg(edivaldo, "bora meter o lanchão");
        // pedro.sendMsg(edivaldo, "quem comer 2 kg de açai nao paga");
        
        // for(Msg msg : edivaldo.getInbox())
        //     System.out.println(msg);
        // pedro.sendMsg(edivaldo, "bora miseria, o Yago chegou aqui antes de ti");
        // pedro.sendMsg(edivaldo, "ele ta cobrando um burgão");
        
        // for(Msg msg : edivaldo.getInbox())
        //     System.out.println(msg);

        // edivaldo.sendMsg(pedro, "partiu, nao eh o Hits, mas ta valendo");

        // for(Msg msg : pedro.getInbox())
        //     System.out.println(msg);
    }
}

