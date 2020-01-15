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

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == currentWord.charAt(0)) {
                    Function<Integer, Integer> increment = x  -> x + 1;
                    Function<Integer, Integer> decrement = x -> x - 1;
                    Function<Integer, Integer> keepvalue = x -> x;
                    checkMatchesAndUppercase(currentWord, i, j, increment, increment); // diagonal LRD
                    checkMatchesAndUppercase(currentWord, i, j, keepvalue, increment); // horizontal LR
                }
            }
        }

        return board;
    }

    private void checkMatchesAndUppercase(String currentWord, int i, int j, Function<Integer, Integer> moveK, Function<Integer, Integer> moveL) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); k = moveK.apply(k), l = moveL.apply(l)) {
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] != currentWord.charAt(counter)) break;
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] == currentWord.charAt(counter)) counter++;
        }

        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); k = moveK.apply(k), l = moveL.apply(l), counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);
            }
        }
    }
}
