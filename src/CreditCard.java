public class CreditCard extends PaymentMethod{

    private String number;
    private String cvv;
    private String expirationDate;

    public CreditCard(String ownerName, String number, String cvv, String expirationDate) {
        super(ownerName);
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
