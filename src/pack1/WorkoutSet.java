package pack1;

public class WorkoutSet {
	private String exerciseName;
    private int weight;
    private int repetitions;

    public WorkoutSet(String exerciseName, int weight, int repetitions) {
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.repetitions = repetitions;
    }

    public int calculateVolume() {
        return weight * repetitions;
    }

}
