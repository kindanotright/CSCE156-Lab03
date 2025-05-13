package unl.soc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Processes a comma-separated value (CSV) file of win/loss data from the 2011
 * National League MLB season. It sorts the teams (best record to worst) and
 * prints a report to the standard output.
 * 
 * @author cbourke
 *
 */
public class Baseball {

	private static final String FILE_NAME = "data/mlb_nl_2011.csv";

	/**
	 * This method loads MLB team data from the CSV file specified by
	 * {@link #FILE_NAME} and instantiates and returns a list of {@link Team}s.
	 * 
	 * @return
	 */
	public static List<Team> loadData() {

		List<Team> teams = new ArrayList<>();

		File file = new File(FILE_NAME);

		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] tokens = line.split(",");
				if (tokens.length != 3)
					continue;

				String name = tokens[0].trim();
				int wins = Integer.parseInt(tokens[1].trim());
				int losses = Integer.parseInt(tokens[2].trim());

				teams.add(new Team(name, wins, losses));
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + FILE_NAME);
			e.printStackTrace();
		}

		// TODO: write code to open the file, process it line-by-line
		// to create team instances and add them to the list.
		//
		// Be sure to close the scanner
		return teams;
	}

	// TODO: implement the file output method

	public static void main(String args[]) {

		List<Team> teams = loadData();

		System.out.println("Teams: ");
		for (Team t : teams) {
			System.out.println(t);
		}

		Collections.sort(teams, Team.teamByWinPercentage);

		System.out.println("\n\nSorted Teams: ");
		for (Team t : teams) {
			System.out.println(t);
		}
		
		try (FileWriter writer = new FileWriter("sorted_mlb_nl_2011.csv")) {
	        for (Team t : teams) {
	            writer.write(t.getName() + "," + t.getWins() + "," + t.getLoss() + "," +
	                         String.format("%.3f", t.getWinPercentage()) + "\n");
	        }
	    } catch (IOException e) {
	        System.err.println("Error writing to file: sorted_mlb_nl_2011.csv");
	        e.printStackTrace();
	    }

		// TODO: call your file output method with the sorted teams

	}

}