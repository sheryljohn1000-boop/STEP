class MovieTicket {

    private int seatNumber;
    protected String screenId;
    double ticketPrice;
    public String movieTitle;
}

class PremiumMovieTicket extends MovieTicket {
    
    // This class represents a subclass in a different package.
}

public class SubclassAccessChecker {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        // public is allowed everywhere
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        // private is allowed only inside the same class
        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        // default/package-private
        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        // protected
        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE") ||
                accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                return "ALLOWED";
            }

            // If accessed through a MovieTicket reference
            // in a different package, protected is denied.
            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

                return "DENIED";
            }

            return "DENIED";
        }

        return "DENIED";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );
    }
}