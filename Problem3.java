/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 3
 */

package net.lumadevelopment.comp;

import java.util.Scanner;

public class Problem3 {
	
	public static boolean isInteger(String s) {
		if(s.isEmpty()) return false;
		for(int i = 0; i < s.length(); i++) {
			if(i == 0 && s.charAt(i) == '-') {
				if(s.length() == 1) return false;
				else continue;
			}
			if(Character.digit(s.charAt(i), 10) < 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean done = false;
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[15];
		int arrayEnd = -1;
		
		while(!done) {
			System.out.println("Enter integers separated by a space. You must have 2-15 numbers greater than zero. End with 0: ");
			String input = scan.nextLine();
			String[] values = input.split(" ");
			
			if(values.length < 3 || values.length > 16) {
				System.out.println("You must have 2-15 numbers greater than zero!");
			}else {
				boolean endloop = false;
				
				for(int i = 0; i < values.length; i++) {
					if(!endloop) {
						if(i == (values.length - 1) && isInteger(values[i])) {
							Integer last = Integer.valueOf(values[i]);
							if(last != 0) {
								System.out.println("Last entry is not a 0, making input invalid!");
							}else {
								arrayEnd = i+1;
							}
						}else {
							if(!isInteger(values[i])) {
								System.out.println("Entry " + (i+1) + " is not an integer!");
								endloop = true;
							}
						}
					}
				}
				
				if(arrayEnd != -1) {
					for(int i = 0; i < (arrayEnd - 1); i++) {
						numbers[i] = Integer.valueOf(values[i]);
					}
					
					done=true;
					System.out.println("Array of numbers is valid, proceeding.");
				}
			}
		}
		
		scan.close();
		arrayEnd -= 1;
		int highestDivided = -1;
		
		for(int i = 0; i < arrayEnd; i++) {
			for(int j = 0; j < arrayEnd; j++) {
				if(i != j) {
					int div = numbers[i] / numbers[j];
					if(div > highestDivided) {
						highestDivided = div;
					}
				}
			}
		}
		
		System.out.println("Highest value of any two numbers in the array divided together is " + highestDivided);
	}

}
