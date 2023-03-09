package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TodoApp {

    public static final int ADD_ELEMENT_TO_ROOT = 1;
    public static final int ADD_ELEMENT_TO_PARENT = 2;
    public static final int MAKE_ACTION = 3;
    public static final int PRINT_TO_CONSOLE = 4;

    public static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    public static final String SELECT = "Пожалуйста, выберите необходимый пункт меню:";
    public static final String ELEMENT_NAME = "Введите имя задания или подзадания:";
    public static final String PARENT_NAME = "Введите имя задания, к которому нужно добавить подзадание:";
    public static final String NO_ELEMENT = "Указанное Вами задание отсутствует";
    public static final String EXIT = "Конец работы";

    public static final String MENU_TEXT = """
                Введите 1, чтобы добавить задание.
                Введите 2, чтобы добавить подзадание к заданию или подзаданию.
                Введите 3, вызвать действие, привязанное к пункту меню.
                Введите 4, чтобы вывести всё меню в консоль.
                Введите любое другое число для выхода.
            """;

    private static final Menu TODO_LIST = new SimpleMenu();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuPrinter printer = new SimpleMenuPrinter();
        boolean run = true;
        while (run) {
            System.out.println(MENU_TEXT);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (ADD_ELEMENT_TO_ROOT == userChoice) {
                System.out.println(ELEMENT_NAME);
                String elementName = scanner.nextLine();
                TODO_LIST.add(Menu.ROOT, elementName, DEFAULT_ACTION);
            } else if (ADD_ELEMENT_TO_PARENT == userChoice) {
                System.out.println(ELEMENT_NAME);
                String elementName = scanner.nextLine();
                System.out.println(PARENT_NAME);
                String parentName = scanner.nextLine();
                if (TODO_LIST.select(parentName).isEmpty()) {
                    System.out.println(NO_ELEMENT);
                    continue;
                }
                TODO_LIST.add(parentName, elementName, DEFAULT_ACTION);
            } else if (MAKE_ACTION == userChoice) {
                System.out.println(ELEMENT_NAME);
                String elementName = scanner.nextLine();
                if (TODO_LIST.select(elementName).isEmpty()) {
                    System.out.println(NO_ELEMENT);
                    continue;
                }
                ActionDelegate action = TODO_LIST.select(elementName).get().getActionDelegate();
                action.delegate();
            } else if (PRINT_TO_CONSOLE == userChoice) {
                printer.print(TODO_LIST);
            } else {
                run = false;
                System.out.println(EXIT);
            }
        }
    }

}