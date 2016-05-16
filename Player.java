import java.util.*;
/* This is the Player class. 
 * Every player is the same class with different parameters
 * String name = player name
 * int gold = amount of currency player has
 * ArrayList playerUnits = units the player owns
 * ArrayList playerLand = territories player owns
 * Should player control currency updating? method to update money
 * 
 */

public class Player {
	
	private String name;
	
	private int gold;
	
	private ArrayList<Unit> playerUnits;
	private ArrayList<Territory> playerLand;
	
	//empty constructor
	public Player(){
		name = "bigRed";
		gold = 0;
		playerUnits = new ArrayList<Unit>();
		playerLand = new ArrayList<Territory>();
		
	}
	
	//overloaded
	//Both lists should start empty. As we decide who starts where, that will be a default value
	//Once values are figured, hardcode here
	public Player(String inName, int inGold){
		name = inName;
		gold = inGold;
		playerUnits = new ArrayList<Unit>();
		playerLand = new ArrayList<Territory>();
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String inName){
		name = inName;
	}
	
	public int getGold(){
		return gold;
	}
	
	public void setGold(int inGold){
		gold = inGold;
	}
	
	public ArrayList<Unit> getUnits(){
		return playerUnits;
	}
	
	public void setUnits(ArrayList<Unit> inUnitList){
		playerUnits = inUnitList;
	}
	
	public ArrayList<Territory> getLand(){
		return playerLand;
	}
	
	public void setLand(ArrayList<Territory> inLand){
		playerLand = inLand;
	}
	
	//Steps through list of Units and uses toString in Unit to append
	public String unitToString(){
		String unitList = "";
		for(int i = 0; i < playerUnits.size(); i++){
			unitList = unitList + playerUnits.get(i).toString() + " ";
		}
		
		return unitList;
	}
	
	//Steps through list of Territory and uses toString in Territory to append
	public String landToString(){
		String landList = "";
		for(int i = 0; i < playerLand.size(); i++){
			landList = landList + playerLand.get(i).toString() + " ";
		}
			
		return landList;
	}
	
	@Override
	public String toString(){
		return "Player name: " + name + " " + "Player Gold: " + gold + "\n\nLAND" + landToString() 
			+ "\n\nUNITS" + unitToString();
	}
	
}
