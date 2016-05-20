import java.util.*;
/* PARENT class for each individual area to be controlled
 * String name = name of territory
 * int terriID = territory ID
 * boolean isDirImpass = cannot be crossed by anyone if true
 * boolean isIndirImpass = can only be crossed by certain units if true
 * boolean isSlow = terrain costs more to traverse if true
 * boolean isWater = terrain is water if true
 */
public class Territory {
	private String name;
	
	private Player owner;
	
	private int terriID;
	
	private boolean isDirImpass;
	private boolean isIndirImpass;
	private boolean isSlow;
	private boolean isWater;
	
	private ArrayList<Unit> territoryUnits;
	
	//empty constructor
	public Territory(){
		name = "landOfRed";
		owner = new Player();
		terriID = -1;
		isDirImpass = false;
		isIndirImpass = false;
		isSlow = false;
		isWater = false;
		territoryUnits = new ArrayList<Unit>();
	}
	
	public Territory(String inName, Player inPlayer, int inID, boolean inDir, boolean inIndir, boolean inSlow
			, boolean inWater, ArrayList<Unit> inUnitList){
		name = inName;
		owner = inPlayer;
		terriID = inID;
		isDirImpass = inDir;
		isIndirImpass = inIndir;
		isSlow = inSlow;
		isWater = inWater;
		territoryUnits = inUnitList;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String inName){
		name = inName;
	}
	
	public int getTerriID(){
		return terriID;
	}
	
	public void setTerriID(int inID){
		terriID = inID;
	}
	
	public boolean getDir(){
		return isDirImpass;
	}
	
	public void setDir(boolean inDir){
		isDirImpass = inDir;
	}
	
	public boolean getIndir(){
		return isIndirImpass;
	}
	
	public void setIndir(boolean inIndir){
		isIndirImpass = inIndir;
	}
	
	public boolean getSlow(){
		return isSlow;
	}
	
	public void setSlow(boolean inSlow){
		isSlow = inSlow;
	}
	
	public boolean getWater(){
		return isWater;
	}
	
	public void setWater(boolean inWater){
		isWater = inWater;
	}
	
	public Player getOwner(){
		return owner;
	}
	
	public void setOwner(Player inOwner){
		owner = inOwner;
	}
	
	public ArrayList<Unit> getTerrUnits(){
		return territoryUnits;
	}
	
	public void setTerrUnits(ArrayList<Unit> inTerrUnits){
		territoryUnits = inTerrUnits;
	}
	
	public String toString(){
		String dirStr, indirStr, slowStr, waterStr;
		
		dirStr = String.valueOf(isDirImpass);
		indirStr = String.valueOf(isIndirImpass);
		slowStr = String.valueOf(isSlow);
		waterStr = String.valueOf(isWater);
		
		return "\n	Territory Name: " + name + " Territory ID: " + terriID + " Territory Owner: " + owner.getName() + " DirImpass: " + dirStr 
				+ " IndirImpass: " + indirStr + " SlowImpass: " + slowStr + " WaterLand: " 
				+ waterStr;		
	}
	
}
