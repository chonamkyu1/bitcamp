package com.mystudy.poly2_overriding;

public class TypeTest {

	public static void main(String[] args) {
		Animal an = new Animal();
		Dog dog = new Dog();
		Pig pig = new Pig();
		Cat cat = new Cat();
		
		dog.sound();
		pig.sound();
		cat.sound();
		
		
		System.out.println("------ sound() 호출 ------");
		sound(dog);
		sound(pig);
		sound(cat);
		
	}
	// 메소드 오버라이딩 활용
	static void sound(Animal animal) {
		animal.sound(); 
	}
	// animal의 울음없음이 출력되는것이아니라 그 밑에 자녀클래스인 dog, pig 울음이 출력된다.	
	
	
/*
	// 다형성 적용 : 형변환 후 
	static void sound(Animal animal) {
		if (animal instanceof Dog) {
			((Dog)animal).sound();
		}
		if (animal instanceof Pig) {
			((Pig)animal).sound();
		}
		
	}
*/	
//	
//	static void sound(Dog dog) {
//		dog.sound();
//	}
//	
//	static void sound(Pig pig) {
//		pig.sound();
//	}
//	
	
	
	
	
	
	
	
}
