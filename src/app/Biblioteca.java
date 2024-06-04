package app;
import models.Livros;
import  models.Usuarios;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Usuarios> usuariosLista;
    public ArrayList<Livros> livrosLista;

    public Biblioteca() {
        usuariosLista = new ArrayList<>();
        livrosLista = new ArrayList<>();
    }
    public void addUsuario(){
        Scanner input = new Scanner(System.in);
        String nome;
        System.out.print("Digite o nome do novo usuario: ");
        nome = input.next();
        Usuarios user = new Usuarios();
        user.setNome(nome);
        this.usuariosLista.add(user);
    }
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
        System.out.println("O livro "+titulo+" foi adiciondo com sucesso!");
    }
    public void getUsers(){
        if (usuariosLista.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
        } else {
            int a = 0;
            for(Usuarios element: usuariosLista){
                System.out.println(a +">"+ element.getNome());
                a= a + 1;
            }
        }

    }
    public void pegarLivroEmprestado(){
        /* for pela listaa de livros cadastrados,
        * verificar se tem livros cadastrados, se n  tiver avisar,
        * tendo livros cadastrados,  perguntar quem é que quer cadastrar, e depois cadastrar diretamente no usuário.*/
        Scanner input = new Scanner(System.in);
        if (livrosLista.isEmpty()){
            System.out.println("Não há livros cadasatrados...");
        }
        else {
            System.out.println("Escolha o número equivalente ao livro escolhido");
            int a = 0;
            for (Livros element : livrosLista) {
                String titulo = element.getTitulo();
                System.out.println(a + " " + titulo);
                a += 1;
            }
            int escolha = input.nextInt();
                Livros livroEscolhido;
                livroEscolhido = livrosLista.get(escolha);
                System.out.println("o livro escolhido foi " + livroEscolhido.getTitulo());
                System.out.println("Digite para quem o livro deve ser enviado");
                getUsers();
                System.out.println("Digite o número equivalente ao index do elemento selecionado");

                int indexEscolhido = input.nextInt();
                Usuarios userEscolhido = usuariosLista.get(indexEscolhido);
                userEscolhido.adicionarLivro(livroEscolhido);
            /*faltando diminuir a quantidade na classe livro/quntidade.*/
        }

    }
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
                int a = 0;
                System.out.println(a+" > " + element.getTitulo());
                a = a + 1;
            }
            System.out.println("Digite o indice do livro a ser devolvido. ");
            int indiceLivro = input.nextInt();
            userEscolhido.removerLivro(indiceLivro);
        }


    }

}
