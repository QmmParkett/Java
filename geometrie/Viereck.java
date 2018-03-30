package geometrie;

import java.awt.Graphics;

public class Viereck extends GObjekt
{
	public Viereck()
	{	
		super("Viereck",4);
		eckpunkte = new Punkt[anzahl];
		seiten=new double[anzahl];
		eckpunkte[0]=new Punkt(0,0);
		eckpunkte[1]=new Punkt(1,0);
		eckpunkte[2]=new Punkt(1,1);
		eckpunkte[3]=new Punkt(0,1);
		seitenBerechnung();		
	}
	
	public Viereck(Punkt[] eck)
	{	
		super("Viereck",4);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		for(int i=0;i<eck.length;i++)
			eckpunkte[i]=new Punkt(eck[i]);
		seitenBerechnung();
	}
	
	public Viereck(Viereck v)
	{	
		super("Viereck",4);
		eckpunkte=new Punkt[anzahl];
		seiten=new double[anzahl];
		for (int i=0;i<anzahl;i++)
			eckpunkte[i]=new Punkt (v.eckpunkte[i]);
		seitenBerechnung();		
	}
	

	public int kontrolle()
	{
		Punkt p1=eckpunkte[0],p2=eckpunkte[1],p3=eckpunkte[2],p4=eckpunkte[3];
		if(Hilfe.equal(p1.x,p2.x)&&Hilfe.equal(p1.y,p2.y))
			return 1;
		else if(Math.abs(Dreieck.flaeche(p1,p2,p3))<Hilfe.EPSILON)
			return 2;
		else
		{
			double fla1,fla2,fla3;
			fla1=Dreieck.flaeche(p1,p2,p4);
			fla2=Dreieck.flaeche(p1,p3,p4);
			fla3=Dreieck.flaeche(p2,p3,p4);
		if((Hilfe.signum(fla1)!=Hilfe.signum(fla2))||(Hilfe.signum(fla1)!=Hilfe.signum(fla3))||(Hilfe.signum(fla2)!=Hilfe.signum(fla3)))
			return 3;
		else
			return 0;
		}
			
	}
	public void eingabe()
	{
		do
		{
			System.out.println("Eingabe fur Viereck: ");
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
		double u=seiten[0]+seiten[1]+seiten[2]+seiten[3];
		
		return u;
	}
	
	public double flaeche()
	{
		double a=seiten[0],b=seiten[1],c=seiten[2],d=seiten[3];
		double seiten1=Gerade.abstand(eckpunkte[1],eckpunkte[3]);
		double p=(a+b+seiten1)/2;
		double z=(c+d+seiten1)/2;
		double resultat=(Math.sqrt(p*(p-1)*(p-b)*(p-seiten1)))+Math.sqrt(z*(z-1)*(z-b)*(z-seiten1));
		return resultat;
	}
	public String art(){
		String s="";
		Punkt a1=eckpunkte[0],b2=eckpunkte[1],c3=eckpunkte[2],d4=eckpunkte[3];
		double a=seiten[0],b=seiten[1],c=seiten[2],d=seiten[3];
		if(Gerade.koeffizient(a1, b2)==Gerade.koeffizient(c3,d4)&&Gerade.koeffizient(a1, c3)==Gerade.koeffizient(b2,d4))
				s="Paralilitaet";
		else if(Gerade.koeffizient(a1, b2)==Gerade.koeffizient(c3,d4)||Gerade.koeffizient(a1, c3)==Gerade.koeffizient(b2,d4))
		{
			if(Hilfe.equal(b, d)||Hilfe.equal(a,c))
				s="Trapez";
		}
		else s="Gewoenliches";
		return s;
	}
	
	public String toString()
	{
		return "Dreieck mit:"+eckpunkte[0]+"-"+eckpunkte[1]+"-"+eckpunkte[2]+"-"+eckpunkte[3];
	}
	public void ausgabe()
	{
		toString();
		System.out.println("Die Art der Dreiecke ist: "+art());
		System.out.println("Die Flaeche ist "+flaeche(/*eckpunkte[0],eckpunkte[1],eckpunkte[2],eckpunkte[3] za drugata funkciq*/));
		System.out.println("Die Umfang ist "+umfang());
		
	}
	
	public static void main(String[] args)
	{
		Viereck v1,v2,v3,v4;
		v1=new Viereck();
		Punkt[] punkte=new Punkt[4];
		punkte[0]=new Punkt(0,0);
		punkte[1]=new Punkt(3,0);
		punkte[2]=new Punkt(2,1);
		punkte[3]=new Punkt(1,1);
		v2=new Viereck(punkte);
		v3=new Viereck();
		System.out.println("Eingabe fur Viereck:");
		v3.eingabe();
		v4=new Viereck(v3);
		
		System.out.println("Ausgabe fur Objekt 1");
		v1.ausgabe();
		System.out.println("Ausgabe fur Objekt 2");
		v2.ausgabe();
		System.out.println("Ausgabe fur Objekt 3");
		v3.ausgabe();
		System.out.println("Ausgabe fur Objekt 4");
		v4.ausgabe();
	}

	@Override
	public void zeichnen(Graphics g, double koef) {
		// TODO Auto-generated method stub
		
	}
}
