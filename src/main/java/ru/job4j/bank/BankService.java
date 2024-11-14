package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает управление пользователями и их банковскими счетами
 * @author JediFoX
 * @version 1.0
 */
public class BankService {
    /**
     * Карта для хранения данных о пользователях и их банковских счетах
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в систему, если его еще нет
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет пользователя из системы по данным паспорта
     * @param passport паспортные данные пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод добавляет банковский счет для пользователя, если аналогичный счет
     * отсутствует у данного пользователя
     * @param passport паспортные данные пользователя
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по данным паспорта
     * @param passport паспортные данные пользователя
     * @return возвращает пользователя или null, если пользователь не найден
     */
    public User findByPassport(String passport) {
        User user = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                user = key;
                break;
            }
        }
        return user;
    }

    /**
     * Метод ищет банковский счет пользователя по данным паспорта и реквизитам счета
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты счета
     * @return возвращает банковский счет или null, если счет не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод с одного счета на другой
     * @param sourcePassport паспортные данные отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport паспортные данные получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма перевода
     * @return возвращает true, если перевод прошел успешно или false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (destinationAccount != null && sourceAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод позволяет получить информацию о всех счетах пользователя
     * @param user пользователь
     * @return возвращает список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}