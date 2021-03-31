package controller;



import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/*
 *  This is the main controller, create and save the state information.
 *  This has the application's current state - either of BoxState, 
 *  CircleState, LineState, LineEndState, or defaultState.
 */


public class StateController extends Controller{

	// define state, current state and canvas for the class
	private static StateController state = null;
	private Controller currentState;
	private JPanel canvas;
	
	private StateController(JPanel canvas) {
		this.canvas = canvas;
		this.currentState = new Controller(this);
	}
	
	// let the application to get the state information
	public static StateController getState(JPanel canvas) {
		if(state == null) {
			state = new StateController(canvas);
		}
		return state;
	}
	
	// getter for the state information
	public static StateController getState() {
		return state;
	}
	
	// getter and setter for the current state
	public Controller getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(Controller currentState) {
		this.currentState = currentState;
	}

	public void boxClick() {
		currentState.boxClick(this);
	}
	
	public void circleClick() {
		currentState.circleClick(this);
	}
	
	public void undoClick() {
		currentState.undoClick(this);
	}
	public void redoClick() {
		currentState.redoClick(this);
	}
	
	public void canvasClick(MouseEvent event) {
		currentState.canvasClick(this,event);
	}

	public void paintCanvas(Graphics graphics) {
		currentState.paintCanvas(this, graphics);
	}
	
	public JPanel getCanvas() {
		return canvas;
	}
}
