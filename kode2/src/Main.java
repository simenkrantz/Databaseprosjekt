import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello, treningsdagbok");

        TreningsCtrl treningsCtrl = new TreningsCtrl ();
        treningsCtrl.connect();
        treningsCtrl.addApparat();
        treningsCtrl.addOvelse();
    }

}
