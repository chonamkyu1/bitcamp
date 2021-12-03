package polymorphism;

import polymorphism2.TV;

public class LgTV implements TV{
	
	public void on() {
		System.out.println("LgTV - 전원ON");
	}
	
	public void off() {
		System.out.println("LgTV - 전원OFF");
	}
	
	public void soundUp() {
		System.out.println("LgTV - 소리크게");
	}
	
	public void soundDown() {
		System.out.println("LgTV - 소리크게");
	}

	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
	}

}
