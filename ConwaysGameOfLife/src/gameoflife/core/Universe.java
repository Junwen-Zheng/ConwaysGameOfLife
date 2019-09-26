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
    
}
