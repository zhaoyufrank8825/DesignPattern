package gui;


import java.awt.EventQueue;

/*
 * Main Class, call the GUI and show the GUI, set the application name here.
 */
public class MainClass {
    
	private void init() {
		GUI shapesGui = new GUI("Application_Zhao_Yu");
		shapesGui.setVisible(true);
	}

	public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
            	MainClass ApplicationObj = new MainClass();
            	ApplicationObj.init();
            }
        });
    }
}
