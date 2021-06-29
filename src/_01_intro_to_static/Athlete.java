package _01_intro_to_static;

public class Athlete {
		static int nextBibNumber = 1;
	    static String raceLocation = "New York";
	    static String raceStartTime = "9.00am";

	    String name;
	    int speed;
	    int bibNumber;

	    Athlete (String name, int speed){
	        this.name = name;
	        this.speed = speed;
	        this.bibNumber = nextBibNumber;
	        nextBibNumber++;
	    }

	    public static void main(String[] args) {
	        Athlete first = new Athlete("Harry", 7);
	    	Athlete second = new Athlete("Belinda", 9);
	    	System.out.println(first.name);
	    	System.out.println(first.bibNumber);
	    	System.out.println(second.name);
	    	System.out.println(second.bibNumber);
	    	System.out.println(raceLocation);
	    	//create two athletes
	        //print their names, bibNumbers, and the location of their race. 
	    }
}
