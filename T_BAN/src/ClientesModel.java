
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientesModel {

    static void create(Clientes c, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO cliente (cpf, nome, rua, bairro, numero, telefone) "
                + "VALUES (?,?,?,?,?,?)");
        st.setLong(1, c.getCpf());
        st.setString(2, c.getNome());
        st.setString(3, c.getRua());
        st.setString(4, c.getBairro());
        st.setInt(5, c.getNumero());
        st.setLong(6, c.getTelefone());
        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cpf, nome, rua, bairro, numero, telefone FROM cliente";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new Clientes(result.getLong(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getInt(6)));
        }
        return list;
    }

    static HashSet listAllWithContas(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT cliente.cpf, nome, rua, bairro, numero, telefone, saldo, conta.cpf FROM cliente NATURAL JOIN conta";
        ResultSet result = st.executeQuery(sql);
        	
        while(result.next()) {
            Clientes cliente = new Clientes(result.getLong(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getInt(5), result.getInt(6));
                        
            Conta conta = new Conta(result.getInt(7), result.getString(8));
            //cliente.setNumConta(conta);
            //list.add(cliente);
            conta.setCliente(cliente);
            list.add(conta);
            

          
        }

        return list;
    }
}
