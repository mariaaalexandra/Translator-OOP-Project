import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Tests {
    public static void Task1() {
        ParssInfo parssInfo = new ParssInfo();
        parssInfo.getDictionaries();
    }

    public static void Task2() {
        //informatii cuvantul "chien"
        List<String> singular = new ArrayList<String>();
        singular.add("chien");
        List<String> plural = new ArrayList<String>();
        plural.add("chiens");
        ArrayList<DefinitionType> definitions = new ArrayList<DefinitionType>();
        ArrayList<String> text = new ArrayList<String>();
        text.add("cabot");
        text.add("clebard");
        text.add("clebs");
        text.add("toutou");
        DefinitionType def = new DefinitionType("Larousse", "synonyms", 2000, text);
        definitions.add(def);
        ArrayList<String> textNew = new ArrayList<String>();
        textNew.add(" Mammifère (canidé) carnivore aux multiples races\");");
        DefinitionType defNew = new DefinitionType("Larousse", "definitions", 2000, textNew);
        definitions.add(defNew);
        WordType cuv = new WordType("chien", "dog", "noun", singular, plural, definitions, "FR");

        //informatii cuvantul "pomme"
        List<String> singularSecond = new ArrayList<String>();
        singularSecond.add("pomme");
        List<String> pluralSecond = new ArrayList<String>();
        pluralSecond.add("pommes");
        ArrayList<DefinitionType> definitionsSecond = new ArrayList<DefinitionType>();
        ArrayList<String> textSec1 = new ArrayList<String>();
        textSec1.add("fleur de pommier");
        textSec1.add("trognon de pomme");
        textSec1.add("trongon");
        textSec1.add("fleur");
        DefinitionType defSec = new DefinitionType("Larousse", "synonyms", 2000, textSec1);
        definitionsSecond.add(defSec);
        ArrayList<String> textSec2 = new ArrayList<String>();
        WordType cuvSec = new WordType("pomme", "apple", "noun", singularSecond, pluralSecond, definitionsSecond, "FR");

        String path = "src/test/outputs/outTask2";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Forma initiala a dictionarului");
            writer.write("\n");
            for (WordType i : ParssInfo.newWords) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.write("METODA ADDWORD");
            writer.write("\n");
            writer.write("Adaugare verificare cuvant chien");
            writer.write("\n");
            if (Methods.addWord(cuv, "FR") == false) {
                writer.write("Cuvantul exista deja");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");;
                }
            }
            writer.write("Adaugare verificare cuvant pomme");
            writer.write("\n");
            if (Methods.addWord(cuvSec, "FR") == false) {
                writer.write("Cuvantul exista deja");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            //Cazul in care cuvantul exista deja in dictionar
            writer.write("Verificare adaugare cuvant care exista deja");
            writer.write("\n");
            if (Methods.addWord(cuv, "FR") == false) {
                writer.write("Cuvantul exista deja");
            }
            else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static void Task3() {
        String path = "src/test/outputs/outTask3";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Forma initiala a dictionarului");
            writer.write("\n");
            for (WordType i : ParssInfo.newWords) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.write("METODA REMOVEWORD");
            writer.write("\n");
            writer.write("Stergere verificare cuvant chien");
            writer.write("\n");
            if (Methods.removeWord("chien", "FR") == false) {
                writer.write("Cuvantul nu exista");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.write("Stergere verificare cuvant pomme");
            writer.write("\n");
            if (Methods.removeWord("pomme", "FR") == false) {
                writer.write("Cuvantul nu exista");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            //Cazul in care cuvantul nu exista in dictionar
            writer.write("Verificare stergere cuvant care nu exista in dictionar");
            writer.write("\n");
            if (Methods.removeWord("chien", "FR") == false) {
                writer.write("Cuvantul nu exista");
            }
            else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        //Adaugare cuvant "chien" din nou
        //informatii cuvantul "chien"
        List<String> singular = new ArrayList<String>();
        singular.add("chien");
        List<String> plural = new ArrayList<String>();
        plural.add("chiens");
        ArrayList<DefinitionType> definitions = new ArrayList<DefinitionType>();
        ArrayList<String> text1 = new ArrayList<String>();
        text1.add("cabot");
        text1.add("clebard");
        text1.add("clebs");
        text1.add("toutou");
        DefinitionType def1 = new DefinitionType("Larousse", "synonyms", 2000, text1);
        definitions.add(def1);
        ArrayList<String> text2 = new ArrayList<String>();
        text2.add(" Mammifère (canidé) carnivore aux multiples races\");");
        DefinitionType def2 = new DefinitionType("Larousse", "definitions", 2000, text2);
        definitions.add(def2);
        WordType carte = new WordType("chien", "dog", "noun", singular, plural, definitions, "FR");

        Methods.addWord(carte, "FR");

    }

    public static void Task4() {
        String path = "src/test/outputs/outTask4";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Forma initiala a dictionarului");
            writer.write("\n");
            for (WordType i : ParssInfo.newWords) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.write("METODA ADDDEFINITION");
            writer.write("\n");
            writer.write("Adaugare definitie cuvant chien");
            writer.write("\n");
            ArrayList<String> text = new ArrayList<String>();
            text.add("l'être vivant qui aboie");
            DefinitionType def = new DefinitionType("Larousse", "definitions", 2000, text);
            if (Methods.addDefinitionForWord("chien", "FR", def) == false) {
                writer.write("Definitia exista deja in dictionar");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.write("Adaugare definite cuvant chat");
            writer.write("\n");
            ArrayList<String> textSec = new ArrayList<String>();
            textSec.add("l'être vivant qui miaule");
            DefinitionType defSec = new DefinitionType("Larousse", "definitions", 2000, textSec);
            if (Methods.addDefinitionForWord("chat", "FR", defSec) == false) {
                writer.write("Cuvantul nu exista");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            //Cazul in care definitia  exista in dictionar
            writer.write("Verificare definitie care exista in dictionar");
            writer.write("\n");
            ArrayList<String> textThird = new ArrayList<String>();
            textThird.add("l'être vivant qui aboie");
            DefinitionType defThird = new DefinitionType("Larousse", "definitions", 2000, textThird);
            if (Methods.addDefinitionForWord("chien", "FR", defThird) == false) {
                writer.write("Definitia exista");
            }
            else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task5() {
        String path = "src/test/outputs/outTask5";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Forma initiala a dictionarului");
            writer.write("\n");
            for (WordType iter : ParssInfo.newWords) {
                writer.write(String.valueOf(iter));
                writer.write("\n");
            }
            writer.write("METODA REMOVEDEFINITION");
            writer.write("\n");
            writer.write("Stergere definitie cuvant jeu");
            writer.write("\n");
            if (Methods.removeDefinition("jeu", "FR", "Larousse") == false) {
                writer.write("Definitia nu exista in dictionar");
            } else {
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
            }
            writer.write("Stergere definite cuvant manger");
            writer.write("\n");

            if (Methods.removeDefinition("manger", "FR", "Larousse") == false) {
                writer.write("Definitia nu exista");
            } else {
                for (WordType iter : ParssInfo.newWords) {
                    writer.write(iter.toString());
                    writer.write("\n");
                }
            }
            //Cazul in care definitia nu exista in dictionar
            writer.write("Verificare definitie care nu exista in dictionar");
            writer.write("\n");
            if (Methods.removeDefinition("jeu", "FR", "Larousse") == false) {
                writer.write("Definitia nu exista");
            }
            else {
                for (WordType iter : ParssInfo.newWords) {
                    writer.write(iter.toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task6() {
        String path = "src/test/outputs/outTask6";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("METODA TRANSLATE_WORD");
            writer.write("\n");
            writer.write("Traducere cuvant caine RO-FR");
            writer.write("\n");
            writer.write("Caine " + Methods.translateWord("câine", "RO", "FR"));
            writer.write("\n");
            writer.write("Traducere cuvant dog ENG-FR");
            writer.write("\n");
            writer.write("Dog " + Methods.translateWord("dog", "ENG", "FR"));
            writer.write("\n");
            writer.write("Verificare cuvantul nu exista");
            writer.write("\n");
            writer.write("Cake " + Methods.translateWord("cake", "ENG", "RO"));
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task7() {
        String path = "src/test/outputs/outTask7";
        File file = new File(path);

      //Se adauga verbul "a manca"
        List<String> singular = new ArrayList<String>();
        singular.add("mananc");
        singular.add("mananci");
        singular.add("mananca");
        List<String> plural = new ArrayList<String>();
        plural.add("mancam");
        plural.add("mancati");
        plural.add("mananca");
        ArrayList<DefinitionType> definitions = new ArrayList<DefinitionType>();
        List<String> text = new ArrayList<String>();
        text.add("a inhala");
        text.add("a introduce alimente in cavitatea bucala");
        DefinitionType def = new DefinitionType("Dicționarul explicativ al limbii române, ediția a II-a", "synonyms", 2000, text);
        definitions.add(def);
        WordType word = new WordType("manca", "eat", "verb", singular, plural, definitions, "RO");
        ParssInfo.newWords.add(word);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("METODA TRANSLATE_SENTENCE");
            writer.write("\n");
            writer.write("Forma initiala a dictionarului");
            writer.write("\n");
            for (WordType i : ParssInfo.newWords) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.write("Traducere RO-FR");
            writer.write("\n");
            writer.write("Pisică mananca " + Methods.translateSentence("pisică mananca", "RO", "FR"));
            writer.write("\n");
            writer.write("Traducere FR-RO");
            writer.write("\n");
            writer.write("Chien mange " + Methods.translateSentence("chien mange", "FR", "RO"));
            writer.write("\n");
            writer.write("Verificare cuvantul nu exista");
            writer.write("\n");
            writer.write("Broasca sare " + Methods.translateSentence("broasca sare", "RO", "FR"));
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task8() {
        String path = "src/test/outputs/outTask8";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("METODA TRANSLATE_SENTENCES");
            writer.write("\n");
            writer.write("Traducere RO-FR");
            writer.write("\n");
            writer.write("Pisică mananca " + Methods.translateSentences("pisică mananca", "RO", "FR"));
            writer.write("\n");
            writer.write("Traducere FR-RO");
            writer.write("\n");
            writer.write("Chien mange " + Methods.translateSentence("chien mange", "FR", "RO"));
            writer.write("\n");
            writer.write("Verificare cuvantul nu exista");
            writer.write("\n");
            writer.write("Broasca sare " + Methods.translateSentence("broasca sare", "RO", "FR"));
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task9() {
        String path = "src/test/outputs/outTask9";
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("METODA GET_DEFINITIONS");
            writer.write("\n");
            writer.write("Definitii pentru cuvantul caine");
            writer.write("\n");
            ArrayList<DefinitionType> first = Methods.getDefinitionsForWord("câine", "RO");
            if (first.size() != 0) {
                for (DefinitionType def : first) {
                    writer.write(def.toString());
                    writer.write("\n");
                }
            }
            else {
                writer.write("Cuvantul nu exista in dictionar");
                writer.write("\n");
            }
            writer.write("Definitii pentru cuvantul chat");
            writer.write("\n");
            ArrayList<DefinitionType> second = Methods.getDefinitionsForWord("chat", "FR");
            if (second.size() != 0) {
                for (DefinitionType def : second) {
                    writer.write(def.toString());
                    writer.write("\n");
                }
            }
            else {
                writer.write("Cuvantul nu exista in dictionar");
                writer.write("\n");
            }
            writer.write("Definitii pentru cuvant care nu exista in dictionar");
            writer.write("\n");
            ArrayList<DefinitionType> third = Methods.getDefinitionsForWord("floare", "RO");
            if (third.size() != 0) {
                for (DefinitionType def : first) {
                    writer.write(def.toString());
                    writer.write("\n");
                }
            }
            else {
                writer.write("Cuvantul nu exista in dictionar");
                writer.write("\n");
            }
            writer.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static void Task10() {
        Methods.exportDictionary("FR");
        Methods.exportDictionary("RO");
    }
}
