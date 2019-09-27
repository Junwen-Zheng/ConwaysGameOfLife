package gameoflife.core;

/**
 * This class model a cell in the universe and is either dead or 
 * live.
 * 
 * @author
 */
public class Cell {
    
    /** constants for the state of each cell */
    public enum State { LIVE, DEAD };
    
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
    
    /**
     * Get the state of the cell.
     * @return the state of this cell
     */
    public State getState(){
        return state;
    }
    
    /**
     * Set the state of this cell.
     * 
     * @param state the new State of this cell
     */
    public void setState(State state){
        this.state = state;
    }
    
    /**
     * Check whether this cell is alive or not.
     * 
     * @return true if cell is alive, otherwise false
     */
    public boolean isAlive(){
        return state == State.LIVE;
    }
    
    /**
     * Check whether this cell is dead or not.
     * 
     * @return true if cell is dead, otherwise false
     */
    public boolean isDead(){
        return state == State.DEAD;
    }
}
