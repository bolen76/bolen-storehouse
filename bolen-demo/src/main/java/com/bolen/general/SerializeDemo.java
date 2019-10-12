package com.bolen.general;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializeDemo {
					
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String s="hello";
		Person p=new Person("bolen", 33, "wuhan");
		FileWriter fileWriter = new FileWriter("a.txt");
		OutputStream outputStream = new FileOutputStream("a.txt");
		ObjectOutputStream oos=new ObjectOutputStream(outputStream);
		oos.writeObject(s);
		oos.writeObject(p);
		
		
		InputStream inputStream = new FileInputStream("a.txt");
		ObjectInputStream ois=new ObjectInputStream(inputStream);
		Object readObject = ois.readObject();
		Object per = ois.readObject();
		System.out.println(readObject);
		
		System.out.println(readObject==s);
		
		
		System.out.println(per);
		
		System.out.println(per==p);
		
	}
	
	
	private static class Person implements Serializable{
		
		
		public Person(String name, int age, String address) {
			super();
			this.name = name;
			this.age = age;
			this.address = address;
		}

		String name;
		
		int age;
		
		transient String address;
		
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
		}
		
		
		
		
	}
}
