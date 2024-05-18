import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // DEFINIÇÃO DE TECLADO
        Scanner teclado = new Scanner(System.in);

        // DEFINIÇÃO DE VARIAVEIS
        int escolha;

        // TITULO DA APLICAÇÃO
        System.out.println("\nBEM-VINDO AO SISTEMA DE BLIBIOTECAS");
        System.out.print("\n-----------------------------------------------------------------\n");

        // INTERFACE DE INTERAÇÃO COM O USUARIO
        System.out.println("\nINTERFACE DE INTERAÇÃO:\n");
        System.out.println("1-CADASTRAR USUARIO");
        System.out.println("2-CADASTRAR LIVRO");
        System.out.println("3-PEGAR LIVRO EMPRESTADO");
        System.out.println("4-DEVOLVER UM LIVRO\n");

        // RESPOSTA DO USUARIO
        System.out.print("Digite o numero da função que você deseja executar: ");
        escolha = teclado.nextInt();

        System.out.print("\n-----------------------------------------------------------------\n");
    }
}