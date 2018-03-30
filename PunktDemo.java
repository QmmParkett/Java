package geometrie;

public class PunktDemo {
	public static void main (String[]args)
	{
		Punkt p1,p2,p3,p4,p5,p6;
		p1=new Punkt();
		p2=new Punkt(2,2);
		p3=new Punkt();
		System.out.println("Eingabe fuer Object 3:");
		p3.eingabe();
		p4=new Punkt (p3);
		p5=p2.newMove(1,1);
		p2.move(3,4);
		p6=p2;
		System.out.println("Object 1:");
		p1.ausgabe();
		System.out.println("Object 2:");
		p2.ausgabe();
		System.out.println("Object 3:");
		p3.ausgabe();
		System.out.println("Object 4:");
		p4.ausgabe();
		System.out.println("Object 5:");
		p5.ausgabe();
		System.out.println("Object 6:");
		p6.ausgabe();
	}
				
}


