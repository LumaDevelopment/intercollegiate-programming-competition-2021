/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 6
 */

package net.lumadevelopment.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6 {

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
		List<Integer> previous_results = new ArrayList<Integer>();
		int number = -1;
		boolean conclusion_reached = false;
		boolean glad_number = false;
		
		while(!done) {
			System.out.print("Input number: ");
			String input = scan.nextLine();
			
			if(isInteger(input)) {
				Integer input_test = Integer.valueOf(input);
				if(input_test > 0) {
					number = input_test;
					System.out.println("Valid number.");
					done = true;
				}else {
					System.out.println("Input must be greater than 0!");
				}
			}else {
				System.out.println("Input must be an integer!");
			}
		}
		
		scan.close();
		
		while(!conclusion_reached) {
			String number_s = String.valueOf(number);
			String[] split = number_s.split("");
			
			int temp_total = 0;
			
			for(int i = 0; i < split.length; i++) {
				temp_total += Integer.valueOf(split[i])*Integer.valueOf(split[i]);
			}
			
			if(temp_total == 1) {
				glad_number = true;
				conclusion_reached = true;
			}else {
				if(previous_results.contains(temp_total)) {
					conclusion_reached = true;
				}else {
					previous_results.add(temp_total);
					number = temp_total;
				}
			}
			
		}
		
		if(glad_number) {
			System.out.println("Glad Number");
		}else {
			System.out.println("Not a Glad Number");
		}
		
	}
	
}
