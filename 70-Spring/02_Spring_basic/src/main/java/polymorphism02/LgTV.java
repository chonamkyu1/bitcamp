package polymorphism02;

public class LgTV implements TV {
	
	public LgTV() {
		System.out.println(">> LgTV 객체 생성");
	}
	

	@Override
	public void powerOn() {
		System.out.println("LgTV - 전원ON");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV - 전원OFF");
		
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV - 소리크게");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게");
		
	}
	public void initMethod() {
		System.out.println(">> SamsungTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println(">> SamsungTV - destroyMethod() 실행");
	}

}
