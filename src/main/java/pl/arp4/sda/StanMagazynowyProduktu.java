package pl.arp4.sda;

public class StanMagazynowyProduktu {
    private String nazwa;
    private double ilosc = 0.0;
    private Jednostka jednostka;

    public StanMagazynowyProduktu(String nazwa, Jednostka jednostka) {
        this.nazwa = nazwa;
        this.jednostka = jednostka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getIlosc() {
        return ilosc;
    }

    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }

    public Jednostka getJednostka() {
        return jednostka;
    }

    public void setJednostka(Jednostka jednostka) {
        this.jednostka = jednostka;
    }

    @Override
    public String toString() {
        return "StanMagazynowyProduktu{" +
                "nazwa= '" + nazwa + '\'' +
                ", ilosc= " + ilosc + " " +
                jednostka +
                '}';
    }
}
