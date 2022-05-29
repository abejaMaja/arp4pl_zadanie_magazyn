package pl.arp4.sda;

import java.util.*;

public class Magazyn {
    Map<String, StanMagazynowyProduktu> mapaMagazynu = new HashMap<>();

    public void dodajProdukt(String nazwa, Jednostka jednostka) {
        if (mapaMagazynu.containsKey(nazwa)) {
            System.err.println("Produkt o podanej nazwie już istnieje");
        } else {
            mapaMagazynu.put(nazwa, new StanMagazynowyProduktu(nazwa, jednostka));
        }
    }

    public void wypiszWszystkieProdukty() {
        System.out.println("Lista produktów:");
        for (StanMagazynowyProduktu produkt : mapaMagazynu.values()) {
            System.out.println(produkt);
        }
    }

    public void usunProdukt(String nazwa) {
        if (mapaMagazynu.containsKey(nazwa)) {
            mapaMagazynu.remove(nazwa);
            System.out.println("Usunięto produkt o nazwie " + nazwa);
        } else {
            System.err.println("Produkt o podanej nazwie nie istnieje");
        }
    }

    public Optional<StanMagazynowyProduktu> zwrocProdukt(String nazwa) {
        if (mapaMagazynu.containsKey(nazwa)) {
            System.out.println("Znaleziono produkt o nazwie: " + nazwa);
            return Optional.of(mapaMagazynu.get(nazwa));
        } else {
            System.err.println("Produkt o podanej nazwie nie istnieje");
            return Optional.empty();
        }

    }

    public void zwiekszStanMagazynowy(String nazwa, double ilosc) {
        if (!mapaMagazynu.containsKey(nazwa)) {
            System.err.println("Nie ma takiego produktu! Nie da się zwiększyć ilości produktu, którego nie ma ");
        } else {
            StanMagazynowyProduktu produkt = mapaMagazynu.get(nazwa);
            produkt.setIlosc(ilosc);
            System.out.println("Dodano " + ilosc + "produktów ");
        }

    }

    public void zmniejszStanMagazynowy(String nazwa, double ilosc) {
        if (!mapaMagazynu.containsKey(nazwa)) {
            System.err.println("Nie ma takiego produktu! Nie da się zwiększyć ilości produktu, którego nie ma ");
        } else if (mapaMagazynu.get(nazwa).getIlosc() <= 0) {
            System.out.println("Produkt " + nazwa + " ma obecnie 0 na stanie, nie możesz zatem odjąć, bo nic nie ma");
        } else {
            StanMagazynowyProduktu produkt = mapaMagazynu.get(nazwa);
            double nowaIlosc = produkt.getIlosc() - ilosc;
            produkt.setIlosc(nowaIlosc);
            System.out.println("Odjęto " + ilosc + " produktów ");
        }

    }


    public List<StanMagazynowyProduktu> zwrocListeProduktowKtorychIloscJestMniejszaNiz(double ilosc, Jednostka jednostka) {
        List<StanMagazynowyProduktu> listaOdIlosc = new ArrayList<>();

        for (StanMagazynowyProduktu produkt : mapaMagazynu.values()) {
            double iloscProduktu = produkt.getIlosc();
            if (iloscProduktu <= ilosc) {
                listaOdIlosc.add(produkt);
            }
        }


        return listaOdIlosc;
    }
}