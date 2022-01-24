/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 5
 */

package net.lumadevelopment.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {
	
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
		boolean lo_done = false;
		boolean lt_done = false;
		Scanner scan = new Scanner(System.in);
		List<Integer> list_one = new ArrayList<Integer>();
		List<Integer> list_two = new ArrayList<Integer>();
		
		while(!lo_done) {
			System.out.print("Enter first set of data separated by space: ");
			String input = scan.nextLine();
			
			String[] input_a = input.split(" ");
			
			if(input_a.length > 1) {
				boolean allValid = true;
				
				for(int i = 0; i < input_a.length; i++) {
					if(!isInteger(input_a[i])) {
						allValid = false;
					}
				}
				
				if(allValid == true) {
					if(Integer.valueOf(input_a[0]) == (input_a.length - 1)) {
						System.out.println("Valid list 1, importing.");
						for(int i = 1; i < input_a.length; i++) {
							list_one.add(Integer.valueOf(input_a[i]));
						}
						lo_done = true;
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
		
		while(!lt_done) {
			System.out.print("Enter second set of data separated by space: ");
			String input = scan.nextLine();
			
			String[] input_a = input.split(" ");
			
			if(input_a.length > 1) {
				boolean allValid = true;
				
				for(int i = 0; i < input_a.length; i++) {
					if(!isInteger(input_a[i])) {
						allValid = false;
					}
				}
				
				if(allValid == true) {
					if(Integer.valueOf(input_a[0]) == (input_a.length - 1)) {
						System.out.println("Valid list 2, importing.");
						for(int i = 1; i < input_a.length; i++) {
							list_two.add(Integer.valueOf(input_a[i]));
						}
						lt_done = true;
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
		
		scan.close();
		
		List<Integer> not_in_both = new ArrayList<Integer>();
		
		for(int i = 0; i < list_one.size(); i++) {
			Integer number = list_one.get(i);
			
			if(!(list_one.contains(number) && list_two.contains(number))) {
				if(!not_in_both.contains(number)) {
					not_in_both.add(number);
				}
			}
		}
		
		for(int i = 0; i < list_two.size(); i++) {
			Integer number = list_two.get(i);
			
			if(!(list_one.contains(number) && list_two.contains(number))) {
				if(!not_in_both.contains(number)) {
					not_in_both.add(number);
				}
			}
		}
		
		String output = "";
		
		if(not_in_both.size() == 0) {
			output = "No differences";
		}else {
			for(int i = 0; i < not_in_both.size(); i++) {
				if(i == (not_in_both.size() - 1)) {
					output += not_in_both.get(i);
				}else {
					output += not_in_both.get(i) + " ";
				}
			}
		}
		
		System.out.println(output);
	}

}
