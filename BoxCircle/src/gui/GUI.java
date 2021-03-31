package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.StateController;

/*
 * Main GUI inherit the JFrame, create four buttons, and one drawing area named canvas.
 * Connected to four buttons controller, using event handler.
 * Set the canvas to access in the future, because we need drawing the shape to the canvas.
 */
public class GUI extends javax.swing.JFrame{

	private static final long serialVersionUID = 1L;
	private JButton btnBox, btnCircle, btnUndo, btnRedo;  
    private final JPanel canvas;   
    

    public GUI(String title)
    {
    	// design the main Frame, set the layout style
    	super(title);
    	setSize(600, 400);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
        
		// design the four buttons, such as location, size and name
		btnBox = new JButton("Box");
		btnBox.setBounds(10, 30, 90, 25);
	    getContentPane().add(btnBox);
	      
	    btnCircle = new JButton("Circle");
	    btnCircle.setBounds(10, 80, 90, 25);
	    getContentPane().add(btnCircle);
	    
	    btnUndo = new JButton("Undo");
	    btnUndo.setBounds(10, 130, 90, 25);
	    getContentPane().add(btnUndo);
	    
	    btnRedo = new JButton("Redo");
	    btnRedo.setBounds(10, 180, 90, 25);
	    getContentPane().add(btnRedo);
	      
	    canvas = new Canvas();	
        canvas.setBackground(Color.WHITE);
        canvas.setBounds(110, 10, 465, 340);
		getContentPane().add(canvas);
	      
	    /* register controller as listener for four buttons,
	     * when button clicked, let the state save the click information
		*/
		btnBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateController state = StateController.getState(getCanvasPanel());
				state.boxClick();
				
				getCanvasPanel().revalidate();
				getCanvasPanel().repaint();
			}
		});
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateController state = StateController.getState(getCanvasPanel());
				state.circleClick();
				
				getCanvasPanel().revalidate();
				getCanvasPanel().repaint();
			}
		});
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateController state = StateController.getState(getCanvasPanel());
				state.undoClick();
				
				getCanvasPanel().revalidate();
				getCanvasPanel().repaint();
			}
		});
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StateController state = StateController.getState(getCanvasPanel());
				state.redoClick();
				
				getCanvasPanel().revalidate();
				getCanvasPanel().repaint();
			}
		});

        setWindowProperties();
        pack();   
    }
    
    // let the application to draw on the canvas in the future
    public JPanel getCanvasPanel() 
    {
    	return canvas;
    }
  
    // basic GUI setting up, like location, size and visible
	private void setWindowProperties(){
        setPreferredSize(new Dimension(600, 400)); 
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

