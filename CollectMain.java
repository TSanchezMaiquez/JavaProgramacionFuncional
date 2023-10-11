package Comparator;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectMain {

	public static void main(String[] args) {
		
		List <Product>products = new ArrayList <> (List.of(
				new Product("1", "product1", 9.99, false),
				new Product("2", "product2", 5.99, false),
				new Product("3", "product3", 39.99, false),
				new Product("4", "product4", 19.99, false)
				));
		
		//Tipo de arrayList que no permite elementos repetidos
		Set <Product>productsSet= products.stream()
				.filter(product -> product.getPrice() > 10)
				//interface. El metodo toSet devuelve el set de productos
				.collect(Collectors.toSet());
		
		//Tipo de arrayList que no permite elementos repetidos
		String names = products.stream()
				.filter(product -> product.getPrice() > 7)
				//se llama al metodo getName de la clase Product
				.map(Product ::getName)
				.collect(Collectors.joining(", "));
		
		System.out.println(names);
		
		DoubleSummaryStatistics stats = products.stream()
					.collect(Collectors.summarizingDouble(Product::getPrice));
		
		System.out.println(stats.getCount());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		System.out.println(stats.getAverage());
		System.out.println(stats.getSum());
		
		
		List <Developer> devs = getDevelopers();
		
		
		/*Se le pasan dos parámetros: 
		 * Integer: permite agrupar los elementos por el parametro declarado dentro del groupingBy, 
		 * en este caso la edad
		 * Lista: una lista de la clase Developer, de la que se utilizara el método getAge*/
		Map<Integer, List<Developer>> devGroups = devs.stream()
				.collect(Collectors.groupingBy(Developer::getAge));
		
		System.out.println(devGroups);
		
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
		
		Developer dev3 = new Developer ("Dev3", 30, List.of());
		
		return List.of(dev1, dev2, dev3);
		
	}

}
