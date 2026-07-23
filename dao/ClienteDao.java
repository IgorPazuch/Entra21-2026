package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import utils.ConectaDb;

public class ClienteDao {

    public Cliente salvar(Cliente cliente) {

        String sql = "INSERT INTO tb_clientes(cpf, nome, email, rua, numero, bairro, cep, cidade, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getRua());
            stm.setInt(5, cliente.getNumero());
            stm.setString(6, cliente.getBairro());
            stm.setInt(7, cliente.getCep());
            stm.setString(8, cliente.getCidade());
            stm.setString(9, cliente.getEstado());

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Cliente salvo com sucesso!");

            return cliente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM tb_clientes";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getInt("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado"));

                clientes.add(cliente);
            }

            rs.close();
            stm.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return clientes;
    }

    public Cliente consultar(int id) {

        String sql = "SELECT * FROM tb_clientes WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("cpf"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("rua"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getInt("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado"));

                rs.close();
                stm.close();
                con.close();

                return cliente;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
    
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE tb_clientes SET "
        + "cpf=?, nome=?, email=?, rua=?, numero=?, bairro=?, cep=?, cidade=?, estado=? "
        + "WHERE id=?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, cliente.getCpf());
            stm.setString(2, cliente.getNome());
            stm.setString(3, cliente.getEmail());
            stm.setString(4, cliente.getRua());
            stm.setInt(5, cliente.getNumero());
            stm.setString(6, cliente.getBairro());
            stm.setInt(7, cliente.getCep());
            stm.setString(8, cliente.getCidade());
            stm.setString(9, cliente.getEstado());
            stm.setInt(10, cliente.getId());

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Cliente atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM tb_clientes WHERE id = ?";

        try {
            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Cliente excluído com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
