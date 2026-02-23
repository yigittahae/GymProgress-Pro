package pack1;
import java.util.ArrayList;
import java.util.List;


public class Workout {
    private String workoutName;
    private List<WorkoutSet> sets;

    public Workout(String workoutName) {
        this.workoutName = workoutName;
        this.sets = new ArrayList<>();
    }

    public void addSet(WorkoutSet set) {
        sets.add(set);
    }


    public String getWorkoutName() {
        return workoutName;
    }

  
    public int calculateTotalVolume() {
        int total = 0;
        for (WorkoutSet set : sets) {
            total += set.calculateVolume();
        }
        return total;
    }
}