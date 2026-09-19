class LibraryMember {

    private String membershipPin;
    String branchCode;       // default / package-private
    double fineOwed;         // default / package-private
    public String displayName;

    LibraryMember(String membershipPin, String branchCode,
                  double fineOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.fineOwed = fineOwed;
        this.displayName = displayName;
    }
}

public class AccessChecker {

    static String classifyAccess(String fieldModifier,
                                 String accessorContext) {

        // public -> accessible everywhere
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
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        String[] modifiers = {
            "private",
            "default",
            "protected",
            "public"
        };

        String result = "";

        for (String modifier : modifiers) {

            int allowed = 0;
            int denied = 0;

            for (String[] attempt : attempts) {

                if (attempt[0].equals(modifier)) {

                    String answer = classifyAccess(
                        attempt[0],
                        attempt[1]
                    );

                    if (answer.equals("ALLOWED")) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }

            result += modifier + ": "
                   + allowed + " allowed / "
                   + denied + " denied\n";
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
            classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            summarizeByModifier(attempts)
        );
    }
}