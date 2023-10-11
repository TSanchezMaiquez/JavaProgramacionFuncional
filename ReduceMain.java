package Comparator;

import java.util.List;

public class ReduceMain {

	public static void main(String[] args) {
		List <Integer> numbers = List.of(1,2,3,4,5,6,7);
		
		Integer aux =0;
		for (Integer number: numbers) {
			aux+= number;
		}
		
		
		//Ambas lineas dan el mismo resultado, pero el segundo mas simplificado
		//numbers.stream().reduce(0, (num1, num2) -> num1 + num2);
		Integer sum = numbers.stream().reduce(0, Integer::sum);
		
		System.out.println(sum);
		
		Integer multiplication = numbers.stream().reduce(0, (num1, num2) -> num1 *num2);
		System.out.println(multiplication);
		
		System.out.println(numbers.stream().reduce(Integer::max));
		
		
		
	}

}
