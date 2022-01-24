/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 7
 */

package net.lumadevelopment.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem7 {
	
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
		List<Integer> list = new ArrayList<Integer>();
		
		while(!done) {
			System.out.print("Enter count, integers separated by a space (integers must be greater than 0): ");
			String input = scan.nextLine();
			
			String[] input_a = input.split(" ");
			
			if(input_a.length > 1) {
				boolean allValid = true;
				
				for(int i = 0; i < input_a.length; i++) {
					if(!isInteger(input_a[i])) {
						allValid = false;
					}else {
						if(!(Integer.valueOf(input_a[i]) > 0)) {
							allValid = false;
						}
					}
				}
				
				if(allValid == true) {
					if(Integer.valueOf(input_a[0]) == (input_a.length - 1)) {
						System.out.println("Valid list, importing.");
						for(int i = 1; i < input_a.length; i++) {
							list.add(Integer.valueOf(input_a[i]));
						}
						done = true;
					}else {
						System.out.println("First number is not the amount of numbers, invalid list!");
					}
				}else {
					System.out.println("All data entered must be integers!");
				}
			}else {
				System.out.println("At least one value must be entered!");
			}
			
		}
		
		int occurrences = 0;
		
		for(int i = 0; i < list.size(); i++) {
			if(!(i == (list.size() - 1))) {
				boolean lowerToRight = false;
				for(int j = i+1; j < list.size(); j++) {
					if(list.get(i) > list.get(j)) {
						lowerToRight = true;
					}
				}
				
				if(lowerToRight) {
					occurrences += 1;
				}
			}
		}
		
		System.out.println(occurrences);
		
		scan.close();
	}

}
