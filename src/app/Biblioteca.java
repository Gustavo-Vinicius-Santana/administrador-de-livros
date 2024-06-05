package app;
import models.Livros;
import  models.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    // LISTAS DOS USUARIOS E LIVROS
    private ArrayList<Usuarios> usuariosLista;
    public ArrayList<Livros> livrosLista;

    // DEFINIÇÃO DO TECLADO
    Scanner input;

    // METODO CONSTRUTOR
    public Biblioteca() {
        usuariosLista = new ArrayList<>();
        livrosLista = new ArrayList<>();
        input = new Scanner(System.in);
    }

    // FUNÇÃO PARA CADASTRAR UM USUARIO
    public void addUsuario(){
        // ENTRADA DO NOME DO USUARIO
        System.out.print("Digite o nome do novo usuario: ");
        String nome = input.next();

        // CRIAR O USUARIO DE ACORDO COM A MODEL
        Usuarios user = new Usuarios();
        user.setNome(nome);

        // ADICIONAR O USUARIO CRIADO
        this.usuariosLista.add(user);
    }

    // FUNÇÃO PARA CADASTRAR UM LIVRO
    public  void addLivros(){
        // ENTRADA DO TITULO DO LIVRO
        System.out.print("Digite o nome do novo livro: ");
        String titulo = input.nextLine();

        // ENTRADA DO NOME DO AUTOR DO LIVRO
        System.out.print("Digite o autor do livro: ");
        String autor = input.nextLine();

        // ENTRADA DO GENERO DO LIVRO
        System.out.print("Digite o genero do livro: ");
        String genero = input.nextLine();

        // ENTRADA DA QUANTIDADE DOS LIVROS
        System.out.print("Digite a quantidade de livros disponíveis: ");
        int quantidade = input.nextInt();

        // CRIAR O LIVRO DE ACORDO COM A MODEL
        Livros livro = new Livros();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setQuantidade(quantidade);

        // INSERIR O LIVRO NA LISTA
        livrosLista.add(livro);
        System.out.println("\nO livro "+titulo+" foi adiciondo com sucesso!");
    }

    // FUNÇÃO PARA RETORNAR TODOS OS USUARIOS CADASTRADOS
    public void getUsers(){
        if (usuariosLista.isEmpty()) {
            System.out.println("Não há usuários cadastrados."); // MENSAGEM QUANDO NÃO HÁ USUARIOS
        } else {
            // REPETIÇÃO PAR MOSTRAR TODOS OS USAURIOS DA LISTA
            int indice = 0;
            for(Usuarios element: usuariosLista){
                System.out.println(indice +"-"+ element.getNome());
                indice += 1;
            }
        }
    }

    // FUNÇÃO MOSTRAR USUSARIOS E OS LIVROS ATRELADOS A ELE
    public void getUserBooks(){
        if (usuariosLista.isEmpty()) {
            System.out.println("Não há usuários cadastrados."); // MENSAGEM QUANDO NÃO HÁ USUARIOS CADASTRADOS
        } else {
            // REPETIÇÃO PARA MOSTRAR TODOS OS USUARIOS
            int indice = 0;
            for(Usuarios usuario: usuariosLista){
                System.out.println(indice +" - "+ usuario.getNome());

                System.out.print("possui:");
                ArrayList<Livros> livrosUsario = usuario.getListaLivros();

                // REPETIÇÃO PARA MOSTRAR OS LIVROS E A QUANTIDADE DOS USUARIOS
                int indiceLivro = 0;
                for (Livros livro : livrosUsario) {

                    String titulo = livro.getTitulo();
                    System.out.println("   " + indiceLivro + " - " + titulo);
                    indiceLivro += 1;
                }
                indice += 1;
            }
        }
    }

    // FUNÇÃO MOSTRAR TODOS OS LIVROS E SEUS DETALHES
    public void mostrarTodosLivros(){
        if (livrosLista.isEmpty()) {
            System.out.println("Não há livros cadastrados."); // MENSAGEM QUANDO NÃO HÁ LIVROS CADASTRADOS
        } else {
            // REPETIÇÃO PARA MOSTRAR TODOS OS LIVROS
            int indice = 0;
            for(Livros livro: livrosLista){
                System.out.println(indice +"-"+ livro.getTitulo()); // MOSTRAR TITULO
                System.out.println("    " + "quantidade: " + livro.getQuantidade()); // MOSTRAR QUANTIDADE
                System.out.println("    " + "autor: " + livro.getAutor()); // MOSTRAR AUTOR
                System.out.println("    " + "genero: " + livro.getGenero()); // MOSTRAR GENERO
                indice += 1;
            }
        }

    }

    // FUNÇÃO DE ATRELAR LIVRO A UM USUARIO
    public void pegarLivroEmprestado(){
        if (livrosLista.isEmpty()){
            System.out.println("Não há livros cadastrados."); // MENSAGEM QUANDO NÃO HÁ LIVROS CADASTRADOS
        }
        else {
            // REPETIÇÃO PARA MOSTRAR TODOS OS LIVROS
            int indice = 0;
            for (Livros element : livrosLista) {
                String titulo = element.getTitulo();
                System.out.println(indice + " " + titulo);
                indice += 1;
            }

            // ENTRADA DA ESCOLHA DE ACORDO COM O INDICE
            System.out.println("Escolha o número equivalente ao livro escolhido: ");
            int escolha = input.nextInt();

            // DIMINUINDO A QUANTIDADE DE LIVROS DE ACORDO COM A ESCOLHA
            Livros livroEscolhido = livrosLista.get(escolha);
            Integer quantidadePrevia = livroEscolhido.getQuantidade();
            Integer quantidadeAtual = quantidadePrevia - 1;
            livroEscolhido.setQuantidade(quantidadeAtual);
            System.out.println("o livro escolhido foi " + livroEscolhido.getTitulo());

            // MOSTRAR TODOS OS USUARIOS
            getUsers();

            // ENTRADA DO INDICE DO USUARIO QUE VAI PEGAR O LIVRO
            System.out.println("Digite o número equivalente ao index do elemento selecionado: ");
            int indexEscolhido = input.nextInt();

            // ADICIONANDO NA LISTA DE USUARIOS
            Usuarios userEscolhido = usuariosLista.get(indexEscolhido);
            userEscolhido.adicionarLivro(livroEscolhido);
        }

    }

    // FUNÇÃO PARA O USUARIO ESCOLHIDO DEVOLVER O LIVRO
    public void devolverLivro(){
        // LISTAR TODOS OS USARIOS
        getUsers();

        // ENTRADA DO INDICE DO USUARIO QUE VAI DEVOLVER UM LIVRO
        System.out.println("Digite o indice do usuário que irá devolver o livro");
        int escolha = input.nextInt();
        Usuarios userEscolhido = usuariosLista.get(escolha);

        if (userEscolhido.getListaLivros().isEmpty()){
            System.out.println("Não há livros a serem devolvidos."); //  MENSAGEM QUANDO NÃO HÁ LIVROS CADASTRADOS
        }
        else{
            // REPETIÇÃO PARA MOSTRAR TODOS OS USUARIOS
            for (Livros livro : userEscolhido.getListaLivros() ){
                int indice = 0;
                System.out.println(indice+"-" + livro.getTitulo());
                indice += 1;
            }

            // ENTRADA DO INDICE DO LIVRO QUE SERÁ DIGITADO
            System.out.println("Digite o indice do livro a ser devolvido: ");
            int indiceLivro = input.nextInt();
            userEscolhido.removerLivro(indiceLivro);

            // AUMENTANDO A QUANTIDADE DO LIVRO DEVOLVIDO
            Livros livroEscolhido = livrosLista.get(indiceLivro);
            Integer quantidadePrevia = livroEscolhido.getQuantidade();
            Integer quantidadeAtual = quantidadePrevia + 1;
            livroEscolhido.setQuantidade(quantidadeAtual);
        }
    }
}
