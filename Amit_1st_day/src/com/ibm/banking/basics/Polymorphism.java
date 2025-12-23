package com.ibm.banking.basics;

public class Polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal animal = new Animal();
		Bird bird = new Bird();
		Cat cat = new Cat();
		
		bird.Sound();
		cat.Sound();

	}

}
