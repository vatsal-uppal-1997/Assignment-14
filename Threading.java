
class halfCount1 implements Runnable {

	private final int start;
	private final int end;

	public halfCount1(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public void run() {
		count();
	}

	private synchronized void count() {
		for (int i=this.start;i<this.end;i++)
			System.out.println((Thread.currentThread()).getId()+" : "+i);
	}

}

public class Threading {



	public static void main(String[] args) throws InterruptedException {

		Thread obj1 = new Thread(new halfCount1(1,500));
		Thread obj2 = new Thread(new halfCount1(500,1001));
		obj1.start();
		Thread.sleep(50);
		obj2.start();

	}


}
