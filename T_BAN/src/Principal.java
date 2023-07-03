
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;

        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new ContaController().createConta(con); break;
                    case 2: new ClientesController().createClientes(con); break;
                    case 3: new ContaController().listarContas(con); break;
                    case 4: new ClientesController().listarCliente(con); break;
                    case 5: new ClientesController().listarContaClientes(con); break;
                    case 6: new ContaController().listarContasSaldoMaior(con); break;
                    case 7: break;
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);
        con.close();
    }

    private static int menu() {
        System.out.println("1 - Inserir uma nova conta");
        System.out.println("2 - Inserir um novo cliente");
        System.out.println("3 - Exibir todas as contas");
        System.out.println("4 - Exibir todos os clientes");
        System.out.println("5 - Exibir todos os clientes e suas respectivas contas");
        System.out.println("6 - Exibir clientes com saldo maior que 1500: ");
        System.out.println("7 - Sair");
        System.out.print("Escolha: ");

        Scanner input = new Scanner(System.in);

        return input.nextInt();
    }
}
