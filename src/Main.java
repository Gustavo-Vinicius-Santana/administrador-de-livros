import app.Biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TITULO DA APLICAÇÃO
        System.out.println("\nBEM-VINDO AO SISTEMA DE BLIBIOTECAS");
        System.out.print("\n-----------------------------------------------------------------\n");

        // INTERFACE DE INTERAÇÃO COM O USUARIO
        System.out.println("\nINTERFACE DE INTERAÇÃO:\n");
        System.out.println("1-CADASTRAR USUARIO");
        System.out.println("2-CADASTRAR LIVRO");
        System.out.println("3-PEGAR LIVRO EMPRESTADO");
        System.out.println("4-DEVOLVER UM LIVRO");
        System.out.println("5-MOSTRAR USUÁRIOS CADASTRADOS\n");

        // ESCOLHA DO USUARIO
        choiceOption();

        System.out.print("\n-----------------------------------------------------------------\n");
    }

    public static void choiceOption(){
        // DEFINIÇÃO DE TECLADO
        Scanner teclado = new Scanner(System.in);

        System.out.print("\nDigite o numero da função que você deseja executar: ");
        int choice = teclado.nextInt();

        //Criação de objetos
        Biblioteca biblioteca = new Biblioteca();


        switch(choice){
            case 1:
                biblioteca.addUsuario();
            case 2:
                System.out.print("\nFunção cadastro livros escolhida.\n");
                break;
            case 3:
                System.out.print("\nFunção de pegar livro emprestado.\n");
                break;
            case 4:
                System.out.print("\nFunção de devolver um livro.\n");
                break;
            case 5:
                biblioteca.getUsers();
                break;
            default:
                System.out.print("\n-----------------------------------------------------------------\n");
                System.out.print("\nO numero digitado é invalido. digite novamente.");
                choiceOption();

        }

    }
}