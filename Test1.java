package com;

/**
 * Author:Fanleilei
 * Created:2019/2/10 0010
 */
public class Test1 {

    private  String msg="this is a attribute";
    //Inner属于内部类，外部类Test1
    class Inner{

        private String msg="this is a inner attribute";
        public void print(){

            System.out.println("这个是从Inner的方法中输出的"+ Test1.this.msg);//外部类的类名.this.属性名
            System.out.println("这个是从Inner的方法中输出的"+ this.msg);//this.属性名   当前内部类的属性

        }
    }
    public void fun(){
        System.out.println("fun方法调用"+this.msg);
        //System.out.println(Inner.this.msg);error  这是个错误的；
        Inner inner=new Inner();
        inner.print();
    }
    public static void main(String[] args) {
        Test1 p=new Test1();
        p.fun();
    }
}
