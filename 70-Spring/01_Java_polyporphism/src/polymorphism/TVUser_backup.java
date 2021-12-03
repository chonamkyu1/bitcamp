package polymorphism;

public class TVUser_backup {
	
	public static void main(String[] args) {
		//삼성TV 사용
//		SamsungTV tv = new SamsungTV();
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();TV.java
//		tv.powerOff();
		
		//LgTv 사용형태로 변경
		LgTV tv = new LgTV();
		tv.on();
		tv.off();
		tv.soundUp();
		tv.soundDown();
	}

}
