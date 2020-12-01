//Jeemin Myung
//jeemin.myung@stonybrook.edu
public class UseTablet {

    public static void main (String[] args) {

        Tablet tablet1 = new Tablet("Jim", 629, 9.7, 16, true, "red");
        tablet1.installApp();
        tablet1.installApp();
	Tablet.add(tablet1);

        Tablet tablet2 = new Tablet("Amy", 599, 9.7, 32, false, "space grey");
        tablet2.installApp();
        tablet2.installApp();
        tablet2.installApp();
	Tablet.add(tablet2);

        Tablet tablet3 = new Tablet("Art", 829, 9.7, 64, true, "silver");
        tablet3.installApp();
	Tablet.add(tablet3);

        Tablet tablet4 = new Tablet("Ken", 599, 9.7, 32, false, "pink");
        tablet4.installApp();
        tablet4.installApp();
        tablet4.installApp();
        tablet4.installApp();
	Tablet.add(tablet4);

        Tablet tablet5 = new Tablet("Jan", 829, 9.7, 64, true, "gold");
        tablet5.installApp();
	Tablet.add(tablet5);

        Tablet.print("All Tablets:");
        System.out.println("The total number of apps: " +
                           Tablet.getTotalNumberOfApps());

        Tablet.remove(tablet3);
        Tablet.print("All Tablets:");
        System.out.println("The total number of apps: " +
                           Tablet.getTotalNumberOfApps());

        Tablet.remove(tablet1);
        Tablet.print("All Tablets:");
        System.out.println("The total number of apps: " +
                           Tablet.getTotalNumberOfApps());

        Tablet.remove(tablet5);
        Tablet.print("All Tablets:");
        System.out.println("The total number of apps: " +
                           Tablet.getTotalNumberOfApps());
    }
}
