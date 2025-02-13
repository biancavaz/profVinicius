package controller;

import Repository.ListadeTarefasRepository;
import Repository.UserRepository;

import java.util.Scanner;

public class Main {

    private static ListadeTarefasRepository listadeTarefasRepository = new ListadeTarefasRepository();
    private static UserRepository userRepository = new UserRepository();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("TO DO LIST");
        incio();

    }

    public static void incio () {
        do {
            opcoesMenu();
            int opcao = 0;
            try{
                mostrarOpcoesmenu(opcao);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    public static void opcoesMenu (){
        System.out.println("""
                
                1 - TAREFAS
                2 - USUÁRIO
                3 - SAIR
                
                """);

    }

    public static void mostrarOpcoesmenu (int opcao) {
        switch (opcao) {
            case 1: {

                break;
            }
            case 2: {

                break;
            }
            case 3: {
                System.exit(0);
            }
        }
    }

    public static void opcoesTarefas () {
        System.out.println("""
                
                1 - ADICIONAR TAREFA
                2 - EDITAR TAREFA
                3 - DELETAR TAREFA
                4 - LISTAR TAREFAS
                5 - PROCURAR POR UMA TAREFA
                6 - SAIR
                
                """);
    }

    public static void mostrarOpcoesTarefas (int opcao) {
        switch (opcao) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 6: {

            }
        }
    }

}