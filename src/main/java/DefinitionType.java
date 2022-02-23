import java.util.List;

public class DefinitionType {
    private String dict;
    private String dictType;
    private Integer year;
    private List<String> text;

    public DefinitionType(String dict, String dictType, Integer year, List<String> text) {
        this.dict = dict;
        this.dictType = dictType;
        this.year = year;
        this.text = text;
    }

    public DefinitionType() {

    }

    public String getDict() {
        return dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        String formatString = "Definition{" +
                               "dict='" + dict + '\'' +
                               ", dictType='" + dictType + '\'' +
                               ", year=" + year +
                               ", text=" + text +
                               '}';
        return formatString;
    }
}
