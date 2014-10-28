

package twitter.utilities;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import java.io.IOException;


public final class ShowUser {

    public static void main(String[] args) {
    	//input: users' screen name
    	String[] screen ={"TigoEnergy"};
    	int num = screen.length;
    	
        if (num < 1) {
            System.out.println("You need at least one user name!");
            System.exit(-1);
        }
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            String oppath="C:\\Users\\cherry\\Desktop\\MIS 586\\UserProfile.txt";
            String[] content=new String[num];
            
            while (num >0) {
				User user = twitter.showUser(screen[num-1]);
				
				if (user.getStatus() != null) {
					content[num-1] = "@" + user.getScreenName() + " - " + user.getStatus();
				} else {
					// the user is protected
					content[num-1] ="@" + user.getScreenName();
				}
				try {
					WriteFile wf = new WriteFile(oppath,true);
					wf.writeToFile(content[num-1]);
					
					System.out.println("Dude, Got users info!");
				}
				catch (IOException e) {
					System.out.println(e.getMessage());
									}
				//System.out.println(content[num-1]);
				num=num-1;
				try {
				    Thread.sleep(6000);                 //1000 milliseconds is one second.
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}				
				
			}	
            System.exit(0);
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("WTF! Failed to delete status: " + te.getMessage());
            System.exit(-1);
        }
        
    }
}

