interface Printable {
    String printLabel();
}

class PackageBox implements Printable {
    String trackingId;

    PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    public String printLabel() {
        return "Package label: " + trackingId;
    }
}

class Invoice implements Printable {
    String invoiceNumber;

    Invoice(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String printLabel() {
        return "Invoice label: " + invoiceNumber;
    }
}

public class PrintableTest {
    static void printAll(Printable[] items) {
        for (Printable p : items)
            System.out.println(p.printLabel());
    }

    public static void main(String[] args) {
        Printable[] items = {
            new PackageBox("TRK-88"),
            new Invoice("INV-42")
        };

        printAll(items);
    }
}