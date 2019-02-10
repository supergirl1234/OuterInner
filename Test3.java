package com;

/**
 * Author:Fanleilei
 * Created:2019/2/10 0010
 */
public class Test3 {

    public static void main(String[] args) {
        Outer outer=new Outer();
        System.out.println(outer.getName());
        System.out.println(outer.getAge());

        outer.display(18);



        //静态内部类创建 不依赖外部类对象
        //静态内部类的类名：外部类.静态内部类
        Outer.InnerC innerC=new Outer.InnerC();
        System.out.println(innerC.getNum());
    }
}

class A{

    private  String name="A 属性";

    public String getName() {
        return name;
    }
}
class B extends A{

    private  int age=20;

    public int getAge() {
        return age;
    }
}

class Outer{

    private int num=20;
    class InnerA extends A{


        public String name() {
            return super.getName();//前对象
        }
        public int getNum(){

            System.out.println("原始值："+Outer.this.num);
            Outer.this.num=22;
            System.out.println("Outer this"+Outer.this);
            return  Outer.this.num;
        }
    }

    class InnerB extends B{
        public int age(){

            return this.getAge();
        }

    }

    public static class InnerC{
        //静态内部类不能发布访问外部类的非静态属性和方法
        public int getNum(){

            //return num;error
            return 33;
        }
    }

    //外部类访问内部类的属性或方法，通过创建内部类的实例化对象后者必须持有内部类的实例化对象的引用
    public String getName(){

        return new InnerA().name();
    }

    public int getAge(){

        return new InnerB().age();

    }


    // public void  display(final int test)
    public void  display(int test){
        //参数，变量 这时候不管你是否给变量添加final修饰符，编译器自动添加
        int a=40;
        class Inner{

            public void fun(){

                num++;
                System.out.println(num);
                System.out.println(a);
            }
        }

        new Inner().fun();


    }

}
