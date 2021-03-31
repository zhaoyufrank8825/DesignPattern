package command;

import composite.Composite;

/*
 * undo concrete command class to do the undo operation
 */
public class UndoCommand implements Command {

	public UndoCommand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	// undo operation is popping from the related stack,
	// let the composite to pop from shapes and push to backup
	// finally the composite draw the new shapes stack
	public void execute() {
		// TODO Auto-generated method stub
		Composite shapes = Composite.getStack();
		shapes.pop(Composite.POP_UNDO);
	}

}
