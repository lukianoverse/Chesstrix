package figure;

import static figure.Army.*;
import static figure.PieceType.*;

public class ChessCounter {

    static int countArmy(Piece[] figures, Army side) {
        int count = 0;
        for (Piece unit : figures)
            if (unit.getSide() == side)
                count++;
        return count;
    }

    static int calculateArmyPercentage(Piece[] figures, Army side) {
        int count = countArmy(figures, side);
        return (int) Math.round(count * 100.0 / figures.length);
    }

    static int countPieceType(Piece[] figures, PieceType type) {
        int count = 0;
        for (Piece unit : figures)
            if (unit.getType() == type)
                count++;
        return count;
    }


    static void main() {
        Piece[] figures = {
                new Piece(WHITE, KING),
                new Piece(BLACK, QUEEN),
                new Piece(WHITE, PAWN),
                new Piece(BLACK, BISHOP),
                new Piece(WHITE, KNIGHT),
                new Piece(BLACK, ROOK),
                new Piece(WHITE, PAWN),
                new Piece(BLACK, KNIGHT),
                new Piece(WHITE, PAWN),
                new Piece(BLACK, BISHOP),
                new Piece(WHITE, KNIGHT),
                new Piece(BLACK, ROOK),
                new Piece(WHITE, PAWN)
        };
        int whitesNumber = countArmy(figures, WHITE);
        int blacksNumber = countArmy(figures, BLACK);
        int whitePercentage = calculateArmyPercentage(figures, WHITE);
        int blackPercentage = calculateArmyPercentage(figures, BLACK);
        int pawnsNumber = countPieceType(figures, PAWN);
        int knightsNumber = countPieceType(figures, KNIGHT);

        IO.println("Численность Белых: " + whitesNumber);
        IO.println("Численность Чёрных: " + blacksNumber);
        IO.println("Процент Белых: " + whitePercentage  + "%");
        IO.println("Процент Чёрных: " + blackPercentage + "%");
        IO.println("Численность Пешек: " + pawnsNumber);
        IO.println("Численность Коней: " + knightsNumber);



    }
}
