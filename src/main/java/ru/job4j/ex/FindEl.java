package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("The element was not found");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"1", "2"}, "0"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
