package com.test.eurekaClient.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.eurekaClient.bean.Person;

public class LambdaTest {

	public static void main(String[] args) {
        /*String[] t1 = {};
        String[] t2 = {"java","C++"};
        String t3 = "java";
        threePoint("java","C++","Python");
        threePoint(t1);
        threePoint(t2);
        threePoint(t3);*/
        //threePoint(t3,t2);//类型错误,数组只能传一个
		
		
		/**
		 * 基本类型数据便利
		 */
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",  
			       "David Ferrer","Roger Federer",  
			       "Andy Murray","Tomas Berdych",  
			       "Juan Martin Del Potro"};  
		List<String> players =  Arrays.asList(atp);  
		/*for (String player : players) {  
		     System.out.print(player + "; ");  
		}  */
		
		players.forEach((player) -> System.out.print(player + "; "));
		players.forEach(System.out::println);
		
		
		// 1.1使用匿名内部类  
		new Thread(new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("Hello world !");  
		    }  
		}).start();  
		  
		// 1.2使用 lambda expression  
		new Thread(() -> System.out.println("Hello world !")).start();  
		  
		// 2.1使用匿名内部类  
		Runnable race1 = new Runnable() {  
		    @Override  
		    public void run() {  
		        System.out.println("Hello world !");  
		    }  
		};  
		  
		// 2.2使用 lambda expression  
		Runnable race2 = () -> System.out.println("Hello world !");  
		   
		// 直接调用 run 方法(没开新线程哦!)  
		race1.run();  
		race2.run();  
		
		
		
		
		// lamdba表达式集合排序
		String[] player = {"Rafael Nadal", "Novak Djokovic",   
			    "Stanislas Wawrinka", "David Ferrer",  
			    "Roger Federer", "Andy Murray",  
			    "Tomas Berdych", "Juan Martin Del Potro",  
			    "Richard Gasquet", "John Isner"};  
		/*Arrays.sort(player, new Comparator<String>() {  
		    @Override  
		    public int compare(String s1, String s2) {  
		        return (s1.compareTo(s2));  
		    }  
		}); */
		
		Arrays.sort(player, (s1,s2) -> s1.compareTo(s2));
		List<String> asList = Arrays.asList(player);
		asList.forEach(System.out::println);
		
		
		/***************************对象处理***************************/
		List<Person> persons = new ArrayList<Person>(){
			{	   
	    add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));  
	    add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));  
	    add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));  
	    add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));  
	    add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));  
	    add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));  
	    add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));  
	    add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));  
	    add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));  
	    add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300)); 
			}
		};	  
			 
		// 过滤 
		persons.stream().filter(n -> n.getAge() > 17).forEach(n -> System.out.println(n));;
		
		
		
		
		
		
		
		
		
		
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    public static void threePoint(String... s) {
        if (s == null) {
            return;
        }
        int len = s.length;
        if (len == 0) {
            System.out.println("没有字符");
        } else {
            for (String s1 : s
            ) {
                System.out.println(s1 + " ");
            }
        }
        System.out.println("==============================");
    }
	
}
