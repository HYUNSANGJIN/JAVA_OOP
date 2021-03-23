interface Irepairable{
    
}
class Unit2{
    int hitpoint;  // 기본에너지
    final int MAX_HP; // 최대 에너지
    Unit2(int hp){
        this.MAX_HP = hp;
    }
}

// 지상 유닛
class GroundUnit extends Unit2{

    GroundUnit(int hp) {
        super(hp);
    }
    
}

// 공중 유닛
class AirUnit extends Unit2{

    AirUnit(int hp) {
        super(hp);
    }
        
}

// 건물
class CommandCenter implements Irepairable{
    
}

class Tank2 extends GroundUnit implements Irepairable{

    Tank2() {
        super(50);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "[Tank2]";
    }
    
    
}

class Marine2 extends GroundUnit {

    Marine2() {
        super(50);
        this.hitpoint = this.MAX_HP;
    }

    @Override
    public String toString() {
        return "[Marine2]";
    } 
}

// scv 자원채취
class Scv extends GroundUnit implements Irepairable{

    Scv() {
        super(50);
        this.hitpoint = this.MAX_HP;
       
    }

    @Override
    public String toString() {
        return "[Scv]";
    }
    // scv가 갖고있는 구체화, 특수화된 기능
    // repair(수리하다) 할 수 있음
   /*
    void reapair(Tank2 tank) {
        if(tank.hitpoint != tank.MAX_HP) {   // 공격당했다
            System.out.println("다쳣움 ㅠㅡㅠ");
            tank.hitpoint += 5;
        }
        
    }
    
    void repair(Scv scv) {
        if(scv.hitpoint != scv.MAX_HP) {   // 공격당했다
            System.out.println("다쳣움 ㅠㅡㅠ");
            scv.hitpoint += 5;
        }
    }
    
    Unit 종류가 30개 (25개)
    Scv repair 해야하는 Unit개수가 증가하면 함수의 개수도 같이 증가
         고민 : 하나의 함수가 Unit repair 할 수 있다면
         ㄴ 전자제품했던거...(상속관계에서 부모타입...다형성을 썻음)랑 같은거 아니야???
         
         void repair(Unit2 unit){} -> Marine2(x), Scv(o) , Tank2(o)
         void repair(GroundUnit unit){} -> 
         Marine2(x), Scv(o) , Tank2(o)
         CommandCenter repair 대상 (유닛과 연관성이 없다)
          
            고민 : Marine2, Scv , Tank2은 CommandCenter과 연관성이없다
            ㄴ 과연 연관성이 있는 것은 뭘깡..
            ㄴ 인터페이스!!!! 연관성이 없는 객체에 부모를 만들어준다!!!
            ㄴ Irepairable 부모로 만들어서 하장
            class Scv extends GroundUnit   implements Irepairable
            class Tank2 extends GroundUnit implements Irepairable
            class CommandCenter            implements Irepairable
                            ㄴ Irepairable은 Scv의                      부모타입이다 (o)
                            ㄴ Irepairable은 Tank2의                  부모타입이다 (o)
                            ㄴ Irepairable은 CommandCenter의 부모타입이다 (o)
                            
          
    */
    void repair(Irepairable repairunit) {
        // repairunit parameter는 Irepairable 인터페이스를 구현하고있는 객체의 주소값이 올 수 있다.
        // void repair(new Tank2()) (o)
        // void repair(new CommandCenter()) (o)
        // void repair(new Scv()) (o)
        // 부모타입은 자식타입의 주소를 받을 수 있다 .. 문제는 부모것만 볼 수 있다.
        
        // 정리
        // CommandCenter 외 Tank2, Scv 수리 방법이 틀리다
        // Irepairable repairunit 은 수리할 자원을 가지고 있지 않다
        // 그럼 Irepairable repairunit 통해서 위 3가지 Unit2온다고 가정하고 분류해 보자
        
        // CommandCenter 외 Tank2, Scv 구문점 Unit2이냐 아니냐..
        // 타입비교 (연산자 : instanceof) -> 좌항(객체) instanceof 우항(타입)
        // https://cafe.naver.com/bit2021/141
        
        if(repairunit instanceof Unit2) { // Tank2 나 Unit2 타입이니?
            Unit2 unit = (Unit2)repairunit; //unit -> Tank2아니면 Marine의 주소값
            // ㄴ Tank2에서 부모타입인 Unit2 자원만 접근
            // ****부모타입의 주소를 자식이 가지려면 자식타입으로 캐스팅 해야된다.****
            
            if(unit.hitpoint != unit.MAX_HP) {
                unit.hitpoint = unit.MAX_HP;
            }
            
            
        }else {
            // 부모타입이 Unit2가 아닌것이다.
            System.out.println("다른 충전 방식을 통해서 ..Unit2타입이 아니에용");
        }
    }
    
}


public class Ex04_Interface {
    public static void main(String[] args) {
        Tank2 tank = new Tank2();
        Marine2 marine = new Marine2();
        Scv scv = new Scv();
        
        // 전투시작
        tank.hitpoint -= 20;
        System.out.println("탱크 : " + tank.hitpoint);
        System.out.println("Scv 얄라바");
        scv.repair(tank);
        System.out.println("탱크 수리 완료 : " + tank.hitpoint);
        
        scv.hitpoint -= 10;
        System.out.println("scv: " + scv.hitpoint);
        System.out.println("Scv 얄라바");
        scv.repair(scv);
        System.out.println("scv 수리 완료 : " + scv.hitpoint);
        
        CommandCenter center = new CommandCenter();
        scv.repair(center);
        
        //scv.repair(marine); -> 컴파일 조차 안되니깐 잘 막은거다
        
    }

}
