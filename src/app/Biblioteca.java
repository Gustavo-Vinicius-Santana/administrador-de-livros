package app;
import models.Livros;
import  models.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Usuarios> usuariosLista;
    public ArrayList<Livros> livrosLista;

    // METODO CONSTRUTOR
    public Biblioteca() {
        usuariosLista = new ArrayList<>();
        livrosLista = new ArrayList<>();
    }

    // FUNÇÃO PARA CADASTRAR UM USUARIO
    public void addUsuario(){
        Scanner input = new Scanner(System.in);
        String nome;
        System.out.print("Digite o nome do novo usuario: ");
        nome = input.next();
        Usuarios user = new Usuarios();
        user.setNome(nome);
        this.usuariosLista.add(user);
    }

    // FUNÇÃO PARA CADASTRAR UM LIVRO
    public  void addLivros(){
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do novo livro: ");
        String titulo = input.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = input.nextLine();
        System.out.print("Digite o genero do livro: ");
        String genero = input.nextLine();
        System.out.print("Digite a quantidade de livros disponíveis: ");
        int quantidade = input.nextInt();
        Livros livro = new Livros();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setQuantidade(quantidade);
        livrosLista.add(livro);
        System.out.println("\nO livro "+titulo+" foi adiciondo com sucesso!");
    }

    // FUNÇÃO PARA RETORNAR TODOS OS USUARIOS CADASTRADOS
    public void getUsers(){
        if (usuariosLista.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
        } else {
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
            System.out.println("Não há usuários cadastrados.");
        } else {
            int indice = 0;
            for(Usuarios usuario: usuariosLista){
                System.out.println(indice +" - "+ usuario.getNome());

                System.out.print("possui:");
                ArrayList<Livros> livrosUsario = usuario.getListaLivros();
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
            System.out.println("Não há livros cadastrados.");
        } else {
            int indice = 0;
            for(Livros livro: livrosLista){
                System.out.println(indice +"-"+ livro.getTitulo());
                System.out.println("    " + "quantidade: " + livro.getQuantidade());
                System.out.println("    " + "autor: " + livro.getAutor());
                System.out.println("    " + "genero: " + livro.getGenero());
                indice += 1;
            }
        }

    }

    // FUNÇÃO DE ATRELAR LIVRO A UM USUARIO
    public void pegarLivroEmprestado(){
        Scanner input = new Scanner(System.in);
        if (livrosLista.isEmpty()){
            System.out.println("Não há livros cadasatrados...");
        }
        else {
            System.out.println("Escolha o número equivalente ao livro escolhido");

            int indice = 0;
            for (Livros element : livrosLista) {
                String titulo = element.getTitulo();
                System.out.println(indice + " " + titulo);
                indice += 1;
            }

            int escolha = input.nextInt();

            Livros livroEscolhido = livrosLista.get(escolha);
            Integer quantidadePrevia = livroEscolhido.getQuantidade();
            Integer quantidadeAtual = quantidadePrevia - 1;
            livroEscolhido.setQuantidade(quantidadeAtual);
            System.out.println("o livro escolhido foi " + livroEscolhido.getTitulo());

            System.out.println("Digite para quem o livro deve ser enviado: ");
            getUsers();
            System.out.println("Digite o número equivalente ao index do elemento selecionado: ");
            int indexEscolhido = input.nextInt();
            Usuarios userEscolhido = usuariosLista.get(indexEscolhido);
            userEscolhido.adicionarLivro(livroEscolhido);
        }

    }

    // FUNÇÃO PARA O USUARIO ESCOLHIDO DEVOLVER O LIVRO
    public void devolverLivro(){
        Scanner input = new Scanner(System.in);
        getUsers();

        System.out.println("Digite o indice do usuário que irá devolver o livro");
        int escolha = input.nextInt();
        Usuarios userEscolhido = usuariosLista.get(escolha);
        if (userEscolhido.getListaLivros().isEmpty()){
            System.out.println("Não há livros a serem devolvidos.");
        }
        else{
            for (Livros element : userEscolhido.getListaLivros() ){
                int indice = 0;
                System.out.println(indice+"-" + element.getTitulo());
                indice += 1;
            }
            System.out.println("Digite o indice do livro a ser devolvido: ");
            int indiceLivro = input.nextInt();
            userEscolhido.removerLivro(indiceLivro);

            Livros livroEscolhido = livrosLista.get(indiceLivro);
            Integer quantidadePrevia = livroEscolhido.getQuantidade();
            Integer quantidadeAtual = quantidadePrevia + 1;
            livroEscolhido.setQuantidade(quantidadeAtual);
        }
    }
}
