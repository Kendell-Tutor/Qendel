package studentservice.model;

public enum Role {

    STUDENT(1), INSTRUCTOR(2), ADMIN(3);
    int value;
    Role(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
