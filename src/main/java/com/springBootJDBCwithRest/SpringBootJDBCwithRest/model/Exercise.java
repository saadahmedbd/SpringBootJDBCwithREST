package com.springBootJDBCwithRest.SpringBootJDBCwithRest.model;

public class Exercise {
    private int id;
    private String workoutName;
    private int sets;
    private  int reps;
    private int weight;
    private  String bodyPart;

    public Exercise(int id, String workoutName, int sets, int reps, int weight, String bodyPart) {
        this.id = id;
        this.workoutName = workoutName;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.bodyPart = bodyPart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", workoutName='" + workoutName + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                ", bodyPart='" + bodyPart + '\'' +
                '}';
    }
}
