package proxy;

// Static Proxy
public class Agent implements Vehicle, Accommodation {
    Vehicle vehicle;
    Accommodation accommodation;

    public Agent(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Agent(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    @Override
    public void checkIn(int count) {
        System.out.println("Booking...");
        System.out.println("Booking confirmed...");
        // before
        System.out.println("Verifying ID...");
        accommodation.checkIn(count);
        // after
        System.out.println("Printing invoice...");
        System.out.println("Managing rewards...");
    }

    @Override
    public void drive() {
        System.out.println("Booking...");
        System.out.println("Booking confirmed...");
        // before
        System.out.println("Verifying ID...");
        vehicle.drive();
        // after
        System.out.println("Printing invoice...");
        System.out.println("Managing rewards...");
    }
}
