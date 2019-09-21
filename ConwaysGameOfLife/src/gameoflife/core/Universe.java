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
    static final int DEFAULT_WIDTH = 500;
    
    /** default height ( number of rows ) of the universe */
    static final int DEFAULT_HEIGHT = 500;
    
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
     * Initialize the universe grid with random cells being alive.
     */
    private void initCells(){
        
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
     * Get a cell in the universe at given position.
     * 
     * @param row the row position in the universe
     * @param col the column position in the universe
     * @return The Cell in universe at (row,col)
     */
    public Cell getCellAt(int row, int col){
        return grid[row][col];
    }
    
    
}
