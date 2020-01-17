import org.junit.Assert;
import org.junit.Test;

public class WordSearchShould {

    @Test
    public void find_words_Horizontal_Left_to_Right(){
        String[] words = new String[] {"bca", "dr"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'x', 'd', 'r'},
                {'l', 'c', 'c'}
        };

        char[][] expected = new char[][] {
                {'A', 'B', 'C'},
                {'x', 'D', 'R'},
                {'l', 'c', 'c'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }



    @Test
    public void find_words_Horizontal_Right_to_Left(){
        String[] words = new String[] {"fxd", "zb"};

        char[][] board = new char[][] {
                {'j', 'b', 'z'},
                {'d', 'x', 'f'},
                {'t', 't', 't'}
        };

        char[][] expected = new char[][] {
                {'j', 'B', 'Z'},
                {'D', 'X', 'F'},
                {'t', 't', 't'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }

    @Test
    public void find_words_vertically_up_to_down(){
        String[] words = new String[] {"jdz", "uz"};

        char[][] board = new char[][] {
                {'j', 'b', 'z'},
                {'d', 'x', 'f'},
                {'z', 'o', 'u'}
        };

        char[][] expected = new char[][] {
                {'J', 'b', 'Z'},
                {'D', 'x', 'f'},
                {'Z', 'o', 'U'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }

    @Test
    public void find_words_vertically_reverse(){
        String[] words = new String[] {"ufz", "zuf"};

        char[][] board = new char[][] {
                {'j', 'b', 'z'},
                {'d', 'x', 'f'},
                {'z', 'o', 'u'}
        };

        char[][] expected = new char[][] {
                {'j', 'b', 'Z'},
                {'d', 'x', 'F'},
                {'z', 'o', 'U'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }
    @Test
    public void find_words_Diagonal_Left_to_Right_Down(){
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
    public void find_words_Diagonal_Right_to_Left_Down(){
        String[] words = new String[] {"cdl", "fca"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'd', 'f'},
                {'l', 'c', 'c'}
        };

        char[][] expected = new char[][] {
                {'A', 'b', 'C'},
                {'d', 'D', 'F'},
                {'L', 'C', 'c'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }

    @Test
    public void find_words_Diagonal_Right_to_Left_Up(){
        String[] words = new String[] {"xda", "lc"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'd', 'f'},
                {'l', 'a', 'x'}
        };

        char[][] expected = new char[][] {
                {'A', 'b', 'C'},
                {'d', 'D', 'f'},
                {'L', 'a', 'X'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }


    @Test
    public void find_words_Diagonal_Left_to_Rigth_Up(){
        String[] words = new String[] {"dcl", "afa"};

        char[][] board = new char[][] {
                {'a', 'b', 'c'},
                {'d', 'd', 'f'},
                {'l', 'a', 'x'}
        };

        char[][] expected = new char[][] {
                {'A', 'b', 'C'},
                {'d', 'D', 'F'},
                {'L', 'A', 'x'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }


    @Test
    public void find_words_In_Every_Direction(){
        String[] words = new String[] {"h", "hr", "hbm", "orb", "rohd","mbnfdm"};

        char[][] board = new char[][] {
                {'r', 'h', 'r', 'u', 'm'},
                {'d', 'd', 'b', 'y', 'b'},
                {'l', 'a', 'l', 'm', 'n'},
                {'t', 'v', 's', 'r', 'f'},
                {'y', 's', 'o', 'k', 'd'}
        };

        char[][] expected = new char[][] {
                {'R', 'H', 'R', 'u', 'm'},
                {'D', 'd', 'B', 'y', 'b'},
                {'l', 'a', 'l', 'M', 'n'},
                {'t', 'v', 's', 'R', 'f'},
                {'y', 's', 'O', 'k', 'd'}
        };

        WordSearch result = new WordSearch(words, board);

        Assert.assertArrayEquals(expected, result.wordSearch());
    }


}