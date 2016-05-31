package java8;

public class Java8Features {
	
	public static void main(String args[]){
		createThread();
	}

	private static void createThread(){
		Runnable r = new Runnable(){
			public void run(){
				System.out.println(Thread.currentThread().getName());
			}
		};
		
	}
}
