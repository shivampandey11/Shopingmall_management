import java.sql.Connection;
import java.sql.DriverManager;

 class DatabaseConnection {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/shopping_mall";
        String username = "root";
        String password = "TIGER";

        try {
            Connection con = DriverManager.getConnection(
                    url, username, password
            );

            System.out.println("Database Connected Successfully!");

            return con;

        }
        catch (Exception e)
        {
            e.printStackTrace();
             return null;
        }
    }
}