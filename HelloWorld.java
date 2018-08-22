/* HelloWorld.java
 */
//import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class HelloWorld
{
	public static void main(String[] args) {
		int col = 10;
		int row = 10;

		boolean result = true;

		// Integer x = new Integer(0);
		// Integer y = new Integer(0);

		int x = 0;
		int y = 0;

		int[][] array1 = new int[10][10];
	

		for(int i = 0; i < 5; i++){

			placeAship(x, y, array1);
		}	
		printArraySum(array1);

		for(int i = 0; i < 5; i++){
			placeAshipPC(x, y, array1);
		}	
		printArraySum(array1);
	}


	// Display the array content
	public static void printArraySum(int arraySum[][]){

		// Display the first row of the map
		System.out.print(" ");
		for(int i = 0; i < arraySum.length; i++){
			System.out.print(" " + i + " ");
		}

		System.out.println();
		for (int i = 0; i < arraySum.length; i++){
			System.out.print(i);
			for (int j = 0; j < arraySum[i].length; j++){
				// if the element in the array equal to 1 (Player) or 2 (PC)
				// the console will display the @ instead
				if (arraySum[i][j] == 1 || arraySum[i][j] == 2 )
					System.out.print(" " + '@' + " " );
				else
					System.out.print(" " + ' ' + " " );


				if (j == arraySum.length-1)
					System.out.print(i);
			}
			System.out.println();
		}

		// Display the last row of the map
		System.out.print(" ");
		for(int i = 0; i < arraySum.length; i++){
			System.out.print(" " + i + " ");
			// System.out.println();
		}

			System.out.println();


	}


	// User enter X-coordinate
	public static int inputX(){
		Scanner reader = new Scanner(System.in);

		int x;
		System.out.print("Enter x: ");
		x = reader.nextInt();
		//x = reader.next().charAt(0);

		return x;
	}

	// User input Y-coordinate
	public static int inputY(){
		Scanner reader = new Scanner(System.in);

		int y;
		System.out.print("Enter y: ");
		y = reader.nextInt();
		// y = reader.next().charAt(0);

		return y;
	}

	// Program generate X-coordinate for PC
	public static int inputPCx(){
		Random rand = new Random();
		int randX = rand.nextInt(10);

		return randX;		
	}

	// Program generate Y-coordinate for PC
	public static int inputPCy(){
		Random rand = new Random();
		int randY = rand.nextInt(10);

		return randY;	
	}

	// Check if it is a valid coordinate X & Y
	public static boolean checkValid(int x, int y, int arraySum[][]){
		if (x > 0 && x < 10){
			if (y > 0 && y < 10){
				if (arraySum[x][y] == 0){
					return true;
				}
				return false;
			}
			return false;
		}

		else{
			return false;
		}
	}


	public static void placeAship(int x, int y, int arraySum[][]) {
		boolean status = false;

		while(status == false){
			// x = inputPCx();
			// y = inputPCy();
			x = inputX();
		    y = inputY();

			status = checkValid(x,y,arraySum);
			if (status == false){
				System.out.println("Invalid coordinate!");
			}
			else{
				arraySum[x][y] = 1;
			}

		}

	}

	public static void placeAshipPC(int x, int y, int arraySum[][]) {
		boolean status = false;

		while(status == false){
			x = inputPCx();
			y = inputPCy();
			// x = inputX();
		    // y = inputY();

			status = checkValid(x,y,arraySum);
			if (status == false){
				System.out.println("Invalid coordinate!");
			}
			else{
				arraySum[x][y] = 2;
			}

		}

	}

}
//LR1 @ labrat1i

//bad operand types for binary operator ' ' -- because compare different dataType
// Why the loop repeat infinite time when I put the inputPCx and inputPCy in 
// for loop in main funcion. But it works when I put it inside the function