
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Interfaces.ICRUD;
import modelos.Produto;
import utils.ConectaDb;

public class ProdutoDao implements ICRUD {

    @Override
    public Produto salvar(Produto prod) {

        String sql = "INSERT INTO tb_produtos(descricao, preco, quantidade) VALUES (?, ?, ?)";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, prod.getDescricao());
            stm.setDouble(2, prod.getPreco());
            stm.setInt(3, prod.getQuantidade());

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Produto salvo com sucesso!");

            return prod;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM tb_produtos";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Produto prod = new Produto(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"));

                produtos.add(prod);
            }

            rs.close();
            stm.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

    public void atualizar(Produto prod) {

        String sql =
                "UPDATE tb_produtos SET descricao = ?, preco = ?, quantidade = ? WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, prod.getDescricao());
            stm.setDouble(2, prod.getPreco());
            stm.setInt(3, prod.getQuantidade());
            stm.setInt(4, prod.getId());

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Produto atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM tb_produtos WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Produto excluído com sucesso!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        excluir(id);
    }

    @Override
    public void alterar(Produto prod) {
        atualizar(prod);
    }

    @Override
    public Produto consultar(int id) {

        String sql = "SELECT * FROM tb_produtos WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            ResultSet rs = stm.executeQuery();

            if (rs.next()) {

                Produto prod = new Produto(
                        rs.getInt("id"),
                        rs.getString("descricao"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"));

                rs.close();
                stm.close();
                con.close();

                return prod;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Produto> consultar() {
        return listar();
    }
}
