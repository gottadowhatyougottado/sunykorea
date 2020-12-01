//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class CarRepairShop {

    private Car[] cars;
    private RepairTicket[] tickets;
    private int carCount;
    private int ticketCount;
    
    
    public CarRepairShop(){
	cars = new Car[50];
	tickets = new RepairTicket[50];
    }
    public int addNewCar(String vin, String make, int year) {
	for(int i=0;i<carCount;i++){
	    if(cars[i] != null){
		if(cars[i].VIN.equals(vin)){
		    return -1;
		}
	    }
	}
	cars[carCount++]=new Car(vin, make, year);
	return carCount;		
    }
    public int addRepairTicket(String vin, double cost, String description) {
	for(int i=0;i<carCount;i++){
	    if(cars[i] != null){
		if(cars[i].VIN.equals(vin)){
		    tickets[ticketCount++]=new RepairTicket(vin, cost, description);
		    tickets[ticketCount-1].ticketNum = ticketCount;
		    return ticketCount;
		}
	    }	    
	}
	return -1;    
    }
    public double getRepairCost(int ticketNum) {
        for(int i=0;i<ticketCount;i++){
	    if(tickets[i]!=null){
		if(tickets[i].ticketNum==ticketNum){
		    return tickets[i].cost;
		}
	    }
	}
	return -1;
    }
    public double getTotalRepairCosts(String vin) {
	double cost=0;
	for(int i=0;i<ticketCount;i++){
	    if(tickets[i]!=null){
		if(tickets[i].VIN.equals(vin)){
		    cost=cost+tickets[i].cost;
		}
	    }
	}
	return cost==0? -1: cost;
    }

    public String getWorstCarMake() {
	int finalCount=0;
	String finalCar="";
		
	for(int i=0;i<carCount;i++){
	    int count=0;
	    for(int j=0;j<ticketCount;j++){
		if(cars[i]!=null&&tickets[j]!=null){
		    if(cars[i].VIN.equals(tickets[j].VIN)){
			count++;
		    }
		}
	    }
	    
	    if (finalCount<count&&cars[i]!=null){
		finalCount=count;
		finalCar=cars[i].make;
	    }
	}
	return finalCount==0? null: finalCar;
    }  
    public boolean updateRepairCost(int ticketNum, double newCost) {
	for(int i=0;i<ticketCount;i++){
	    if(tickets[i] != null){
		if(tickets[i].ticketNum == ticketNum){
		    tickets[i].cost=newCost;
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean deleteRepair(int ticketNum) {
	for(int i=0; i<ticketCount; i++){
	    if(tickets[i] != null){
		if(tickets[i].ticketNum == ticketNum){
		    tickets[i] = null;
		    return true;
		}
	    }
	}
	return false;	
    }
    public boolean deleteAllRepairsForCar(String VIN) {
       
	for(int i=0;i<ticketCount;i++){
	    if(tickets[i]!=null){
		if(tickets[i].VIN.equals(VIN)){
		    tickets[i]=null;
		    return true;
		}
	    }
	}
	return false;
    }
    public boolean deleteCarAndRepairs(String VIN) {
 
	for(int i=0;i<ticketCount;i++){
	    if(tickets[i]!=null){
		if(tickets[i].VIN.equals(VIN)){
		    tickets[i]=null;
		}
	    }
	}
	for(int i=0;i<carCount;i++){
	    if(cars[i]!=null){
		if(cars[i].VIN.equals(VIN)){
		    cars[i]=null;	
		    return true;
		}
	    }
	}
	return false;
    }
    
}

class Car {
    String VIN;
    String make;
    int year;

    public Car (String VIN, String make, int year){
	this.VIN = VIN;
	this.make = make;
	this.year = year;
    }	       
}

class RepairTicket {
    String VIN;
    double cost;
    String description;
    int ticketNum;
    public RepairTicket(String VIN, double cost, String description){
	this.VIN=VIN;
	this.cost=cost;
	this.description=description;
    }
}
