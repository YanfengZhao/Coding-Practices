// How to run Thread with Runnable

class Foo{
	String name;
	public Foo(String s){
		name = s;
	}
	public void setName(String s){
		name = s;
	}
	public String getName(){
		return name;
	}
}

class FooBar extends Foo implements Runnable{
	public FooBar(String s){
		super(s);
	}
	public void run(){
		for(int i = 0; i < 10; i++){
			System.out.println(getName() + ": Hello World");
		}
	}
	public static void main(String[] args){
		// create object of type FooBar,
		// construct a new Thread object with the FooBar object as parameter
		// when you do t1.start(), the run method would be called
		FooBar f1 = new FooBar("Romeo");
		Thread t1 = new Thread(f1);
		t1.start();
		FooBar f2 = new FooBar("Juliet");
		Thread t2 = new Thread(f2);
		t2.start();
	}
}