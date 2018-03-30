package geometrie;

import java.awt.*;

public class Rechteck extends GObjekt 
{

	protected double br,ho;
	protected int brZ,hoZ;
	
	public Rechteck()
	{
	super("Rechteck",1);
	eckpunkte=new Punkt[anzahl];
	seiten=new double[anzahl];
	eckpunkte[0]=new Punkt(0,0);
	br=1;
	ho=1;
	}
	
	public Rechteck(Punkt anfang, double brn, double hon)
	{
	super("Rechteck",1);
	eckpunkte=new Punkt[anzahl];
	eckpunkte[0]=anfang;
	br=brn;
	ho=hon;
	}

	public Rechteck(Rechteck s)
	{
	super("Rechteck",1);	
	eckpunkte=new Punkt[anzahl];
	eckpunkte[0]=new Punkt(s.eckpunkte[0]);
	br=s.br; ho=s.ho;
	}

	public void eingabe()
	{
	System.out.println("Eingabe fur Rechteck: ");
	System.out.println("Koordinaten fur Anfangspunkt: ");
	eckpunkte[0].eingabe();
	do
		{
		System.out.println("Breite = ");
		br=Hilfe.sc.nextDouble();
		System.out.println("Hoehe = ");
		ho=Hilfe.sc.nextDouble();
		if(kontrolle()>0)
			System.out.println("Falsche Werte "+kontrolle());
		}
	while(kontrolle()>0);	
	}
   
	public int kontrolle()
	{
	if(br<=0)
	   return 2;
   	else if(ho<=0)
	   return 1;
   	else 
	   return 0;
	}

	public double umfang()
	{
	return 2*br+2*ho;
	}
 
	public double flaeche()
	{
	double lice=br*ho;
   	return lice;
	}

	public String art()
	{
	String s="";
   	if(Hilfe.equal(br,ho))
	   s="Quadrat";
   	else
	   s="Rechteck";
   	return s;
	}

	public String toString()
	{
	return "Anfang: "+eckpunkte[0]+", breite="+br+", hoehe="+ho;
	}

	public void ausgabe()
	{
	toString();
   	System.out.println("Die Rechteck ist "+art()+" mit umfang "+umfang()+" und flaeche "+flaeche());
	}
	
	public void zeichnen(Graphics g, double koef)
	{
		eckpunkteZ=new Point[anzahl];
		masstab=koef;
		for(int i=0;i<eckpunkteZ.length;i++)
			{
			eckpunkteZ[i]=new Point((int)(eckpunkte[i].x*masstab),(int)(eckpunkte[i].y*masstab));
			}
		brZ=(int)(br*masstab);
		hoZ=(int)(ho*masstab);
		g.drawRect(eckpunkteZ[0].x, eckpunkteZ[0].y, brZ, hoZ);
	}


	public boolean contains(int x, int y) 
	{	
		if(x>eckpunkteZ[0].x && x<(eckpunkteZ[0].x+brZ))
			{
			if(y>eckpunkteZ[0].y && y<(eckpunkteZ[0].y+hoZ))
				return true;
			}
			else 
				return false;
		return false;
	}
	
	public static void main (String[] args)
	{
		Rechteck r1,r2,r3,r4;
		r1=new Rechteck();
		Punkt anfang = new Punkt(1,1);
		r2=new Rechteck(anfang,2,3);
		r3=new Rechteck();
		System.out.println("Eingabe fur Rechteck: ");
		r3.eingabe();
		r4=new Rechteck(r3);
		System.out.println("Ausgabe fur Objekt 1");
		r1.ausgabe();
		System.out.println("Ausgabe fur Objekt 2");
		r2.ausgabe();
		System.out.println("Ausgabe fur Objekt 3");
		r3.ausgabe();
		System.out.println("Ausgabe fur Objekt 4");
		r4.ausgabe();
	}
}

