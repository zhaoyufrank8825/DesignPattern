package controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

import composite.BoxShape;
import composite.Component;

/*
 * inherit the function from the controller super class
 * rewrite for circle click to reset the state information
 * if in the box state, and the canvas being clicked, draw the graph
 */
public class BoxController extends Controller {
	
	// change the cursor when in this state to cross hair
	public BoxController(StateController state) {
		state.getCanvas().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));		
	}

	public void boxClick(StateController state) {
	}

	// rewrite for circle click event, to set to circle state for future use
	public void circleClick(StateController state) {
		state.setCurrentState(new CircleController(state));
	}

	// if canvas click in this state, draw the graph
	public void canvasClick(StateController state, MouseEvent event) {
		state.getCanvas().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		state.setCurrentState(new Controller(state));
		Component boxShape = new BoxShape(event);
		boxShape.execute();
	}
}
