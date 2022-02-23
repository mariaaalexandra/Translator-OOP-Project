import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //  CITIRE
        Tests.Task1();

        //ADAUGARE CUVANT IN DICTIONAR
        Tests.Task2();

        //STERGERE CUVANT DIN DICTIONAR
        Tests.Task3();

        //ADAUGARE DEFINITIE
        Tests.Task4();

        //STERGERE DEFINITIE
        Tests.Task5();

        //TRADUCERE CUVANT
        Tests.Task6();

        //TRADUCERE PROPOZITIE
        Tests.Task7();

        //TRADUCERE PROPOZITII
        Tests.Task8();

        //AFISARE DEFINITII
        Tests.Task9();

        //EXPORTARE DICTIONAR
        Tests.Task10();

    }
}
