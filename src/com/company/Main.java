package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj pełną ścieżke pliku słownika: ");
        String sciezka = scanner.nextLine();

        System.out.println("Podaj szukane słowo:");
        String szukaneSlowo = scanner.nextLine();

        //odwrocenie szukanego slowa
        char[] szuakeZnaki = szukaneSlowo.toCharArray();
        Arrays.sort(szuakeZnaki);
        String posortowaneSzukaneSlowo = new String(szuakeZnaki);

        ArrayList<String> znalezioneAnagramy = new ArrayList<>();

        try {
            // otwieranie pliku
            Stream<String> lines = Files.lines(Paths.get(sciezka));

            // ODCZYT KOLEJNYCH LINII Z PLIKU
            lines.forEach(slowo -> {
                // sortowanie wyrazu po literkach
                char[] chars = slowo.toCharArray();
                Arrays.sort(chars);
                String posortowaneSlowo = new String(chars);

// posortowany wyraz ze slownika porownywany jest z szukanym slowem, a nastepnie dodawany jest do Tablicy

                if (posortowaneSlowo.equals(posortowaneSzukaneSlowo)) {
                    znalezioneAnagramy.add(slowo);
                }

            });


        } catch (NoSuchFileException ex) {
            System.out.println("Nie ma takiego pliku: " + sciezka);
            System.exit(1);
        }


        System.out.println(znalezioneAnagramy);

    }
}
