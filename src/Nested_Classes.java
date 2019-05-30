 class Outer {
    class Inner{
        public void innerTest(){
            System.out.println("blablabla");
        }
    }

     public static void main(String[] args) {
         Outer.Inner inner=new Outer().new Inner();
         inner.innerTest();
         Outer outer=new Outer();
         Inner inner2=outer.new Inner();
         inner2.innerTest();
     }
}
