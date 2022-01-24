/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 8
 */

package net.lumadevelopment.comp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Problem8 {

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
		int target = Integer.MAX_VALUE;
		List<Integer> list = new ArrayList<Integer>();
		List<String> outputs = new ArrayList<String>();
		HashMap<Integer, Integer> found_pairs = new HashMap<Integer, Integer>();
		
		while(!done) {
			System.out.print("Enter the desired sum, number of elements, each element: ");
			String input = scan.nextLine();
			
			String[] input_a = input.split(" ");
			
			if(input_a.length > 3) {
				boolean allValid = true;
				
				for(int i = 0; i < input_a.length; i++) {
					if(!isInteger(input_a[i])) {
						allValid = false;
					}
				}
				
				if(allValid == true) {
					if(Integer.valueOf(input_a[1]) == (input_a.length - 2)) {
						System.out.println("Valid list, importing.");
						for(int i = 2; i < input_a.length; i++) {
							list.add(Integer.valueOf(input_a[i]));
						}
						target = Integer.valueOf(input_a[0]);
						done = true;
					}else {
						System.out.println("Second number is not the amount of numbers, invalid list!");
					}
				}else {
					System.out.println("All data entered must be integers!");
				}
			}else {
				System.out.println("At least one target, the number of elements, and one pair must be entered!");
			}
		}
		
		scan.close();
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(i != j) {
					if((list.get(i)+list.get(j)) == target) {
						boolean alreadyExists = false;
						
						if(found_pairs.keySet().contains(j)) {
							if(found_pairs.get(j) == i) {
								alreadyExists = true;
							}
						}
						
						if(!alreadyExists) {
							outputs.add("(" + list.get(i) + ", " + list.get(j) + ") found at [" + String.valueOf(i+1) + "][" + String.valueOf(j+1) + "]");
							found_pairs.put(i, j);
						}
					}
				}
			}
		}
		
		if(outputs.size() == 0) {
			System.out.println("No pairs found");
		}else {
			for(int i = 0; i < outputs.size(); i++) {
				System.out.println(outputs.get(i));
			}
		}
	}
	
}
