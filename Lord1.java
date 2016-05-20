import java.util.*;
// this be that cult nigga cult of the calamity or arconius or Baldruzz'z or Lengiligan

public class Lord1 extends Player {
	String name;
	String description;
	
	Territory startTerr;
	
	int lordPower;
	
	//will be a list of specialUnits once its in
	ArrayList<Unit> lordUnits;
	
	public Lord1(){
		name = "cultOfBred";
		startTerr = new Territory("bigRedDomain", this, 1, false, false, false, false, lordUnits);
		description ="\t\tHe is the Reddest, Bringer of Foretold Doom, the Smasher Incarnate. Born to a demon hunter, The Red learned the ways\n"
				+ "\t\tof combat and terror. As he matured, followers flocked to his dark but efficient methods, entranced by a power never before seen.\n"
				+ "\t\tHe sits the Throne of the Biggest, his massive stature only dwarfed by the legions of fanatics at his command.";
		lordPower = 1;
		lordUnits = new ArrayList<Unit>();
		lordUnits.add(0, new Unit("Captain FalcRed", 2, startTerr));//null starting territory until we pick out starting spots
		lordUnits.add(1, new Unit("BigRed5", 2, startTerr));//null starting territory until we pick out starting spots
		lordUnits.add(2, new Unit("Xavier", 2, startTerr));//null starting territory until we pick out starting spots
		startTerr.setTerrUnits(lordUnits);//fuckin shit programming
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String inName){
		name = inName;
	}
	
	public int getLordPower(){
		return lordPower;
	}
	
	public void setLordPower(int inPower){
		lordPower = inPower;
	}
	
	public ArrayList<Unit> getLordUnits(){   // will change when we make heroUnit
		return lordUnits;
	}
	
	public void setName(ArrayList<Unit> inUnit){
		lordUnits = inUnit;
	}
	
	public String toString(){
		return "Lord: \n\t\t" + name + "\nDescription: \n" + description + "\nLord Power: " + lordPower + "\nUnits: " 
				+ lordUnits.toString();
	}

	
}
