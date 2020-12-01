package ps8;
//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class Jet implements Comparable<Jet> {
	protected String manufacturer;
	protected String model;
	protected int year;
	protected String owner;
	protected double grossWeightEmpty;
	protected int lastOverhaul;
	protected int numOverhauls;
	protected int maxRecommendedFlightHours;

	
	public Jet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
			int lastOverhaul,int numOverhauls, int maxRecommendedFlightHours){
		this.manufacturer=manufacturer;
		this.model=model;
		this.year=year;
		this.owner=owner;
		this.grossWeightEmpty=grossWeightEmpty;
		this.lastOverhaul=lastOverhaul;
		this.numOverhauls=numOverhauls;
		this.maxRecommendedFlightHours=maxRecommendedFlightHours;
	}

	public void sellTo(String owner){
		this.owner=owner;
	}
	public void overhaul(){
		lastOverhaul=0;
		numOverhauls++;
	}
	public int timeTillOverhaul(){
		return maxRecommendedFlightHours-lastOverhaul;
	}
	public void fly(int dailyHour){
		lastOverhaul+=dailyHour;
	}
	public boolean needsOverhaul(){
		return maxRecommendedFlightHours-lastOverhaul<=100;
	}
	public boolean isAging(){
		return 2020-year>15&&numOverhauls>=20;
	}
	
	public int compareTo(Jet o) {
		if(this.year<o.year){
			return -1;
		}
		else if(this.year>o.year){
			return 1;
		}
		else{
			return 0;
		}
	}
	public String toString (){
		return "Manufacturer: "+manufacturer+", Model: "+model+", Year: "+year+", Owner: "+
	owner+", Weight in Kg: "+grossWeightEmpty+", Last overhaul: "+lastOverhaul+", Numbers of overhauls: "+
				numOverhauls+", Max recommended flight hours: "+maxRecommendedFlightHours;
	}
	public static void main(String[]args){
		Jet j1=new Jet("Boeing","A-747",2018,"Jeemin Myung",1400.7,14,7,250);
		Jet j2=new Jet("McDonnell Douglas","F-15K",2000,"Lt.Dan",1224.23,12,21,30);
		System.out.println("j1's specification a: "+j1);
		j1.sellTo("Professor.Kuhn");
		j1.fly(20);
		j1.overhaul();
		System.out.println("j1's specification b: "+j1);
		System.out.println("Jet j1's time till overhaul: "+j1.timeTillOverhaul());
		System.out.println("Jet j1 needs overhaul: "+j1.needsOverhaul());
		System.out.println("Jet j1 is aging: "+j1.isAging());
		
		System.out.println("\nj2's specification: "+j2);
		System.out.println("Jet j2's time till overhaul: "+j2.timeTillOverhaul());
		System.out.println("Jet j2 needs overhaul: "+j2.needsOverhaul());
		System.out.println("Jet j2 is aging: "+j2.isAging());
		
		if(j1.compareTo(j2)==1){
			System.out.println("\nj1 is a better jet because it is newer!");
		}
		else if(j1.compareTo(j2)==0){
			System.out.println("\nIt is nearly impossible to distiguish which jet is better");
		}
		else{
			System.out.println("\nj2 is a better jet because it is newer!");
		}
		
		
	}


}
