package Comparator;

import java.util.List;

public class takeWhile_dropWhile {
	
	public static void main (String [] args ) {
	
		
		List <Developer> devs = getDevelopers();
		
		devs.stream()
			.flatMap(dev -> dev.getTasks().stream())
			//muestra las tareas de menos de o iguales a 6 horas
			.takeWhile(task -> task.getHours() <=6).forEach(System.out::println);
		
		devs.stream()
		  .flatMap(dev -> dev.getTasks().stream())
		  //elimina las tareas de menos de o iguales a 6 horas
		  .dropWhile(task -> task.getHours() <=6).forEach(System.out::println);
		
	}

	
private static List<Developer>getDevelopers(){
		
		Task task1 = new Task(1L, "task1", 5);
		Task task2 = new Task(1L, "task2", 4);
		Task task3 = new Task(1L, "task3", 6);
		Developer dev1 = new Developer ("Dev1", 20, List.of(task1, task2, task3));
		
		Task task4 = new Task(1L, "task4", 2);
		Task task5 = new Task(1L, "task5", 10);
		Task task6 = new Task(1L, "task6", 7);
		Developer dev2 = new Developer ("Dev2", 30, List.of(task4, task5, task6));
		
		return List.of(dev1, dev2);
		
	}
	
}
