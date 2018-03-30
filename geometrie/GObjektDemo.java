package geometrie;

public class GObjektDemo 
{
	static GObjekt[] objekte=new GObjekt[8];
	public static void init()
	{
		Punkt anf=new Punkt(1,0);
		objekte[0]=new Rechteck(anf,2,1.5);
		anf=new Punkt(4,0);
		objekte[1]=new Rechteck(anf,2.5,1.5);
		
		Punkt[] punkte=new Punkt[3];
		punkte[0]=new Punkt(0,3);
		punkte[1]=new Punkt(1,3);
		punkte[2]=new Punkt(1,1.5);
		objekte[2]=new Dreieck(punkte);
		
		Punkt[] punkte1=new Punkt[3];
		punkte1[0]=new Punkt(2,3);
		punkte1[1]=new Punkt(3,3);
		punkte1[2]=new Punkt(3,1.5);
		objekte[3]=new Dreieck(punkte1);
		
		Punkt[] punkte2=new Punkt[4];
		punkte2[0]=new Punkt(4,1.5);
		punkte2[1]=new Punkt(5,3);
		punkte2[2]=new Punkt(6,3);
		punkte2[3]=new Punkt(6.5,1.5);
		objekte[4]=new Viereck(punkte2);
		
		anf=new Punkt(2,4);
		objekte[5]=new Ellipse(anf,1,1);
		
		anf=new Punkt(5.5,4);
		objekte[6]=new Ellipse(anf,1,1);
		
		anf=new Punkt(4,6);
		objekte[7]=new Ellipse(anf,2,1);
	}
	public static void main(String args[])
	{
		init();	
		System.out.println("Die Objekte sind: ");
		System.out.println("Objekt Umfang Flaeche Art");
		double gesamtFlaeche=0;
		for(int i=0;i<objekte.length;i++)
		{
			System.out.printf("\n %8s",objekte[i].name);
			System.out.printf(" %8.2f",objekte[i].umfang());
			System.out.printf(" %8.2f",objekte[i].flaeche());
			System.out.printf("	%s",objekte[i].art());
			gesamtFlaeche +=objekte[i].flaeche();
		}
		System.out.printf("\n\n Gesamtflache =%8.2f", gesamtFlaeche);
	}
}


	
