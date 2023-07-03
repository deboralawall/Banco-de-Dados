
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClientesController {
    public void createClientes(Connection con) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro de cliente: ");
        System.out.print("CPF: ");
        long cpf = input.nextLong();

        System.out.print("Nome: ");
        String nome = input.nextLine();
        nome = input.nextLine();

        System.out.println("Endereco: ");
        System.out.print("Rua: ");
        String rua = input.nextLine();

        System.out.print("Bairro: ");
        String bairro = input.nextLine();

        System.out.print("Numero: ");
        int num = input.nextInt();

        System.out.print("Telefone: ");
        long tel = input.nextLong();

        Clientes c = new Clientes(cpf, nome, rua, bairro, num, tel);
        ClientesModel.create(c, con);
        System.out.println("Cliente cadastrado");
    }

    void listarCliente(Connection con) throws SQLException {
        HashSet all = ClientesModel.listAll(con);
        Iterator<Clientes> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    void listarContaClientes(Connection con) throws SQLException {
        HashSet all = ClientesModel.listAllWithContas(con);
        Iterator<Conta> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toStringComCliente());
        }
    }
}
