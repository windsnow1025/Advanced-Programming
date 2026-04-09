package proxy;

public interface Vehicle {
    void drive();
}

class AirPlane implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Flying an airplane...");
    }
}

class Train implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Taking a train...");
    }
}
