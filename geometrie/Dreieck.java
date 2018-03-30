package geometrie;
import java.awt.*;

public class Dreieck extends GObjekt
{
	public Dreieck()
	{
		super("Dreieck",3);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		eckpunkte[0]=new Punkt(0,0);
		eckpunkte[1]=new Punkt(1,0);
		eckpunkte[2]=new Punkt(0,1);
		seitenBerechnung();		                  
	}
	
	public Dreieck(Punkt... eck)
	{	
		super("Dreieck",3);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		for(int i=0;i<eck.length;i++)
			eckpunkte[i]=new Punkt(eck[i]);
		seitenBerechnung();
	}
	public Dreieck(Dreieck dr)
	{	
		super("Dreieck",3);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		for (int i=0;i<anzahl;i++)
			eckpunkte[i]=new Punkt (dr.eckpunkte[i]);
			seitenBerechnung();		
	}
	
	public void zeichnen(Graphics g, double koef)
	{
		eckpunkteZ=new Point[anzahl];
		masstab=koef;
		for(int i=0;i<eckpunkteZ.length;i++)
		{
			eckpunkteZ[i]=new Point((int)(eckpunkte[i].x*masstab),(int)(eckpunkte[i].y*masstab));
		}
		int mx[], my[];
		mx=new int[eckpunkteZ.length];
		my=new int[eckpunkteZ.length];
		for (int i=0;i<eckpunkteZ.length;i++)
		{
			mx[i]=eckpunkteZ[i].x;
			my[i]=eckpunkteZ[i].y;
		}
		g.drawPolygon(mx,my,eckpunkteZ.length);
	}	
	

	public boolean contains(int x,int y)
	{
		double gesflaeche;
		Punkt m=new Punkt(x,y);
        Punkt p1=new Punkt(eckpunkteZ[0].x,eckpunkteZ[0].y);
        Punkt p2=new Punkt(eckpunkteZ[1].x,eckpunkteZ[1].y);
        Punkt p3=new Punkt(eckpunkteZ[2].x,eckpunkteZ[2].y);
		Dreieck dr1 = new Dreieck(p1,p2,m),	dr2 = new Dreieck(p2,m,p3),	dr3 = new Dreieck(p3,p1,m);
		gesflaeche= dr1.flaeche()+dr2.flaeche()+dr3.flaeche();
		if (Math.abs(gesflaeche-Math.abs(flaeche(p1,p2,p3)))<Hilfe.EPSILON)
			return true;
		else return false;
	}
	
	public int kontrolle()
	{
		Punkt p1=eckpunkte[0],p2=eckpunkte[1],p3=eckpunkte[2];
		if(Hilfe.equal(p1.x,p2.x)&&Hilfe.equal(p1.y, p2.y))
			return 1;
		else if (Math.abs(flaeche(p1,p2,p3))<Hilfe.EPSILON)
			return 2;
		else
			return 0;
	}
	public void eingabe()
	{
		do
		{
			System.out.println("Eingabe fur Dreieck: ");
			for(int i=0;i<eckpunkte.length;i++)
			{
				System.out.println("Koordinagen fur Punkt "+(i+1));
				eckpunkte[i].eingabe();
			}
			if(kontrolle()>0)
				System.out.println("Falscher Punkt: "+kontrolle());
		}
		while(kontrolle()>0);
		seitenBerechnung();
	}
	public double umfang()
	{
		double u=seiten[0]+seiten[1]+seiten[2];
		return u;
	}
	public double flaeche()
	{
		double a=seiten[0],b=seiten[1],c=seiten[2];
		double p=(a+b+c)/2;
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}
	public static double flaeche(Punkt t1,Punkt t2,Punkt t3)
	{
		double m=t1.x*(t2.y-t3.y)+t2.x*(t3.y-t1.y)+t3.x*(t1.y-t2.y);
		return 0.5*m;
	}
	
	public String art()
	{
		String s;
		double a=seiten[0],b=seiten[1],c=seiten[2];
		if(Hilfe.equal(a, b)&&Hilfe.equal(b,c))
			s="Gleichseitig";
		else
			if(Hilfe.equal(a,b)||Hilfe.equal(b,c)||Hilfe.equal(a,c))
				s="Gleichschenklig";
			else
				s="Allgemein";
		if(Hilfe.equal(maxWinkel(),Math.PI/2))
			s=s+" rechtwinklig";
		else if(maxWinkel()<Math.PI/2)
			s=s+" spitzwinklig";
		else s=s+" stumpfwinklig";
		return s;
	}
	static double winkel(double a, double b, double c)
	{
		double wink=((b*b+c*c-a*a)/(2*b*c));
		double alfa=Math.acos(wink);
		return alfa;
	}
	double maxWinkel()
	{	
		double alfa=winkel(seiten[0],seiten[1],seiten[2]);
		double beta=winkel(seiten[1],seiten[2],seiten[0]);
		double gamma=winkel(seiten[2],seiten[0],seiten[1]);
		if(alfa<beta)
			if(beta<gamma)
				return gamma;
			else 
				return beta;
		else
			return alfa;
	}
	
	public String toString()
	{
		return "Dreieck mit: "+eckpunkte[0]+" - "+eckpunkte[1]+" - "+eckpunkte[2];
	}
	public void ausgabe()
	{
		System.out.println(toString());
		System.out.println("Umfang = "+umfang());
		System.out.println("Flaeche = "+flaeche());
		System.out.println("Art: "+art());
		
	}
	
	public static void main(String[] args)
	{	
		Dreieck d1,d2,d3,d4;
		d1=new Dreieck();
		Punkt[] punkte=new Punkt[3];
		punkte[0]=new Punkt(2,0);
		punkte[1]=new Punkt(3,0);
		punkte[2]=new Punkt(4,1);
		d2=new Dreieck(punkte);
		d3=new Dreieck();
		System.out.println("Eingabe fur Dreieck:");
		d3.eingabe();
		d4=new Dreieck(d3);
		System.out.println("Ausgabe fur Objekt 1");
		d1.ausgabe();
		System.out.println("Ausgabe fur Objekt 2");
		d2.ausgabe();
		System.out.println("Ausgabe fur Objekt 3");
		d3.ausgabe();
		System.out.println("Ausgabe fur Objekt 4");
		d4.ausgabe();
	}
}

