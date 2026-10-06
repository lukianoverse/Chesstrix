package figure;

class Piece {
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
}
