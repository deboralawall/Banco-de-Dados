
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class ContaModel {

    public static void create(Conta c, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO conta (saldo, cpf) VALUES (?,?)");

        st.setFloat(1, c.getSaldo());
        st.setString(2, c.getCpf());

        st.execute();
        st.close();
    }

    static HashSet listAll(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT numConta, saldo, cpf FROM conta";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new Conta(result.getInt(1), result.getFloat(2), result.getString(3)));
        }
        return list;
    }
    
    static HashSet saldoMaior(Connection con) throws SQLException {
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "SELECT nome FROM cliente JOIN conta ON cliente.cpf = conta.cpf WHERE saldo > 1500;";
        ResultSet result = st.executeQuery(sql);
        while(result.next()) {
            list.add(new Clientes(result.getString(1)));
        }
        return list;
    }
    
}
