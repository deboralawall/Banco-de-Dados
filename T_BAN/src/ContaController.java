import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ContaController {

    public void createConta(Connection con) throws SQLException {

        Scanner input = new Scanner(System.in);

        System.out.println("Insira os seguintes dados para a criar uma conta: ");

        System.out.print("saldo: ");
        float saldo = input.nextFloat();
        
        System.out.println("CPF do cliente: ");
        String cpf = input.next();

        Conta conta = new Conta(saldo, cpf);
        ContaModel.create(conta, con);
        
        

    }

    void listarContas(Connection con) throws SQLException {
        HashSet all = ContaModel.listAll(con);
        Iterator<Conta> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    void listarContasSaldoMaior(Connection con) throws SQLException {
        HashSet all = ContaModel.saldoMaior(con);
        Iterator<Clientes> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getNome());
        }
    }
}
