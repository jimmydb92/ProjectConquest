/* The PARENT class for all units. All units can move, attack, have name, id num, location
 * String name = unit name
 * int idNum = ID
 * int atkPwr = attack
 * Territory location = where unit is
 * Should attack() be here? or handled by game engine grabbing value from class?
 */
public class Unit {
	private String name;
	
	//private int idNum;
	private int atkPwr;
	
	private Territory location;
	
	public Unit(){
		name = "bringerOfForetoldDoom";
		//idNum = -1;
		atkPwr = -1;
		location = null;
	}
	
	public Unit(String inName, int inAtk, Territory inLoc){
		name = inName;
		//idNum = inID;
		atkPwr = inAtk;
		location = inLoc;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String inName){
		name = inName;
	}
	
	//public int getID(){
	//	return idNum;
	//}
	
	//public void setID(int inID){
	//	idNum = inID;
	//}
	
	public int getAtk(){
		return atkPwr;
	}
	
	public void setAtk(int inAtk){
		atkPwr = inAtk;
	}
	
	public Territory getLocation(){
		return location;
	}
	
	public void setLocation(Territory inLocation){
		location = inLocation;
	}
	
	public String toString(){
		return "\n 	Unit name: " + name + " Attack: " + atkPwr 
				+ " Location: " + location.getName();
	}
	
	//This may take the place of setLocation. Makes it easier to program and follow. not sure yet tho
	public void move(Territory inTerritory){
		setLocation(inTerritory);
	}
}
