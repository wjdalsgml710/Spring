package sdlc01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class OtherStudent {
	private String name;
	private int age;
	
	@PostConstruct
	public void initMethod() {  // 응애
		System.out.println("OtherStudent의 initMethod() 생성자 생성이후");
	}
	
	@PreDestroy
	public void destoryMethod() {
		System.out.println("OtherStudent의 destoryMethod() 소멸자가 소멸되기전..");
	}

	public OtherStudent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
