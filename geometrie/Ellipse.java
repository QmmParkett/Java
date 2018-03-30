package geometrie;

import java.awt.*;

public class Ellipse extends GObjekt
{
	protected double a,b;
	protected int aZ,bZ;
	
	public Ellipse()
	{	
		super("Ellipse",1);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		eckpunkte[0]=new Punkt(0,0);
		a=1;
		b=1;
	}
	
	public Ellipse(Punkt anfang,double an,double bn)
	{	
		super("Ellipse",1);
		eckpunkte=new Punkt[anzahl];
		eckpunkte[0]=anfang;
		a=an;
		b=bn;
	}
	
	public Ellipse(Ellipse e)
	{	
		super("Ellipse",1);
		eckpunkte=new Punkt[anzahl];
		eckpunkte[0]=new Punkt(e.eckpunkte[0]);
		a=e.a; b=e.b;
	}
	
	public int kontrolle()
	{
		   if(a<=0)
			   return 2;
		   else if(b<=0)
			   return 1;
		   else 
			   return 0;
	}
	
	public void eingabe()
	{
			System.out.println("Eingabe fur Ellipse: ");
			System.out.println("Koordinaten fur Anfangspunkt: ");
			eckpunkte[0].eingabe();
			do
			{
				System.out.println("Halbachse a = ");
				a=Hilfe.sc.nextDouble();
				System.out.println("Halbachse b = ");
				b=Hilfe.sc.nextDouble();
				if(kontrolle()>0)
					System.out.println("Falsche Werte "+kontrolle());
			}
			while(kontrolle()>0);
	}
	
	public double umfang()
	{
		double abs=Math.abs(3*(a+b)-Math.sqrt((3*a+b)*(a+3*b)));
		double umfang=Math.PI*abs;
		return umfang;
	}
	
	public double flaeche()
	{
		double fl=Math.PI*a*b;
		return fl;
	}
	
	public String art()
	{
		String s="";
		if(Hilfe.equal(a,b))
		   s="Kreis";
		else
		   s="Ellipse";
		return s;
	}
	
	public String toString()
	{
		return "Anfang: "+eckpunkte[0]+", Halbachse a= "+a+", Halbachse b= "+b;
	}
	  
	public void ausgabe()
	{
		   toString();
		   System.out.println("Die Ellipse ist "+art()+" mit Umfang "+umfang()+" und Flaeche"+flaeche());
	}
	
	public void zeichnen(Graphics g, double koef)
	{
		eckpunkteZ=new Point[anzahl];
		masstab=koef;
		for(int i=0;i<eckpunkteZ.length;i++)
			{
			eckpunkteZ[i]=new Point((int)(eckpunkte[i].x*masstab),(int)(eckpunkte[i].y*masstab));
			}
		aZ=(int)(a*masstab);
		bZ=(int)(b*masstab);
		g.drawArc(eckpunkteZ[0].x,eckpunkteZ[0].y,2*aZ,2*bZ,0,360);
	}
	
	
	public boolean contains(int x,int y)
	{	
		double p,yu,yo;
		int b2=bZ*bZ;
		int a2=aZ*aZ;
		int xC=x-(eckpunkteZ[0].x+aZ);
		p=(Math.sqrt((b2*(a2-(xC*xC)))))/aZ;
		yu=eckpunkteZ[0].y+bZ-p;
		yo=eckpunkteZ[0].y+bZ+p;
		if (y>=yu&&y<yo)
			return true;	
		return false;
	}


	public static void main (String[] args)
	{
		Ellipse e1,e2,e3,e4;
		e1=new Ellipse();
		Punkt anfang = new Punkt(1,1);
		e2=new Ellipse(anfang,2.2,3.3);
		e3=new Ellipse();
		System.out.println("Eingabe fur Rechteck: ");
		e3.eingabe();
		e4=new Ellipse(e3);
		System.out.println("Ausgabe fur Objekt 1");
		e1.ausgabe();
		System.out.println("Ausgabe fur Objekt 2");
		e2.ausgabe();
		System.out.println("Ausgabe fur Objekt 3");
		e3.ausgabe();
		System.out.println("Ausgabe fur Objekt 4");
		e4.ausgabe();
	}
}

