package controller;


import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import command.RedoCommand;
import command.UndoCommand;
import composite.Composite;


/* The basic controller function is set here, combine function like box click, 
 * circle click, undo click, redo click, canvas click, and draw the shape
 * when other special controller inherit this class, not need rewrite the correct function
 */

public class  Controller{

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	// set the cursor to the default
	public Controller(StateController state) {
		state.getCanvas().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	// box click function, and save the information to state
	public void boxClick(StateController state) {
		state.setCurrentState(new BoxController(state));
	}

	// circle click function, and save the information to state
	public void circleClick(StateController state) {
		state.setCurrentState(new CircleController(state));
	}

	// canvas click function, not implement in here
	public void canvasClick(StateController state, MouseEvent event) {

	}
	
	// undo click function, call the undo Command to do action
	public void undoClick(StateController state) {
		state.setCurrentState(new Controller(state));
		new UndoCommand().execute();
	}
	
	// redo click function, call the redo Command to do action
	public void redoClick(StateController state) {
		state.setCurrentState(new Controller(state));
		new RedoCommand().execute();
	}

	// let the composite to draw the graph
	public void paintCanvas(StateController state, Graphics g) {
		Composite composite = new Composite(g);
		composite.execute();
	}
}
