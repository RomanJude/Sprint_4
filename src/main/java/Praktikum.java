public class Praktikum {

    public static void main(String[] args) {
        String name = "ТимотиШаламе";
        Account account = new Account(name);
        boolean result = account.checkNameToEmboss();
        System.out.println(result);
    }

}