import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


class NrPers {
    public static void main(String[] args) {
        String filePath = "persoane.txt";
        List<Person> personList = new ArrayList<>();
        Map<Person, Integer> persoane = new HashMap<>();

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    Person person = new Person(parts[0],parts[1]);
                    personList.add(person);
                    persoane.put(person, persoane.getOrDefault(person, 0) + 1);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Eroare: Fișierul '" + filePath + "' nu a fost găsit.");
            return;
        }

        for(Person p : persoane.keySet()){
            if(persoane.get(p)>=3){
                System.out.print(p);
            }
        }
    }
}
