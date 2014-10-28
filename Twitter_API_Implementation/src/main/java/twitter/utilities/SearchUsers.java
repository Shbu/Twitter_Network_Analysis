

package twitter.utilities;

import java.io.IOException;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public final class SearchUsers {

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
		
		
    	//input search keywords
    	String[] screen ={"Renewable energy"};
		String content=new String();
		String oppath = "C:\\Users\\cherry\\Desktop\\MIS 586\\TwitterID.txt";
        
        try {
        	Twitter twitter = new TwitterFactory(configurationBuilder.build())
			.getInstance();
            int page = 1;
            ResponseList<User> users;
            do {
                users = twitter.searchUsers(screen[0], page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                       content=content + "@"+ user.getScreenName()+"\r\n";
                    } else {
                        // the user is protected
                       content=content + "@"+ user.getScreenName()+"\r\n";
                    }
                }
                page++;
            } while (users.size() != 0 && page < 50);
            WriteFile wf = new WriteFile(oppath,true);
			try {
				wf.writeToFile(content);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Yo baby!. Got users!");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("WTF! Failed to search users: " + te.getMessage());
            System.exit(-1);
        }
    }
}
