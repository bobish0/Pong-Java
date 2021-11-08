
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;		// import flow of time
import java.awt.event.ActionListener;    //  import object movement
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class AwesomePong extends JComponent implements ActionListener, MouseMotionListener {

// start position for the ball.
private int bollx = 400;
private int bolly = 500;

//start speed and direction of the ball
private int bollyfart = 4;
private int bollxfart = 4;

private int musx;
public static void main (String[] args){

	JFrame fonster = new JFrame ("Pong av Kristian");
	AwesomePong spel = new AwesomePong();
	fonster.add(spel); // connection JFrame with main class extentions through object "spel" , JComponent, ActionListnerer,MouseMotionListener and others, etc.
	fonster.pack();
	fonster.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // close window when exit.
	fonster.setVisible(true);  // so it visible.
	fonster.addMouseMotionListener(spel);
// so you can see the window.
	//fonster.setSize(300,400); ALTERNATIVE way to show window within main instead of separate method.

  //boilerplate code for repetition

Timer tid = new Timer(5, spel);  // "5" is in miliseconds.
tid.start();



	}


public Dimension getPreferredSize() {   //java.awt.*; must be activated for this .  // method for JFrame-size.

	return new Dimension(2000,1000);
	}


protected void paintComponent(Graphics r) {

	r.setColor(new Color(46,93,88));  // background
	r.fillRect(0, 0, 2000, 1000);

	r.setColor(Color.GREEN);
	r.fill3DRect(musx, 800, 300, 40, true);  // black by default.

	r.setColor(Color.YELLOW);
	r.fillOval(bollx, bolly, 80, 80);



	}

// mandatory for MouseMotionListener
	public void mouseDragged(MouseEvent h) { //when moving mouse and holding down a button

	}

// mandatory for MouseMotionListener
	public void mouseMoved(MouseEvent h) { // whenever the mouse moves in the window

	musx = h.getX() - 150;
	repaint();

	}


// mandatory for ActionEvent
public void actionPerformed(ActionEvent h) {  // creates flow of time in java

		bollx = bollx + bollxfart;   // movement
		bolly = bolly + bollyfart;


		if ( bollx >= musx && bollx <= musx + 150 && bolly >= 720){
		bollyfart = -4;
		}


		if (bolly >= 1000){
		bollyfart = -4;
		}

if (bollx >= 1840)  {

	bollxfart = -4;
	}

	if ( bollx < 0){

		bollxfart = 4;

		}


	if ( bolly < 0){

		bollyfart = 4;

		}


	// to only bounce on  the rectangle



repaint();

	}




}