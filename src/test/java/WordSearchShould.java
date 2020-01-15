import org.junit.Assert;
import org.junit.Test;

public class WordSearchShould {

    @Test
    public void find_a_word_Diagonal_Left_to_Right_Down(){
        String[] words = new String[] {"lbf", "dcc"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'd', 'f'},
                {'l', 'c', 'c'}
        };

        char[][] expected = new char[][] {
                {'a', 'B', 'C'},
                {'D', 'd', 'F'},
                {'L', 'C', 'c'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }

    @Test
    public void find_a_word_Horizontal_Left_to_Right(){
        String[] words = new String[] {"bca", "df"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'd', 'f'},
                {'l', 'c', 'c'}
        };

        char[][] expected = new char[][] {
                {'A', 'B', 'C'},
                {'d', 'D', 'F'},
                {'l', 'c', 'c'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }
}