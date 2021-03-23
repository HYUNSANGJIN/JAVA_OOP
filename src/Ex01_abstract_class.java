/*
 추상클래스
 >> 미완성 클래스(완성되지 않은 설계도)
 1. 완성된 코드 + 미완성 코드
 2. 완성된 코드(실행블럭이 있는 함수) + 미완성코드(함수이지만, 실행블럭이 없는 함수: void run();)
 3. 완성된 클래스(new 가능): 미완성 클래스(스스로 객체 생성 불가능)
 
 정리
 1. 추상클래스(미완성): 스스로 객체 생성이 불가 (new 사용 불가)
 2. 추상클래스는 결국 완성된 클래스로 만드는 것이 목적이다. (-> 상속을 통해서,,,)
 3. 상속관계에서 미완성 자원(추상함수)을 완성해라(구현) >> 재정의해라(추상자원)
 
 설계자의 입장
 - 의도: 상속하면 반드시 재정의해라 >> 강제적 구현을 해라(why? 믿지 못하니까)
 
 */

class Car{
    void run() { // 강제성이 없다
        
    }
}

class Hcar extends Car{
    //Hcar run() -> 재정의 해도 되고 안해도 문제가 없다. (강제성 x)
}

////////////////////////////////////////////////
abstract class AbClass{ // abstract >> 클래스 안에 최소 1개의 추상자원을 만들겠다.
    //완성된 코드
    int pos;
    void run() {
        ++pos;
    }
    //미완성된 코드
    abstract void stop(); // {} x -> 추상함수 -> 반드시 재정의해서 사용해라
}

class Child extends AbClass {

    @Override
    void stop() { // 강제적 구현 // 설계도를 사용하는 사람이 어떠한 기능을 무조건 오버라이드해서 사용하도록 만든당
        this.pos = 0;
        System.out.println("stop: "+ this.pos);
    } 
}

class Child2 extends AbClass {

    @Override
    void stop() {
        this.pos = -1;
        System.out.println("stop: "+ this.pos);
    }
    
}


public class Ex01_abstract_class {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.run();
        ch.run();
        System.out.println(ch.pos);
        ch.stop();
        
        Child2 ch2 = new Child2();
        // 다형성
        AbClass ab = ch;
        // 부모타입의 참조 변수는 자식타입 객체의 주소를 가질 수 있다. -> 다형성
        // 단, 부모는 자기타입의 자원만 본다.
        
        ab.run();
        ab.stop(); // 재정의
                   // 부모타입으로 접근하더라도 추상함수는 실행이 안된다. 
                   // ㄴ 재정의(자식)된 함수 호출(예외적으로)
    }
}
