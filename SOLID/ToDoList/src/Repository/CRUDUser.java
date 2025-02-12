package Repository;

import models.ListaDeTarefas;
import models.User;

import java.sql.*;

public class CRUDUser {

    BancoDeDados banco = new BancoDeDados();

    //CREATE
    public User CreateUser(User user) {

        try (Connection con = banco.getConnection()){

            PreparedStatement ps = con.prepareStatement("INSERT INTO tb_tarefa (nome, " +
                    "email, senha) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys(); // só retorna as colunas auto-increments

            if (rs.next()){
                user.setId(rs.getInt(1));
                return user;
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }

    //EDITAR
    public void UpdateUser(User user) {
        try (Connection con = banco.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE tb_tarefa" +
                    " SET nome = ?, email = ?, senha =? WHERE nome = ?");

            ps.setString(1, user.getNome());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getNome());
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }

    //DELETE
    public void DeleteUser(String nome) {

    }

    //READ ALL

    //READ ONE
}
