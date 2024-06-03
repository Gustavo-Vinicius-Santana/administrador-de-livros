package models;

public class Livros {
    private String titulo;
    private String autor;
    private String genero;
    private Integer quantidade;
}
public Livros(String titulo){
    this.titulo = titulo;
    this.autor = autor;
    this.genero = genero;
    this.quantidade = quantidade;
}
public String getTitulo(){
    return titulo;
}
public void setTitulo(String titulo){
    this.titulo = titulo;
}
public String getAutor(){
    return autor;
}
public void setAutor(String autor){
    this.autor = autor;
}
public String getGenero(){
    return genero;
}
public void setGenero(String genero){
    this.genero = genero;
}
public integer getQuantidade(){
    return quantidade;
}
public void setQuantidade(integer quantidade){
    this.quantidade = quantidade;
}