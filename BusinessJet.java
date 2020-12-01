package ps8;
//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class BusinessJet extends Jet{
	private int numPassengers;
	private boolean transOceanCertified;
	public BusinessJet(String manufacturer, String model, int year, String owner, double grossWeightEmpty,
			int lastOverhaul,int numOverhauls, int maxRecommendedFlightHours, int numPassengers, boolean transOceanCertified) {
		super(manufacturer,model,year,owner,grossWeightEmpty,lastOverhaul,numOverhauls,maxRecommendedFlightHours);
		this.numPassengers=numPassengers;
		this.transOceanCertified=transOceanCertified;
	}
	public boolean isHighClass(){
		return numPassengers>=40&&transOceanCertified;
	}
	public String toString() {		
		return super.toString()+"Number of passengers available: "+numPassengers+", The aircraft is certified to fly over ocean: "+transOceanCertified;
	}
	public int compareTo(BusinessJet o) {
		if(this.transOceanCertified&&!o.transOceanCertified){
			return 1;
		}
		else if(!this.transOceanCertified&&o.transOceanCertified){
			return -1;
		}
		else{
			return 0;
		}
	}
	public static void main(String[] args) {
		BusinessJet bj1=new BusinessJet("Boeing","A-737",2010,"Korea Airline",2100.2,10,12,100,40,false);
		BusinessJet bj2=new BusinessJet("Airbus","A320",2019,"Airbus airlines",2457.2,12,5,130,50,true);
		System.out.println("bj1's specification: "+bj1);
		System.out.println("The jet is high class: "+bj1.isHighClass());
		
		System.out.println("\nbj2's specification: "+bj2);
		System.out.println("The jet is high class: "+bj2.isHighClass());
		if(bj1.compareTo(bj2)==1){
			System.out.println("\nbj1 is a better passenger jet since it has capability of more than 40 passengers");		
		}	
		else if(bj1.compareTo(bj2)==0){
			System.out.println("\nIt is nearly impossible to distinguish which business jet is better");
		}
		else{
			System.out.println("\nbj2 is a better passenger jet since it has capability of more than 40 passengers");
		}
		

	}

}
