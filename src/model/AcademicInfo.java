package model;

/**
 * Represents academic information and procedures provided by the institution.
 *
 * This class inherits the common information fields and methods
 * from InformationItem and provides its own academic category.
 *
 * Examples include registration procedures, examination schedules,
 * grading systems, and academic calendars.
 *
 * @author CampusConnect Team
 */
public class AcademicInfo extends InformationItem {

    /**
     * Creates a new academic information record.
     *
     * @param id       unique ID of the information record
     * @param title    title of the academic information
     * @param keywords keywords used to identify the information
     * @param answer  academic information or explanation
     * @param source  source of the academic information
     */
    public AcademicInfo(int id, String title, String keywords,
                        String answer, String source) {

        super(id, title, keywords, answer, source);
    }

    /**
     * Returns the category of this information record.
     *
     * @return the academic category
     */
    @Override
    public String getCategory() {
        return "Academic";
    }
}
