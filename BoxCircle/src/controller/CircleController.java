package controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;


import composite.CircleShape;
import composite.Component;


/*
 * inherit the function from the controller super class
 * rewrite for box click to reset the state information
 * if in the circle state, and the canvas being clicked, draw the graph
 */
public class CircleController extends Controller {
	
	// change the cursor when in this state to cross hair
	public CircleController(StateController state) {
		state.getCanvas().setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
	}

	// rewrite for box click to reset the state information
	public void boxClick(StateController state) {
		state.setCurrentState(new BoxController(state));
	}

	public void circleClick(StateController state) {

	}

	// in the circle state, and the canvas being clicked, draw the graph
	public void canvasClick(StateController state, MouseEvent event) {
		state.setCurrentState(new Controller(state));
		Component circleShape = new CircleShape(event);
		circleShape.execute();
		
	}
}
