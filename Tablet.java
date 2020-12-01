//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class Tablet{
    private String name;
    private int price;
    private double displaySize;
    private int capacity;
    private boolean cellular;
    private String color;
    private int serialNum;
    private int appCount;

    private static Tablet[] tablets = new Tablet[20];
    private static int totalNumApps = 0;
    private static int serialStart = -1;
    private static int tabletCount = 0;
    

    public Tablet(String name, int price, double displaySize, int capacity, boolean cellular, String color){
	this.name=name;
	this.price=price;
	this.displaySize=displaySize;
	this.capacity=capacity;
	this.cellular=cellular;
	this.color=color;
	serialNum=getSerialNum();
    }
    public void installApp(){
	totalNumApps +=1;
	appCount +=1;
    }
    
    public static int getTotalNumberOfApps(){
	return totalNumApps;
    }
    public int getAppCount(){
	return appCount;
    }
    public int getSerialNum(){
	serialStart+=1;
	return serialStart;
    }
    
    public static void remove(Tablet tab){
	for(int i=0;i<tabletCount;i++){
	    if(tablets[i].equals(tab)){
		tablets[i]=null;
		for(int j=i;j<tabletCount;j++){
		    Tablet temp = tablets[j];
		    tablets[j]=tablets[j+1];
		    tablets[j+1]=temp;
		}
		break;
	    }
	}
	totalNumApps=totalNumApps-tab.getAppCount();
	tabletCount-=1;
    }
    public static void add(Tablet tab){
	tablets[tabletCount]=tab;
	tabletCount+=1;
    }
    public String toString(){
	return "   ("+name+", "+serialNum+", "+price+", "+displaySize+", "+capacity+", "+appCount+", "+cellular+", "+color+")";
    }
    public static void print(String s){
	System.out.println(s);
	for(int i=0;i<tabletCount;i++){
	    System.out.println(tablets[i]);
	}
    }
}
