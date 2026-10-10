abstract class ArtPiece {
    static int count = 1001;
    final String pieceId;
    String title;

    ArtPiece(String title) {
        this.title = title;
        pieceId = "ART-" + count++;
    }

    abstract String describe();

    String getPieceId() {
        return pieceId;
    }
}

class Painting extends ArtPiece {
    Painting(String title) {
        super(title);
    }

    String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    Sculpture(String title) {
        super(title);
    }

    String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}

public class ArtPieceTest {
    public static void main(String[] args) {
        ArtPiece p = new Painting("Sunset Fields");
        ArtPiece s = new Sculpture("The Thinker II");

        System.out.println(p.describe());
        System.out.println(s.describe());
        System.out.println(p.getPieceId());
        System.out.println(s.getPieceId());
    }
}