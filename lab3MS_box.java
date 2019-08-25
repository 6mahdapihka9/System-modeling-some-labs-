
public class lab3MS_box extends Thread{
	public boolean empty = false, going = true;
	public int timeToDo, wholeTime = 1000;
	
	public lab3MS_box( int t) {
		timeToDo = t;
	}
	
	public void run() {
		while(going) {
			try {
				if (wholeTime > 0) {
					wholeTime--;
					if (timeToDo > 0) {
						timeToDo--;
					}
					else
						empty = true;
				}
				else {
					going = false;
					lab3MS.Info();
				}
				//System.out.println("box time " + wholeTime);
				Thread.sleep(1);
			}catch(Exception ex) {}
		}
	}
}
