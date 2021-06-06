public class Grade {
    private int grade;
    private Course course;

    public Grade(int grade,Course course)
    {
        this.grade=grade;
        this.course=course;
    }

    public int getGrade()
    {
        return this.grade;
    }

    public Course getCourse()
    {
        return this.course;
    }

    public Grade copy()
    {
        return new Grade(this.grade,this.course);
    }

    public String toString()
    {
        return "["+this.grade + ", course: " + this.course.getName()+"]";
    }

}
