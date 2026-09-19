import java.util.Scanner;

class CSVStudentRecordParser {

    void parseStudentRecord(String csvLine) {

        // Split the input wherever there is a comma
        String[] fields = csvLine.split(",");

        // Check if exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        // Print the formatted student record
        System.out.println("Name: " + fields[0]
                + " | Roll No: " + fields[1]
                + " | Dept: " + fields[2]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        CSVStudentRecordParser obj = new CSVStudentRecordParser();

        obj.parseStudentRecord(csvLine);
    }
}