package composite;


import java.awt.Graphics;
import java.util.Iterator;
import java.util.Stack;

import composite.Component;

/*
 * This is the location to save all the shape information, using two stacks shapes and backup,
 * shapes for the drawing process, backup is used to do the undo and redo operation
 * create pop and push function for the stacks
 */

public class Composite extends Component {
	
	// define the attribute stackInstance, shapes, backup, graphics, and two final value
	private static Composite stackInstance = null;
	private Stack<Component> shapes;
	private Stack<Component> backup;
	private Graphics graphics = null;
	public final static String POP_UNDO = "U";
	public final static String POP_REDO = "R";

	public Composite(Graphics graphics) {
		this.graphics = graphics;
	}
	
	// when call the composite constructor, if two stacks are not created, 
	// create this two stacks in here
	private Composite() {
		if(shapes == null) {
			shapes = new Stack<Component>();			
		}
		if(backup == null) {
			backup = new Stack<Component>();
		}
	}

	// set the iterator for the stack
	public Iterator<Component> getIterator(){
		return this.shapes.iterator();
	}
	
	// set the getter function for the composite
	public static Composite getStack() {
		if(stackInstance == null) {
			stackInstance = new Composite();
		}
		return stackInstance;
	}
	
	public void push(Component boxShape) {
		shapes.push(boxShape);		
	}

	// pop function need consider the input,
	// one for undo and the other for redo
	public Component pop(String s) {
		Component bt = null;
		if(s == POP_UNDO) {
			if(!shapes.empty()) {
				bt = shapes.pop();
				backup.push(bt);	
			}
		}
		else if(s == POP_REDO) {
			if(!backup.empty()) {
				bt = backup.pop();
				shapes.push(bt);
			}
		}
		return bt;
	}
	
	// the composite iterate the shapes stack, and draw the graph
	// execute is used for draw the whole graph combine all the shape
	public void execute() {
		Composite stack = Composite.getStack();
		
		Iterator<Component> iterator = stack.getIterator();
		while(iterator.hasNext()) {
			Component shape = iterator.next().getResult();
			shape.draw(graphics);
		}
	}

	@Override
	// the draw function is used for every box, circle draw operation
	public void draw(Graphics graphics) {
		// TODO Auto-generated method stub
		
	}

}
