package ParkingLotDesign.payment;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Logic for credit card payment processing
    }
}
