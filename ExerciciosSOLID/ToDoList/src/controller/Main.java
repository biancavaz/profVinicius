package controller;

import Repository.ListadeTarefasRepository;
import Repository.UserRepository;
import models.ListaDeTarefas;
import models.User;

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
                do {
                    opcoesTarefas();
                    int opcaoTarefa = 0;
                    do {
                        mostrarOpcoesTarefas(opcaoTarefa);
                    } while (true);
                } while (opcao != 6);
            }
            case 2: {
                do {
                    opcoesUser();
                    int opcaoUser = 0;
                    do{
                        mostrarOpcoesUser(opcaoUser);
                    } while (true);
                } while (opcao != 6);
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
                adicionarTarefa();
                break;
            }
            case 2: {
                editarTerefa();
                break;
            }
            case 3: {
                deletarTarefa();
                break;
            }
            case 4: {
                mostrarTarefas();
                break;
            }
            case 5: {
                readOneTarefas();
                break;
            }
            case 6: {
                incio();
            }
        }
    }

    public static void opcoesUser () {
        System.out.println("""
                
                1 - ADICIONAR USER
                2 - EDITAR USER
                3 - DELETAR USER
                4 - LISTAR USUÁRIOS
                5 - PROCURAR POR UM USER
                6 - SAIR
                
                """);
    }

    public static void mostrarOpcoesUser (int opcao) {
        switch (opcao) {
            case 1: {
                adicionarUsuario();
                break;
            }
            case 2: {
                editarUsuario();
                break;
            }
            case 3: {
                deletarUsuario();
                break;
            }
            case 4: {
                mostrarusers();
                break;
            }
            case 5: {
                readOneUser();
                break;
            }
            case 6: {
                incio();
            }
        }
    }


    //adicionar
    public static void adicionarTarefa () {

        System.out.println("Informe o título da tarefa: ");
        String titulo = sc.nextLine();

        System.out.println("Informe a descrição da tarefa: ");
        String descricao = sc.nextLine();

        System.out.println("Informe o status da tarefa: ");
        String status = sc.nextLine();

        System.out.println("Informe a prioridade da tarefa: ");
        String prioridade = sc.nextLine();

        //busca o user
        User user = readOneUser();

        listadeTarefasRepository.CreateTarefa(new ListaDeTarefas
                (titulo, descricao, status, prioridade, user));
    }

    public static void adicionarUsuario () {

        System.out.println("Informe o nome do usuario: ");
        String nome = sc.nextLine();

        System.out.println("Informe o email do usuario: ");
        String email = sc.nextLine();

        System.out.println("Informe a senha de usuario: ");
        String senha = sc.nextLine();

        userRepository.CreateUser(new User(nome, email, senha));
    }

    //editar
    public static void editarTerefa () {
        ListaDeTarefas tarefas = readOneTarefas();

        User user = readOneUser();
        tarefas.setUser(user);

        System.out.println("Informe o status da tarefa: ");
        String status = sc.nextLine();

        tarefas.setStatus(status);
        listadeTarefasRepository.UpdateTarefa(tarefas);
    }

    public static void editarUsuario () {
        User user = readOneUser();

        System.out.println("informe nova senha: ");
        String senha = sc.nextLine();

        user.setSenha(senha);
        userRepository.UpdateUser(user);
    }

    //deletar
    public static void deletarTarefa () {
        ListaDeTarefas tarefas = readOneTarefas();
        listadeTarefasRepository.DeleteTarefa(tarefas.getTitulo());
    }

    public static void deletarUsuario () {
        User user = readOneUser();
        userRepository.DeleteUser(user.getNome());
    }

    //mostrar um
    public static User readOneUser () {
        System.out.println(userRepository.readAllUsers());
        System.out.println("Informe o id: ");
        int id = sc.nextInt();

        return userRepository.readOnde(id);
    }

    public static ListaDeTarefas readOneTarefas () {
        System.out.println(listadeTarefasRepository.readAll());

        System.out.println("Informe o titulo da tarefa: ");
        String titulo = sc.nextLine();

        return listadeTarefasRepository.readOnde(titulo);
    }

    //mostrar vários
    public static void mostrarTarefas () {
        System.out.println(listadeTarefasRepository.readAll());
    }

    public static void mostrarusers () {
        System.out.println(userRepository.readAllUsers());
    }

}