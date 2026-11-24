package campusconnect.model;

/**
 * Abstract parent class for all campus information.
 * Subclasses must say which category they belong to by overriding getCategory().
 */
public abstract class InformationItem {

    private int id;
    private String title;
    private String keywords;   // comma-separated, e.g. "borrow,books,library"
    private String answer;
    private String source;     // where the information came from (office, website, etc.)

    public InformationItem(int id, String title, String keywords, String answer, String source) {
        this.id = id;
        this.title = title;
        this.keywords = keywords;
        this.answer = answer;
        this.source = source;
    }

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getAnswer() {
        return answer;
    }

    public String getSource() {
        return source;
    }

    // ----- Setters (id is not changeable once created) -----

    public void setTitle(String title) {
        this.title = title;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Each subclass returns its own category label.
     */
    public abstract String getCategory();

    @Override
    public String toString() {
        return "[" + getCategory() + "] " + title + " (id=" + id + ")";
    }
}
