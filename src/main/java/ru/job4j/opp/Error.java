package ru.job4j.opp;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Статус: " + active);
        System.out.println("№ ошибки: " + status);
        System.out.println("Информация об ошибке: " + message);
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        Error secondError = new Error(true, 5, "IOException");
        Error thirdError = new Error(false, 3, "IllegalFormatException");
        firstError.printInfo();
        secondError.printInfo();
        thirdError.printInfo();
    }
}
