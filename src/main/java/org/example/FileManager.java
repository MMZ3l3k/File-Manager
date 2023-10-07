package org.example;

import java.io.File;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class FileManager {

    public void listFilesInDirectory(String directory) //metoda wyswietlajaca nam pliki w danym folderze (argument to katalog ktoego pliki chcemy wyswietlic)
    {
        //ta metoda zwraca pliki i foldery (folderow nie chcemy) wiec trzeba przefiltrowac ta liste i chcemy wyswietlic nazwy plikow
        //Stream.of Ta metoda konwertuje tablicę (zwróconą przez listFiles()) na strumień (Stream), co umożliwia wykorzystanie kolejnych operacji strumieniowych.

        Stream.of(Objects.requireNonNull(new File(directory).listFiles())) //Za pomocą metody listFiles() na obiekcie klasy File pobierana jest lista wszystkich plików i podkatalogów wewnątrz katalogu.
       //  requireNonNull Ta metoda jest używana, aby upewnić się, że zwrócona lista plików nie jest nullem. Jeśli jest nullem, zostanie zgłoszony wyjątek NullPointerException.
                .filter(File::isFile)
                .map(File::getName)
                .forEach(System.out::println);


    }
    //sortowanie plikow pod wzgledem wielkosci od najwiekszego do najmniejszego
    public void sortFilesInDirectory(String directory){
        Stream.of(Objects.requireNonNull(new File(directory).listFiles()))
                .filter(File::isFile)
                .sorted((o1, o2) -> {
                    return Long.compare(o2.length(), o1.length());
                })
                .forEach(file -> {
                    System.out.println(file.getName());
                    System.out.println(file.length());
                    System.out.println(" ");


                });



    }
}
