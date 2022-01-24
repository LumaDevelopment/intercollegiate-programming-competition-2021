/*
 * Joshua Sheldon
 * Eastern Florida State College
 * Blue Track
 * Problem 1
 */

package net.lumadevelopment.comp;

import java.util.Scanner;

public class Problem1 {

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
		boolean validInput = false;
		Scanner scan = new Scanner(System.in);
		String kwhu_i;
		Integer kwhu = 0;
		
		while(!validInput) {
			System.out.println("Input kilowatt hours used (integer greater than 0): ");
			kwhu_i = scan.nextLine();
			
			if(isInteger(kwhu_i)) {
				kwhu = Integer.valueOf(kwhu_i);
				
				if(kwhu > 0) {
					validInput = true;
				}else {
					System.out.println("Integer equal to or less than 0! Enter an integer greater than 0.");
				}
				
			}else {
				System.out.println("Not an integer! Enter an integer greater than 0.");
			}
		}
		
		scan.close();
		
		double totalCost;
		
		if(kwhu <= 1000) {
			totalCost = kwhu * 7.633;
		} else {
			int remainder = kwhu - 1000;
			totalCost = 7.633*1000;
			totalCost += remainder*9.259;
		}
		
		totalCost = totalCost / 100;
		
		System.out.printf("Amount owed is $%.5f %n", totalCost);
		
	}
	
}
