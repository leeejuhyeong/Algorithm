public class Gamma{
    static Foo fooBar(Foo foo1) {
        foo1 = new Foo(100);
        return foo1;
    }
    public static void main(String[] args) {
        Foo foo = new Foo(300);
        System.out.print(foo.getX() + "-");
        Foo fooFoo = fooBar(foo);
        System.out.print(foo.getX() +"-");
        System.out.print(fooFoo.getX() + "-");
        foo = fooBar(fooFoo);
        System.out.print(foo.getX() + "-");
        System.out.print(fooFoo.getX());
    } // main close
} //  Gamma close

