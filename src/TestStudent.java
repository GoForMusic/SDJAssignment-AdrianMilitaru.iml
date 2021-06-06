import java.util.ArrayList;

public class TestStudent {

    public static void main(String[] args)
    {
        //get the current date
        Date date = Date.today();

        //students constructors
        Student student = new Student(2004213,"Adrian-Cristian Militaru");
        Student student1 = new Student(5555,"Bob");
        Student student2 = new Student(5556, "Bob's brother");

        //add corona passport to students
        student.addCoronaPassport(new CoronaPassport("Vaccinated",date));
        student1.addCoronaPassport(new CoronaPassport("Tested",new Date(4,5,2021)));
        student2.addCoronaPassport(new CoronaPassport("Infected",new Date(20,4,2021)));

        //create courses
        Course SDJ = new Course("JDK1");
        Course SSE = new Course("SSE");
        Course SEP = new Course("SEP1");
        Course RWD = new Course("RWD");

        //create resources, I've use a list of resources for every course
        Resource[] resourcesSDJ = {new Resource("GUI_intro","pdf"),new Resource("javafx","zip")};
        Resource[] resourcesRWD= {new Resource("javascript","pdf"),new Resource("ex1","zip")};
        Resource[] resourcesSSE = {new Resource("TeamWork","pdf")};
        Resource[] resourcesSEP = {new Resource("TeamContract","pdf"),new Resource("DiagramExample","PDF")};

        //discord lesson
        SDJ.addLesson(new DiscordLesson("GUI",new Date(5,5,2021),new Time(9,0,0),new Time(12,0,0),resourcesSDJ,false,"1st-semester"));
        //zoom lesson true breakout
        SSE.addLesson(new ZoomLesson("Process Report",new Date(3,5,2021),new Time(8,20,0),new Time(12,0,0),resourcesSSE,true,"https://...",true));
        //zoom lesson false breakout
        //I test start time if is a valid time, and changed to 8:20 to test everything after
        RWD.addLesson(new ZoomLesson("jQuery",new Date(7,5,2021),new Time(8,20,0),new Time(12,0,0),resourcesRWD,true,"https://...",false));
        //not Online Course
        SEP.addLesson(new Lesson("TeamContract",new Date(28,3,2021),new Time(10,0,0),new Time(16,0,0),resourcesSEP));

        //assign all the courses to every student in the system
        student.addCourse(SDJ);
        student.addCourse(SSE);
        student.addCourse(SEP);
        student.addCourse(RWD);
        student1.addCourse(SDJ);
        student1.addCourse(SSE);
        student1.addCourse(SEP);
        student1.addCourse(RWD);
        student2.addCourse(SDJ);
        student2.addCourse(SSE);
        student2.addCourse(SEP);
        student2.addCourse(RWD);

        //add grades for every student on a specific course
        student.addGrade(7,SSE);
        student.addGrade(12,SDJ);
        student.addGrade(12,SEP);
        student.addGrade(12,RWD);
        student1.addGrade(0,SSE);
        student1.addGrade(-3,SDJ);
        student1.addGrade(0,SEP);
        student1.addGrade(0,RWD);
        student2.addGrade(7,SSE);
        student2.addGrade(7,SDJ);
        student2.addGrade(7,SEP);
        student2.addGrade(7,RWD);


        //Student info
        getStudentDetails(student);
        getStudentDetails(student1);
        getStudentDetails(student2);

        //Type of courses (Additional filters)
        showCoursesDetails(student);
        showCoursesDetails(student1);
        showCoursesDetails(student2);

    }

    public static void showCoursesDetails(Student student)
    {
        ArrayList<Lesson> onlineLessons = new ArrayList();
        ArrayList<Lesson> zoomLessons=new ArrayList<>();
        ArrayList<Lesson> discordLessons = new ArrayList<>();

        for(Course course:student.getAllCourses())
        {
            //will add to onlineLessons ArrayList all the lessons from a list of courses
            onlineLessons.addAll(course.getOnlineLessonsWithCameraRequired());
            //will add to zoomLessons ArrayList all the lessons from a list of courses
            zoomLessons.addAll(course.getZoomLessonsWithBreakoutRooms());
            //will add to discordLessons ArrayList all the lessons from a list of courses
            discordLessons.addAll(course.getDiscordLessons());
        }

        System.out.println("---Student "+student.getName()+"--- (" + student.getStudentNumber()+")");
        System.out.println("::Online Lessons with Camera Required::");
        showCoursesNumbers(onlineLessons);
        System.out.println("::Online Zoom lessons with breakout rooms::");
        showCoursesNumbers(zoomLessons);
        System.out.println("::Online Discord lessons::");
        showCoursesNumbers(discordLessons);
    }

    public static void showCoursesNumbers(ArrayList<Lesson> list)
    {
        for(Lesson element:list)
        {
            System.out.println(element);
        }
    }

    public static void getStudentDetails(Student student)
    {
        //initialize local Array and student details such as name and studentNumber
        Grade[] grades = student.getAllGrades();
        Course[] courses = student.getAllCourses();
        String name = student.getName();
        int studentNumber = student.getStudentNumber();

        //print Student information
        System.out.println("---Student "+name+"--- (" + studentNumber+")");
        for(int index=0;index<grades.length;index++)
        {
            System.out.println(grades[index]);
        }
        //print the Student average
        System.out.println("Average: " + student.getGradeAverage());
        //print the student corona passport type and ask if is valid or not
        System.out.println("Corona passport reason: "+student.getCoronaPassport() + " |Valid?("+student.hasValidCoronaPassport()+")");
        //print student's courses
        System.out.println("--Student courses--");
        for(int index=0;index<courses.length;index++)
        {
            System.out.println(courses[index]);
        }
        //just a line to show a delimitation of a student on terminal
        System.out.println("##############################################################");
    }
}
