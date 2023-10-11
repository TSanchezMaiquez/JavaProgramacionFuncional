package Comparator;

import java.util.List;

public class Developer {

	
	private String name;
	private Integer age;
	private List<Task> tasks;
	
	public Developer (String name, int age, List<Task> tasks) {
		this.name= name;
		this.age= age;
		this.tasks=tasks;
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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
	@Override
	public String toString() {
	    return "Developer{" +
	            "name='" + name + '\'' +
	            ", age=" + age +
	            ", tasks=" + tasks +
	            '}';
	}

	
}
