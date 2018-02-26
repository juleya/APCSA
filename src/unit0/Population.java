package unit0;

public class Population {

	public static void main(String[] args) {
		double seconds = 365 * 24 * 3600;
		double birth = seconds / 7;
		double death = seconds / 13;
		double immigrants = seconds / 45;
		int population = 312032486;
		System.out.println("Year\tPopulation \t");
		
		for (int i = 1; i < 6; i++) {
			population += birth - death + immigrants;
			System.out.println(i + "\t" + population + "\t");
		}

	}

}
