package figure;

import static figure.Army.*;

public class Piece {
    private final Army color;
    private final PieceType type;

    public Piece(Army color, PieceType type) {
        this.color = color;
        this.type = type;
    }
    public Army getSide() {
        return color;
    }
    public PieceType getType() {
        return type;
    }

    public char getSymbol() {
        return color == WHITE ?
                type.getWhite() :
                type.getBlack();
    }

    public int getValue() {
        return type.getValue();
    }

    public String getName() {
        String color = this.color == WHITE ? "Бел" : "Чёрн";
        String flexion = type.getGender() == Gender.M ? "ый" : "ая";
        String type = this.type.getName();

        return "%s%s %s".formatted(color, flexion, type);
    }
}
