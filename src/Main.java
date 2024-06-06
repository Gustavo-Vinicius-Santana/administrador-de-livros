import app.Biblioteca;

import java.util.Scanner;

public class Main {
    // CONSTANTE DE BARRA
    public static final String BARRA = "\n-----------------------------------------------------------------\n";
    // CONSTANTE DA LISTA DE FUNÇÕES
    public static final String OPÇÕES_FUNÇÕES =
            "\nINTERFACE DE INTERAÇÃO:" +
            "\n1-CADASTRAR USUARIO" +
            "\n2-CADASTRAR LIVRO" +
            "\n3-PEGAR LIVRO EMPRESTADO" +
            "\n4-DEVOLVER UM LIVRO" +
            "\n5-MOSTRAR USUÁRIOS CADASTRADOS" +
            "\n6-MOSTRAR USUARIOS E SEUS LIVROS" +
            "\n7-MOSTRAR TODOS OS LIVROS" +
            "\n8-MOSTRAR LISTA DE FUNÇÕES" +
            "\n9-PARAR A APLICAÇÃO";

    // METODO MAIN
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
            while (!teclado.hasNextInt()) {
                System.out.println("Por favor, digite um número  válido.");
                teclado.next();
            }
            int choice = teclado.nextInt(); // !!!!! BUG DO INPUT !!!!!
                System.out.println("Escolha: " + choice);
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
                    System.out.print(BARRA);
                    break;
                case 3:
                    System.out.print("\nFunção de pegar livro emprestado.\n");
                    biblioteca.pegarLivroEmprestado();
                    System.out.print(BARRA);
                    break;
                case 4:
                    System.out.print("\nFunção de devolver um livro.\n");
                    biblioteca.devolverLivro();
                    System.out.print(BARRA);
                    break;
                case 5:
                    System.out.print("\nMostrar usuarios escolhida\n");
                    biblioteca.getUsers();
                    System.out.print(BARRA);
                    break;
                case 6:
                    System.out.print("\nMostrar usuarios e seus livros escolhida\n");
                    biblioteca.getUserBooks();
                    System.out.print(BARRA);
                    break;
                case 7:
                    System.out.print("\nMostrar todos os livros escolhida\n");
                    biblioteca.mostrarTodosLivros();
                    System.out.print(BARRA);
                    break;
                case 8:
                    System.out.print(OPÇÕES_FUNÇÕES);
                    System.out.print(BARRA);
                    break;
                case 9:
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