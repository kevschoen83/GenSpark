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
        setBoardingPassID(generateBoardingPassID());

    }

    int generateBoardingPassID() {
        return (int) (Math.random() * 1000000);
    }

    int generateETA(String origin, String destination, int departureTime) {
        return 0;
    }

/*    Ticket Price should be calculated as follows:
    Age < = 12, 50% reduction of ticket price regardless of gender
    Age > = 60, 60% reduction of ticket price regardless of gender
    Females, 25% discount on the ticket price*/

    double generatePrice(int age, String gender) {
        int price = 0;
        if (age <= 12) {
            return price * 0.5;
        } else if (age >= 60) {
            return price * 0.6;
        } else if (gender.equals("Female") || gender.equals("female")) {
            return price * 0.25;
        } else {
            return price;
        }
    }

    public void setETA(int eta) {
        this.eta = eta;
    }

    public void setBoardingPassID(int boardingPassID) {
        this.boardingPassID = boardingPassID;
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
