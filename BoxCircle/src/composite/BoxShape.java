package composite;


import java.awt.Graphics;
import java.awt.event.MouseEvent;

/*
 * Box detail information is store in this class, such as position and how to draw the box
 * create box shape when the canvas is clicked, and get the click location
 */

public class BoxShape extends Component {
	
	private MouseEvent clickEvent; 
	private int x,y;
	
	// mouse click on the canvas, save the information
	public BoxShape(MouseEvent click) {
		this.clickEvent = click;
		Composite.getStack().push(this);
	}
	
	// build the box constructor using x, y location
	public BoxShape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// get the x, y location and save to box constructor
	public void execute() {
		int x = clickEvent.getX();
		int y = clickEvent.getY();
		result = new BoxShape(x,y);
	}
	
	// draw the box with detail information
	public void draw(Graphics graphics) {
		graphics.drawRect(x, y, 50, 50);
	}
}
