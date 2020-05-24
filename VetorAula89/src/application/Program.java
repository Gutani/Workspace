package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Register;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Register[] cadastro = new Register[10];
		
		//Reserves quantity
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<n; i++) {
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("Email: ");
			String email = sc.nextLine();
			System.out.println("Room that you choose: 0 to 9");
			int room = sc.nextInt();
			sc.nextLine();
			
			cadastro[room] = new Register(name, email);	
		}
		
		for(int i=0; i<10; i++) {
			if(cadastro[i]!=null) {
				System.out.println("Room " + i + ": "+ cadastro[i]);
				
			}
		}
		sc.close();
	}
}
