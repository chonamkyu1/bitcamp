package com.mystudy.exception3_sungjuk;

// 자바빈(Java bean) 형태의 클래스 작성
// VO(Value Object) : 값을 저장하기 위한 클래스(객체) - xxxVo, xxxVo
// DTO(Data Transfer Object) : 값을 저장해서 전달하기 위한 클래스(객체) - xxxDTO, xxxDto 
public class StudentVO {
	// 필드 선언 -----------------------
	// 성명 - name : String
	// 국어 - kor : int
	// 영어 = eng : int
	// 수학 = math : int
	// 총점 = tot : int
	// 평균 = avg : double

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	// 생성자 선언 ----------------------------
	// 생성자 - 성명, 국어, 영어, 수학 점수를 입력받는 생성자 -> 파라미터값에 넣어준다
	// 총점, 평균 계산처리 computeToAvg() 사용
	//public StudentVO() { //생성자는 클래스명 
		
	//}
	
	//public StudentVO(String name) {
		//this.name = name;
	//}

	public StudentVO(String name, int kor, int eng, int math) {
		super(); // 오브젝트 클래스 생성자를 가져와서 쓴다 ,사용해도되고 안해도된다
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		computeToAvg();
	}

	
		
	

	// setter, getter 메소드 선언 ----------------------------
	// 국어, 영어, 수학 점수가 변경되면 총점, 평균 재계산 처리
	// 점수는 0~100까지의 값만 입력처리
	// 데이터를 전달할땐 set메소드호출
	// 값을(데이터) 가지고올때는 get메소드 호출
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}
	// 호출한 곳으로 예외 던지기(throws)
	public void setKor(int kor) throws JumsuOutOfValueException { // 발생 예외 던지기
		if (kor >= 0 && kor <= 100) {
			this.kor = kor;
			computeToAvg();  //나중에 값 출력시 총점, 평균값 계산해준다.
		} else {
			//System.out.println("잘못된점수입니다.");
			throw new JumsuOutOfValueException(); // 예외 발생시키고 던지기
		}
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if (eng >= 0 && eng <= 100) {
			this.eng = eng;
			computeToAvg();   //나중에 값 출력시 총점, 평균값 계산해준다.
		} else {
			System.out.println("잘못된점수입니다.");
		}
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		if (math >= 0 && math <= 100) {
			this.math = math;
			computeToAvg();   //나중에 값 출력시 총점, 평균값 계산해준다.
		} else {
			System.out.println("잘못된점수입니다.");
		}
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	//================================================================
	public void computeToAvg() {
		tot = kor + eng + math;
		avg = tot * 100 / 3 / 100.0;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", tot=" + tot + ", avg="
				+ avg  + "]";
	}
	
	// 화면에 데이터 출력하는 메소드
	public void printData() {
		System.out.println(name + "\t" + kor + "\t" + eng + "\t" + math + "\t"
			+tot + "\t" + avg);
	}
	
}
