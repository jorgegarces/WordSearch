import java.util.function.Function;

public class WordSearch {

    private final String[] wordArray;
    private char[][] board;

    public WordSearch(String[] wordArray, char[][] board) {
        this.wordArray = wordArray;
        this.board = board;
    }

    public char[][] wordSearch() {

        for (String currentWord : wordArray) {
            board = traverseMatrix(currentWord);
        }
        return board;
    }

    private char[][] traverseMatrix(String currentWord) {

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (Character.toLowerCase(board[i][j]) == currentWord.charAt(0)) {
                    for (Move move : Move.values()) {
                        upperCaseIfFound(currentWord, i, j, move);
                    }
                }
        return board;
    }

    static Function<Integer, Integer> increment = x -> x + 1;
    static Function<Integer, Integer> decrement = x -> x - 1;
    static Function<Integer, Integer> keepValue = x -> x;

    private enum Move {
        HORIZONTALLR(keepValue, increment),
        HORIZONTALRL(keepValue, decrement),
        VERTICALUD(increment, keepValue),
        VERTICALDU(decrement, keepValue),
        DIAGONALLRD(increment, increment),
        DIAGONALRLD(increment, decrement),
        DIAGONALLRU(decrement, increment),
        DIAGONALRLU(decrement, decrement);

        private Function<Integer, Integer> horizontal;
        private Function<Integer, Integer> vertical;

        Move(Function<Integer, Integer> horizontal, Function<Integer, Integer> vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }
    }

    private void upperCaseIfFound(String currentWord, int i, int j, Move move) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); k = move.horizontal.apply(k), l = move.vertical.apply(l), counter++) {
            if (Character.toLowerCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]) != currentWord.charAt(counter))
                break;
            if (counter > 0 && Math.floorMod(k, board.length) == i && Math.floorMod(l, board[0].length) == j) break;
        }

        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); k = move.horizontal.apply(k), l = move.vertical.apply(l), counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);
            }
        }
    }
}