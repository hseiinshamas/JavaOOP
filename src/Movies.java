package PACKAGE_NAME;public class movies {

  import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Movies {

    private ArrayList<String> movies;


    public Movies(String pathname) {
        movies = new ArrayList<>();
        File file = new File(pathname);
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                movies.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file does not exist !");
        }
    }
    public String getMovie() {
        int indexMovie = (int)(Math.random()* movies.size());
        return movies.get(indexMovie);
    }

}
