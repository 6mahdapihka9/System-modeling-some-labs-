import java.util.Scanner;
import static java.lang.System.out;

public class lab1MS {
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		final int n = 20;
		String outChoice, inChoice;
		out.println("Введіть 1-4 для вибору завдання, 'q' для виходу :");
		q:for(;;) {
			outChoice = "";
			out.print("Виберіть: ");
			outChoice = in.next();
			switch (outChoice) {
			case "1": {
				out.println("\tВведіть 1-8 відповідно до номеру розподілу.");
				out.println("\t1 - Розподіл Пуассона");
				out.println("\t2 - Від'ємно біноміальний розподіл");
				out.println("\t3 - Геометричний розподіл");
				out.println("\t4 - Біноміальний");
				out.println("\t5 - Експоненціальний розподіл");
				out.println("\t6 - Розподіл Парето");
				out.println("\t7 - Рівномірний розподіл");
				out.println("\t8 - Нормальний розподіл");
				out.println("\tb - Назад");
				b:for(;;) {
					inChoice = "";
					out.print("\tВиберіть: ");
					inChoice = in.next();
					switch (inChoice) {
						case "1": {
							out.print("\t\tВведіть лямбда: ");
							int lambda = in.nextInt();
							double p,s;
							double z[] = new double[20];
							int x[] = new int[20];
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) {								
								p = Math.pow(Math.E,-1*lambda);
								x[i] = 0;
								s = p;
								while (z[i] > s) {
									x[i] ++;
									p = p*lambda/x[i];
									s += p;
								}
							}
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %d\n", z[i], x[i]);
							break;
						}
						case "2": {
							out.print("\t\tВведіть 'p': ");
							double pi = in.nextDouble();
							out.print("\t\tВведіть alfa: ");
							int alfa = in.nextInt();
							double p,s;
							double z[] = new double[20];
							int x[] = new int[20];
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) {								
								p = Math.pow(pi,alfa);
								x[i] = 0;
								s = p;
								while (z[i] > s) {
									x[i] ++;
									p = (p*(alfa + x[i] - 1)*(1-pi))/x[i];
									s += p;
								}
							}
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %d\n", z[i], x[i]);
							break;
						}
						case "3": {
							out.print("\t\tВведіть 'p': ");
							double pi = in.nextDouble();
							double p,s;
							double z[] = new double[20];
							int x[] = new int[20];
							for (int i = 0; i < n; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) {								
								p = pi;
								x[i] = 0;
								s = p;
								while (z[i] > s) {
									x[i] ++;
									p = p*(1-pi);
									s += p;
								}
							}
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %d\n", z[i], x[i]);
							break;
						}
						case "4": {
							out.print("\t\tВведіть 'p': ");
							double pi = in.nextDouble();
							out.print("\t\tВведіть 'n': ");
							int N = in.nextInt();
							double p,s;
							double z[] = new double[N];
							int x[] = new int[N];
							for (int i = 0; i < N; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 1; i < N; i++) {								
								p = Math.pow(1 - pi,N);
								x[i] = 0;
								s = p;
								while (z[i] > s) {
									x[i] ++;
									p = p*(pi*(N - x[i]) / ((1 - pi)*(x[i] + 1)));
									s += p;
								}
							}
							for (int i = 0; i < N; i++)
								System.out.printf("\t\t%.9f > %d\n", z[i], x[i]);
							break;
						}
						case "5": {
							out.print("\t\tВведіть 'lambda': ");
							double lambda = in.nextDouble();
							double z[] = new double[20], x[] = new double[20];
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) 
								x[i] = (-1/lambda)*Math.log(1 - z[i]);
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %.9f\n", z[i], x[i]);
							break;
						}
						case "6": {
							out.print("\t\tВведіть 'lambda': ");
							double lambda = in.nextDouble();
							out.print("\t\tВведіть 'alfa': ");
							double alfa = in.nextDouble();
							double z[] = new double[20], x[] = new double[20];
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) 
								x[i] = (lambda*Math.pow(1 - z[i], ((-1)/alfa))) - lambda;
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %.9f\n", z[i], x[i]);
							break;
						}
						case "7": {
							out.print("\t\tВведіть початок відрізка: ");
							double A = in.nextDouble();
							out.print("\t\tВведіть початок відрізка: ");
							double B = in.nextDouble();
							double z[] = new double[20], x[] = new double[20];
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) 
								x[i] = (B - A)*z[i] + A;
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %.9f\n", z[i], x[i]);
							break;
						}
						case "8": {
							out.print("\t\tВведіть 'a': ");
							double a = in.nextDouble();
							out.print("\t\tВведіть 'sigma': ");
							double sigma = in.nextDouble();
							double z[] = new double[20], x[] = new double[20], y[] = new double[12], yS = 0;
							
							for (int i = 0; i < 20; i++) 
								z[i] = Math.random();
							qSort(z);
							for (int i = 0; i < 20; i++) {
								for (int j = 0; j < 12; j++) {
									y[j] = Math.random();
									yS += y[j];
								}
								yS = yS - 6;
								x[i] = yS*sigma + a;
							}
							for (int i = 0; i < 20; i++)
								System.out.printf("\t\t%.9f > %.9f\n", z[i], x[i]);
							break;
						}
						case "b": {
							in.close();
							break b;
						}
						default:
							out.println("Incorrect data, try again!");
					}
				}//menu-for
				break;
			}
			case "2": {
				//out.println("\tНехай бюджет компанії : 500 000,");
				//out.println("\tЙмовірність померти своєю смертю обходиться в 250 000.");
				//out.println("\tЙмовірність померти від нещасного випадку обходиться в 500 000.");
				int s = 0, m = 0;
				out.println("\tВведіть бюджет: ");
				int u = in.nextInt();
				out.println("\tВведіть ймовірність померти своєю смертю: ");
				double p1 = in.nextDouble();
				out.println("\tВведіть виплату за звичайну смерть: ");
				int sm1 = in.nextInt();
				out.println("\tВведіть ймовірність померти від нещасного випадка: ");
				double p2 = in.nextDouble();
				out.println("\tВведіть виплату за нещасний випадок: ");
				int sm2 = in.nextInt();
				int X[] = new int[10];
				double z[] = new double[20];
				for (int k = 0; k < 100000; k++) {
					for (int i = 0; i < 10; i++) {
						z[i] = Math.random();
						if (z[i] > 0 && z[i] < 1-p1-p2) {
							X[i] = 0;
						}
						else if (z[i] >= 1-p1-p2 && z[i] < 1-p2) {
							X[i] = sm1;
						}
						else if (z[i] >= 1-p2 && z[i] < 1) {
							X[i] = sm2;
						}
						s += X[i];
					}
					if (s > u) 
						m++;
					s = 0;
				}
				out.println("\tТоді ймовірність банкрутства компанії : " + (double)m/100000);
				break;
			}
			case "3": {
				
				double z, p, s = 0;
				int lambda1 = 9, u = 105000, x = 0, m = 0;
				
				out.println("\tНехай кількість пожеж описується пуассоновим розподілом с середнім Лямбда1 = 9,");
				out.println("\tА величина збитків має експоненціальний розподіл з середнім Лямбда2 = 5 000грн.");
				out.println("\tРезервний фонд становить 105 000грн.");
				
				for (int k = 0; k < 100000; k++) {
					z = Math.random();						
					p = Math.pow(Math.E,-1*lambda1);
					x = 0;
					s = p;
					while (z > s) {
						x++;
						p = p*lambda1/x;
						s += p;
					}
					double X[] = new double[x];
					for (int i = 0; i < x; i++) {
						X[i] = (-5000)*Math.log(1 - z);
						s += X[i];
					}
					if (s > u) 
						m++;
					s = 0;
				}
	
				out.printf("\tТоді ймовірність банкрутства : %.7f \n", (double)m/100000);
				break;
			}
			case "4": {
				out.print("\tВведіть початкову вартість (S0): ");
				double S0 = in.nextDouble();
				out.print("\tВведіть коефіціент мінливості (mu)': ");
				double mu = in.nextDouble();
				out.print("\tВведіть відхилення (sigma): ");
				double sigma = in.nextDouble();
				double s[] = new double[20], y[] = new double[12], yS = 0;
				s[0] = S0;
				for (int i = 1; i < 20; i++) {
					for (int j = 0; j < 12; j++) {
						y[j] = Math.random();
						yS += y[j];
					}
					yS = yS - 6;
					s[i] = s[i - 1]*Math.pow(Math.E,mu + sigma*yS - sigma*sigma*(1/2));
				}
				for (int i = 1; i < 20; i++)
					System.out.printf("\t%.9f\n", s[i]);
				break;
			}
			case "q": {
				in.close();
				break q;
			}
			default:
				out.println("Incorrect data, try again!");
			}
		}
	}
	
	static public int fact(int k) {
		int i = 1 ;
		for (int j = 0; j < k; j++) {
			i *= (j+1);
		}
		return i;
	}
	
	static void qSort(double mass[]) {
		qs(mass, 0, mass.length - 1);
	}
	
	private static void qs(double mass[], int left, int right) {
		int i, j;
		double x, y;
		
		i = left; j = right;
		x = mass[(left + right)/2];
		
		do {
			while ((mass[i] < x) && (i < right)) i++;
			while ((mass[j] > x) && (j > left)) j--;
			
			if (i <= j) {
				y = mass[i];
				mass[i] = mass[j];
				mass[j] = y;
				i++; j--;
			}
		} while (i <= j);
		
		if (left < j) qs(mass, left, j);
		if (right > i) qs(mass, i, right);		
	}
}