package gameoflife.ui;

import gameoflife.core.Cell;
import gameoflife.core.Universe;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is the GUI panel that displays the universe with grid cell marked as black
 * (live) or white (dead). This panel handles mouse click to set a cell in the universe
 * alive.
 * 
 * @author
 */
public class UniversePanel extends javax.swing.JPanel implements MouseListener {

    /** reference to Universe instance to display in this panel */
    private Universe universe;
    
    /**
     * Creates new form UniversePanel with given model class.
     * @param universe Reference to the Universe model class
     */
    public UniversePanel(Universe universe) {
        this.universe = universe;
        initComponents();
        this.addMouseListener(this);
    }

    /**
     * Set the universe.
     * @param universe the new Universe
     */
    public void setUniverse(Universe universe){
        this.universe = universe;
        repaint();
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
        
        double cellWidth = getWidth()/cols;
        double cellHeight = getHeight()/rows;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Cell cell = universe.get(i, j);
                g2d.setColor(Color.GRAY);
                if(cell.isAlive()){                    
                    g2d.fillRect((int)(j*cellWidth), (int)(i*cellHeight), (int)cellWidth, (int)cellHeight);
                }
                else{
                    g2d.drawRect((int)(j*cellWidth), (int)(i*cellHeight), (int)cellWidth, (int)cellHeight);
                }
            }
        }
        g2d.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
    }

    @Override
    public void mousePressed(MouseEvent e) {        
    }

    @Override
    public void mouseReleased(MouseEvent e) {    
        int mouseX = e.getX();
        int mouseY = e.getY();
        int cellWidth = getWidth()/universe.getWidth();
        int cellHeight = getHeight()/universe.getHeight();
        int row = mouseY/cellHeight;
        int col = mouseX/cellWidth;
        Cell cell = universe.get(row, col);
        if(cell.isAlive()){
            universe.set(row, col, Cell.State.DEAD);
        }
        else{
            universe.set(row, col, Cell.State.LIVE);
        }        
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {        
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }


    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
