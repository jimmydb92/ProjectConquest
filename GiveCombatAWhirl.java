import java.util.ArrayList;

public class GiveCombatAWhirl {

	public static void main(String[] args) {
		
		Player player1 = new Player();
		Player player2 = new Player("jim", 0);
		Lord1 bred = new Lord1();
		
		ArrayList<Unit> testUnitList1 = new ArrayList<Unit>();
		testUnitList1.add(new Unit());
		testUnitList1.add(new Unit());
		
		ArrayList<Unit> testUnitList2 = new ArrayList<Unit>();
		testUnitList1.add(new Unit());
		
		
		ArrayList<Territory> testTerritoryList1 = new ArrayList<Territory>();
		testTerritoryList1.add(new Territory("ericB", player1, 1, false, false, false, false, testUnitList1));
		
		ArrayList<Territory> testTerritoryList2 = new ArrayList<Territory>();
		testTerritoryList2.add(new Territory("rakim", player2, 1, false, false, false, false, testUnitList2));
		
		
		
		CombatInstance letsFight = new CombatInstance(testTerritoryList1.get(0),testTerritoryList2.get(0));
		letsFight.combat();
		System.out.println(bred.toString());
		System.out.println("done");
		
		//need constructor in territory for list of units
	}

}
