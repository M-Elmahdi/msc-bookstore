public class Order {

    private Customer customer;
    private ShoppingCart cart;
    private double total;
    private PaymentMethod paymentMethod;

    public Order(Customer customer, ShoppingCart cart, double total, PaymentMethod paymentMethod) {
        this.customer = customer;
        this.cart = cart;
        this.total = total;
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public double getTotal() {
        return total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}
