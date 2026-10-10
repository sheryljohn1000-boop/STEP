abstract class GardenTool {
    abstract String use();
}

class CuttingTool extends GardenTool {
    String use() {
        return "Cutting plants";
    }
}

class Pruner extends CuttingTool {
    String use() {
        return "Pruning branches";
    }
}

public class GardenToolTest {
    public static void main(String[] args) {
        GardenTool a = new CuttingTool();
        GardenTool b = new Pruner();

        System.out.println(a.use());
        System.out.println(b.use());
    }
}