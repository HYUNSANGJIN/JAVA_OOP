/*
 * User(사용자) , Provider(제공자)
 * 
 * ex) class A{}
 *     class B{}
 *     ㄴ 관계) A는 B를 사용합니다.
 *     ㄴ 사용하는 방법 : 1. 상속을통해서 사용  -> A extends B
 *                  2. 포함할 수 있다. -> A라는 클래스는 B를 member field로 가질수 있다. class A {B b;}
 *                      ㄴ 부분집합으로 가질수있다.
 *                      ㄴ 전체집합으로 가질수있다.
 *  ----------------------------------------------------------------------------------------
 *  <차와 엔진의 관계>  <- 이것으로 이해!!
 *  class B{}
 *  class A{
 *    int i;
 *    B b;  -> A는 B를 사용합니다(포함관계)
 *    A(){
 *        b = new B();
 *    }
 *  }                 
 *  -> B라는 클래스는 독자적인 생성을 하지 않는다 -> A라는 객체가 만들어져야 B도 생성이 되는것이다.
 *  -> A a = new A();  -> A객체도 생성되고, B객체도 생성
 *  -> 같은 생명(생명주기가 같다) -> 전체집합이라고 함  , A가 만들어지면 B도만들어지고 A가 죽으면 B도 죽는다
 *  
 *  
 *  <학생과 학교와의 관계>   <- 이것으로 이해!!!
 *  class B{}
 *  class A{
 *      int i;
 *      B b;   -> A는 B를 사용합니다(포함관계)
 *      A(){
 *      
 *      } 
 *      A(B b){
 *        this.b = b;
 *      }
 *  }
 *     
 *   public static void main(String [] args){
 *     A a = new A();
 *     B b = new B();
 *     A a2 = new A(b);  -> b객체의 주소를 준것이다.(부분집합)
 *     
 *     A, B는 같은 운명체가 아니다.
 *     
 *    - 밖에서 들어오면 부분집합, 안에서 같이 만들어지면 전체집합
 *   }               
 *   -------------------------------------------------------------------------
 *   class B{}
 *  class A{
 *    int i;
 *    A(){
 *    }
 *    void m(B b){  -> A는 B에 의존합니다(함수) ... ***B타입의 member field가 없다.
 *         b 객체를 가지고 작업
 *     }
 *    }
 *  
 *  public static void main(String [] args){
 *  B b = new B();
 *  A a = new A();
 *  어떤 상황에는 B객체가 필요
 *  a.m(b);
 *  }
 *  
 */
class B {

}

class A {
    void method(B b) {

    }
}
// ***************************************중요함***********************************************
// 현대적인 프로그래밍 기법 : 인터페이스 활용
// 인터페이스는 부모타입이다.
interface Icallable{
    void m();
}
class D implements Icallable{

    @Override
    public void m() {
        System.out.println("D Icallable 인터페이스의 m() 재정의");
        
    }
    
}
class F implements Icallable{

    @Override
    public void m() {
        System.out.println("F Icallable 인터페이스의 m() 재정의");
        
    }
}
// interface POINT -> 유연하게 잘짜느냐 -> 확장자 -> 느슨한 관계를 만든다.
class User{
    void method(Icallable ic) {
        ic.m();
    }
    /*
    void method(D d) {
        d.m();
    }
    void method(F f) {
        f.m();
    }
    */
}

public class Ex05_User_Provider {

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        a.method(b); // B타입의 객체 주소가 와야된다. -> B객체를 생성하지 않으면 A method는 사용할수 없다.
        
        D d = new D();
        F f = new F();
        User user = new User();
        user.method(f);

    }

}
