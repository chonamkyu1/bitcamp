package wapper;

public class Ex01_Wrapper_class {
	public static void main(String[] args) {
		// wrapper class : 기본 데이터타입의 기능확장한 클래스 총칭
		// 기본데이터 타입 : 전체 소문자 char, int .... 등등
		// boolean, char, byte, short, int, long, float, double
		// wrapper class : 기본데이터 타입의 첫글자를 대문자로
		// 예외 : char -> Character , int -> Integer
		// Boolean, Character, Byte, Short, Integer, Long, Float, Double
		// --------------------------------------------------------------
		
		int num = 100;
		//num = "100";
		
		//Integer intNum = new Integer(100);
		Integer intNum = 100; // 자동형변환 Integer <- int
		
		//intNum = new Integer("100");
		intNum = Integer.valueOf("100"); // Integer <- String
		
		num = Integer.parseInt("100"); // int <- String
		
		intNum = 900; // Integer <- int : 자동형변환
		num = intNum; // int <- Integer : 자동형변환
		
		System.out.println("정수형 int 최대값 : " +  Integer.MAX_VALUE); 
		System.out.println("정수형 int 최소값 : " +  Integer.MIN_VALUE); 

		System.out.println("---------- Boolean ----------");
		Boolean bool = true;
		bool = new Boolean(true);
		bool = new Boolean("true"); // true : true , TRUE , True , tRue
		System.out.println("bool : " + bool);
	
		bool = new Boolean("true1"); // 참(true) 을 의미하는 영단어가 아니면 모두 false 
		System.out.println("bool : " + bool);
		                                                    
		System.out.println(Boolean.TRUE);
		System.out.println(Boolean.FALSE);
		
		System.out.println("--- String -> Boolean ---");
		bool =  Boolean.valueOf("true");
		System.out.println("Boolean.valueOf(\"true\"): " + bool);
		bool =  Boolean.valueOf("TRUE");
		System.out.println("Boolean.valueOf(\"TRUE\"): " + bool);
		bool =  Boolean.valueOf("true1");
		System.out.println("Boolean.valueOf(\"true1\"): " + bool);
		
		//==========================================================
		System.out.println("----- Float, Double 동일 -----");
		Float f = 10.5f; // Float <- float : 자동형변환
		f = new Float(12.5f);
		f = new Float("12.5f");
		
		//Float <- String  형변환
		f = Float.valueOf("12.5f");
		System.out.println("f: " + f);  //이건 숫자
		
		// String <- Float 형변환
		String str = String.valueOf(f);
		System.out.println("str: " + str); // 이건 문자
		// ---------------------------------------------
		Double d = 10.5d; // Double <- double 자동형변환
		d = new Double(12.5d);
		d = new Double("12.5d");
	
		// String <- Double
		str = String.valueOf(d);
		System.out.println("str: " + str);
		
		// Double <- String
		d = Double.valueOf("12.5");
		d = Double.valueOf(str);
		System.out.println("d: " + d);
		
		
	}
}
