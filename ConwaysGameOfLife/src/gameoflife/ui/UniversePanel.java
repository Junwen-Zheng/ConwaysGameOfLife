package gameoflife.ui;

import gameoflife.core.Cell;
import gameoflife.core.Universe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * This is the GUI panel that displays the universe with grid cell marked as black
 * (live) or white (dead).
 * 
 * @author
 */
public class UniversePanel extends javax.swing.JPanel {

    /** reference to Universe instance to display in this panel */
    private Universe universe;
    
    /**
     * Creates new form UniversePanel with given model class.
     * @param universe Reference to the Universe model class
     */
    public UniversePanel(Universe universe) {
        this.universe = universe;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method paints all the universe cells in the panel
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.WHITE);
        
        g2d.fillRect(0, 0, getWidth(), getHeight());
        
        int rows = universe.getHeight();
        int cols = universe.getWidth();
        
        int cellWidth = getWidth()/cols;
        int cellHeight = getHeight()/rows;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Cell cell = universe.getCellAt(i, j);
                if(cell.isAlive()){
                    g2d.setColor(Color.black);
                    g2d.fillRect(j*cellWidth, i*cellHeight, cellWidth, cellHeight);
                }
            }
        }
        g2d.dispose();
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
