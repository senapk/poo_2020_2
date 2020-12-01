import java.util.Arrays;
import java.util.Scanner;
public class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite varios numeros em linha");
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        int qtd = tokens.length;
        System.out.println("Voce digitou " + qtd + " elementos");
        
        System.out.print("[ ");
        for(int i = 0; i < tokens.length; i++)
            System.out.print(tokens[i] + " ");
        System.out.println("]");
        
        //somando todos
        float acc = 0;
        for(int i = 0; i < tokens.length; i++)
            acc += Float.parseFloat(tokens[i]);

        System.out.println("A soma deu " + acc);
        System.out.println(Arrays.asList(tokens));

        scanner.close(); //liberacao
    }
}