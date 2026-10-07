package figure;

import static figure.Gender.F;
import static figure.Gender.M;

public enum PieceType {
    KING("Король", '♔', '♚', 0, M),
    QUEEN("Ферзь", '♕', '♛', 9, M),
    ROOK("Ладья", '♖', '♜', 5, F),
    BISHOP("Слон", '♗', '♝', 3, M),
    KNIGHT("Конь", '♘', '♞', 3, M),
    PAWN("Пешка", '♙', '♟', 1, F);

    private final String name;
    private final char white;
    private final char black;
    private final int value;
    private final Gender gender;

    PieceType(String name, char white, char black, int value, Gender gender) {
        this.name = name;
        this.white = white;
        this.black = black;
        this.value = value;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public char getWhite() {
        return white;
    }

    public char getBlack() {
        return black;
    }

    public int getValue() {
        return value;
    }

    Gender getGender() {
        return gender;
    }
}

enum Gender {
    M, F
}