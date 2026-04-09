package reflection;

public class User {
    private String name;
    private int age;
    private String role;

    public User(String name, int age) {
        this(name, age, "user");
    }

    public User(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    private boolean isAdmin() {
        return "admin".equals(role);
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + ", role='" + role + "'}";
    }
}
