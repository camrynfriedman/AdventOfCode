import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_RockPaperScissors {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("data/day2input.txt"));
        String line = sc.nextLine();
        String theirMove;
        String myMove;
        int player1Pts = 0; // I am player one
        int player2Pts = 0; // They are player two
        int selectedShapeValueP1 = 0;
        int selectedShapeValueP2 = 0;
        int winner = 0;
        System.out.println("Their move" + "\tMy move" + "\tWinner" + "\tP1Points" + "\tP2Points");
        while (sc.hasNextLine()) {
            if (line.equals("EOF")) {
                break;
            }
            // tokenize line
            String[] tokens = line.split(" "); // creates array length 2
            /*
             * for (String token : tokens) {
             * System.out.print(token + " ");
             * }
             * System.out.println();
             */
            theirMove = tokens[0]; // A = rock, B = paper, C = scissors
            myMove = tokens[1]; // X = rock, Y = paper, Z = scissors
            if (theirMove.equals("A")) {
                selectedShapeValueP2 = 1;
                // theirMove = rock
                // if myMove = paper, I win
                if (myMove.equals("X")) {
                    selectedShapeValueP1 = 1;
                    // we chose the same; DRAW
                    player1Pts += (3 + selectedShapeValueP1);
                    player2Pts += (3 + selectedShapeValueP2);
                    // winner = 0;
                    winner = 0;
                } else if (myMove.equals("Y")) {
                    selectedShapeValueP1 = 2;
                    // i win
                    player1Pts += (6 + selectedShapeValueP1);
                    player2Pts += selectedShapeValueP2;
                    winner = 1;
                } else if (myMove.equals("Z")) {
                    selectedShapeValueP1 = 3;
                    // they win
                    player2Pts += (6 + selectedShapeValueP2);
                    player1Pts += selectedShapeValueP1;
                    winner = 2;
                }
            } else if (theirMove.equals("B")) {
                selectedShapeValueP2 = 2;
                // their move = paper
                // if myMove = scissors, I win
                if (myMove.equals("X")) {
                    selectedShapeValueP1 = 1;
                    // my move is rock, they win
                    player2Pts += (6 + selectedShapeValueP2);
                    player1Pts += selectedShapeValueP1;
                    winner = 2;

                } else if (myMove.equals("Y")) {
                    selectedShapeValueP1 = 2;
                    // my move is paper. DRAW
                    player1Pts += (3 + selectedShapeValueP1);
                    player2Pts += (3 + selectedShapeValueP2);
                    winner = 0;

                } else if (myMove.equals("Z")) {
                    selectedShapeValueP1 = 3;
                    // i win
                    player1Pts += (6 + selectedShapeValueP1);
                    player2Pts += selectedShapeValueP2;
                    winner = 1;
                }
            } else if (theirMove.equals("C")) {
                selectedShapeValueP2 = 3;
                // their move = scissors
                // if myMove = rock, I win
                if (myMove.equals("X")) {
                    selectedShapeValueP1 = 1;
                    // my move is rock, I win
                    player1Pts += (6 + selectedShapeValueP1);
                    player2Pts += selectedShapeValueP2;
                    winner = 1;
                } else if (myMove.equals("Y")) {
                    selectedShapeValueP1 = 2;
                    // my move is paper. I lose.
                    player2Pts += (6 + selectedShapeValueP2);
                    player1Pts += selectedShapeValueP1;
                    winner = 2;
                } else if (myMove.equals("Z")) {
                    selectedShapeValueP1 = 3;
                    // my move is scissors. DRAW
                    player1Pts += (3 + selectedShapeValueP1);
                    player2Pts += (3 + selectedShapeValueP2);
                    winner = 0;

                }
            }
            System.out.println(theirMove + "\t" + myMove + "\t" + winner + "\t" + player1Pts + "\t" + player2Pts);
            System.out.println();
            line = sc.nextLine();
        }
        // account for last line

        System.out.print(player1Pts);
        sc.close();
    }

}
