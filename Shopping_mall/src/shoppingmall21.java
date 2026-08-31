import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

class ShoppingMall23 {

    public static void main(String args[]) {



        Scanner sc = new Scanner(System.in);// keyboard se input lene ke liye



        int choice = 0;

        int quantity;



        int totalBill = 0;// amount store karta hai



        int shirtQty = 0;//quantity store karta hai

        int jeansQty = 0;// same

        int shoesQty = 0;

        int watchQty = 0;

        int tshirtQty = 0;



        System.out.println("=========================");

        System.out.println("---- WELCOME TO SHOPPING MALL ----");

        System.out.println("=========================");



        while (true) {



            System.out.println("\n---- SHOPPING MENU ----");

            System.out.println("1. Shirt  - Rs 500");

            System.out.println("2. Jeans  - Rs 1000");

            System.out.println("3. Shoes  - Rs 1550");

            System.out.println("4. Watch  - Rs 2499");

            System.out.println("5. T-shirt - Rs 699");

            System.out.println("6. Exit");

            System.out.print("Choose your product: ");



            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter quantity of shirt: ");
                quantity = sc.nextInt();

                shirtQty += quantity;
                totalBill += quantity * 500;

                OrderDAO.addOrder(1, quantity, quantity * 500);

                System.out.println("Shirt added to cart!");
            }



             else if (choice == 2) {

                System.out.print("Enter quantity of jeans: ");

                quantity = sc.nextInt();

                jeansQty += quantity;

                totalBill += quantity * 1000;

                OrderDAO.addOrder(2, quantity, quantity * 1000);

                System.out.println("Jeans added to cart!");

            }



            else if (choice == 3) {

                System.out.print("Enter quantity of shoes: ");

                quantity = sc.nextInt();

                shoesQty += quantity;

                totalBill += quantity * 1550;

                OrderDAO.addOrder(3, quantity, quantity * 1550);


                System.out.println("Shoes added to cart!");

            }



            else if (choice == 4) {

                System.out.print("Enter quantity of watch: ");

                quantity = sc.nextInt();

                watchQty += quantity;

                totalBill += quantity * 2499;

                OrderDAO.addOrder(4, quantity, quantity * 2499);

                System.out.println("Watch added to cart!");

            }



            else if (choice == 5) {

                System.out.print("Enter quantity of T-shirt: ");

                quantity = sc.nextInt();

                tshirtQty += quantity;

                totalBill += quantity * 699;

                OrderDAO.addOrder(5, quantity, quantity * 699);

                System.out.println("T-shirt added to cart!");

            }



            else if (choice == 6) {

                break;

            }



            else {

                System.out.println("Invalid choice! Try again");

            }



            System.out.print("Do you want to continue shopping? (1-Yes / 0-No): ");

            int cont = sc.nextInt();

            if (cont == 0) {

                break;

            }

        }



        // DISCOUNT + GST

        double discount = 0;



        if (totalBill > 3000) {

            discount = totalBill * 0.10;

        }



        double billAfterDiscount = totalBill - discount;

        double gst = billAfterDiscount * 0.05;

        double finalAmount = billAfterDiscount + gst;
        BillDAO.saveBill(totalBill, discount, gst, finalAmount);





        // BILL PRINT

        System.out.println("\n==================================");

        System.out.println("            FINAL BILL            ");

        System.out.println("==================================");



        if (shirtQty > 0)

            System.out.println("Shirt x " + shirtQty + " = " + (shirtQty * 500));



        if (jeansQty > 0)

            System.out.println("Jeans x " + jeansQty + " = " + (jeansQty * 1000));



        if (shoesQty > 0)

            System.out.println("Shoes x " + shoesQty + " = " + (shoesQty * 1550));



        if (watchQty > 0)

            System.out.println("Watch x " + watchQty + " = " + (watchQty * 2499));



        if (tshirtQty > 0)

            System.out.println("T-shirt x " + tshirtQty + " = " + (tshirtQty * 699));



        System.out.println("----------------------------------");

        System.out.println("Total Bill       : " + totalBill);



        if (discount > 0)

            System.out.println("Discount (10%)   : -" + discount);



        System.out.println("GST (5%)         : +" + gst);

        System.out.println("----------------------------------");

        System.out.println("Final Amount     : " + finalAmount);

        System.out.println("==================================");



        System.out.println("🙏 Thank you for shopping!");



        sc.close();

    }

}