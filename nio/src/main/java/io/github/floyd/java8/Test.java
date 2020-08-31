package io.github.floyd.java8;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.java8
 * Company: com.yinhai
 * date 2019/12/8
 * @see *#
 */
public class Test {
    public static void main(String args[]) {
        class Foo {
            public int i = 5;
        }
        Object o = (Object) new Foo();
        Foo foo = (Foo) o;
        System.out.println("i = " + foo.i);
////////////= HashMap和hashTable都继承了Map，hashTable线程安全 =////////////
        HashMap h = new HashMap();
        h.put("1", "own");
        h.containsKey("1");
        Hashtable t = new Hashtable();
        t.put("1", "一");
        t.contains("1");
        /////////= =//////////
        Integer i = -5;
        i = i >> 2;
        System.out.println(i);
        i = i >>> 2;
        System.out.println(i);
        //定义一个抽象类
        abstract class A {
            //普通方法
            public void fun() {
                System.out.println("存在方法体的方法");
            }
        }
        A a = new A() {
            @Override
            public void fun() {
                super.fun();
            }
        };
        a.fun();
        /////-比较日期-/////
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(2019, Calendar.DECEMBER, 1, 0, 0, 0);
        Calendar aae030Calendar = Calendar.getInstance();
        aae030Calendar.set(2019, Calendar.DECEMBER, 1, 12, 43);
        System.out.println(startCalendar.getTime());
        System.out.println(aae030Calendar.getTime());
        System.out.println(startCalendar.getTime().before(aae030Calendar.getTime()));
    }
}

/*public class Test{
    public void method(){
        for(int i = 1; i < 3; i++){
            System.out.print(i);
        }
        System.out.print(i);
    }
}*/
class TestSuper {
    TestSuper(int i) {
    }
}

class TestSub extends TestSuper {
    TestSub() {
        super(3);
    }

    TestSub(int i) {
        super(i);
    }
}

class TestAll {
    public static void main(String[] args) {
        new TestSub();
    }
}

// 反射
class ConstructorDemo4 {

    public static void main(String[] args) throws Exception {
        class Emp {
            private String name;
            private int age;

            private Emp() {
            }

            Emp(String name) {
            }

            public Emp(String name, int age) {
            }
        }

        //得到所有的构造器（先得到类）
        Class<Emp> c = Emp.class;
        /**
          * Constructor<?>[] getConstructors()
                返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法。
          */
        Constructor[] con = c.getConstructors();//前面的修饰符必须是public才可以在这个方法下获取到
        for (Constructor cons : con) {
            System.out.println("c.getConstructors()" + cons);//如果上面的某构造器public去掉，则显示不出
            /**打印
             public junereflect624.Emp(java.lang.String,int)
              */
        }

        //得到指定的构造器,也是必须public
        Constructor c1 = c.getConstructor(String.class, int.class);
        System.out.println(c1);//public junereflect624.Emp(java.lang.String,int)

        System.out.println("====================================");

        //现在想获得不受public影响的,getDeclaredConstructors(),暴力反射

        con = c.getDeclaredConstructors();
        for (Constructor cons : con) {
            System.out.println("c.getDeclaredConstructors()==" + cons);//此时不受修饰符的影响
            /**打印
              *  public junereflect624.Emp()
             public junereflect624.Emp(java.lang.String)
             public junereflect624.Emp(java.lang.String,int)
              */
        }
    }
}

class ReflectDemo6 {
    public static void main(String[] args) throws Exception {
        class Stu {
            private String name;
            private String sex;
            private int age;
            private Stu(String name, String sex, int age) {
                super();
                this.name = name;
                this.sex = sex;
                this.age = age;
            }
        }
        Stu s = new Stu("刘昭", "男", 12);
        Class<Stu> c = Stu.class;
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        // 从入参(实例)上获取实例成员变量
        System.out.println(f.get(s));
// 修改对象的值
/**
 Field f = c.getField("name");
 f.set(s,"章泽天");
 System.out.println(f.get(s));//从哪个对象身上取！//此时显示章泽天
 */

    }
}
class Parent{
    public int addValue(int a,int b) {
        int s;
        s=a+b;
        return s;
    }
}
class Child extends Parent{
    @Override
    public int addValue(int a,int b)throws RuntimeException {
        return 3;
    }
}