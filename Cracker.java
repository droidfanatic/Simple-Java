import java.util.*;

class GameBoard{
	public
	    int pegCount;
	    int[] holes;

	    GameBoard(int holeNum){
	    	holes = new int[15];
	        pegCount = 14;
	        for (int i = 0; i < 15; i++)
	        	holes[i] = i == holeNum ? 0 : 1;
	    }

	    GameBoard(int pegCount, int[] cells){
	        this.pegCount = pegCount;
	        this.holes = cells.clone();
	    }
	
	    GameBoard move(Move m){
	        if (holes[m.from] == 1 && holes[m.over] == 1 && holes[m.to]   == 0) {
	        	GameBoard boardAfter = new GameBoard(pegCount-1, holes.clone());
	            boardAfter.holes[m.from] = 0;
	            boardAfter.holes[m.over] = 0;
	            boardAfter.holes[m.to] = 1;
	
	            return boardAfter;
	        }
	        return null;
	    }
}

class Move{
	public
	    int from; 
	    int over; 
	    int to; 
	
	    Move(int from, int over, int to){
	        this.from = from;
	        this.over = over;
	        this.to = to;
	    }
	
	    Move reversed(){ 
	    	return new Move(to, over, from); 
	    }
}

class StepList implements Iterable<Move>{
    public static final Move[] moves = {
        new Move(0, 1, 3), new Move(0, 2, 5), new Move(1, 3, 6), new Move(1, 4, 8), new Move(2, 4, 7), new Move(2, 5, 9),
        new Move(3, 6, 10), new Move(3, 7, 12), new Move(4, 7, 11), new Move(4, 8, 13), new Move(5, 8, 12), new Move(5, 9, 14),
        new Move(3, 4, 5), new Move(6, 7, 8), new Move(7, 8, 9), new Move(10, 11, 12), new Move(11, 12, 13), new Move(12, 13, 14)
    };

    @Override
    public StepIterator iterator(){
    	return new StepIterator(moves);
    }
}

class StepIterator implements Iterator<Move>{
	private
    	Move[] moves;
		Move reversed;
		int i;

    public StepIterator(Move[] moves){
        this.moves = moves;
        this.i = 0;
    }

    @Override
    public boolean hasNext() {
    	return i < moves.length || (i == moves.length && reversed != null);
    }
    
    @Override
    public Move next() { 
        if (reversed != null){
            Move result = reversed;
            reversed = null;
            return result;
        }

        Move m = moves[i++];
        reversed = m.reversed();

        return m;
    }
}

public class Cracker{
    static StepList steps(){
    	return new StepList();
    }

    static ArrayList<LinkedList<Move>> solve(GameBoard b){
        ArrayList<LinkedList<Move>> out = new ArrayList<LinkedList<Move>>();
        solve(b, out, 0);

        return out;
    }

    static LinkedList<Move> firstSolution(GameBoard b){
        ArrayList<LinkedList<Move>> out = new ArrayList<LinkedList<Move>>();
        solve(b, out, 1);

        if (out.size() == 0)
            return null;

        return out.get(0);
    }

    static void solve(GameBoard b, ArrayList<LinkedList<Move>> solutions, int count){
        if (b.pegCount == 1){
            solutions.add(new LinkedList<Move>());
            return;
        }

        for (Move m : steps()){
        	GameBoard boardAfter = b.move(m);
            if (boardAfter == null) continue;

            ArrayList<LinkedList<Move>> possibleSolutions = new ArrayList<LinkedList<Move>>();
            solve(boardAfter, possibleSolutions, count);

            for (LinkedList<Move> solution : possibleSolutions){
                solution.add(0, m);
                solutions.add(solution);

                if (solutions.size() == count)
                    return;
            }
        }
    }

    static void printBoard(GameBoard b){
        System.out.print("(" + b.pegCount + ", [");
        for (int i = 0; i < b.holes.length; i++)
            System.out.print(i < b.holes.length-1 ? b.holes[i] + ", " : b.holes[i] + "])");
        System.out.println();
    }

    static void show(GameBoard b){
        int[][] lines = { {4,0,0}, {3,1,2}, {2,3,5}, {1,6,9}, {0,10,14} };
        for (int[] l : lines){
            int spaces = l[0];
            int begin  = l[1];
            int end    = l[2];

            String space = new String();
            for (int i = 0; i < spaces; i++)
                space += " ";

            System.out.print(space);
            for (int i = begin; i <= end; i++)
                System.out.print(b.holes[i] == 0 ? ". " : "x ");

            System.out.println();
        }

        System.out.println();
    }

    static void replay(List<Move> moves, GameBoard b){
        show(b);
        for (Move m : moves){
            b = b.move(m);
            show(b);
        }
    }

    public static void main(String[] args){
    	for (int i = 0; i < 5; i++){
            System.out.println("=== " + i + " ===");
            GameBoard b = new GameBoard(i);
            replay(firstSolution(b), b);
            System.out.println();
        }
    }
}
