package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (User value : users) {
            if (value.getUsername().equals(login)) {
                user = value;
                break;
            } else {
                throw new UserNotFoundException();
            }
        }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean result = user.isValid();
        if (!result || user.getUsername().length() < 3) {
            throw new UserInvalidException();
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            User[] users = {
                    new User("Petr Arsentev", true)
            };
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException ui) {
            System.out.println("User is not valid");
        } catch (UserNotFoundException un) {
            System.out.println("User is not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
