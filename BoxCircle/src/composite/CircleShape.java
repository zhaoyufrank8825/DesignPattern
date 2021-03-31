package composite;


import java.awt.Graphics;
import java.awt.event.MouseEvent;

/*
 * Circle detail information is store in this class, such as position and how to draw the box
 * create circle shape when the canvas is clicked, and get the click location
 */
public class CircleShape extends Component {
	
	private MouseEvent click;
	private int x,y;
	
	// mouse click on the canvas, save the information
	public CircleShape(MouseEvent e) {
		this.click = e;
		Composite.getStack().push(this);
	}
	
	// build the circle constructor using x, y location
	public CircleShape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// get the x, y location and save to box constructor
	public void execute() {
		int x = click.getX();
		int y = click.getY();
		result = new CircleShape(x,y);
	}
	
	// draw the box with detail information
	public void draw(Graphics g) {
		g.drawOval(x,y,50,50);
	}

}
