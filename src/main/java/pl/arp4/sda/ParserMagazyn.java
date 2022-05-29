package pl.arp4.sda;

import java.util.Arrays;
import java.util.Scanner;

public class ParserMagazyn {

        Magazyn magazyn = new Magazyn();
        Scanner scanner = new Scanner(System.in);
        Jednostka jednostka = null;
        String komenda;

        public void doIt (){
            do {
                System.out.println("Podaj komende: (dodaj, wypisz, usuń, zwróć, zwiększ, zmniejsz, lista, koniec)");
                komenda = scanner.next();

                if (komenda.equalsIgnoreCase("dodaj")) {
                    System.out.println("Podaj nazwę produktu ");
                    String nazwa = scanner.next();
                    System.out.println("Podaj jednostkę dla produktu " + nazwa + " GRAM, SZTUKA, LITR" + ":");
                    String jednostkaString = scanner.next();
                    try {

                        jednostka = Jednostka.valueOf(jednostkaString.toUpperCase());
                    } catch (IllegalArgumentException iae) {
                        System.out.println("U nas nie ma takiej jednostki");
                    }
                    magazyn.dodajProdukt(nazwa, jednostka);
                } else if (komenda.equalsIgnoreCase("wypisz")){
                    magazyn.wypiszWszystkieProdukty();

                }else if (komenda.equalsIgnoreCase("usuń")){
                    System.out.println("Podaj nazwę produktu do usunięcia ");
                    String nazwa = scanner.next();
                    magazyn.usunProdukt(nazwa);

                }else if (komenda.equalsIgnoreCase("zwróć")){
                    System.out.println("Jakiego szukasz produktu ");
                    String nazwa = scanner.next();
                    magazyn.zwrocProdukt(nazwa);

                }else if (komenda.equalsIgnoreCase("zwiększ")){
                    System.out.println("Dla jakiego produktu chcesz zwiększyć stan magazynu ");
                    String nazwa = scanner.next();
                    System.out.println("O ile chcesz zwiększyć stan magazynu ");
                    double ilosc = scanner.nextDouble();
                    magazyn.zwiekszStanMagazynowy(nazwa, ilosc);

                }else if (komenda.equalsIgnoreCase("zmniejsz")){
                    System.out.println("Dla jakiego produktu chcesz zmniejszyć stan magazynu ");
                    String nazwa = scanner.next();
                    System.out.println("O ile chcesz zmniejszyć stan magazynu ");
                    double ilosc = scanner.nextDouble();
                    magazyn.zmniejszStanMagazynowy(nazwa, ilosc);

                }else if (komenda.equalsIgnoreCase("lista")){
                    System.out.println("Podaj wielkość, dla której szukamy produktów o mniejszej ilości od podanej przez Ciebie ");
                    double ilosc = scanner.nextDouble();
                    System.out.println("Podaj jednostkę dla produktu " + (Arrays.toString(Jednostka.values())) + ":");
                    String jednostkaNowa = scanner.next();
                    try {

                        jednostka = Jednostka.valueOf(jednostkaNowa.toUpperCase());
                    } catch (IllegalArgumentException iae) {
                        System.out.println("U nas nie ma takiej jednostki");
                    }
                    System.out.println("Lista produktów o mniejszej ilości niż " + ilosc + " to ");
                    magazyn.zwrocListeProduktowKtorychIloscJestMniejszaNiz(ilosc, jednostka);

                }


            } while (!komenda.equalsIgnoreCase("koniec"));


        }



    }

