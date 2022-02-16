import java.time.chrono.Era;

public class Text implements Drawable, Eraseable {

    private String content;
    private boolean italic; // kursiv
    private boolean bold; // fett

    public Text(String content, boolean italic, boolean bold) {
        this.content = content;
        this.italic = italic;
        this.bold = bold;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Text: " + content);
    }

    @Override
    public void erase() {
        System.out.println("Erasing a Text: " + content);
    }
}
