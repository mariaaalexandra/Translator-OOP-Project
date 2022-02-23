import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Methods {
    public static boolean addWord(WordType word, String language) {
        //Parcurg cuvintele existente
        //Verific daca limba si denumirea coincid
        for (WordType each : ParssInfo.newWords) {
            boolean wordEqual = (word.getWord()).equals(each.getWord());
            boolean languageEqual = language.equals(each.getLanguage());
            if (languageEqual == true && wordEqual == true) {
                return false;
            }
            else {
            }
        }
        ParssInfo.newWords.add(word);
        return true;

    }

    public static boolean removeWord(String word, String language) {
        //numarul de cuvinte din dictionar
        int count = ParssInfo.newWords.size();
        //cuvantul cautat
        WordType searchedWord = new WordType();
        //Parcurg cuvintele
        //Verific daca numele si limba coincid
        for (int i = 0; i < count; i++) {
            searchedWord = ParssInfo.newWords.get(i);
            boolean wordEqual = word.equals(searchedWord.getWord());
            boolean languageEqual = language.equals(searchedWord.getLanguage());
            if (languageEqual == true) {
                if (wordEqual == true) {
                    ParssInfo.newWords.remove(searchedWord);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean addDefinitionForWord(String word, String language, DefinitionType definition) {
        //numar de cuvinte
        int count = ParssInfo.newWords.size();
        //cuvantul cautat
        WordType searchedWord;
        //parcurg cuvintele si caut cuvantul dat ca parametru
        for (int i = 0; i < count; i++) {
            searchedWord = ParssInfo.newWords.get(i);
            boolean wordEqual = word.equals(searchedWord.getWord());
            boolean languageEqual = language.equals(searchedWord.getLanguage());
            //pentru cuvantul gasit parcurg definitile si verific daca
            //definitia exista sau nu
            if (wordEqual == true && languageEqual == true) {
                int number = searchedWord.getDefinitions().size();
                for (int j = 0; j < number; j++) {
                    DefinitionType searchedDef = searchedWord.getDefinitions().get(j);
                    boolean defEqual = definition.getText().equals(searchedDef.getText());
                    if (defEqual == true) {
                        return false;
                    }
                }
                //adaug definitia
                searchedWord.getDefinitions().add(definition);
                return true;
            }
        }
        return false;
    }

    public static boolean removeDefinition(String word, String language, String dictinoary) {
        //numarul de cuvinte
        int count = ParssInfo.newWords.size();
        //cuvantul cautat
        WordType searchedWord;
        //parcurg cuvintele si verific
        //daca am ajuns la cuvantul cauta
        for (int i = 0; i < count; i++) {
            searchedWord = ParssInfo.newWords.get(i);
            boolean wordEqual = word.equals(searchedWord.getWord());
            boolean languageEqual = language.equals(searchedWord.getLanguage());
            //verific daca exista definitia in dictionar si o sterg
            if (wordEqual == true && languageEqual == true) {
                if (searchedWord.getDefinitions().size() != 0) {
                    searchedWord.getDefinitions().clear();
                } else {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static String translateWord(String word, String fromLanguage, String toLanguage) {
        //Cuvanatul nu exista
        int value = 0;
        //forma de plural si singular
        int sg = 0;
        int pl = 0;
        //numarul de cuvinte
        int count = ParssInfo.newWords.size();
        //cuvant ce trebuie tradus
        WordType fromWord;
        //cuvant tradus
        WordType toWord;
        //traducere in engleza
        String transEng = "";
        //cuvantul tradus
        String  transWord = "NU EXISTA";

        //Parcurg cuvintele si caut cuvantul
        //dat ca parametru atat in formele de
        //singular cat si de plural
        for (int i = 0; i < count; i++) {
            fromWord = ParssInfo.newWords.get(i);
            boolean wordEqual = word.equals(fromWord.getWord());
            //cand cuvantul este gasit retin forma in engleza
            if (wordEqual == true ) {
                if (fromWord.getSingular().contains(word)) {
                    value = 1;
                    transEng = fromWord.getWord_en();
                    sg = 1;
                    break;
                }
                else if (fromWord.getPlural().contains(word)) {
                    value = 1;
                    transEng = fromWord.getWord_en();
                    pl = 1;
                    break;
                }
                value = 1;
                transEng = fromWord.getWord_en();
                break;
            }
            if (fromWord.getSingular().contains(word)) {
                value = 1;
                transEng = fromWord.getWord_en();
                sg = 1;
                break;
            }
            else if (fromWord.getPlural().contains(word)) {
                value = 1;
                transEng = fromWord.getWord_en();
                pl = 1;
                break;
            }
        }
        //daca cuvantul de tradus este deja in engleza
        if (fromLanguage.equals("ENG")) {
            transEng = word;
            value = 1;
        }
        //daca limba de traducere este engleza se returneaza direct
        if (toLanguage.equals("ENG")) {
            return transEng;
        }
        else {
            //Se parcurge lista din nou si se
            //cauta cuvantul cu traducerea in engleza
            for (int i = 0; i < count; i++) {
                toWord = ParssInfo.newWords.get(i);
                String type = toWord.getType();
                boolean wordEqual = transEng.equals(toWord.getWord_en());
                boolean languageEqual = toLanguage.equals(toWord.getLanguage());
                //verific daca are forma de plural sau singular
                if (wordEqual == true && languageEqual == true) {
                    if (sg == 0 && pl == 0) {
                        transWord = toWord.getWord();
                        break;
                    }
                    else if (sg == 1) {
                        //verific daca este verb sau substantiv
                        if (type.equals("noun")) {
                            transWord = toWord.getSingular().get(0);
                            break;
                        }
                        else {
                            //forma de persoana 3 singular
                            transWord = toWord.getSingular().get(2);
                            break;
                        }
                    }
                    else if (pl == 1) {
                        if (type.equals("noun")) {
                            transWord = toWord.getPlural().get(0);
                            break;
                        }
                        else {
                            //forma de persoana a 3 plural
                            transWord = toWord.getPlural().get(2);
                            break;
                        }
                    }

                }
            }
        }

        return transWord;
    }

    public static String translateSentence(String sentence, String fromLanguage, String toLanguage) {
        //impart propozitia in cuvinte
        String[] words = sentence.split(" ");
        //propozitia tradusa
        String transSentence = new String();
        //nr cuvinte din propozitie
        int count = words.length;
        //parcurg cuvintele si le trduc pe fiecare
        for (int i = 0; i < count; i++) {
            String string = words[i];
            transSentence = transSentence + translateWord(string, fromLanguage, toLanguage) + " ";
        }
        return transSentence;
    }

    public static ArrayList<String> synoyms(String string, String fromLanguage, String toLanguage) {
        //numarul de cuvinte
        int count = ParssInfo.newWords.size();
        //traducere in engleza
        String transEng = "";
        //ArrayList de sinonime
        ArrayList<String> synonyms = new ArrayList<>();
        //parcurg cuvintele
        //caut traducerea in engleza
        for (int i = 0; i < count; i++) {
            WordType fromWord = ParssInfo.newWords.get(i);
            if (string.equals(fromWord.getWord())) {
                transEng = fromWord.getWord_en();
                break;
            }
        }
        //caut definitiile
        for (int j = 0; j < count; j++) {
            WordType toWord = ParssInfo.newWords.get(j);
            boolean wordEqual = transEng.equals(toWord.getWord_en());
            boolean languageEqual = toLanguage.equals(toWord.getLanguage());
            if (wordEqual == true && languageEqual == true) {
                for (DefinitionType def : toWord.getDefinitions()) {
                    //adaug sinonimele in vector
                    if (def.getDictType().equals("synonyms")) {
                        synonyms.addAll(def.getText());
                    }
                }
                break;
            }
        }
        return synonyms;
    }

    public static ArrayList<String> translateSentences(String sentence, String fromLanguage, String toLanguage) {
        //impart in cuvinte propozitia
        String[] words = sentence.split(" ");
        //sinonimele cuvantului
        ArrayList<String> translations = new ArrayList<String>();
        //propozitiile traduse folosind sinonime
        ArrayList<String> sentences = new ArrayList<String>();
        //numarul de cuvinte
        int count = words.length;
        //numarul de traduceri
        int nrTrans = 0;
        //parucrg cuvintele din propozitie
        for (int i = 0; i < count - 1; i++) {
            String string = words[i];
            //numarul de sinonime
            int nrSyno = synoyms(string, fromLanguage, toLanguage).size();
            translations = synoyms(string, fromLanguage, toLanguage);
            while (nrSyno != 0 && nrTrans != 3) {
                String transSentence = new String();
                //adaug sinonimul cuvantului si traduc restul propozitiei
                transSentence = transSentence + translations.get(nrTrans) + " ";
                //traduc cuvintele ramase
                for (int j = i + 1; j < count; j++) {
                    String next = words[j];
                    transSentence = transSentence + " " +  translateWord(next, fromLanguage, toLanguage);
                }
                sentences.add(transSentence);
                nrTrans++;
                nrSyno--;
            }
            break;
        }
        return sentences;
    }

    public static ArrayList<DefinitionType> getDefinitionsForWord(String word, String language) {
        //numarul de cuvinte
        int count = ParssInfo.newWords.size();
        //cuvantul cautat
        WordType searchedWord = new WordType();
        //definitii
        ArrayList<DefinitionType> defs = new ArrayList<DefinitionType>();
        //caut cuvantul
        for (int i = 0; i < count; i++) {
            searchedWord = ParssInfo.newWords.get(i);
            boolean wordEqual = word.equals(searchedWord.getWord());
            boolean languageEqual = language.equals(searchedWord.getLanguage());
            if (wordEqual == true && languageEqual == true) {
                defs.addAll(searchedWord.getDefinitions());
                break;
            }
        }
        int nrDef = defs.size();
        //parcurg definitiile si le sortez dupa an
        for (int i = 0; i < nrDef; i++) {
            for (int j = i + 1; j < nrDef; j++) {
                if (defs.get(i).getYear() > defs.get(j).getYear()) {
                    Collections.swap(defs, i, j);
                    Collections.swap(searchedWord.getDefinitions(), i, j);
                }
            }
        }
        return defs;
    }

    public static void exportDictionary(String language) {
        //sortare defintii pt toate cuv din dictionar
        int count = ParssInfo.newWords.size();
        ArrayList<WordType> words = ParssInfo.newWords;
        ArrayList<WordType> wordsLanguage = new ArrayList<WordType>();
        for (int i = 0; i < count; i++) {
            if (words.get(i).getLanguage().equals(language)) {
                String wordLanguage = ParssInfo.newWords.get(i).getLanguage();
                getDefinitionsForWord(ParssInfo.newWords.get(i).getWord(), wordLanguage);
                wordsLanguage.add(words.get(i));
            }
        }
        //sortare dictionar alfabetic
        int number = wordsLanguage.size();
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                if (wordsLanguage.get(i).getWord().compareTo(wordsLanguage.get(j).getWord()) > 0) {
                        Collections.swap(wordsLanguage, i, j);
                }
            }
        }

        try {
            //afisare dictionar in format json
            String path = "src/test/outputs/";
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            File file;
            FileWriter out = new FileWriter(path + "Dictionary-" + language);
            gson.toJson(wordsLanguage, out);
            out.close();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }
}
