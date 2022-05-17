public class Ticket {

    private int boardingPassID;
    private int date;
    private String origin;
    private String destination;
    private int eta;
    private int departureTime;
    private String name;
    private String email;
    private int phone;
    private String gender;
    private int age;
    private double price;

    public Ticket(String name, String email,
                  int phone, String gender, int age, int date, String destination, int departureTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;

        //TODO generate data methods
    }

    public int getBoardingPassID() {
        return boardingPassID;
    }
    public int getDate() {
        return date;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getEta() {
        return eta;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public double getPrice() {
        return price;
    }
}
