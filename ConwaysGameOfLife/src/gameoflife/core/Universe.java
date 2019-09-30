package gameoflife.core;

import java.util.Random;

/**
 * This class model the universe of the game of life game that contains
 * a 2d grid of cells and has methods for evolution.
 * 
 * @author
 */
public class Universe {
    
    /** default width (number of columns) of the universe */
    static final int DEFAULT_WIDTH = 70;
    
    /** default height ( number of rows ) of the universe */
    static final int DEFAULT_HEIGHT = 70;
    
    /** 2d array to store the cells */
    private Cell[][] grid;

    Random rand = new Random();
    
    /**
     * Default constructor that creates a new Universe with 
     * default width and height
     */
    public Universe() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Class constructor that creates a new Universe of given size.
     * 
     * @param width the width/columns of the universe
     * @param height the height/rows of the universe
     */
    public Universe(int width, int height) {
        grid = new Cell[height][width];
        initCells();
    }
    
    /**
     * Initialize the universe grid with random cells being alive.
     */
    private void initCells(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = new Cell(Cell.State.DEAD);
            }
        }
    }
    
    /**
     * Set the size of the universe.
     * 
     * @param width the width of the size
     * @param height the height of the size
     */
    public void setSize(int width, int height){
        grid = new Cell[height][width];
        initCells();
    }
    
    /**
     * Set the state of a cell in the universe at given position.
     * 
     * @param row the row position in the universe
     * @param col the column position in the universe
     * @param state the new State of the cell
     */
    public void set(int row, int col, Cell.State state){
        grid[row][col].setState(state);
    }
    
    /**
     * Get the cell in the universe at given position.
     * 
     * @param row the row position in the universe
     * @param col the column position in the universe
     * @return the Cell in the universe at given position
     */
    public Cell get(int row, int col){
        return grid[row][col];
    }
    
    /**
     * Get the width (number of columns) of the universe grid
     * @return the width of the universe
     */
    public int getWidth(){
        return grid[0].length;
    }
    
    /**
     * Get the height (number of rows) of the universe grid
     * @return the height of the universe
     */
    public int getHeight(){
        return grid.length;
    }       
    
    /**
     * This method generates the next universe from the current state based on each
     * cell state and following the below rules.
     * 
     * 1. Any live cell with fewer than two live neighbours dies
     * 2. Any live cell with more than three live neighbours dies
     * 3. Any live cell with two or three live neighbours lives, unchanged, to the next generation.
     * 4. Any dead cell with exactly three live neighbours will come to life
     * 
     * @return The Universe generated for next generation.
     */
    public Universe evolve(){
        Universe nextUniv = new Universe(this.getWidth(), this.getHeight());
        for(int row = 0; row < getHeight(); row++){
            for(int col = 0; col < getWidth(); col++){
                Cell cell = this.get(row, col);
                nextUniv.set(row, col, cell.getState());
                int aliveNeighborCount = countLiveNeighborsOfCellAt(row, col);
                if(cell.isAlive()){
                    if((aliveNeighborCount < 2) || (aliveNeighborCount > 3)) {
                        nextUniv.set(row, col, Cell.State.DEAD);
                    }
                }
                else{
                    if(aliveNeighborCount == 3){
                        nextUniv.set(row, col, Cell.State.LIVE);
                    }
                }
            }
        }
        return nextUniv;
    }
    
    /**
     * Check whether a given position is a valid cell position in the
     * universe.
     * 
     * @param row the cell row position
     * @param col the cell column position
     * @return true if position is valid, else false
     */
    private boolean isValidPosition(int row, int col){
        return (row >= 0) && (row < getHeight()) && (col >= 0) && (col < getWidth());
    }
    
    /**
     * Count the number of live cells in the neighbour hood of a cell with given 
     * position.
     * 
     * @param row the row of the cell position
     * @param col the column of the cell position
     * @return the count of live neighbours of given cell
     */
    private int countLiveNeighborsOfCellAt(int row, int col){
        int aliveCount = 0;
        for(int dx = -1; dx <= 1; dx++){
            for(int dy = -1; dy <= 1; dy++){
                if(!((dx == 0) && (dy == 0))){
                    int nrow = row+dy;
                    int ncol = col+dx;
                    if(isValidPosition(nrow, ncol) && grid[nrow][ncol].isAlive()){
                        aliveCount++;
                    }
                }                
            }
        }
        return aliveCount;
    }
}
