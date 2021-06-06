import java.util.ArrayList;

public class Student {
    private int studentNumber;
    private String name;
    private CoronaPassport coronaPassport;
    private ArrayList<Course> courses;
    private ArrayList<Grade> grades;

    public Student(int studentNumber,String name)
    {
        this.studentNumber=studentNumber;
        this.name=name;
        this.coronaPassport=null;
        this.courses=new ArrayList<Course>();
        this.grades=new ArrayList<Grade>();
    }

    public int getStudentNumber()
    {
        return this.studentNumber;
    }

    public String getName()
    {
        return this.name;
    }

    public void addCourse(Course course)
    {
        courses.add(course);
    }

    public void addGrade(int grade, Course course)
    {
        for(Course index:courses)
        {
            if(index.equals(course))
            {
                grades.add(new Grade(grade,course));
            }
        }
    }

    public void addCoronaPassport(CoronaPassport passport)
    {
        this.coronaPassport=passport;
    }

    public void removeCoronaPassport()
    {
        this.coronaPassport=null;
    }

    public CoronaPassport getCoronaPassport()
    {
        return this.coronaPassport;
    }

    public boolean hasValidCoronaPassport()
    {
        if(!Date.today().isBefore(this.coronaPassport.getDate())&&this.coronaPassport!=null){
            int localRange = Date.today().numberOfDaysUntil(this.coronaPassport.getDate());
            if(this.coronaPassport.getReason().equals("Vaccinated")) return true;
            else if(this.coronaPassport.getReason().equals("Tested") && (localRange<=3)) return true;
            else if(this.coronaPassport.getReason().equals("Infected") && (localRange>=14&&localRange<=180)) return true;
            else return false;
        } else return false;
    }

    public double getGradeAverage()
    {
        double localDouble = 0;
        for(Grade grade:grades)
        {
            localDouble+=grade.getGrade();
        }
        return localDouble/grades.size();
    }

    public Grade[] getAllGrades()
    {
        return grades.toArray(new Grade[grades.size()]);
    }

    public Course[] getAllCourses()
    {
        return courses.toArray(new Course[courses.size()]);
    }
}
