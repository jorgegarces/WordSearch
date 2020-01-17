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

        Function<Integer, Integer> increment = x  -> x + 1;
        Function<Integer, Integer> decrement = x -> x - 1;
        Function<Integer, Integer> keepValue = x -> x;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (Character.toLowerCase(board[i][j]) == currentWord.charAt(0)) {
                    upperCaseIfFound(currentWord, i, j, keepValue, increment); // horizontal LR
                    upperCaseIfFound(currentWord, i, j, keepValue, decrement); // horizontal Reverse
                    upperCaseIfFound(currentWord, i, j, increment, keepValue); // vertical
                    upperCaseIfFound(currentWord, i, j, decrement, keepValue); // vertical Reverse
                    upperCaseIfFound(currentWord, i, j, increment, increment); // diagonal LRD
                    upperCaseIfFound(currentWord, i, j, increment, decrement); // diagonal RLD
                    upperCaseIfFound(currentWord, i, j, decrement, decrement); // diagonal RLU
                    upperCaseIfFound(currentWord, i, j, decrement, increment); // diagonal LRU
                }

        return board;
    }

    private void upperCaseIfFound(String currentWord, int i, int j, Function<Integer, Integer> moveK, Function<Integer, Integer> moveL) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); k = moveK.apply(k), l = moveL.apply(l), counter++) {
            if (Character.toLowerCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]) != currentWord.charAt(counter)) break;
            if (counter > 0 && Math.floorMod(k, board.length) == i && Math.floorMod(l, board[0].length) == j) break;
        }

        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); k = moveK.apply(k), l = moveL.apply(l), counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);
            }
        }
    }
}