package ioc;

import java.lang.reflect.Constructor;

// Inversion of Control
class IoCDemo {
    static void main() throws Exception {
        OrderService order1 = new OrderService(PaymentFactory.create("ioc.CreditCard"));
        order1.checkout();

        OrderService order2 = new OrderService();
        order2.setPaymentMethod(PaymentFactory.create("ioc.BankTransfer"));
        order2.checkout();
    }
}

// Factory Method
class PaymentFactory {
    static PaymentMethod create(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        return (PaymentMethod) constructor.newInstance();
    }
}

class OrderService {
    // Dependency Injection
    private PaymentMethod paymentMethod;

    public OrderService() {
    }

    // Constructor injection
    public OrderService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Setter injection
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    void checkout() {
        paymentMethod.pay();
    }
}

interface PaymentMethod {
    void pay();
}

class CreditCard implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Paid with credit card");
    }
}

class BankTransfer implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Paid with bank transfer");
    }
}
