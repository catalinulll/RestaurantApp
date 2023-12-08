public class Main {
    public static void main(String[] args) {
        String driverClassName = "org.postgresql.Driver";

        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        String url = "jdbc:postgresql://localhost:5432/restaurantapp";
        String username = "postgres";
        String password = "parola";


    }
}
