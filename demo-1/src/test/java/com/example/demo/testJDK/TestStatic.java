package com.example.demo.testJDK;

import org.junit.jupiter.api.Test;

import com.example.demo.dao.Student;

public class TestStatic {

	public static int a = 0;

	public final int b = 2;

	public static final int C = 4;
	
	public int d =5;
	
	public static String strStatic = "static";
	public static final String STRSTATICFINAL = "staticFinal";
	public final String strFinal = "final";
	
	public Student stu;
	
	public static Student stuStatic;
	
	public static final Student stuStaticFinal = new Student() ;
	
	public  final Student stuFinal = new Student() ;


	public static void testStatic() {

		
	}
	
	@Test
	public void testFinal() {
		stuStatic = new Student();
		
		System.out.println(stuStatic.toString());
	}
	
	@Test
	public void testParameter() {
		Student stuA = new Student();
		testParam(stuA);
		System.out.println(stuA);
	}
	
	public void testParam(Student stu) {
		System.out.println(stu.toString());
		stu.setName("谷少华");
		System.out.println(stu.toString());
	}
	@Test
	public void testSingleton() {
		Singleton singletonA = Singleton.getSingleton();
		Singleton singletonB = Singleton.getSingleton();
		System.out.println(singletonA.toString());
		System.out.println(singletonB.toString());
		singletonA.setId(12);
		singletonA.setName("谷少华");
		System.out.println(singletonA.toString());
		System.out.println(singletonB.singleton.toString());
		
	}
	
	static class Singleton{
		private volatile static Singleton singleton;
		
		private int id;
		private String name;
		
		private Singleton() {};
		
		public static Singleton  getSingleton() {
			if(singleton ==null) {
				synchronized (Singleton.class) {
					if(singleton ==null) {
						singleton = new Singleton();
					}
				}
			}
			return singleton;			
		}

		
		@Override
		public String toString() {
			return "Singleton [id=" + id + ", name=" + name + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public static void setSingleton(Singleton singleton) {
			Singleton.singleton = singleton;
		}	
	}
	
}