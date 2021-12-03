package di_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component : 객체 생성
// @Component : 명칭 생략시 samsungTV 명칭 사용 (클래스 명칭 사용, 첫글자는 소문자) 
@Component("tv") // tv 라는 명칭으로 객체 생성
public class SamsungTV implements TV{
	@Autowired // 동일한 데이터 타입을 찾아서 주입
	@Qualifier("sony")
	private Speaker speaker;
	private int price;
	private int width;
	private int height;
	
	public SamsungTV() {
		System.out.println(">> SamsungTV 객체 생성");
	}
	
	
	public SamsungTV(Speaker speaker) {
		System.out.println(">> SamsungTV(speaker) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println(">> SamsungTV(speaker, price) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	public SamsungTV(Speaker speaker, int width, int height) {
		System.out.println(">> SamsungTV(speaker, width, height) 객체 생성");
		this.speaker = speaker;
		this.width = width;
		this.height = height;
	}
	/*
	 * public SamsungTV(Speaker speaker,int price, int width, int height) {
	 * System.out.println(">> SamsungTV(speaker,price, width, height) 객체 생성");
	 * this.speaker = speaker; this.price = price; this.width = width; this.height =
	 * height; }
	 */



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
		return "SamsungTV [speaker=" + speaker + ", price=" + price + ", width=" + width + ", height=" + height + "]";
	}


	// ======== getter / setter  생성 ============
	public Speaker getSpeaker(Speaker speaker) {
		return speaker;
	}


	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getheight() {
		return height;
	}


	public void setheight(int height) {
		this.height = height;
	}


	
	
	

}
