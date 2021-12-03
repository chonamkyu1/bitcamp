package polymorphism02;

public class SamsungTV implements TV{
	private SonySpeaker speaker;
	private int price;
	private int width;
	private int heigth;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}
	
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(SonySpeaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.heigth = height;
	}



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
		speaker.volumnUp();
	}

	@Override
	public void volumeDown() {
		System.out.println("소리작게");
		speaker.volumnDown();

	}
	
	// ----------------------------------
	public void initMethod() {
		System.out.println(">> SamsungTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println(">> SamsungTV - destroyMethod() 실행");
	}


	@Override
	public String toString() {
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", heigth=" + heigth + "]";
	}


	
	
	

}
