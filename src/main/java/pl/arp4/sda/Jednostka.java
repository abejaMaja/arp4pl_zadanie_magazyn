package pl.arp4.sda;

public enum Jednostka {
    GRAM ("g"),
    SZTUKA("szt."),
    LITR("l");

    private final String jednostka;
    Jednostka(String jednotka) {
        this.jednostka = jednotka;
    }

    public String getJednotka() {
        return jednostka;
    }

    @Override
    public String toString() {
        return jednostka;
    }
}
