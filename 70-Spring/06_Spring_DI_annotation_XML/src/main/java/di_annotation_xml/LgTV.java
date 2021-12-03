package di_annotation_xml;

import org.springframework.stereotype.Component;

@Component
public class LgTV implements TV {
	Speaker speaker = new Speaker() {
		
		@Override
		public void volumnUp() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void volumnDown() {
			// TODO Auto-generated method stub
			
		}
	};
	
	public void LgTV() {
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
		speaker.volumnUp();
		
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV - 소리작게");
		speaker.volumnDown();
	}
	public void initMethod() {
		System.out.println(">> SamsungTV - initMethod() 실행");
	}
	public void destroyMethod() {
		System.out.println(">> SamsungTV - destroyMethod() 실행");
	}

}
