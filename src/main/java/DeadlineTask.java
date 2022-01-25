import java.time.LocalDate;
import java.time.LocalTime;

public class DeadlineTask extends Task{
    protected LocalDate taskDate;
    protected LocalTime taskTime;

    public DeadlineTask(String title, String taskDate){
        super(title);
        this.type = TaskType.DEADLINE;
        this.taskDate = LocalDate.parse(taskDate);
        this.taskTime = null;
    }

    public DeadlineTask(String title, String taskDate, String taskTime){
        super(title);
        this.type = TaskType.DEADLINE;
        this.taskDate = LocalDate.parse(taskDate);
        this.taskTime = LocalTime.parse(taskTime);
    }

    public DeadlineTask(String title, Boolean isDone, String taskDate){
        super(title, isDone);
        this.type = TaskType.DEADLINE;
        this.taskDate = LocalDate.parse(taskDate);
        this.taskTime = null;
    }

    public DeadlineTask(String title, Boolean isDone, String taskDate, String taskTime){
        super(title, isDone);
        this.type = TaskType.DEADLINE;
        this.taskDate = LocalDate.parse(taskDate);
        this.taskTime = LocalTime.parse(taskTime);
    }

    public String getByTime(){
        return "(by: " + taskDate + (taskTime != null ? " " + taskTime.toString() : "") + ")";
    }
    
    @Override
    public String toString(){
        return this.title + " " + getByTime();
    }
}
