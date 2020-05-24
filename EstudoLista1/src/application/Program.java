package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Func;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		List<Func> func = new ArrayList<>();
		
		System.out.println("How Many Employee are you going to add? ");
		int number = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<number;i++) {
			System.out.println("Enter ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name: ");
			String name = sc.nextLine();
			System.out.println("Enter Salary: ");
			double salary = sc.nextDouble();
			func.add(new Func(name, id, salary));
			
		}
		
		System.out.println("Employees Id that you want to increase salary");
		int id = sc.nextInt();
		Func fun = func.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if(fun == null) {
			System.out.println("The ID does not exist!");
		}else {
			System.out.println("How Much Do You Intent to Increase? ");
			double percent = sc.nextDouble();
			fun.increaseSalary(percent);
		}
		
		//Listing Func
		System.out.println("List Of Employees");
		for(Func obj: func) {
			System.out.println(obj);
		}
		sc.close();
	}

}
