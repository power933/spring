package AOP;

import lombok.Getter;
import lombok.Setter;

@Getter
public class aop_person {
	private String name;
	private String id;
	private String age;
	private int level;
	
	public aop_person(String name, String id, String age, int level) {
		this.name = name;
		this.id = id;
		this.age = age;
		this.level = level;
	}
}
