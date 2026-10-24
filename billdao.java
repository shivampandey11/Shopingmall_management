import java.sql.Connection;
import java.sql.PreparedStatement;

class BillDAO
{

    public static void saveBill(double totalBill, double discount,
                                double gst, double finalAmount)
    {

        String sql = "INSERT INTO bills " +
                "(total_bill, discount, gst, final_amount) " +
                "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, totalBill);
            ps.setDouble(2, discount);
            ps.setDouble(3, gst);
            ps.setDouble(4, finalAmount);

            ps.executeUpdate();

            System.out.println("Bill saved in database!");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}