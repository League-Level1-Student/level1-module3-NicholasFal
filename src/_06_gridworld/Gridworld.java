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
	world.add(flowerLocation, flower);
	world.add(betterFlowerLocation, betterFlower);
	for(int flowers = 0; flowers < 96; flowers++) {
		Flower flowerExtra = new Flower();
		
	}
}
}
