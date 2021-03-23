/*
 * 추상클래스 : 인터페이스


 * 
 * 인터페이스 : 표준, 약속, 규약, 규칙 을 만드는 행위
 * 
 * [추상 클래스 , 인터페이스 공통점]
 * 1. 스스로 객체 생성이 불가능하다.(new (x))
 *    ㄴ 차이점 : 추상 클래스는 (완성된 일반함수 + 미완성된 일반함수)
 *             인터페이스(모든 것이 미완성)
 * 2. 사용
 *   ㄴ 추상클래스 : extends
 *   ㄴ 인터페이스 : implements(구현의 기능)
 *   ㄴ 예) class Car extends abclass{}
 *   ㄴ        class Car implements la{}  -> 인터페이스가 가지는 추상자원을 다 재정의 해라.
 *   
 * 추상클래스, 인터페이스
 * ㄴ 인터페이스 : 다중상속이 가능(구현) -> 약속(작은 단위로 여러개) -> 여러개의 작은 약속 모아 모아서
 * class Test extends Object implements Ia, Ib, Ic
 * 약속을 크게 만들면 -> 사용성 떨어진다 -> 한정 -> 쪼개서...
 * 
 * ㄴ 추상클래스는 단일원속원칙(계층적 상속)
 * ㄴ 추상클래스 (완성 + 미완성)
 * ㄴ 인터페이스는(상수를 제외한 나머지는 미완성(추상)자원 -> JDK(Default값, static값)
 * 
 *  인터페이스 소프트웨어 설계 최상위 단계
 *  (경험과 노하우가 없으면 힘듬..)
 *  
 *  ++ 개발자 (초급) ++
 *  1. 인터페이스 [다형성] 입장으로 접근(인터페이스는 부모 타입)
 *  2. 서로 연관성이 없는 클래스를 하나로 묶어주는 기능(인터페이스를 구현함으로써 같은 부모를 만들어준다)
 *  3. JAVA API 여러분이 사용할 만한 수많은 인터페이스를 만들어 놓음
 *  4. 인터페이스(관용적) : (~able) : 수리할 수 있는, 날수있는 : Cloneable(관용적 표현)
 *  5. 객체간 연결 고리(객체간 소통) -> 다형성 -> 같은 부모
 * 
 */
/*
interface Iable{
    String print();
    // 출력할때 print 함수 써라 (약속)
    // retrun은 문자열이야 (약속)
}

class Test implements Iable{

    @Override
    public String print() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
*/
// 설계표준 -> 구현 강제 -> 재정의
/*
 * 1. 실제 구현부를 가지고 있지 않다 : 실행 블럭이 없는 함수 -> void run();
 *    ㄴ 게임설계 이동 move(int x, int y) -> 인터페이스 -> 탱크, 마린 -> move 구현
 *    ㄴ JAVA API : Collection(동적배열 : 자료구조) -> Vector, [ArrayList], HashSet, [HashMap]
 *    ㄴ Vector, [ArrayList], HashSet, [HashMap] 넘들은 수많은 interface구현
 *    
 * 2. 생성방법(interface 자원)
 *    ㄴ public static final int VERSION = 1; -> int VERSION = 1 
 *     -> 컴파일러가 [public static final] 있어요   
 *     
 *    ㄴ public abstract void run(); -> [public abstract]생략 -> void run()
 *    
 * 컴파일러가 바라보는 부분   
 * interface Iable{
 *    public static final int VERSION = 1;
 *     public abstract void run();
 *     }
 *     
 * 실제사용시
 *     interface Iable{
 *     int VERSION = 1;
 *     void run();
 *     String move(int x, int y);
 *     }
 *     
 * interface Iable{}    
 * interface Bable{int NUM = 0}  
 * interface Cable{void run(); void move();}  
 * 
 * class Test extends Object implement Iable, Bable, Cable
 */

interface Humanable{
    int AGE = 100; // int앞에 public static final 생략되어있음
    String GENDER = "남";
    
    String print();
    void message(String str);
}

interface Iable{
    int AGE = 10;
    void info();
    String val(String s);
}

class Test extends Object implements Humanable, Iable{

    @Override
    public void info() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String val(String s) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String print() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void message(String str) {
        // TODO Auto-generated method stub
        
    }  // 원래 extends Object는 생략가능
    
}

public class Ex03_Interface {
    public static void main(String[] args) {
        Test t = new Test();
        Humanable h = t;  // 다형성(부모는 자식 객체의 주소를 가질수 있다.)
        System.out.println(h.AGE);
        
        Iable ia = t;
        System.out.println(ia.AGE);
    }

}
