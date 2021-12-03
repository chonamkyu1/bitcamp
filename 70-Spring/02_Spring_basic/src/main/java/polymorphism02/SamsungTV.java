package polymorphism02;


public class SamsungTV implements TV {

	

	@Override
	public void powerOn() {
		System.out.println("전원ON");
	}

	@Override
	public void powerOff() {
		System.out.println("전원OFF");
	}

	@Override
	public void volumeUp() {
		System.out.println("소리크게");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("소리작게");
	}

	// ----------------------------------
	public void initMethod() {
		System.out.println(">> SamsungTV - initMethod() 실행");
	}

	public void destroyMethod() {
		System.out.println(">> SamsungTV - destroyMethod() 실행");
	}

}
