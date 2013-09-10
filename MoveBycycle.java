import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/**

@author Firzan Ghulam

<applet code=MoveBycycle height=300 width=1300>
</applet>
*/
public class MoveBycycle extends Applet implements Runnable,ActionListener
{
	private int theta=90,theta1=270,theta2=180,theta3=360,dist=0;
	Thread t;
	int th=1;
	Button  b1,b2;
	int x=100;
	int x1=18,y1=18; //radius of a circle
	int x2,y2,x3,y3,x4,y4,x5,y5;
	 int xx=0;
	boolean flag=true ;
	public MoveBycycle()
	{
		b1=new Button("Break");
		b2=new Button("Accelarate");
		add(b1);
		add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		t=new Thread(this);	
		t.start();
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Break")){
			pause();		
		}
		else if(e.getActionCommand().equals("Accelarate")){
			resume();
		}
	
	}
	public void run()
	{
		while(flag)
		{			 
			try
			{
				if(theta==360){
					theta=90;
					theta1=270;
					theta2=180;
					theta3=360;
				}
				else{
					theta=theta+3;//line moving with the angle 3 deg
					theta1=theta1+3;
					theta2=theta2+3;
					theta3=theta3+3;
				}
				if(x>=1250){
					//flag=false;
					x=100;
					xx=0;
					dist=0;
				}
				else{
				 	x=x+1;
				 	xx=xx+1;
				}
				Thread.sleep(10);
			}catch(InterruptedException e){}
			repaint();
		}
		
	}
	public void paint(Graphics g)
	{
		
		x2=((int)(x1*Math.cos(theta*Math.PI/180)))-((int)(y1* Math.sin(theta*Math.PI/180)));
        y2=((int)(x1*Math.sin(theta*Math.PI/180)))+((int)(y1* Math.cos(theta*Math.PI/180)));
       
		x3=((int)(x1*Math.cos(theta1*Math.PI/180)))-((int)(y1* Math.sin(theta1*Math.PI/180)));
        y3=((int)(x1*Math.sin(theta1*Math.PI/180)))+((int)(y1* Math.cos(theta1*Math.PI/180)));
       
		x4=((int)(x1*Math.cos(theta2*Math.PI/180)))-((int)(y1* Math.sin(theta2*Math.PI/180)));
        y4=((int)(x1*Math.sin(theta2*Math.PI/180)))+((int)(y1* Math.cos(theta2*Math.PI/180)));
    
		x5=((int)(x1*Math.cos(theta3*Math.PI/180)))-((int)(y1* Math.sin(theta3*Math.PI/180)));
        y5=((int)(x1*Math.sin(theta3*Math.PI/180)))+((int)(y1* Math.cos(theta3*Math.PI/180)));
     	
		
		//g.drawLine(110,151,900,150);	//route line 
		g.drawRect(80,150,1250,5);//   or route line 
		g.setColor(Color.BLACK);
		g.fillRect(80,150,1300,5);
		//bycycle structure...
		g.drawOval(x,100,50,50);
		g.drawOval(x,100,49,49);
		g.drawOval(x,100,48,48);
		g.drawOval(x,100,47,47);
		g.drawOval(x+100,100,50,50);
		g.drawOval(x+100,100,49,49);
		g.drawOval(x+100,100,48,48);
		g.drawOval(x+100,100,47,47);
		g.drawLine(x+25,125,x+125,125);
		g.drawLine(170+xx,50,225+xx,125);
		g.drawLine(140+xx,80,185+xx,30);
		  
		g.setColor(Color.RED);
		g.drawLine(125+xx,125 ,125-y2+xx,125+x2);//spoke 1//tyre 1
		g.setColor(Color.RED);
		g.drawLine(125+xx,125,125-y3+xx,125+x3);//spoke 2//tyre 1

		g.setColor(Color.BLUE);	
		g.drawLine(125+xx,125,125-y4+xx,125+x4);//spoke 1//tyre 1
		g.setColor(Color.BLUE);
		g.drawLine(125+xx,125,125-y5+xx,125+x5);//spoke 2//tyre 1
			
		g.setColor(Color.RED);
		g.drawLine(225+xx,125 ,225-y2+xx,125+x2);//spoke 1//tyre 2
		g.setColor(Color.RED);
		g.drawLine(225+xx,125,225-y3+xx,125+x3);//spoke 2//tyre 2
	 	
		g.setColor(Color.BLUE);
		g.drawLine(225+xx,125,225-y4+xx,125+x4);//spoke 1//tyre 2
		g.setColor(Color.BLUE);
	  	g.drawLine(225+xx,125,225-y5+xx,125+x5);//spoke 2//tyre 2
		
		g.drawOval(xx+120,120,10,10);// small wheel for tyre 1
		g.setColor(Color.BLACK); 
		g.fillOval(xx+120,120,11,11);
		g.drawOval(xx+220,120,10,10);//small wheel for tyre 2
		g.setColor(Color.BLACK);
		g.fillOval(xx+220,120,11,11);
		g.setColor(Color.RED);
		g.drawString("Distance=>  "+String.valueOf(dist)+ " Meter",200,30);
		if(x%100==0){
			dist++;
		}
		
	}
		public void pause(){
			flag=false;
		}
		public void resume(){
			th=1;
			flag=true;
			t=new Thread(this);	
			System.out.println(th++);
			t.start();
		}
		
}
