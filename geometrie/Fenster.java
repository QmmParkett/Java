package geometrie;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class GOZeichnenApp extends Applet{
	static GObjekt[] objekte=new GObjekt[9];
	static TextField textfield;
	public static Object textfield;
	public static Object textfield;
	public static Object textfield;
	public void init(){
		Punkt anf=new Punkt(1,5.5);
		objekte[0]= new Rechteck(anf,2,1.5);
		anf= new Punkt (4,5.5);
		objekte[1]=new Rechteck(anf,2.5,1.5);
		Punkt[] p= new Punkt[3];
		p[0]=new Punkt (1,5.5);
		p[1]= new Punkt (1,4);
		p[2]=new Punkt (0,4);
		objekte[2]= new Dreieck(p);
		p[0]=new Punkt (3,5.5);
		p[1]= new Punkt (3,4);
		p[2]=new Punkt (2,4);
		objekte[3]= new Dreieck(p);
		Punkt[] p1= new Punkt[4];
		p1[0]=new Punkt (4,5.5);
		p1[1]= new Punkt (6.5,5.5);
		p1[2]=new Punkt (5.5,4);
		p1[3]=new Punkt (5,4);
		objekte[4]= new Viereck(p1);
		anf=new Punkt(0.5,2);
		objekte[5]=new Ellipse(anf,1,1);
		anf=new Punkt(3,2);
		objekte[6]= new Rechteck(anf,1,2);
		anf=new Punkt(4,2);
		objekte[7]=new Ellipse(anf,1,1);
		anf=new Punkt(1.5,0);
		objekte[8]=new Ellipse(anf,2,1);
		this.addMouseListener(new Fenster());
		textfield=new TextField("Objekt",20);
		this.add(textfield);
	}
	public void paint(Graphics g){
		int i;
		double koeff=30;
		double gesamtFlaeche=0;
		for(i=0;i<objekte.length;i++){
			gesamtFlaeche+=objekte[i].flaeche();
		}
		for(i=0;i<objekte.length;i++){
			objekte[i].zeichnen(g, koeff);
		}
		g.drawString("Anzahl= "+objekte.length,220, 80);
		g.drawString("Gesamtflaeche= "+gesamtFlaeche,220, 100);
	}
}
class Fenster implements MouseListener {
	public void mouseClicked(MouseEvent event) {
		boolean click=false;
		int i=0;
		do{
			if(GOZeichnenApp.objekte[i]!=null&&GOZeichnenApp.objekte[i].contains(event.getX(),event.getY())){
				click=true;
				GOZeichnenApp.textfield.setText(GOZeichnenApp.objekte[i].name);
			}
			else i++;
		}while(!click&&i<GOZeichnenApp.objekte.length);
		if(!click) GOZeichnenApp.textfield.setText("Kein Objekt");
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}

}
		
		
		
	


