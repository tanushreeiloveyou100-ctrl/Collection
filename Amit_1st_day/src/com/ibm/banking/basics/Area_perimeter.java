package com.ibm.banking.basics;
import java.lang.Math;
import java.util.Scanner;

public class Area_perimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final double radius;
		
		System.out.println("The radius of the circle is: ");
		
		radius = sc.nextDouble();
		
		//area
		System.out.println("Area of the circle is: " + Math.PI*radius*radius);
		//perimeter
		System.out.println("The perimeter of the circle is: " + 2*Math.PI*radius);
		
		
	}

}
