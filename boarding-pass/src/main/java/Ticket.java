public class Ticket {

    private int boardingPassID;
    private long date;
    private String origin;
    private String destination;
    private int eta;
    private int departureTime;
    private String name;
    private String email;
    private long phone;
    private String gender;
    private int age;
    private double price;
    private String[] originList = {"Cebu", "Botswana" , "Conakry", "Nice", "Shenzhen"};
    private double distanceInMiles;

    public Ticket(String name, String email,
                  long phone, String gender, int age, long date, String destination, int departureTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;
        this.origin = originList[(int)(Math.random() * (originList.length - 1))];
        distanceInMiles = generateDistance(origin, this.destination);
        this.eta = generateETA(distanceInMiles, this.departureTime);
        setBoardingPassID();
        price = generatePrice(this.age, this.gender, distanceInMiles);

    }

    private int generateBoardingPassID() {
        return (int) (Math.random() * 1000000);
    }

    private int generateETA(double distance, int departureTime) {
        //distance(miles) divided by average speed of commercial aircraft (575mph)
        double timeInHours = (int)(distance / 575.0 * 10) / 10.0; //truncate value after 1st decimal place
        int eta = departureTime + (int)(timeInHours * 100);
        if(eta > 2400)
            eta -= 2400;
        return eta;
    }

    private double generateDistance(String origin, String destination) {
        int distance = Math.abs((origin.hashCode() - destination.hashCode()) / 100);
        return (double)distance / 5280.0 ;
    }

/*    Ticket Price should be calculated as follows:
    Age < = 12, 50% reduction of ticket price regardless of gender
    Age > = 60, 60% reduction of ticket price regardless of gender
    Females, 25% discount on the ticket price*/

    double generatePrice(int age, String gender, double distance) {
        double price = distance * (0.013 * 10); //distance in miles multiplied by avg (flight cost per mile * 10)

        if (age <= 12) {
            price *= 0.5;
        } else if (age >= 60) {
            price *= 0.6;
        } else if (gender.toLowerCase().startsWith("f")) {
            price *= 0.25;
        }

        //truncate value after 2nd decimal place
        price = (int)(price * 100) / 100.00;

        return price;
    }

    public void setBoardingPassID() {
        this.boardingPassID = generateBoardingPassID();
    }

    public int getBoardingPassID() {
        return boardingPassID;
    }

    public long getDate() {
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

    public long getPhone() {
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
