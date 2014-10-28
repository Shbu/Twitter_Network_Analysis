package twitter.utilities;

import java.io.IOException;

import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class GetFriendsIDs {

	public static void main(String[] args) {

		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthConsumerKey("");
		configurationBuilder
				.setOAuthConsumerSecret("");
		configurationBuilder
				.setOAuthAccessToken("");
		configurationBuilder
				.setOAuthAccessTokenSecret("");

		// users' screen names
		String[] screen = { "RefurbThat", "RnfrstAlliance", "Solar_tuk_tuk",
				"SolarKev", "Stratfordenergy", "WalmartGreen", "Ways2GoGreen" };
		int num = screen.length;

		try {

			Twitter twitter = new TwitterFactory(configurationBuilder.build())
					.getInstance();

			IDs ids;
			String[] content = new String[num];
			String oppath = "C:\\Users\\cherry\\Desktop\\MIS 586\\FriendsID.txt";
			// String oppath = "/home/ec2-user/data/FriendsID.txt";

			while (num > 0) {
				long cursor = -1;

				String hint = "\r\n" + " @" + screen[num - 1]
						+ " followers." + "\r\n";
				content[num - 1] = hint;

				do {
					if (0 < num) {
						ids = twitter.getFriendsIDs(screen[num - 1], cursor);
					} else {
						ids = twitter.getFriendsIDs(cursor);
					}
					content[num - 1] = content[num - 1] + ids;

				} while ((cursor = ids.getNextCursor()) != 0);

				WriteFile wf = new WriteFile(oppath, true);

				try {
					wf.writeToFile(content[num - 1]);
					
					System.out.println("Got followers! you can shutdown now!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				num = num - 1;
				try {
					Thread.sleep(90000); // 1000 milliseconds is one second.
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}// while (num>0)
			System.exit(0);
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out
					.println("OMG! Failed to get friends' ids: " + te.getMessage());
			System.exit(-1);
		}// catch

	} // main method
} // class

