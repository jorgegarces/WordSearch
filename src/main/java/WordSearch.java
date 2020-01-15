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
                    diagonalLeftToRightDown(currentWord, i, j);
                    horizontalLeftToRight(currentWord, i, j);
                }
            }
        }

        return board;
    }

    private void diagonalLeftToRightDown(String currentWord, int i, int j) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); k++, l++) {
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] != currentWord.charAt(counter)) break;
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] == currentWord.charAt(counter)) counter++;
        }

        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); k++, l++, counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);

            }
        }
    }

    private void horizontalLeftToRight(String currentWord, int i, int j) {
        int counter = 0;
        for (int k = i, l = j; counter < currentWord.length(); l++) {
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] != currentWord.charAt(counter)) break;
            if (board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] == currentWord.charAt(counter)) counter++;
        }
        if (counter == currentWord.length()) {
            counter = 0;
            for (int k = i, l = j; counter < currentWord.length(); l++, counter++) {
                board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)] = Character.toUpperCase(board[Math.floorMod(k, board.length)][Math.floorMod(l, board[0].length)]);
            }
        }
    }

}
