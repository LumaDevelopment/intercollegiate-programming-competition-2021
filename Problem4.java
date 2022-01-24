/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 4
 */

package net.lumadevelopment.comp;

import java.util.Scanner;

public class Problem4 {
	
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
		int x = 0;
		int y = 0;
		
		while(!done) {
			System.out.print("Enter X and Y separated by a space: ");
			String input = scan.nextLine();
			String[] s_input = input.split(" ");
			if(s_input.length == 2) {
				if(isInteger(s_input[0]) && isInteger(s_input[1])) {
					int xt = Integer.valueOf(s_input[0]);
					int yt = Integer.valueOf(s_input[1]);
					
					if(xt != 0 && yt != 0) {
						x = xt;
						y = yt;
						
						done = true;
					}else {
						System.out.println("Neither coordinate can be 0!");
					}
				}else {
					System.out.println("Both coordinates must be integers!");
				}
			}else {
				System.out.println("Must have 2 coordinates!");
			}
		}
		
		scan.close();
		int quadrant = 0;
		
		if(x == 0 & y == 0) {
			System.out.println("CRITICAL PROGRAM FAILURE");
		} else if(x > 0 && y > 0) {
			quadrant = 1;
		} else if(x < 0 && y > 0) {
			quadrant = 2;
		} else if(x < 0 && y < 0) {
			quadrant = 3;
		} else {
			quadrant = 4;
		}
		
		System.out.println("Q " + quadrant);
	}

}
