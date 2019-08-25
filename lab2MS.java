import java.util.Scanner;
import static java.lang.System.out;

public class lab2MS {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		String choice;
		out.println("¬вед≥ть 1-3 дл€ вибору завданн€, 'q' дл€ виходу :");
		q:for(;;) {
			choice = "";
			out.print("¬ибер≥ть: ");
			choice = in.next();
			switch (choice) {
				case "1": {
					out.print("¬вед≥ть початковий стан [0-5]: ");
					int condition = in.nextInt();
					double P[][] = new double [6][6];
					P[0][0] = 0;	P[0][1] = 1;	P[0][2] = 0;	P[0][3] = 0;	P[0][4] = 0;	P[0][5] = 0;
					P[1][0] = 0.2;	P[1][1] = 0;	P[1][2] = 0.8;	P[1][3] = 0;	P[1][4] = 0;	P[1][5] = 0;
					P[2][0] = 0;	P[2][1] = 0.4;	P[2][2] = 0;	P[2][3] = 0.6;	P[2][4] = 0;	P[2][5] = 0;
					P[3][0] = 0;	P[3][1] = 0;	P[3][2] = 0.6;	P[3][3] = 0;	P[3][4] = 0.4;	P[3][5] = 0;
					P[4][0] = 0;	P[4][1] = 0;	P[4][2] = 0;	P[4][3] = 0.8;	P[4][4] = 0;	P[4][5] = 0.2;
					P[5][0] = 0;	P[5][1] = 0;	P[5][2] = 0;	P[5][3] = 0;	P[5][4] = 1;	P[5][5] = 0;
					
					MarkovChain(P, condition, 6, 20);
					
					break;
				}
				case "2": {
					out.print("¬вед≥ть початковий стан [0-2]: ");
					int condition = in.nextInt();
					double P[][] = new double [3][3];
					P[0][0] = 0;	P[0][1] = 0.5;	P[0][2] = 0.5;	
					P[1][0] = 0.25;	P[1][1] = 0.5;	P[1][2] = 0.25;	
					P[2][0] = 0.25;	P[2][1] = 0.5;	P[2][2] = 0.25;
					
					MarkovChain(P, condition-1, 3, 20);
					break;
				}
				case "3": {
					out.print("¬вед≥ть початковий стан [0-3]: ");
					int condition = in.nextInt();
					double P[][] = new double [4][4];
					P[0][0] = 1;	P[0][1] = 0;	P[0][2] = 0;	P[0][3] = 0;
					P[1][0] = 0.25;	P[1][1] = 0.55;	P[1][2] = 0.4;	P[1][3] = 0;
					P[2][0] = 0.25;	P[2][1] = 0;	P[2][2] = 0.35;	P[2][3] = 0.4;
					P[3][0] = 0;	P[3][1] = 0.25;	P[3][2] = 0;	P[3][3] = 0.75;
					
					MarkovChain(P, condition, 4, 10);
					break;
				}
				case "q": 
					break q;
			}//switch
		}//q end
		in.close();
	}//main
	
	public static void MarkovChain(double [][]p_ij, int cond, int countOfCond, int numOfExp) {
		double sum;
		int i = cond;
		double d;
		out.print(i + " > ");
		for (int exp = 0; exp < numOfExp; exp++) {
			sum = 0;
			d = Math.random();
			for (int j = 0; j < countOfCond; j++) 
				if (p_ij[i][j] != 0) {
					if (d > sum & d < sum + p_ij[i][j]) {
						i = j; 
						break;
					}
					sum += p_ij[i][j];
				}
			out.print(i + " > ");
		}
		out.println();
	}
}//class