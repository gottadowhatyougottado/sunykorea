//Jeemin Myung
//jeemin.myung@stonybrook.edu
package ps8;
import java.util.Scanner;
public class TeamManager{
	
	
	public static void main(String[]args){
		
		System.out.println("Menu:"+"\n1. Print player list."+"\n2. Add player to roster"+
	"\n3. Remove player from roster."+"\n4. Change player's position."+"\n5. Quit.");
		Player[] players = new Player[10];
		int count = 0;
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter menu choice: ");
		int menuChoice=scan.nextInt();
		while(menuChoice!=5){	
			if(menuChoice==1){
				for(int i=0;i<players.length;i++){
					if(players[i]!=null){
						System.out.println(players[i]);
					}
				}
			}
			if (menuChoice==2){
				System.out.print("Enter player name: ");
				String playerName=scan.next();
				System.out.print("Enter player position (1 = defender, 2 = midfielder, 3 = forward) : ");
				Position playerPositionEnum=null;
				int playerPosition=scan.nextInt();
				if (playerPosition==1){
					playerPositionEnum = Position.DEFENDER;
				}
				if(playerPosition==2){
					playerPositionEnum = Position.MIDFIELDER;
				}
				if(playerPosition==3){
					playerPositionEnum = Position.FORWARD;
				}

				Player p1 = new Player(playerName, playerPositionEnum);
				players[count] = p1;
				count++;
				
			}
			if (menuChoice==3){
				System.out.print("Enter name of player to remove: ");
				String removeName = scan.next();
				remove(players,removeName);
			}
			if (menuChoice==4){
				System.out.print("Enter name of player to reposition: ");
				String repositionName = scan.next();
				System.out.print("Enter new position (1 = defender, 2 = midfielder. 3 = forward): ");
				int repositionNum = scan.nextInt();
				Position playerPositionEnum=null;
				if (repositionNum==1){
					playerPositionEnum = Position.DEFENDER;
				}
				if(repositionNum==2){
					playerPositionEnum = Position.MIDFIELDER;
				}
				if(repositionNum==3){
					playerPositionEnum = Position.FORWARD;
				}
				for(int i=0;i<players.length;i++){
					if(players[i]!=null){
						if(players[i].getName().equals(repositionName)){
							players[i].setPosition(playerPositionEnum);
						}
					}
					
				}
				
			}
			
			System.out.println("Menu:"+"\n1. Print player list."+"\n2. Add player to roster"+
					"\n3. Remove player from roster."+"\n4. Change player's position."+"\n5. Quit.");
			System.out.print("Enter menu choice: ");
			menuChoice=scan.nextInt();
		}
	}
	public static void remove(Player[] players,String p){
		for(int i=0;i<players.length;i++){
			if(players[i]!=null){
				if(players[i].getName().equals(p)){
					players[i]=null;
				}
			}
		}
	}
}

enum Position {DEFENDER, MIDFIELDER, FORWARD};
class Player {
	String name;
	Position position;

	public Player(String name, Position position){
		this.name=name;
		this.position=position;
	}
	public String getName(){
		return name;
	}
	public void setPosition(Position position){
		this.position=position;
	}
	public String toString(){
		return name+": "+position;
	}
	
}
