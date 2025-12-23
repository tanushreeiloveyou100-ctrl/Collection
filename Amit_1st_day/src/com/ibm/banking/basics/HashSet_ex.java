package com.ibm.banking.basics;
import java.util.HashSet;
import java.util.Scanner;

public class HashSet_ex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> st = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many elements you want to add? ");
		int n = sc.nextInt();
		
		sc.nextLine(); 
		
		while(n > 0){
			System.out.println("Enter the element to be added: ");
		    int element = sc.nextInt();
			appendLast(st, element);
			n--;
		}
		
		System.out.println("The size of the HashSet is: " + st.size());
		
	}

    public static void appendLast(HashSet<Integer> st, int element) {
    	st.add(element);
    }

}
