package figure;

import java.util.Arrays;

import static figure.Army.*;
import static figure.PieceType.*;

public class ChessCounter {

    static int countArmy(Piece[] figures, Army side) {
        return (int) Arrays.stream(figures)
                .filter(unit -> unit.getSide() == side)
                .count();
    }

    static int calculateArmyPercentage(Piece[] figures, Army side) {
        return (int) Math.round(
                countArmy(figures, side) * 100.0
                        / figures.length
        );
    }

    static int countPieceType(Piece[] figures, PieceType type) {
        return (int) Arrays.stream(figures)
                .filter(unit -> unit.getType() == type)
                .count();
    }

    static int evaluateArmyStrength(Piece[] figures, Army side) {
        return Arrays.stream(figures)
                .filter(unit -> unit.getSide() == side)
                .map(Piece::getValue)
                .mapToInt(Integer::intValue)
                .sum();
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
        for (Piece figure : figures)
            IO.println(figure.getName() + " " + figure.getSymbol());
        IO.println("");

        int whitesNumber = countArmy(figures, WHITE);
        int blacksNumber = countArmy(figures, BLACK);
        int whitePercentage = calculateArmyPercentage(figures, WHITE);
        int blackPercentage = calculateArmyPercentage(figures, BLACK);
        int whiteStrength = evaluateArmyStrength(figures, WHITE);
        int blackStrength = evaluateArmyStrength(figures, BLACK);
        int pawnsNumber = countPieceType(figures, PAWN);
        int knightsNumber = countPieceType(figures, KNIGHT);

        IO.println("Численность Белых: " + whitesNumber);
        IO.println("Численность Чёрных: " + blacksNumber);
        IO.println("Процент Белых: " + whitePercentage  + "%");
        IO.println("Процент Чёрных: " + blackPercentage + "%");
        IO.println("Численность Пешек: " + pawnsNumber);
        IO.println("Численность Коней: " + knightsNumber);
        IO.println("Сила Белых: " + whiteStrength);
        IO.println("Сила Чёрных: " + blackStrength);

        FigureProvider generator = new FigureProvider();
        Piece[] kit = generator.getStandardKit();
        Arrays.stream(kit)
                .map(Piece::getSymbol)
                .forEach(IO::print);
        IO.println();

        Piece previous = null;
        for (Piece piece : kit) {
            String name = piece.getName();
            IO.print(
                    previous != null && previous.getType() == piece.getType() ?
                            ", " : "\n"
            );
            IO.print(name);
            previous = piece;
        }
        IO.println();

        Piece[] someFig = generator.randomFigures(10, true);
        Arrays.stream(someFig)
                .map(Piece::getSymbol)
                .forEach(IO::print);

    }
}
