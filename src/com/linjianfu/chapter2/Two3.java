package com.linjianfu.chapter2;

class Two3C{
    Two3C( ){
        System.out.println("构造器已初始化！");
//        return Two3C( );
    }
}
public class Two3 {

     class A{
           String jj(String s) {
           String cao = "diuleiloumo";
           return cao;
           }

    }

    public static void main(String args[]){
       // System.out.println("throw exception:");
     //   throw new Exception("");
       // Two3 sl = new Two3();
      //  String s = sl.method("1", "2");
     //   System.out.println(s);

//        System.out.println("print input parameters:");
//        for (int i=0;i<args.length;i++){
//        System.out.println(args[i]);}

        class ATypeName {

                int i;
                double d;
                boolean b;

            void show() {
                System.out.println(i);
                System.out.println(d);
                new Two3C();
                System.out.println(b);

            }
        }

   ATypeName a=new ATypeName();
   a.i=3;
   a.d=2.718;
   a.b=false;
   a.show();
   Two3 b=new Two3();
   A cc=b.new A();
   System.out.println(cc.jj(""));
//   new A().jj();
//   Two3.A bc= bb.jj();


    }
 //   public String method(String me,String who){
   //     return me+who;
   // }
}
