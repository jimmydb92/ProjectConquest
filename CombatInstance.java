import java.util.*;
/* Handles each instance of combat
 * also will handle bonuses
 * 
 * 
 */
public class CombatInstance {
	private Territory atkingTer;
	private Territory defingTer;
	
	private Player victor;
	private Player loser;
	
	//empty constructor
	public CombatInstance(){
		atkingTer = null;
		defingTer = null;
		victor = null;
		loser = null;
	}
	
	public CombatInstance(Territory inAtkTer, Territory inDefTer){
		atkingTer = inAtkTer;
		defingTer = inDefTer;
		victor = null;
		loser = null;
	}
	
	public Territory getAtkTerr(){
		return atkingTer;
	}
	
	public void setAtkTerr(Territory inAtkTer){
		 atkingTer = inAtkTer;
	}
	
	public Territory getDefTerr(){
		return defingTer;
	}
	
	public void setDefTerr(Territory inDefTer){
		 defingTer = inDefTer;
	}
	
	public Player getVictor(){
		return victor;
	}
	
	public void setVictor(Player inPlayer){
		victor = inPlayer;
	}
	
	public Player getLoser(){
		return loser;
	}
	
	public void setLoser(Player inPlayer){
		loser = inPlayer;
	}
	
	public void combat(){
		int atkPower = compileAtkPwr();
		int defPower = compileDefPwr();
		battle(atkPower, defPower);
		//victoryPhase(victor, loser);
		//results();
		System.out.println("Winner: " + victor.getName() + " Loser: " + loser.getName());
	}
	
	public int compileAtkPwr(){
		int addAtk = 0;
		for (int i = 0; i < atkingTer.getTerrUnits().size(); i++){
			addAtk = addAtk +  atkingTer.getTerrUnits().get(i).getAtk();
		}
		return addAtk;
	}
	
	public int compileDefPwr(){
		int addDef = 0;
		for (int i = 0; i < defingTer.getTerrUnits().size(); i++){
			addDef = addDef +  defingTer.getTerrUnits().get(i).getAtk();
		}
		return addDef;
	}
	
	public void battle(int inAtk, int inDef){
		if (inAtk > inDef){
			victor = atkingTer.getOwner();
			loser = defingTer.getOwner();
		}
		else if(inAtk < inDef){
			victor = defingTer.getOwner();
			loser = atkingTer.getOwner();
		}
		
		else{
			victor = defingTer.getOwner();
			loser = atkingTer.getOwner();
		}
		
		
		//tie goes to defender but this will change	
	}
	
}
