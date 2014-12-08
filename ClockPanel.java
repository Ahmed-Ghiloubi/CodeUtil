/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_ecole_pro;

/**
 *
 * @author Ahmed
 */

/**
 * A panel that draws a clock.
 */
import java.awt.Color; 
import java.awt.Container; 
import java.awt.FlowLayout; 
import java.awt.Font; 
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 



import javax.swing.UIManager; 
import javax.swing.UnsupportedLookAndFeelException; 


public class ClockPanel extends JPanel implements Runnable, WindowListener{ 

	Thread timer=null; 
	 
	String dateToDisplay; 
	 
	int hr; 
	Date d; 
	JLabel dateLabel=new JLabel();	 
	int hour; 
	 int minute; 
	 int second; 
	// String amPm="AM"; 
	  
	

	public void start() { 
		 if(timer == null) 
	    { 
	      timer = new Thread((Runnable) this); 
	      timer.start(); 
	    } 
	} 
	 
	public void stop() 
	{ 
	  timer = null; 
	} 

	ClockPanel() 
	{ 
		 
		this.setLayout(new FlowLayout()); 
		 
		dateLabel.setBackground(Color.GRAY); 
		dateLabel.setForeground(Color.BLUE); 
		dateLabel.setFont(new Font("Calibri",Font.PLAIN,56)); 
		 
		 this.add(dateLabel); 
		// this.setTitle("Clock "); 
		//this.pack(); 
	        //	this.setLocationRelativeTo(null); 
		
	} 
	public String getFormatedDate(Date d) 
	{ 
	String formatedDate=" "; 
	 hour = d.getHours(); 
	 minute = d.getMinutes(); 
	 second = d.getSeconds(); 
	// amPm=(hour<12)?"AM":"PM"; 
	 hr= hour; 
		 
	formatedDate=formatedDate.concat(padElement(hr, '0')); 
	formatedDate=formatedDate.concat(":"); 
	formatedDate=formatedDate.concat(padElement(minute, '0')); 
	formatedDate=formatedDate.concat(":"); 
	formatedDate=formatedDate.concat(padElement(second, '0')); 
	//formatedDate=formatedDate.concat(" "+ amPm); 
	return formatedDate;  
	} 
	 
	private String padElement(int expr, char padChar) 
	{ 
	  String result = ""; 
	  // I'm just padding 2 digit numbers 
	  if (expr < 10) result = result.concat(String.valueOf(padChar)); 
	  result = result.concat(String.valueOf(expr)); 
	  return(result); 
	} 
	 
	 
	public void run() { 
		 // Sleep in the timer thread... 
		  while (timer != null) { 
		    try {timer.sleep(10);} 
		catch (InterruptedException e){} 
		d=new  Date(); 
		dateToDisplay=getFormatedDate(d); 
		 dateLabel.setText(dateToDisplay); 
		} 
		timer = null; 
		 
	} 

	 
	public void windowActivated(WindowEvent arg0) { 
		// TODO Auto-generated method stub 
		 
	} 

	 public void windowClosed(WindowEvent arg0) { 
	 } 
	public void windowClosing(WindowEvent arg0) { 
		stop(); 
		//this.dispose(); 
		//System.exit(0); 
		 
	} 
	public void windowDeactivated(WindowEvent arg0) { 
	} 
	public void windowDeiconified(WindowEvent arg0) { 
	} 
	public void windowIconified(WindowEvent arg0) { 
	} 
	public void windowOpened(WindowEvent arg0) { 
	} 

}