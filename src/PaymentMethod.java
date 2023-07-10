abstract class PaymentMethod {
    private String ownerName;

    public PaymentMethod(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
