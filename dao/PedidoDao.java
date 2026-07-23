
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelos.Pedido;
import utils.ConectaDb;

public class PedidoDao {

    public void salvar(Pedido pedido) {

        String sql = "INSERT INTO tb_pedidos(cliente_id, data, status) VALUES (?, ?, ?)";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, pedido.getCliente().getId());
            stm.setString(2, pedido.getData().toString());
            stm.setString(3, pedido.getStatus());

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Pedido salvo com sucesso!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public List<Pedido> listar() {

        List<Pedido> pedidos = new ArrayList<>();

        String sql = "SELECT * FROM tb_pedidos";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                Pedido pedido = new Pedido();

                pedido.setId(rs.getInt("id"));
                pedido.setData(LocalDate.parse(rs.getString("data")));
                pedido.setStatus(rs.getString("status"));

                pedidos.add(pedido);
            }

            rs.close();
            stm.close();
            con.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return pedidos;
    }

    public void finalizar(int id) {

        String sql = "UPDATE tb_pedidos SET status = 'FINALIZADO' WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Pedido finalizado com sucesso!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public void excluir(int id) {

        String sql = "DELETE FROM tb_pedidos WHERE id = ?";

        try {

            Connection con = ConectaDb.conectar();
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setInt(1, id);

            stm.execute();

            stm.close();
            con.close();

            System.out.println("Pedido excluído com sucesso!");

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

}
