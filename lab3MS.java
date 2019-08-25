
public class lab3MS {
	static int n = 20, timeForClient, timeToDo;
	static lab3MS_box box;
	static lab3MS_client client[];
	
	static int countOfSatisf = 0, countOfNotSat = 0, avarageTimeToWait = 0;
	
	lab3MS(){
		
	}
	
	public static void main(String args[]) {
		timeToDo = 50;
		box = new lab3MS_box(timeToDo);
		box.start();
		
		client = new lab3MS_client[n];
		for (int i = 0; i < n; i++) {
			timeForClient = (int)(Math.random()*100);
			client[i] = new lab3MS_client(box, timeForClient);
			client[i].start();
		}
		
	}
	
	public static void Info() {
		System.out.println("Count of satisfied clients:" + countOfSatisf);
		System.out.println("Count of not satisfied clients:" + countOfNotSat);
		System.out.println("Avarage time to wait:" + (avarageTimeToWait)/n);
	}
}
