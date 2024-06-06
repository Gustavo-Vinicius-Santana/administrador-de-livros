package models;
import models.Livros;

        import java.util.ArrayList;

public class Usuarios {
    // ATRIBUTOS DA CLASSE USUARIOS
    private String nome;
    private int id;
    private ArrayList<Livros> listaLivrosEmprestados;
    private static int contId = 1;

    // METODO CONSTRUTOR
    public Usuarios(){
        this.nome = nome;
        this.id = contId++;
        this.listaLivrosEmprestados = new ArrayList<>();
    }

    // PEGAR NOME DO USUARIO
    public String getNome() {
        return nome;
    }
    // PEGAR O ID DO USUARIO
    public int getId() {
        return id;
    }


    // DEFINIR NOME DO USUARIO
    public void setNome(String nome) {
        this.nome = nome;
    }


    // PEGAR A LISTA DE LIVROS DO USUARIO
    public ArrayList<Livros> getListaLivros() {
        return listaLivrosEmprestados;
    }
    // ADICIONAR LIVRO NA LISTA
    public void adicionarLivro(Livros livro) {
        listaLivrosEmprestados.add(livro);
        System.out.println("O livro "+ listaLivrosEmprestados.get(0).getTitulo()+" foi adicionado!");
    }
    // REMOVER LIVRO DA LISTA
    public void removerLivro(int index) {
        listaLivrosEmprestados.remove(index);
        System.out.println("O Livro foi devolvido");
    }

}



