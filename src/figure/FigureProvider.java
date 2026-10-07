package figure;

import java.util.*;

import static figure.PieceType.*;

public class FigureProvider {

    /**
     * Стандартное количество фигур в армии: 1 король, 1 ферзь, 2 ладьи,
     * 2 слона, 2 коня и 8 пешек.
     * Порядок соответствует ординалу в {@link figure.PieceType}.
     */
    final static int[] STANDARD_PIECE_COMPOSITION = {1, 1, 2, 2, 2, 8};

    Random random = new Random();

    /**
     * Возвращает случайную фигуру случайного цвета.
     */
    public Piece randomFigure() {
        return randomFigure(false);
    }

    public Piece randomFigure(Army side) {
        return randomFigure(side, false);
    }

    public Piece randomFigure(boolean fair) {
        PieceType type;
        if (fair) {
            int seed = random.nextInt(16);
            if (seed > 7) type = PAWN;
            else if (seed > 5) type = KNIGHT;
            else if (seed > 3) type = BISHOP;
            else if (seed > 1) type = ROOK;
            else if (seed > 0) type = QUEEN;
            else type = KING;
        } else {
            type = values()[random.nextInt(6)];
        }
        Army side = Army.values()[random.nextInt(2)];
        return new Piece(side, type);
    }

    public Piece randomFigure(Army side, boolean fair) {
        PieceType type;
        if (fair) {
            int seed = random.nextInt(16);
            if (seed > 7) type = PAWN;
            else if (seed > 5) type = KNIGHT;
            else if (seed > 3) type = BISHOP;
            else if (seed > 1) type = ROOK;
            else if (seed > 0) type = QUEEN;
            else type = KING;
        } else {
            type = values()[random.nextInt(6)];
        }
        return new Piece(side, type);
    }

    /**
     * Возвращает массив случайных фигур случайного цвета
     * @param count количество фигур
     * @return  массив случайных фигур указанного размера.
     */
    public Piece[] randomFigures(int count) {
        return randomFigures(count, false);
    }

    public Piece[] randomFigures(int count, boolean fair) {
        Piece[] figures = new Piece[count];
        Arrays.setAll(figures, _ -> randomFigure(fair));
        return figures;
    }


    public Piece[] getStandardKit() {
        Piece[] figures = new Piece[32];
        int index = 0;
        for (Army side : Army.values())
            for (PieceType type : values()) {
                int count = STANDARD_PIECE_COMPOSITION[type.ordinal()];
                for (int i = 0; i < count; i++)
                    figures[index++] = new Piece(side, type);
            }
        return figures;
    }

}
