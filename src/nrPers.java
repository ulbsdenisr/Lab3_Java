import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class nrPers {
    public static void main(String[] args) {
        String filePath = "persoane.txt";
        Map<Person, Integer> persoane = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    Person person = new Person(parts[0], parts[1]);
                    if (persoane.containsKey(person)) {
                        persoane.put(person, persoane.get(person) + 1);
                    } else {
                        persoane.put(person, 1);
                    }
                }
            }

            scanner.close();

            for (Person person : persoane.keySet()) {
                if (persoane.get(person) >= 3) {
                    System.out.println(person);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Nu am găsit fișierul '" + filePath + "'.");
        }
    }
}
