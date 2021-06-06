import java.util.ArrayList;
import java.util.EmptyStackException;

public class Lesson {
    private String topic;
    private Date date;
    private ArrayList<Resource> resources;
    private Time start;
    private Time end;

    public Lesson(String topic, Date date, Time start, Time end, Resource[] res)
    {
        this.topic=topic;
        if(hasValidTime(start,end)) {
            this.date = date.copy();
            this.start = start.copy();
        }else throw new EmptyStackException();
        this.end=end.copy();
        resources = new ArrayList<Resource>();
        if(res.length>0)
        {
            for(int index=0;index<res.length;index++)
            {
                resources.add(res[index]);
            }
        }
    }

    public String getTopic()
    {
        return this.topic;
    }

    public Date getDate()
    {
        return this.date;
    }

    public Resource[] getResources()
    {
        return resources.toArray(new Resource[resources.size()]);
    }

    public ArrayList<Resource> getAllPDFs()
    {
        ArrayList<Resource> localList = new ArrayList<Resource>();

        for(Resource resource:resources){
            if(resource.isPDF()) localList.add(resource);
        }

        return localList;
    }

    public Time getDuration()
    {
        return this.start.timeUntil(this.end);
    }

    public static boolean hasValidTime(Time startTime,Time endTime){
        if(endTime.isBefore(startTime)) return false;
        else if(startTime.isBefore(new Time(8,20,00))) return false;
        else if(!endTime.isBefore(new Time(21,10,00))) return false;
        else return true;
    }

    public String getDateTimeString()
    {
        return this.date+" "+this.start+" - "+this.end;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Lesson)) return false;

        Lesson lesson = (Lesson) obj;

        if(this.topic.equals(lesson.topic)&&this.date.equals(lesson.date)&&this.start.equals(lesson.start)&&this.end.equals(lesson.end)&&this.resources.equals(lesson.resources)) return true;
        else return false;
    }

    public String toString()
    {
        String localString=this.topic+" "+getDateTimeString()+"\n";

        for(Resource resource:resources)
        {
            localString+=resource+"\n";
        }

        return localString;
    }
}
