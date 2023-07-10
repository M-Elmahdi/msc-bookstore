public class Main {
    public static void main(String[] args) {

        Bookstore store = new Bookstore();
        store.addBook("9780132350884", "Effective Java", "Joshua Bloch", 49.99, 10);
        store.addBook("9780321356680", "Clean Code", "Robert C. Martin", 39.99, 5);
        store.addBook("9781449328291", "Learning Python", "Mark Lutz", 44.99, 20);
        ShoppingCart cart = new ShoppingCart();
        try {
            store.addToCart("9780132350884", 2, cart);
            store.addToCart("9780321356680", 1, cart);
            store.removeFromCart("9780132350884", 1, cart);
            Customer customer = new Customer("John Doe", "johndoe@example.com", "123 Main St, Anytown, USA");
            PaymentMethod paymentMethod = new CreditCard("John Doe", "4111111111111111", "123", "01/23");
            store.placeOrder(customer, cart, paymentMethod);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}