public class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-argument constructor
    public MovieBookingProfile() {
    }

    // Convenience constructor
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Boolean JavaBean getter
    public boolean isConfirmed() {
        return confirmed;
    }

    // Setter for confirmed
    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // OTP can be set
    public void setOtp(String otp) {
        this.otp = otp;
    }

    /*
     * There is intentionally NO getOtp().
     *
     * This makes OTP write-only from outside the class.
     */

    public static void main(String[] args) {

        MovieBookingProfile p =
            new MovieBookingProfile("Rahul Dev");

        System.out.println(p.getName());

        p.setConfirmed(true);

        System.out.println(p.isConfirmed());

        p.setOtp("4471");

        // No getOtp() method exists.
        // So the OTP cannot be retrieved from outside.
    }
}