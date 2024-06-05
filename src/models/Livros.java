package models;

public class Livros {
    // ATRIBUTOS DA CLASSE LIVROS
    private String titulo;
    private String autor;
    private String genero;
    private Integer quantidade;

    // METODO CONSTRUTOR
    public Livros() {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.quantidade = quantidade;
    }

    // METODO PARA PEGAR O LIVRO DO LIVRO
    public String getTitulo() {
        return titulo;
    }
    // METODO PARA PEGAR O AUTOR DO LIVRO
    public String getAutor() {
        return autor;
    }
    // METODO PARA PEGAR O GENERO DO LIVRO
    public String getGenero() {
        return genero;
    }
    // METODO PARA PEGAR A QUANTIDADE DE LIVROS
    public Integer getQuantidade() {
        return quantidade;
    }

    // METODO PARA DEFINIR O TITULO
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    // METODO PARA DEFINIR AUTOR
    public void setAutor(String autor) {
        this.autor = autor;
    }
    // METODO PARA DEFINIR GENERO
    public void setGenero(String genero) {
        this.genero = genero;
    }
    // METODO PARA DEFINIR A QUANTIDADE
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}