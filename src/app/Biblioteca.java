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
        this.usuariosLista.add(new Usuarios(nome));
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
}
