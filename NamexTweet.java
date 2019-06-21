import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class NamexTweet {
    private final static String CONSUMER_KEY = "JnnZ8V1xLOxih4rwMbyqHe3bM";
    private final static String CONSUMER_KEY_SECRET = "WnSh11qAVDJeS8B39mlCB9kI1uTOpeL9gv4NDwzzXKvZJJeDY9";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "5JEFVt6NRHNVxJHne8ekfHyq0ER3u9FoBFc8B1aXD17uy";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1138399948284633089-5zuiBJBGBBVm0SLz3GiZ8D1qA4gAqY";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}