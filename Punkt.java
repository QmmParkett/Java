package geometrie;

public class Punkt {
	protected double x,y;
	public Punkt(){
		x=0;
		y=0;
		}
	public Punkt(double x,double y)
	{
		this.x=x;
		this.y=y;
	}
	public Punkt(Punkt p)
	{
		x=p.x;
		y=p.y;
	}
	public void eingabe()
	{
		System.out.println("Eingabe fue einen Punkt:");
		System.out.println("Eingabe fur x=");
		x=Hilfe.sc.nextDouble();
		System.out.println("Eingabe fur y=");
		y=Hilfe.sc.nextDouble();
	}
	public void move(double delx,double dely){
		x=x+delx;
		y=y+dely;
	}
	public Punkt newMove(double delx, double dely)
	{
		double xp=x+delx;
		double yp=y+dely;
		return new Punkt(xp,yp);
	}
	public String toString()
	{
		return "("+x+","+y+")";
	}
	public void ausgabe()
	{
		System.out.println(this);
	}
	
		
		
		
}


