public class FibonacciWithThreads extends Thread{
	int n;
	int result;
	public FibonacciWithThreads(int n){
		this.n = n;
	}

	public void run(){
		if(n == 0){
			result = 0;
		}
		else if(n == 1){
			result = 1;
		}
		else{
			FibonacciWithThreads f1 = new FibonacciWithThreads(n-1);
			FibonacciWithThreads f2 = new FibonacciWithThreads(n-2);
			f1.start();
			f2.start();
			// wait for f1 and f2 to both finish
			try{
				f1.join();
				f2.join();
			}
			catch (InterruptedException e){};
			result = f1.getResult()+f2.getResult();
		}
	}

	public int getResult(){
		return result;
	}

	public static void main(String[] args){
		FibonacciWithThreads f = new FibonacciWithThreads(Integer.parseInt(args[0]));
		f.start();
		try{
			f.join();
		} catch (InterruptedException e){};
		System.out.println(f.getResult());
	}
}