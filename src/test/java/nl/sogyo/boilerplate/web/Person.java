package nl.sogyo.boilerplate.web;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {

	@NotNull
	private String name;

	private double someDouble;

	private boolean someBoolean;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;
		return this;
	}

	public double getSomeDouble() {
		return someDouble;
	}

	public Person setSomeDouble(double someDouble) {
		this.someDouble = someDouble;
		return this;
	}

	public boolean isSomeBoolean() {
		return someBoolean;
	}

	public Person setSomeBoolean(boolean someBoolean) {
		this.someBoolean = someBoolean;
		return this;
	}
}