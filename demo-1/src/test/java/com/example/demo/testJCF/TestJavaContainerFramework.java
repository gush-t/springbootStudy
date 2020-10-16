package com.example.demo.testJCF;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

public class TestJavaContainerFramework {
	
	/**
	 * List 测试学习
	 */
	@Test
	public void testArraylist() {
		ArrayList<String> testArrayList = new ArrayList<>();
		testArrayList.add("gu");
		testArrayList.add("shao");
		testArrayList.add("hua");
		for (String string : testArrayList) {
			System.out.println(string);
		}
		testArrayList.stream().forEach(System.out::println);
		Collections.sort(testArrayList, (str1,str2) -> str1.compareTo(str2));
		Iterator<String> iterator = testArrayList.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
			iterator.remove();
		}
		testArrayList.add(0,"nihao");
		testArrayList.set(0, "I your father");
		for (String string : testArrayList) {
			System.out.println(string);
		}
		ArrayList<String> retainList = new ArrayList<>();
		retainList.add(0,"shao");
		retainList.add(0, "good");
		retainList.addAll(testArrayList);
		retainList.set(0, "I your mother");
		//testArrayList.retainAll(retainList);
		for (String string : retainList) {
			System.out.println(string);
		}
		
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student(201401L, 669));
		stuList.add(new Student(201402L, 690));
		stuList.add(new Student(201403L, 666));
		stuList.add(new Student(201403L, 665));
		System.out.println("distinct");
		stuList.stream().distinct().forEach(System.out::println);
		//Sort
		System.out.println("sorted");
		stuList.stream().sorted().forEach(System.out::println);
		Collections.reverse(stuList);
		ArrayList<Student> capaCity = new ArrayList<>(10000);
		Collections.fill(capaCity, new Student(201488L, 899));
		System.out.println("hello world");
		capaCity.stream().forEach(System.out::println);
		//stuList.stream().sorted((stu01,stu02) ->stu01.getStuAge().compareTo(stu02.getStuAge())).forEach(System.out::println);		
		
		
	}
	
	@Test
	public void testSet() {
		Student stu01 = new Student(201403L, 666);
		Student stu02 = new Student(201403L, 666);
		System.out.println(stu01.equals(stu02));
		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student(201401L, 666));
		stuList.add(new Student(201402L, 666));
		stuList.add(new Student(201403L, 666));
		stuList.add(new Student(201403L, 666));	
		Collections.fill(stuList, new Student(2014L, 888));
		HashSet<Student> stuHashSet = new HashSet<>();
		stuHashSet.addAll(stuList);
		stuHashSet.add(new Student(201403L, 666));
		assertThat(2).isEqualTo(stuHashSet.size());
		for (Student student : stuHashSet) {
			System.out.println(student.toString());
		}
		System.out.println("stream forEach");
		stuHashSet.stream().forEach(System.out::println);
		System.out.println("iterator");
		Iterator<Student> iterator = stuHashSet.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		assertThat(true).isEqualTo(stuList.get(2).equals(stuList.get(3)));
		
		// TreeSet 
		
		TreeSet<Student> stuTreeSet = new TreeSet<>();
		
	}
	
	@Test
	public void testMap() {
		HashMap<Integer, Student> stuMap = new HashMap<>();
		stuMap.put(1, new Student());
		stuMap.put(2, new Student());
		stuMap.put(3, new Student());
		stuMap.put(4, new Student());
		stuMap.put(5, new Student());
		stuMap.putIfAbsent(8, new Student());
		stuMap.putIfAbsent(5, new Student());
		
		//foreach entrySet
		 Iterator<Entry<Integer, Student>> iterator = stuMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Student> next = iterator.next();
			System.out.println("key:"+next.getKey());
			System.out.println("value:"+next.getValue());
		}
		Iterator<Integer> iterator2 = stuMap.keySet().iterator();
		while (iterator2.hasNext()) {
			Integer integer = (Integer) iterator2.next();
			System.out.println("key:"+integer+" value:"+stuMap.get(integer));
		}
		
	}
	
	@Test
	public void testGenericityJunit() {
		Student stu  = new Student();
		 Student work = TestGenericity.work(stu);
	}
	
	@Test
	public void testFatherSonExecuteOrder() {
		Son son  = new Son();
		son.msg();
		System.out.println(son.getClass());
		System.out.println(son.getClass().getSimpleName());
		Father father = son;
		father.msg();
	}
}

class Father{
	static final int a =1;
	int c;
	static int b = 2;
	
	static {
		System.out.println("父类静态代码块");
	}
	
	static void fatherMethod() {
		System.out.println("父类静态方法");
	}
	
	public  Father() {
		System.out.println("父类无参构造");
		System.out.println(c);
	}
	
	public void msg() {
		System.out.println("父类普通方法");
	}
}

class Son extends Father{
static final int a =1;
	int c;
	static int b = 2;
	
	static {
		System.out.println("子类静态代码块");
	}
	
	static void sonMethod() {
		System.out.println("子类静态方法");
	}
	
	public  Son() {
		System.out.println("子类无参构造");
		System.out.println(c);
	}
	
	@Override
	public void msg() {
		System.out.println("子类普通方法");
	}
}


class Student implements Serializable,Comparable<Student>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long stuNo;
	
	private String stuName;
	
	private String stuAge;
	
	private String stuClass;
	
	private double stuGrade;
	
	@Override
	public boolean equals(Object obj) {
		if( false == (obj instanceof Student) ) {
			return false;
		}
		if(false == this.getClass().equals(obj.getClass()) ) {
			return false;
		}
		Student stu = (Student) obj;
		if(false == (this.getStuNo().equals(stu.getStuNo()))) {
			return false;
		}
		return true;	
	}
	
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = hash*31+getStuNo().hashCode();		
		return hash;	
	}

	@Override
	public int compareTo(Student o) {
		if(this.stuGrade != o.getStuGrade()) {
			return this.stuGrade > o.getStuGrade() ? 1 :-1;
		}
		return 0;
	}	

	public Student() {
		super();
	}
	
	public Student(Long stuNo,double stuGrade) {
		super();
		this.stuNo = stuNo;
		this.stuGrade = stuGrade;
	}

	public Student(Long stuNo, String stuName, String stuAge, String stuClass) {
		super();
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.stuClass = stuClass;
	}

	
	
	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuClass=" + stuClass
				+ "]";
	}

	public Long getStuNo() {
		return stuNo;
	}

	public void setStuNo(Long stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAge() {
		return stuAge;
	}

	public void setStuAge(String stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}


	public double getStuGrade() {
		return stuGrade;
	}


	public void setStuGrade(double stuGrade) {
		this.stuGrade = stuGrade;
	}
}


class TestGenericity{
	public static <T> T work(T people) {
		System.out.println(people.toString()+"工作");
		return people;
	}
}

class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getStuGrade() != o2.getStuGrade()) {
			return o1.getStuGrade() > o2.getStuGrade() ? 1 : -1;
		}
		return 0;
	}
	
}