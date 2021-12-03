package com.mystudent.bean;

public class StudentMain {
	public static void main(String[] args) {
		Student stu = new Student();
		//stu.name = "홍길동";
	stu.setName("홍길동");
	System.out.println("name: " + stu.getName());
	
	stu.setKor(100); //private로 변수선언하면 setter 처리되어야만 사용가능하다
	stu.setEng(90);
	stu.setMath(81);
	
	int tot = stu.getKor() + stu.getEng() + stu.getMath();
	stu.setTot(tot);
	
	double avg = stu.getTot()  * 100 / 3 / 100.0;
	System.out.println("avg: " + avg);
	stu.setAvg(avg); //90.33
	// stu.setAvg(100); 값을 의미대로 바꿀수도 있다. 임의대로 잘못된 점수를 바꿀수있는데
	
	
	System.out.println(stu);
	
	Student stu2 = new Student("김유신", 100, 90, 82);
	System.out.println(stu2);
	
	stu2.setKor(200);
	System.out.println(stu2);
	
	
	
	
	
	
	}
}
