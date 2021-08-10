package _06_gridworld;

import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {

public static void main(String[] args) {
	World world = new World();
	world.show();
	Bug bug = new Bug();
	Location buglocation = new Location(5,3);
	world.add(buglocation, bug);
	Random ran = new Random();
	int randomBugLocationX = ran.nextInt(10);
	int randomBugLocationY = ran.nextInt(10);
	Bug betterBug = new Bug();
	Location betterBugLocation = new Location(randomBugLocationX, randomBugLocationY);
	world.add(betterBugLocation, betterBug);
	betterBug.setColor(Color.BLUE);
	betterBug.setDirection(90);
	Flower flower = new Flower();
	Location flowerLocation = new Location(randomBugLocationX, randomBugLocationY - 1);
	flower.setColor(Color.YELLOW);
	Flower betterFlower = new Flower();
	Location betterFlowerLocation = new Location(randomBugLocationX, randomBugLocationY + 1);
	betterFlower.setColor(Color.yellow);
	//world.add(flowerLocation, flower);
	//world.add(betterFlowerLocation, betterFlower);
//	for(int flowers = 0; flowers < 96; flowers++) {
//		Flower flowerExtra = new Flower();
//		if(flowers < 10) {
//		Location flowerExtraLocation = new Location(flowers, 0);
//		world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 19) {
//			Location flowerExtraLocation = new Location(flowers - 9, 1);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 28) {
//			Location flowerExtraLocation = new Location(flowers - 18, 2);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 37) {
//			Location flowerExtraLocation = new Location(flowers - 27, 3);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 46) {
//			Location flowerExtraLocation = new Location(flowers - 36, 4);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 55) {
//			Location flowerExtraLocation = new Location(flowers - 45, 5);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 64) {
//			Location flowerExtraLocation = new Location(flowers - 54, 6);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 73) {
//			Location flowerExtraLocation = new Location(flowers - 63, 6);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 82) {
//			Location flowerExtraLocation = new Location(flowers - 72, 7);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 91) {
//			Location flowerExtraLocation = new Location(flowers - 81, 8);
//			world.add(flowerExtraLocation, flowerExtra);
//		} else if(flowers < 100) {
//			Location flowerExtraLocation = new Location(flowers - 90, 9);
//			world.add(flowerExtraLocation, flowerExtra);
//		}
for(int row = 0; row < 10; row++) {
	for(int column = 0; column < 10; column++) {
		Location loc = new Location(row, column);
		Flower newFlower = new Flower();
		world.add(loc, newFlower);
		if(row % 2 == 0) {
			newFlower.setColor(Color.red);
		} else {
			newFlower.setColor(Color.white);
		}
		
	}
}
}
}
