import java.util.*;
/*
 * To Do 5/15/2016
 * player has army on a territory, can move army to another territory
 * 		-unit created and placed
 * 		-move order
 * 		
 */
public class GiveItAWhirl {

	public static void main(String[] args) {
		ArrayList<Unit> testUnitList = new ArrayList<Unit>();
		ArrayList<Territory> testTerritoryList = new ArrayList<Territory>();
		
		
		testTerritoryList.add(new Territory("ericB", 1, false, false, false, false));
		testTerritoryList.add(new Territory("rakim", 2, false, false, false, false));
		testUnitList.add(new Unit("lilHomie", 1, testTerritoryList.get(0)));
		
		Player testPlayer = new Player();
		
		testPlayer.setUnits(testUnitList);
		testPlayer.setLand(testTerritoryList);
		
		System.out.println(testPlayer.toString()); 
		
		System.out.println("UNIT MOVE");
		
		testPlayer.getUnits().get(0).move(testTerritoryList.get(1));
		
		System.out.println(testPlayer.toString());
		
		System.out.println("done");

	}

}
