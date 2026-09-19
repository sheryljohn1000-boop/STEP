class LibraryMember {

    private String membershipPin;
    String branchCode;
    double fineOwed;
    protected String memberType;
    public String displayName;
}

public class SubclassAccessChecker {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        // public -> allowed everywhere
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        // private -> only same class
        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        // default -> same class or same package
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

            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

                return "DENIED";
            }

            return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String result = classifyAccess(
                attempts[i][0],
                attempts[i][1]
            );

            if (result.equals("DENIED")) {

                return attempts[i][0]
                    + " via "
                    + attempts[i][1]
                    + " (attempt #"
                    + (i + 1)
                    + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {

        String[][] attempts = {
            {"public",
             "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

            {"protected",
             "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},

            {"protected",
             "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(attempts)
        );

        String[][] attempts2 = {
            {"public",
             "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},

            {"protected",
             "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(attempts2)
        );
    }
}