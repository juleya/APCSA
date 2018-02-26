package magpie;

public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf("dog") >= 0 || statement.indexOf("cat") >= 0) {
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("Remington") >= 0) {
			response = "He sounds like a good teacher.";
		}
		
		else if ((statement.trim()).length() == 0) {
			response = "Say something please.";
		}
		else if (statement.indexOf("school") >= 0) {
			response = "What school do you go to?";
		}
		else if (statement.indexOf("stress") >= 0) {
			response = "What do you do to calm down?";
		}
		else if (statement.indexOf("weather") >= 0) {
			response = "Do you think it's going to be sunny in a week?";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4) {
			response = "How does that make you feel?";
		}
		else if (whichResponse == 5) {
			response = "Is that right?";
		}
		return response;
	}
}
