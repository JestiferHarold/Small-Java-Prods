public enum HangDiagram {
	FULL_LIFE(" _____________\n" +
	         "|             |\n" +
		 "|             |\n" +
		 "|             |\n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|_____________" ),
	THREE_LIFES(" _____________\n" +
	         "|             |\n" +
		 "|             |\n" +
		 "|             |\n" +
		 "|	      O\n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|_____________"),
	TWO_LIFES(" _____________\n" +
	         "|             |\n" +
		 "|             |\n" +
		 "|             |\n" +
		 "|	      O\n" +
		 "|	     / \\ \n" +
		 "|\n" +
		 "|\n" +
		 "|\n" +
		 "|_____________"),
	ONE_LIFE(" _____________\n" +
	         "|             |\n" +
		 "|             |\n" +
		 "|             |\n" +
		 "|	      O\n" +
		 "|	     /|\\ \n" +
		 "|	      |\n" +
		 "|\n" +
		 "|\n" +
		 "|_____________"),
	DEAD(" _____________\n" +
	         "|             |\n" +
		 "|             |\n" +
		 "|             |\n" +
		 "|	      O\n" +
		 "|	     /|\\ \n" +
		 "|	      |\n" +
		 "|  	     / \\\n" +
		 "|\n" +
		 "|_____________");
	
	private final String diagram;

	HangDiagram(String d) {
		diagram = d;
	}

	public String getDiagram() {
		return diagram;
	}
}
