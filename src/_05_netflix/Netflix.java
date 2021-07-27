package _05_netflix;

public class Netflix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie godfather = new Movie("The Godfather", 4);
		Movie lordOfRings = new Movie("The Lord of the Rings", 5);
		Movie spaceJam = new Movie("Space Jam", 5);
		Movie avatar = new Movie("Avatar", 1);
		Movie titanic = new Movie("Titanic", 4);
		System.out.println(titanic.getTicketPrice());
	}

}
