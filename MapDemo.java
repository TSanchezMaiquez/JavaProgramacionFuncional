package Comparator;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

	public static void main(String[] args) {

		List <String> names = List.of(
				
				"patricia", "antonio", "maria", "antonio", "raquel"
				);
		
		names.stream()
		//map elimina elementos repetidos
		.map(String::toUpperCase)
		.distinct()
		.sorted(Comparator.comparing(String::length))
		.forEach(System.out::println);
		
		
		List<Developer>developers = getDevelopers();
		
		developers.stream()
		//flatMap permite acceder a la lista que hay dentro de otra lista
		//y de esta forma poder realizar filtrados
					.flatMap(dev -> dev.getTasks().stream())
					.filter(task -> task.getHours() > 5)
					.forEach(System.out::println);
		
		
		
		List <Integer> list1 = List.of(1, 2, 3);
		List <Integer> list2 = List.of(4, 5, 6);
		List <Integer> list3 = List.of(7, 8, 9);
		
		List<List<Integer>> listOfLists =List.of(list1, list2, list3);
		
		//Igual que en el caso anterior, de todos los valores que guarda internamente
		//la lista de listas solo muestra aquellos que cumplen la condicion de filter	
		List<Integer> results =listOfLists.stream()
					.flatMap(Collection::stream)
					//peek ayuda a ver que esta pasando en ese momento en concreto
					.peek(System.out::println)
					.filter(num -> num >5)
					.peek(System.out::println)
					//sirve para modificar el valor guardado en una propiedad o variable
					//en este caso a realizado una operacion y a actualizado el valor de num= num*num
					.map(num -> num * num)
					.toList();
		System.out.println(results);
		
		List<String> strings = List.of("hola", "mundo", "java");

		
		//Cuando usamos un stream tenemos que volver a transformar esa información en una lista.
		List<String> uppercaseStrings = strings.stream()
		    .map(str -> str.toUpperCase())
		    .collect(Collectors.toList());

		System.out.println(uppercaseStrings);
		
		
		/*.flatMap(dev -> dev.getTasks().stream()) VS .flatMap(Collection::stream)
		 * dev -> ...... cuando estamos trabajando con clases que no forman parte de la biblioteca
		 * estandar de java
		 * collection::stream    cuando trabajamos con clases de la biblioteca de java*/
		
		
	}

	private static List<Developer>getDevelopers(){
		
		Task task1 = new Task(1L, "task1", 5);
		Task task2 = new Task(1L, "task2", 4);
		Task task3 = new Task(1L, "task3", 6);
		Developer dev1 = new Developer ("Dev1", 30, List.of(task1, task2, task3));
		
		Task task4 = new Task(1L, "task4", 2);
		Task task5 = new Task(1L, "task5", 10);
		Task task6 = new Task(1L, "task6", 7);
		Developer dev2 = new Developer ("Dev2", 30, List.of(task4, task5, task6));
		
		return List.of(dev1, dev2);
		
	}
	
}
