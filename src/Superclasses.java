 class Test {
    public static void main(String[] args) {
// Анонимный класс наследуется от класса Demo
        Demo demo = new Demo() {
            public void show() {

                System.out.println("Метод внутреннего анонимного класса");
            }
        };
        demo.show();
    }
}
class Demo {
    public void show() {
        System.out.println("Метод суперкласса");
    }
}