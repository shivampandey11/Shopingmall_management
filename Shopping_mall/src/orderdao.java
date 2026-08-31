import java.sql.Connection;
import java.sql.PreparedStatement;

class OrderDAO {

    public static void addOrder(int productId, int quantity, double totalPrice) {

        String sql = "INSERT INTO orders (product_id, quantity, total_price) VALUES (?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);
            ps.setInt(2, quantity);
            ps.setDouble(3, totalPrice);

            ps.executeUpdate();

            System.out.println("Order saved in database!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}