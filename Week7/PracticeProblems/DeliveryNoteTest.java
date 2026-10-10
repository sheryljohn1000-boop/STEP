abstract class DeliveryNote {
    String id;

    DeliveryNote(String id) {
        this.id = id;
    }

    abstract String generateNote();
}

class ParcelNote extends DeliveryNote {
    ParcelNote(String id) {
        super(id);
    }

    String generateNote() {
        return "Parcel delivery: " + id;
    }
}

class FoodNote extends DeliveryNote {
    FoodNote(String id) {
        super(id);
    }

    String generateNote() {
        return "Food delivery: " + id;
    }
}

public class DeliveryNoteTest {
    public static void main(String[] args) {
        DeliveryNote a = new ParcelNote("P101");
        DeliveryNote b = new FoodNote("F101");

        System.out.println(a.generateNote());
        System.out.println(b.generateNote());
    }
}