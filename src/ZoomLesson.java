public class ZoomLesson extends OnlineLesson
{
    private String link;
    private boolean breakoutRooms;

    public ZoomLesson(String topic, Date date, Time start, Time end, Resource[] res, boolean camera,String link,boolean breakout)
    {
        super(topic,date,start,end,res,camera);
        this.link=link;
        this.breakoutRooms=breakout;
    }

    public String getLink()
    {
        return this.link;
    }

    public boolean useBreakoutRooms()
    {
        if(breakoutRooms) return true;
        else return false;
    }

    public String nameOfSoftware()
    {
        return "Zoom";
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof ZoomLesson)) return false;

        ZoomLesson zoomLesson = (ZoomLesson) obj;

        if(this.link.equals(zoomLesson.link)&&this.breakoutRooms==zoomLesson.breakoutRooms&&super.equals(zoomLesson)) return true;
        else return false;
    }


    public String toString()
    {
        String localString = "LINK("+this.link+"), Have breakout rooms?("+this.breakoutRooms+") ";
        localString+=super.toString();
        return localString;
    }
}
