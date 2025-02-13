package Repository;

import models.ListaDeTarefas;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

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
        try(Connection con = banco.getConnection()){

            PreparedStatement ps = con.prepareStatement("DELETE FROM tb_tarefa " +
                    "WHERE nome = ?");

            ps.setString(1, nome);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //READ ALL
    public List<User> readAllUsers() {
        try(Connection con = banco.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM tb_tarefa");

            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();

            while (rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                users.add(new User(nome, id, email, senha));

            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }

    //READ ONE
    public User readOnde(int id) {
        try(Connection con = banco.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM " +
                    " tb_tarefa WHERE id = ?");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                int idUser = rs.getInt("idUser");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String senha = rs.getString("senha");

                return new User(nome, idUser, email, senha);

            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException();
    }
}
