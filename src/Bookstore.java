import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {
    private Map<String, Book> catalog;
    private List<Order> orders;
    private Map<String, Integer> inventory;

    public Bookstore() {
        this.catalog = new HashMap<>();
        this.orders = new ArrayList<>();
        this.inventory = new HashMap<>();
    }

    public void addBook(String isbn, String title, String author, double price, int quantity) {
        catalog.put(isbn, new Book(isbn, title, author, price));
        inventory.put(isbn, quantity);
    }

    public List<Book> search(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : catalog.values()) {
            if (book.getTitle().contains(query) || book.getAuthor().contains(query) || book.getIsbn().contains(query)) {
                results.add(book);
            }
        }
        return results;
    }

    public void addToCart(String isbn, int quantity, ShoppingCart cart) {
        if (inventory.get(isbn) < quantity) {
            System.out.println("Not enough inventory for " + catalog.get(isbn).getTitle());
            return;
        }
        inventory.put(isbn, inventory.get(isbn) - quantity);
        cart.add(new CartItem(catalog.get(isbn), quantity));
    }

    public void removeFromCart(String isbn, int quantity, ShoppingCart cart) {
        inventory.put(isbn, inventory.get(isbn) + quantity);
        cart.remove(new CartItem(catalog.get(isbn), quantity));
    }

    public double calculateTotal(ShoppingCart cart) {
        double total = 0;
        for (CartItem item : cart.getItems()) {
            total += item.getBook().getPrice() * item.getQuantity();
        }
        return total;
    }

    public void placeOrder(Customer customer, ShoppingCart cart, PaymentMethod paymentMethod) {
        Order order = new Order(customer, cart, calculateTotal(cart), paymentMethod);
        orders.add(order);
        cart.clear();
    }
}
