package controller;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/*
 *  This is a action listener for the button clicks on the canvas.
 *  call the canvas click function to draw the graph
 */

public class CanvasController implements MouseListener {
	
	// when mouse is pressed on the canvas, call the canvas click function to draw
	public void mousePressed(MouseEvent event) {
		StateController state = StateController.getState();
		if(state != null ) {
			state.canvasClick(event);
			event.getComponent().repaint();
		}
		
	}
	
	// draw the graph
	public void drawShape(Graphics graphics) {
		StateController state = StateController.getState();
		if(state !=null) {
			state.paintCanvas(graphics);	
		}
	}
	
	@Override
	public void mouseClicked(java.awt.event.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
}