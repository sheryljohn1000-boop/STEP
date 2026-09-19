public class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premium;
    private String securityAnswer;

    // Public no-argument constructor
    public LibraryMember() {
    }

    // JavaBean getter and setter for membershipId
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        // Write-once property
        if (membershipId == null) {
            membershipId = id;
        }
    }

    // JavaBean getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Premium uses isPremiumMember()
    public boolean isPremiumMember() {
        return premium;
    }

    public void setPremiumMember(boolean premium) {
        this.premium = premium;
    }

    // Security answer is write-only
    public void setSecurityAnswer(String answer) {

        // Store a simple transformed value
        securityAnswer = answer.hashCode() + "";
    }

    /*
     * There is deliberately NO getSecurityAnswer().
     *
     * The security answer can be set,
     * but it cannot be retrieved.
     */

    public static void main(String[] args) {

        LibraryMember m = new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(
            m.getMembershipId()
        );

        // Second attempt is ignored
        m.setMembershipId("FAKE-0000");

        System.out.println(
            m.getMembershipId()
        );

        System.out.println(
            m.isPremiumMember()
        );

        m.setSecurityAnswer("myanswer");
    }
}