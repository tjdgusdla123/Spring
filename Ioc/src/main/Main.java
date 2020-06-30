package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import domain.Good;
import domain.GoodFactory;

public class Main {

	public static void main(String[] args) {
		/*
		//어노테이션을 이용해서 Bean을 생성
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(GoodFactory.class);
		
		Good good = context.getBean("build", Good.class);
		*/
		
		//XML을 이용해서 Bean을 생성
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		Good good = context.getBean("good", Good.class);
		good.setNum(1);
		good.setName("사과");
		System.out.println(good);
		
		Good good1 = context.getBean("good", Good.class);
		good.setNum(2);
		good.setName("밀감");
		System.out.println(good);
		
		//해시코드 출력 - 해시 코드가 동일하게 출력
		//해시코드가 동일하면 동일한 메모리 영역을 사용하고 있는 것		
		System.out.println(System.identityHashCode(good));
		System.out.println(System.identityHashCode(good1));
		
		//상수는 상수 풀에 저장하고 풀에 저장한 상수의 참조를 저장합니다.
		int a =10;
		int b =10;
		int c =10;
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(System.identityHashCode(c));
		
        context.close();
	}

}
