package com.ibm.banking.basics;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedList_exercise {

	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many elements you want to add? ");
		int n = sc.nextInt();
		
		sc.nextLine(); 
		
		while(n > 0){
			System.out.println("Enter the element to be added: ");
			String element = sc.nextLine();
			appendLast(list, element);
			n--;
		}
		
		System.out.println("The Linkedlist is: ");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + (i < list.size() - 1 ? " -> " : " -> null"));
		}
		
		sc.close();
	}
	
	public static void appendLast(List<String> list, String element){
		list.add(element);
	}
}
