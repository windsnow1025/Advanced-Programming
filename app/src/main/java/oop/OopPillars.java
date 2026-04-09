package oop;

public class OopPillars {

    abstract static class Payment {
        // Encapsulation
        private final String reference;
        private final long amountCents;

        protected Payment(String reference, long amountCents) {
            if (amountCents <= 0) throw new IllegalArgumentException("amount must be positive");
            this.reference = reference;
            this.amountCents = amountCents;
        }

        // Inheritance
        public String getReference() { return reference; }
        public long getAmountCents() { return amountCents; }

        // Abstraction
        public abstract String process();
    }

    static class CreditCardPayment extends Payment {
        private final String last4;

        public CreditCardPayment(String reference, long amountCents, String last4) {
            super(reference, amountCents);
            this.last4 = last4;
        }

        @Override
        public String process() {
            return "Charged $" + (getAmountCents() / 100.0) + " to card ****" + last4 + " [" + getReference() + "]";
        }
    }

    static class BankTransferPayment extends Payment {
        private final String iban;

        public BankTransferPayment(String reference, long amountCents, String iban) {
            super(reference, amountCents);
            this.iban = iban;
        }

        @Override
        public String process() {
            return "Wired $" + (getAmountCents() / 100.0) + " to IBAN " + iban + " [" + getReference() + "]";
        }
    }

    static void main() {
        Payment card = new CreditCardPayment("ORD-1001", 4999, "4242");
        Payment bank = new BankTransferPayment("ORD-1002", 250000, "DE89370400440532013000");

        // Polymorphism
        System.out.println(card.process());
        System.out.println(bank.process());
    }
}
