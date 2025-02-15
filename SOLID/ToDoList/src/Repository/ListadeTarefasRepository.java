package Repository;

import Exception.TarefaInexistenteException;
import models.ListaDeTarefas;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListadeTarefasRepository {

    private final BancoDeDados db = new BancoDeDados();

    //CREATE
    public ListaDeTarefas CreateTarefa(ListaDeTarefas listaDeTarefas) {

        try (Connection con = db.getConnection()){

            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_tarefa (titulo, " +
                    "descricao, status, prioridade, id_user)" +
                    "VALUES (?,?,?,?,?,)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, listaDeTarefas.getTitulo());
            ps.setString(2, listaDeTarefas.getDescricao());
            ps.setString(3, listaDeTarefas.getStatus());
            ps.setString(4, listaDeTarefas.getPrioridade());
            ps.setInt(5, listaDeTarefas.getUser().getId());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // só retorna as colunas auto-increments

            if (rs.next()){
                listaDeTarefas.setId(rs.getInt(1));
                return listaDeTarefas;
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }

    //EDITAR
    public void UpdateTarefa(ListaDeTarefas listaDeTarefas) {
        try (Connection con = db.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE tb_tarefa" +
                    " SET titulo = ?, descricao = ?, status =?, prioridade =?, id_user =? " +
                    " WHERE titulo = ?");

            ps.setString(1, listaDeTarefas.getTitulo());
            ps.setString(2, listaDeTarefas.getDescricao());
            ps.setString(3, listaDeTarefas.getStatus());
            ps.setString(4, listaDeTarefas.getPrioridade());
            ps.setInt(5, listaDeTarefas.getUser().getId());
            ps.setString(6, listaDeTarefas.getTitulo());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //DELETE
    public void DeleteTarefa(String titulo) {

        try(Connection con = db.getConnection()){

            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_tarefa WHERE titulo = ?");

            ps.setString(1, titulo);
            ps.execute();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    //READ ALL
    public List<ListaDeTarefas> readAll () {

        try(Connection con = db.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_tarefa");
            ResultSet rs = ps.executeQuery();
            List<ListaDeTarefas> listaTarefas = new ArrayList<>();

            while (rs.next()) {

                int id = rs.getInt("id_tarefa");
                String titulo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                String prioridade = rs.getString("prioridade");
                int id_user = rs.getInt("id_user");

                UserRepository crudUser = new UserRepository();
                User user = crudUser.readOnde(id_user);

                listaTarefas.add(new ListaDeTarefas(id, titulo, descricao, status, prioridade, user));
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }

    //READ ONE
    public ListaDeTarefas readOnde(String titulo) {
        try (Connection con = db.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_tarefas " +
                    " WHERE titulo = ?");

            ps.setString(1, titulo);
            ResultSet rs = ps.executeQuery();

            //avança de uma em uma casa
            if (rs.next()) {

                int id = rs.getInt("id");
                String tituloo = rs.getString("titulo");
                String descricao = rs.getString("descricao");
                String status = rs.getString("status");
                String prioridade = rs.getString("prioridade");
                int id_user = rs.getInt("id_user");


                UserRepository crudUser = new UserRepository();
                User user = crudUser.readOnde(id_user);

                return new ListaDeTarefas(id, tituloo, descricao, status, prioridade, user);

            }

        } catch (SQLException e){
            System.err.println(e.getMessage());
        }

        throw new TarefaInexistenteException();
    }

}
