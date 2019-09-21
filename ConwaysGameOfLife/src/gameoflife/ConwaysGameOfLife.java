package gameoflife;

import gameoflife.ui.MainScreenFrame;

/**
 * This is the main driver class of the Conway's Game of Life simulation that
 * creates the main GUI screen and display it to user for interaction.
 * 
 * @author
 */
public class ConwaysGameOfLife {
 
    public static void main(String[] args){
        // instantiate the game window
        MainScreenFrame gameUI = new MainScreenFrame();
        // setup the size of game window
        gameUI.setSize(800,700);
        // position the window at center of user screen 
        gameUI.setLocationRelativeTo(null);
        // display the window
        gameUI.setVisible(true);
    }
}
