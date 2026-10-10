abstract class Instrument {
    abstract String play();
}

class StringInstrument extends Instrument {
    String play() {
        return "Playing a string instrument";
    }

    String warmUp() {
        return "Warming up string instrument";
    }
}

class Violin extends StringInstrument {
    String play() {
        return "Playing violin";
    }

    String warmUp() {
        return super.warmUp() + " and tuning violin";
    }
}

public class InstrumentTest {
    public static void main(String[] args) {
        Violin v = new Violin();

        System.out.println(v.play());
        System.out.println(v.warmUp());
    }
}