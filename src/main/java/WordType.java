import java.io.Serializable;
import java.util.List;

public class WordType  implements Serializable {
    private String language;
    private String word;
    private String word_en;
    private String type;
    private List<String> singular;
    private List<String> plural;
    private List<DefinitionType> definitions;

    public WordType() {

    }

    public WordType(String word, String word_en, String type, List<String> singular, List<String> plural, List<DefinitionType> definitions, String language) {
        this.word = word;
        this.word_en = word_en;
        this.type = type;
        this.singular = singular;
        this.plural = plural;
        this.definitions = definitions;
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord_en() {
        return word_en;
    }

    public void setWord_en(String word_en) {
        this.word_en = word_en;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSingular() {
        return singular;
    }

    public void setSingular(List<String> singular) {
        this.singular = singular;
    }

    public List<String> getPlural() {
        return plural;
    }

    public void setPlural(List<String> plural) {
        this.plural = plural;
    }

    public List<DefinitionType> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<DefinitionType> definitions) {
        this.definitions = definitions;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        String stringFormat = "Word{" +
                "word='" + word + '\'' +
                ", word_en'" + word_en + '\'' +
                ", type='" + type + '\'' +
                ", singular=" + singular +
                ", plural=" + plural +
                ", definitions=" + definitions +
                '}';
        return stringFormat;
    }
}
