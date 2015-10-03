public class ThreadExample extends Thread{
	public void run(){
		System.out.println("Hello World");
	}
	public static void main(String[] args){
		ThreadExample t = new ThreadExample();
		t.start();
	}
}