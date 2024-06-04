package models;
import models.Livros;

        import java.util.ArrayList;

        public class Usuarios {
            private String nome;
            private int id;
            private ArrayList<Livros> listaLivrosEmprestados;
            private static int contId = 1;

            public Usuarios(){
                this.nome = nome;
                this.id = contId++;
                this.listaLivrosEmprestados = new ArrayList<>();
            }

            public String getNome() {

                return nome;
            }

            public int getId() {

                return id;
            }

            public ArrayList<Livros> getListaLivros() {
                return listaLivrosEmprestados;
            }

            public void adicionarLivro(Livros livro) {

                listaLivrosEmprestados.add(livro);
                System.out.println("O livro "+ listaLivrosEmprestados.get(0).getTitulo()+" foi adicionado!");
            }

            public void removerLivro(int index) {

                listaLivrosEmprestados.remove(index);
                System.out.println("O Livro foi devolvido");
            }

            public void setNome(String nome) {
                this.nome = nome;
            }
        }



