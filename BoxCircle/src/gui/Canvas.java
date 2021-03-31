package gui;

import java.awt.Graphics;
import javax.swing.JPanel;

import controller.CanvasController;


/*
 * This is for displaying shapes, and let the application drawing on the canvas
 */
public class Canvas extends JPanel {
	private static final long serialVersionUID = 1L;
	private CanvasController canvasController;

	// set the canvas controller
	public Canvas() {
		canvasController = new CanvasController();
		this.addMouseListener(canvasController);
	}	
	
	// let the canvas controller draw the graph on the canvas
	public void paintComponent(Graphics grahics) {
        super.paintComponent(grahics);
        canvasController.drawShape(grahics);
	}
}
