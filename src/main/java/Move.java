import java.util.function.Function;

public enum Move {
    HORIZONTALLR(Move::keepValue, Move::increment),
    HORIZONTALRL(Move::keepValue, Move::decrement),
    VERTICALUD(Move::increment, Move::keepValue),
    VERTICALDU(Move::decrement, Move::keepValue),
    DIAGONALLRD(Move::increment, Move::increment),
    DIAGONALRLD(Move::increment, Move::decrement),
    DIAGONALLRU(Move::decrement, Move::increment),
    DIAGONALRLU(Move::decrement, Move::decrement);

    private Function<Integer, Integer> horizontal;
    private Function<Integer, Integer> vertical;

    Move(Function<Integer, Integer> horizontal, Function<Integer, Integer> vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    public  int horizontalMove(int k) {
        return this.horizontal.apply(k);
    }

    public int verticalMove(int l) {
        return this.vertical.apply(l);
    }
    
    static int keepValue(int x) {
        return x;
    }
    
    static int increment(int x) {
        return x + 1;
    }

    static int decrement(int x) {
        return x - 1;
    }
}
