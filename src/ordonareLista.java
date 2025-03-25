import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ordonareLista {
    public static void main(String[] args) {
        String filePath = "persoane.txt";
        List<Person> persoane = new ArrayList<>();

        try {
            citFisier(filePath, persoane);

            sortareLista(persoane);

            afisareLista(persoane);

        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Nu am găsit fișierul '" + filePath + "'.");
        }
    }

    private static void afisareLista(List<Person> persoane) {
        for (Person person : persoane) {
            System.out.println(person);
        }
    }

    private static List<Person> sortareLista(List<Person> persoane) {
        /*for (int i = 0; i < persoane.size() - 1; i++) {
            for (int j = i + 1; j < persoane.size(); j++) {
                Person p1 = persoane.get(i);
                Person p2 = persoane.get(j);

                if (p1.getNume().compareTo(p2.getNume()) > 0 ||
                        (p1.getNume().equals(p2.getNume()) && p1.getPrenume().compareTo(p2.getPrenume()) > 0) ||
                        (p1.getNume().equals(p2.getNume()) && p1.getPrenume().equals(p2.getPrenume()) && p1.getVarsta() > p2.getVarsta())) {
                    persoane.set(i, p2);
                    persoane.set(j, p1);
                }
            }
        }*/
        persoane.sort(Comparator.comparing(p -> p.getNume()));

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
