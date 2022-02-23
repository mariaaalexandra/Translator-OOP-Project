import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

public class ParssInfo {
    //vector de cuvinte
    public static WordType[] words;
    //ArrayList ce contine cuvintele noi adaugate
    public static ArrayList<WordType> newWords = new ArrayList<WordType>();
    //calea din care se citesc fisierele json
    public static final String READING_FILES = "src/test/resources";
    private String readingFiles;

    //citire din json si crearea dictionarelor
    public Map<String, Dictionary> getDictionaries() {
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final File inputs = new File(READING_FILES);
        String path = "src/test/outputs/outTask1";
        File file = new File(path);
        //parcurg si verific daca fisierele din director
        //au extensia .json
        for (final File input : inputs.listFiles()) {
            if (input.getName().endsWith(".json") == true) {
                try {
                    jsonReader = new JsonReader(new FileReader(input));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                //lista cuvinte din cadrul fisierele .json
                words = new Gson().fromJson(jsonReader, WordType[].class);

                //parcurg cuvintele citite si le setez limba
                for (WordType each : words) {
                    if (input.getName().startsWith("ro") == true) {
                        each.setLanguage("RO");
                    } else {
                        if (input.getName().startsWith("fr") == true) {
                            each.setLanguage("FR");
                        } else {
                            if (input.getName().startsWith("eng") == true) {
                                each.setLanguage("ENG");
                            }
                        }
                    }
                    //adaugat cuvantul in ArrayList
                    newWords.add(each);
                }
            }
            try {
                FileWriter writer = new FileWriter(file);
                for (WordType i : ParssInfo.newWords) {
                    writer.write(i.toString());
                    writer.write("\n");
                }
                writer.close();
            } catch (Exception exception) {
                System.out.println(exception);

            }
        }
        return null;
    }
}
