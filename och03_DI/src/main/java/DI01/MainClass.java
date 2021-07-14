package DI01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		MyCalculator myCalculator = new MyCalculator();
	//		Calculator calculator = new Calculator();
	//		myCalculator.setCalculator(calculator); 이 두줄이 아래의 한줄과 동일!
//		myCalculator.setCalculator(new Calculator());
//		myCalculator.setFirstNum(10);
//		myCalculator.setSecondNum(2);
//		
//		myCalculator.add();
//		myCalculator.sub();
//		myCalculator.mul();
//		myCalculator.div();
		
// 		DI 구현
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
		myCalculator.add();
		myCalculator.sub();
		myCalculator.mul();
		myCalculator.div();
	}

}
