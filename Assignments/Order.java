import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private String name;
    private Double price;
    private Double orderedQuantity;

    public Order(Integer id, String name, Double price, Double orderedQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderedQuantity = orderedQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getOrderedQuantity() {
        return orderedQuantity;
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Product 1", 100.0, 2.0));
        orders.add(new Order(2, "Product 2", 200.0, 1.0));
        Double totalBillAmount = orders.stream().mapToDouble(order -> order.getPrice() * order.getOrderedQuantity())
                .sum();
        Bill creditCardBill = new Bill(1, "John Doe", orders, totalBillAmount, new CreditCardPaymentStrategy());
        Bill netBankingBill = new Bill(2, "Jane Doe", orders, totalBillAmount, new NetBankingPaymentStrategy());
        Bill ePaymentBill = new Bill(3, "Alice", orders, totalBillAmount, new EPaymentStrategy());
        System.out.println("Final amount for Credit Card payment: $" + creditCardBill.calculateFinalAmount());
        System.out.println("Final amount for Net Banking payment: $" + netBankingBill.calculateFinalAmount());
        System.out.println("Final amount for E-Payment: $" + ePaymentBill.calculateFinalAmount());
    }
}

interface PaymentStrategy {
    double calculateExtraCharge(double billAmount);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public double calculateExtraCharge(double billAmount) {
        return 0.0;
    }
}

class NetBankingPaymentStrategy implements PaymentStrategy {
    private static final double BANKING_CHARGE_PERCENTAGE = 2.5;

    @Override
    public double calculateExtraCharge(double billAmount) {
        return (BANKING_CHARGE_PERCENTAGE / 100) * billAmount;
    }
}

class EPaymentStrategy implements PaymentStrategy {
    private static final double EPAYMENT_CHARGE_PERCENTAGE = 5.0;

    @Override
    public double calculateExtraCharge(double billAmount) {
        return (EPAYMENT_CHARGE_PERCENTAGE / 100) * billAmount;
    }
}

class Bill {
    private Integer billNumber;
    private String customerName;
    private List<Order> orderList;
    private Double billAmount;
    private PaymentStrategy paymentStrategy; 

    public Bill(Integer billNumber, String customerName, List<Order> orderList, Double billAmount,
            PaymentStrategy paymentStrategy) {
        this.billNumber = billNumber;
        this.customerName = customerName;
        this.orderList = orderList;
        this.billAmount = billAmount;
        this.paymentStrategy = paymentStrategy;
    }

    public Double calculateFinalAmount() {
        double extraCharge = paymentStrategy.calculateExtraCharge(billAmount);
        return billAmount + extraCharge;
    }
}
