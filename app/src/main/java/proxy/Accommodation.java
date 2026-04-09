package proxy;

public interface Accommodation {
    void checkIn(int count);
}

class Inn implements Accommodation {
    @Override
    public void checkIn(int count) {
        System.out.println(count + " guests checked into an inn...");
    }
}

class Hostel implements Accommodation {
    @Override
    public void checkIn(int count) {
        System.out.println(count + " guests checked into a hostel...");
    }
}
