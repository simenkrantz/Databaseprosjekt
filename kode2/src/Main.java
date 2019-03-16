

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, treningsdagbok");

        TreningsCtrl treningsCtrl = new TreningsCtrl ();
        treningsCtrl.connect();
        treningsCtrl.addApparat();
    }

}
