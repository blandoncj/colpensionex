package util;

public class LongHandler {

    private String taskName;
    private long totalTasks;
    private long tasksProcessed;

    public void start(String taskName, long totalTasks) {
        this.taskName = taskName;
        this.totalTasks = totalTasks;
        this.tasksProcessed = 0;

        System.out.println("Inicio de la tarea: " + taskName + " con " + totalTasks + " elementos.");
    }

    public void update(long tasksProcessed) {
        this.tasksProcessed = tasksProcessed;
        System.out.println("Progreso: " + tasksProcessed + "/" + totalTasks + " (" + getPercentage() + "%)");
    }

    public void finish() {
        System.out.println("Tarea finalizada: " + taskName + ". Procesados " + tasksProcessed + " elementos.");
    }

    private double getPercentage() {
        return ((double) tasksProcessed / totalTasks) * 100;
    }
}
