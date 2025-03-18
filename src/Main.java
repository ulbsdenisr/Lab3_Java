import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "input.txt";
        Map<String, Integer> cuvIntalnite = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase().replaceAll("[^a-zA-Z0-9]", " ");
                String[] words = line.split(" ");

                for (String word : words) {
                   /* if (!word.isEmpty()) {
                        cuvIntalnite.put(word, cuvIntalnite.getOrDefault(word, 0) + 1);
                    }
                    */
                    if(cuvIntalnite.containsKey(word))
                    {
                        cuvIntalnite.put(word,cuvIntalnite.get(word)+1);
                    }
                    else
                    {
                        cuvIntalnite.put(word,1);
                    }
                }
            }
            scanner.close();
            for(String word : cuvIntalnite.keySet())
            {
               /* System.out.println("Frecvența cuvintelor în fișier:");
                cuvIntalnite.forEach((key, value) -> System.out.println(key + ": " + value));
                */
                System.out.println(word + " " + cuvIntalnite.get(word));
            }

        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Nu am găsit fișierul '" + filePath + "'.");
            return;
        }
    }
}
