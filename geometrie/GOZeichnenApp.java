package geometrie;
import java.applet.*;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GOZeichnenApp extends Applet
{
	private static final long serialVersionUID = 4231207367940612143L;
	static GObjekt[] objekte = new GObjekt[9];
	TextField textfeld;
	public void init()
	{
		this.addMouseListener(new Fenster());
		textfeld = new TextField("Objekt",20);
		this.add(textfeld);
		
		Punkt anf=new Punkt(1,0);
		objekte[0]=new Rechteck(anf,2,1.5);
		
		anf=new Punkt(4,0);
		objekte[1]=new Rechteck(anf,2.5,1.5);
		
		Punkt[] punkte=new Punkt[3];
		punkte[0]=new Punkt(1,1.5);
		punkte[1]=new Punkt(1,3);
		punkte[2]=new Punkt(0,3);
		objekte[2]=new Dreieck(punkte);		
		
		Punkt[] punkte1=new Punkt[3];
		punkte1[0]=new Punkt(3,1.5);
		punkte1[1]=new Punkt(3,3);
		punkte1[2]=new Punkt(2,3);
		objekte[3]=new Dreieck(punkte1);
		
		Punkt[] punkte2=new Punkt[4];
		punkte2[0]=new Punkt(4,1.5);
		punkte2[1]=new Punkt(5,3);
		punkte2[2]=new Punkt(5.5,3);
		punkte2[3]=new Punkt(6.5,1.5);
		objekte[4]=new Viereck(punkte2);
		
		anf=new Punkt(1,3);
		objekte[5]=new Ellipse(anf,1,1);
		anf=new Punkt(4.5,3);
		objekte[6]=new Ellipse(anf,1,1);
		anf=new Punkt(2,5);
		objekte[7]=new Ellipse(anf,2,0.5);
	}
	
	public void paint(Graphics g)
	{
		int i; double koef=30;
		double gesamtFlaeche=0;
		for(i=0;i<objekte.length;i++)
			gesamtFlaeche += objekte[i].flaeche();
		for(i=0;i<objekte.length;i++)
			objekte[i].zeichnen(g,koef);
		g.drawString("Anzahl = "+objekte.length,220,80);
		g.drawString("Geasmt Flaeche = "+gesamtFlaeche,220,100);
	}	

	public class Fenster implements MouseListener
	{


		
		public void mouseClicked(MouseEvent event) 
		{
			
			boolean click = false;
			int i = 0;			
			do
			{
				if(objekte[i] != null && objekte[i].contains(event.getX(),event.getY()))
				{
					click = true;
					textfeld.setText(objekte[i].name);
				}
				else
					i++;
			}
			while (!click && i<objekte.length);
			if(!click)
				textfeld.setText("Kein Objekt");
		}
		
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		
	}
}



