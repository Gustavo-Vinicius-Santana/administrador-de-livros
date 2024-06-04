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
        String titulo = input.next();
        System.out.print("Digite o autor do livro: ");
        String autor = input.next();
        System.out.print("Digite o genero do livro: ");
        String genero = input.next();
        System.out.print("Digite a quantidade de livros disponíveis");
        int quantidade = input.nextInt();
        Livros livro = new Livros();
        livro.setTitulo(titulo);
        livro.setAutor(autor);
        livro.setGenero(genero);
        livro.setQuantidade(quantidade);
        System.out.println("O livro "+titulo+" foi adiciondo com sucesso!");
    }
    public void getUsers(){
        if (usuariosLista.isEmpty()) {
            System.out.println("Não há usuários cadastrados.");
        } else {
            for(Usuarios element: usuariosLista){
                System.out.println(element.getNome());
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
            int a = 1;
            for (Livros element : livrosLista) {
                String titulo = element.getTitulo();
                System.out.println(a + " " + titulo);
                a += 1;
            }
            int escolha = input.nextInt();
            /*faltando escolher o livro baseado no index dele e acrescentar a listas presente em Usuarios de livros cadastrados*/
        }

    }
}
