package at.appdevs.basics;

public enum Color {
    RED("r"), YELLOW("y");

    private String caption;

    Color(String caption) {
        this.caption = caption;
    }

    @Override
    public String toString() {
        return caption;
    }
}
