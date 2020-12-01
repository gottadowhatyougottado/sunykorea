package ps8;
//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class PassengerJet extends Jet {

	private int numPassengers;
	private int numEngines;
	private boolean hasAutopilot;

	public PassengerJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
			int lastOverhaul,int numOverhauls, int maxRecommendedFlightHours, int numPassengers,int numEngines, boolean hasAutopilot){
		super(manufacturer,model,year,owner,grossWeightEmpty,lastOverhaul,numOverhauls,maxRecommendedFlightHours);
		this.numPassengers=numPassengers;
		this.numEngines=numEngines;
		this.hasAutopilot=hasAutopilot;
	}
	public boolean isHardToFly(){
		return !hasAutopilot;
	}
	public boolean needsLongRunway(){
		return grossWeightEmpty>230000;
	}


	public int compareTo(PassengerJet o) {
		if(this.hasAutopilot&&!o.hasAutopilot){
			return 1;
		}
		else if(!this.hasAutopilot&&o.hasAutopilot){
			return -1;
		}
		else{
			return 0;
		}
	}
	public String toString() {		
		return super.toString()+"Number of passengers available: "+numPassengers+", Number of engines: "+numEngines+", Autopilot feature: "+hasAutopilot;
	}

	public static void main(String[] args) {
		PassengerJet pj1=new PassengerJet("Boeing","A-737",2010,"Korea Airline",2100.2,10,12,200,100,4,false);
		PassengerJet pj2=new PassengerJet("Airbus","A320",2019,"Airbus airlines",2457.2,12,5,150,200,3,true);
		System.out.println("pj1's specification: "+pj1);
		System.out.println("The jet is hard to fly: "+pj1.isHardToFly());
		System.out.println("The jet needs a long runway"+pj1.needsLongRunway());

		System.out.println("\npj2's specification"+pj2);
		System.out.println("The jet is hard to fly: "+pj2.isHardToFly());
		System.out.println("The jet needs a long runway: "+pj2.needsLongRunway());

		if(pj1.compareTo(pj2)==1){
			System.out.println("\npj1 is a better passenger jet since it has autopilot");		
		}	
		else if(pj1.compareTo(pj2)==0){
			System.out.println("\nIt is nearly impossible to distinguish which passenger jet is better");
		}
		else{
			System.out.println("\npj2 is a better passenger jet since it has autopilot");
		}
	}
}


