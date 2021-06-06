import java.util.ArrayList;

public class Course {
    private String name;
    private ArrayList<Lesson> schedule;

    public Course(String name)
    {
        this.name=name;
        schedule=new ArrayList<Lesson>();
    }

    public String getName()
    {
        return this.name;
    }

    public int getNumberOfLessons()
    {
        return schedule.size();
    }

    public void addLesson(Lesson lesson)
    {
        schedule.add(lesson);
    }

    public void removeLesson(Lesson lesson)
    {
        schedule.remove(lesson);
    }

    public boolean hasLessonOnDate(Date date)
    {
        boolean localBool = false;
        for(Lesson lesson:schedule)
        {
            if(lesson.getDate().equals(date)){
                localBool = true;
                break;
            }
        }
        return localBool;
    }

    public ArrayList<Lesson> getAllLessons()
    {
        return schedule;
    }

    public ArrayList<String> getAllTopics()
    {
        ArrayList<String> localList = new ArrayList<String>();
        for(Lesson lesson:schedule)
        {
            localList.add(lesson.getTopic());
        }
        return localList;
    }

    public ArrayList<OnlineLesson> getOnlineLessons()
    {
           ArrayList<OnlineLesson> localList = new ArrayList<OnlineLesson>();
           for(Lesson lesson:schedule)
           {
               if(lesson instanceof OnlineLesson){
                   localList.add((OnlineLesson) lesson);
               }
           }
           return localList;
    }

    public ArrayList<OnlineLesson> getOnlineLessonsWithCameraRequired()
    {
        ArrayList<OnlineLesson> localList = new ArrayList<OnlineLesson>();
        for(OnlineLesson onlineLesson:getOnlineLessons()){
            if(onlineLesson.isCameraRequired()) localList.add(onlineLesson);
        }
        return localList;
    }

    public ArrayList<DiscordLesson> getDiscordLessons()
    {
        ArrayList<DiscordLesson> localList = new ArrayList<DiscordLesson>();
        for(OnlineLesson onlineLesson:getOnlineLessons()){
            if(onlineLesson instanceof DiscordLesson){
                localList.add((DiscordLesson) onlineLesson);
            }
        }
        return localList;
    }

    public ArrayList<ZoomLesson> getZoomLessonsWithBreakoutRooms()
    {
        ArrayList<ZoomLesson> localList = new ArrayList<ZoomLesson>();
        for(OnlineLesson onlineLesson:getOnlineLessons()){
            if((onlineLesson instanceof ZoomLesson)&&((ZoomLesson) onlineLesson).useBreakoutRooms()){
                localList.add((ZoomLesson) onlineLesson);
            }
        }
        return localList;
    }

    public ArrayList<Resource> getAllResources()
    {
        ArrayList<Resource> localList = new ArrayList<Resource>();
        for(Lesson lesson:schedule)
        {
            ArrayList<Resource> local2List = lesson.getAllPDFs();
            for(Resource resource:local2List)
            {
                localList.add(resource);
            }
        }
        return localList;
    }

    public String toString()
    {
        String localString = "Course name: "+this.name+"\n";
        for(Lesson lesson:schedule)
        {
            localString+="Lesson: "+lesson+"\n";
        }
        return localString;
    }

}
