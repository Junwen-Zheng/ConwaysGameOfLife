package gameoflife.core;

/**
 * This class model a cell in the universe and is either dead or 
 * live.
 * 
 * @author
 */
public class Cell {
    
    /** constants for the state of each cell */
    enum State { LIVE, DEAD };
    
    /** the state of this cell */
    private State state;
    
    /**
     * Class constructor that creates a new Cell with given state.
     * 
     * @param state the state of the new cell
     */
    public Cell(State state){
        this.state = state;
    }
    
    public boolean isAlive(){
        return state == State.LIVE;
    }
    
    public boolean isDead(){
        return state == State.DEAD;
    }
}