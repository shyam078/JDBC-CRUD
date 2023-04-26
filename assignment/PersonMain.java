package Com.Advance.assignment;

import java.util.Scanner;

public class PersonMain {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		/*PersonCRUDOperation.savePerson(3, "prasad", 9874563210L, 21, "abcdefg@gmail.com", "abcd@123");
		System.out.println("---------------------");*/
		PersonCRUDOperation.getPersonById(1);
		System.out.println("-------------------");
		PersonCRUDOperation.getAllPerson();
		System.out.println("----------------------");
		PersonCRUDOperation.validateByEmail("Shyamprasad5259@gmail.com", "Shyam@996");
		System.out.println("----------------------");
		PersonCRUDOperation.validateByPhone(9963705259L, "shyam@996");
	}

}
