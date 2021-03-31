package command;

import composite.Composite;


/*
 * redo concrete command class to do the redo operation
 */
public class RedoCommand implements Command {
	
	public RedoCommand() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	// redo operation is popping from the related stack,
	// let the composite to pop from backup and push to shapes
	// finally the composite draw the new shapes stack
	public void execute() {
		// TODO Auto-generated method stub
		Composite shapes = Composite.getStack();
		shapes.pop(Composite.POP_REDO);
	}
}
