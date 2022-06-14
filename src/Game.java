package PACKAGE_NAME;public class game {
  
   private final String moviesToGuess;
    private int pointsLost;
    private String wrongLetters;
    private String rightLetters;
    private boolean gameWon;


    public Game(String pathname) {
        Movies movies = new Movies(pathname);
        moviesToGuess = movies.getMovie().trim();
        pointsLost = 0;
        wrongLetters = "";
        rightLetters = "";
        gameWon = false;
    }

    public String getMoviesTitle() {
        return moviesToGuess;
    }

    public String getHiddenMovies() {
        if (rightLetters.equals("")) {
            return moviesToGuess.replaceAll("[a-zA-Z]", "_");
        } else {
            return moviesToGuess.replaceAll("[a-zA-Z&&[^" + rightLetters + "]]", "_");
        }
    }

    public String getWrongLetters() {
        return wrongLetters;
    }

    public boolean WonGame() {
        return gameWon;
    }

    public boolean gameEnded() {
        if (pointsLost >= 10) {
            return true;
        }

        if (!getHiddenMovies().contains("_")) {
            gameWon = true;
            return true;
        }
        return false;

    }

    private String inputLetter() {
        System.out.println("Guess a letter:");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine().toLowerCase();

        if (!letter.matches("[a-z]")) {
            System.out.println("That is not a letter.");
            return inputLetter();
        } else if (wrongLetters.contains(letter) || rightLetters.contains(letter)) {
            System.out.println("You already guessed that letter.");
            return inputLetter();
        } else {
            return letter;
        }
    }

    public void guessLetter() {
        String guessedLetter = inputLetter();

        if (moviesToGuess.toLowerCase().contains(guessedLetter)) {
            rightLetters += guessedLetter + guessedLetter.toUpperCase();
        } else {
            pointsLost++;
            wrongLetters += " " + guessedLetter;
        }
    }
}
