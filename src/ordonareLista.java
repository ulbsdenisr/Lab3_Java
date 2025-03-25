import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class ordonareLista {
    public static void main(String[] args) {
        String inputPath = "persoane.txt";
        String outputPath = "output.txt";
        List<Person> persoane = new ArrayList<>();

        try {
            citFisier(inputPath, persoane);

            sortareLista(persoane);

            afisareLista(persoane);
            afisFisier(persoane, outputPath);

        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Nu am găsit fișierul '" + inputPath + "'.");
        }
    }

    private static void afisFisier(List<Person> persoane, String filePath) {
        try {
            PrintWriter writer = new PrintWriter(filePath);

            for (Person person : persoane) {
                writer.println(person);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Eroare la scrierea în fișier: " + filePath);
        }
    }

    private static void afisareLista(List<Person> persoane) {
        for (Person person : persoane) {
            System.out.println(person);
        }
    }

    private static List<Person> sortareLista(List<Person> persoane) {
        persoane.sort(
                Comparator.comparing(Person::getNume)
                        .thenComparing(Person::getPrenume)
                        .thenComparingInt(Person::getVarsta)
        );
        return persoane;
    }

    private static void citFisier(String filePath, List<Person> persoane) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split(" ");

            if (parts.length == 3) {
                String nume = parts[0];
                String prenume = parts[1];
                int varsta;

                try {
                    varsta = Integer.parseInt(parts[2]);
                } catch (NumberFormatException e) {
                    System.err.println("Linie invalidă: " + line);
                    continue;
                }

                persoane.add(new Person(nume, prenume, varsta));
            }
        }

        scanner.close();
    }
}
