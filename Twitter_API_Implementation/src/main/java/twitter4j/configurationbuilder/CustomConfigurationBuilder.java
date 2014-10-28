package twitter4j.configurationbuilder;

import twitter4j.conf.ConfigurationBuilder;

public class CustomConfigurationBuilder {
	
	ConfigurationBuilder configurationBuilder=null;

	public CustomConfigurationBuilder() {

		configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthConsumerKey("u5DkUHFYiHFgjthvcivFKb1r9");
		configurationBuilder
				.setOAuthConsumerSecret("2Gxi8Ng6bI13ZWbCoyflXJlBkyb0S08Y0HTRjk9Mn98A7JTPdp");
		configurationBuilder
				.setOAuthAccessToken("2788136796-IRvS3V3ZRAZx8gRE1OBzUpADXfQiGUaMIYrWyNQ");
		configurationBuilder
				.setOAuthAccessTokenSecret("GU4duYToRWhWnfWYgkYbz5CPy73XT0PoWeS24XbZGgQXd");
	
	
	}

	public ConfigurationBuilder getConfigurationBuilder() {
		return configurationBuilder;
	}

	public void setConfigurationBuilder(ConfigurationBuilder configurationBuilder) {
		this.configurationBuilder = configurationBuilder;
	}
	

}
