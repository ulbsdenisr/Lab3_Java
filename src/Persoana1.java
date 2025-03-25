public class Persoana1 {
    String nume;
    String prenume;

    public Persoana1(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String toString() {
        return nume + " " + prenume;
    }
}
