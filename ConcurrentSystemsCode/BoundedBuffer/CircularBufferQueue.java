interface Queue<T> {
	void enqueue(T object);
	T dequeue();
}

class CircularBufferQueue<T> implements Queue<T>{
	T[] buf;
	private int start = 0;
	private int size = 0;

	ReentrantLock queueLock;
	Condition queueFull;
	Condition queueEmpty;

	public CircularBufferQueue(int capacity){
		buf = new T[capacity];

		queueLock = new ReentrantLock();
		queueFull = queueLock.newCondition();
		queueEmpty = queueLock.newCondition();
	}

	public void enqueue(T object){
		queueLock.lock();
		try{
			while(size == buf.length){
				queueFull.await();
			}

			buf[(start+size) % buf.length] = object;
			size++;
			queueEmpty.signal();
		}
		finally{
			queueLock.unlock();
		}
	}

	public T dequeue(){
		queueLock.lock();
		try{
			while(size == 0){
				queueEmpty.await();
			}

			T returnElement = buf[start];
			start = (start + 1) % buf.length;
			size--;
			queueFull.signal();
			return returnElement;
		}
		finally{
			queueLock.unlock();
		}
	}
}
