package models;

        import java.util.ArrayList;

        public class Usuarios {
            private String nome;
            private int id;
            private ArrayList<String> listaLivros;
            private static int contId = 1;

            public Usuarios(String nome) {
                this.nome = nome;
                this.id = contId++;
                this.listaLivros = new ArrayList<>();
            }

            public String getNome() {
                return nome;
            }

            public int getId() {
                return id;
            }

            public ArrayList<String> getListaLivros() {
                return listaLivros;
            }

            public void adicionarLivro(String livro) {
                listaLivros.add(livro);
            }

            public void removerLivro(String livro) {
                listaLivros.remove(livro);
            }
        }



