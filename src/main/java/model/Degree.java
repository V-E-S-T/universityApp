package model;

public enum Degree {
    ASSISTANT,
    ASSOCIATE_PROFESSOR,
    PROFESSOR;

    Degree() {
    }

    @Override
    public String toString() {
        switch (this){
            case ASSISTANT: return "assistant";
            case PROFESSOR: return "professor";
            case ASSOCIATE_PROFESSOR: return "associate professor";
            default: return"";
        }
    }
}
