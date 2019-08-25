
public class lab3MS_client extends Thread{
	lab3MS_box parentBox;
	boolean isDone = false, going = true;
	int timeToWait, startAt, allTime;
	
	public lab3MS_client(lab3MS_box parentObj, int t) {
		parentBox = parentObj;
		allTime = timeToWait = t;
		startAt = (int)(Math.random()*1000);
	}
	
	public void run() {
		while(going) {
			try {
				if (startAt > 0)
					startAt--;
				else {
					if (!parentBox.empty & timeToWait > 0)
						timeToWait--;
					else if (parentBox.empty & timeToWait > 0) {
						isDone = true;
						going = false;
						lab3MS.countOfSatisf++;
						lab3MS.avarageTimeToWait += allTime - timeToWait;
						parentBox.empty = false;
						parentBox.timeToDo = 50;
					}
					else if (timeToWait <= 0) {
						going = false;
						lab3MS.avarageTimeToWait += allTime;
						lab3MS.countOfNotSat++;
					}
				}
				if (parentBox.wholeTime == 0)
					going = false;
				//System.out.println("client wait time " + timeToWait);
				//System.out.println("client start after " + startAt);
				Thread.sleep(1);
			}catch(Exception ex) {}
		}
	}
}
