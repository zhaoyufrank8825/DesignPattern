package composite;

import java.awt.Graphics;

/*
 * Super class define two abstract function to implement in sub class
 * provide basic attribute for later
 */

public abstract class Component {
	
	public Component() {
		super();
		// TODO Auto-generated constructor stub
	}

	//stores the result of the command execution
	protected Component result;		
	
	// define two abstract function for inheritance
	public abstract void execute();
	public abstract void draw(Graphics graphics);
	
	// getter function to set the component result to use
	public Component getResult() {
		return result;
	}
}
