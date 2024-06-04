import app.Biblioteca;

import java.util.Scanner;

public class Main {
    public static final String BARRA = "\n-----------------------------------------------------------------\n";

    public static final String OPÇÕES_FUNÇÕES =
            "\nINTERFACE DE INTERAÇÃO:" +
            "\n1-CADASTRAR USUARIO" +
            "\n2-CADASTRAR LIVRO" +
            "\n3-PEGAR LIVRO EMPRESTADO" +
            "\n4-DEVOLVER UM LIVRO" +
            "\n5-MOSTRAR USUÁRIOS CADASTRADOS" +
            "\n6-MOSTRAR LISTA DE FUNÇÕES" +
            "\n7-PARAR A APLICAÇÃO";

    public static void main(String[] args) {
        // TITULO DA APLICAÇÃO
        System.out.print(BARRA);
        System.out.println("\nBEM-VINDO AO SISTEMA DE BLIBIOTECAS");

        // INTERFACE DE INTERAÇÃO COM O USUARIO
        System.out.println(OPÇÕES_FUNÇÕES);

        // ESCOLHA DO USUARIO
        choiceOption();
        System.out.print(BARRA);
    }

    public static void choiceOption(){
        // DEFINIÇÃO DE TECLADO
        Scanner teclado = new Scanner(System.in);

        // DEFINIÇÃO DO OBJETO
        Biblioteca biblioteca = new Biblioteca();

        boolean continuous = true;
        while(continuous){
            // ESCOLHA DA FUNÇÃO QUE O USUARIO DESEJA REALIZAR
            System.out.print("\nDigite o numero da função que você deseja executar: ");
            int choice = teclado.nextInt();
            System.out.print(BARRA);

            switch(choice){
                case 1:
                    System.out.print("\nFunção de cadastro de usuarios escolhida\n");
                    biblioteca.addUsuario();
                    System.out.print(BARRA);
                    break;
                case 2:
                    System.out.print("\nCadastro livros escolhida.\n");
                    biblioteca.addLivros();
                    break;
                case 3:
                    System.out.print("\nFunção de pegar livro emprestado.\n");
                    biblioteca.pegarLivroEmprestado();
                    break;
                case 4:
                    System.out.print("\nFunção de devolver um livro.\n");
                    break;
                case 5:
                    System.out.print("\nMostrar usuarios escolhida\n");
                    biblioteca.getUsers();
                    System.out.print(BARRA);
                    break;
                case 6:
                    System.out.print(OPÇÕES_FUNÇÕES);
                    System.out.print(BARRA);
                    break;
                case 7:
                    System.out.print("\nSistema encerrado.");
                    continuous = false;
                    break;
                default:
                    System.out.print(BARRA);
                    System.out.print("\nO numero digitado é invalido. digite novamente.");
                    choiceOption();
            }
        }
    }
}