public class Text  implements Printable, Drawable {

    private String content;
    private boolean isBold;
    private boolean isItalic;

    public Text(String content, boolean isBold, boolean isItalic) {
        this.content = content;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isBold() {
        return isBold;
    }

    public void setBold(boolean bold) {
        isBold = bold;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public void setItalic(boolean italic) {
        isItalic = italic;
    }

    @Override
    public void print() {
        System.out.println("Print Text: " + content);
    }

    @Override
    public void draw() {
        System.out.println("Draw text");
    }

    @Override
    public void erase() {
        System.out.println("Erase Text");
    }
}
