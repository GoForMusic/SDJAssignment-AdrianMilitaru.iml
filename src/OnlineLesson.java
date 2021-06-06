public abstract class OnlineLesson extends Lesson
{
    private boolean cameraRequired;

    public OnlineLesson(String topic, Date date, Time start, Time end, Resource[] res, boolean cameraRequired)
    {
        super(topic, date, start, end, res);
        this.cameraRequired=cameraRequired;
    }

    public boolean isCameraRequired()
    {
        if(cameraRequired) return true;
        else return false;
    }

    public abstract String nameOfSoftware();

    public boolean equals(Object obj)
    {
        if(!(obj instanceof OnlineLesson)) return false;

        OnlineLesson onlineLesson = (OnlineLesson) obj;

        if(this.cameraRequired==onlineLesson.cameraRequired&&super.equals(onlineLesson)) return true;
        else return false;
    }

    public String toString()
    {
        String localString = "Camera is Required?("+this.cameraRequired+")\n";

        localString+=super.toString();

        return localString;
    }
}
