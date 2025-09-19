import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isContinue = true;
        while (isContinue) {
            showMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    isContinue = false;
                    break;
                case "1":
                    addTask();
                    break;
                case "2":
                    break;
                case "3":
                    removeByNum();
                    break;
                case "4":
                    removeByTask();
                    break;
                case "5":
                    removeByKeyword();
                    break;
                default:
                    System.out.println("Нет данных");
            }
            showTasks();
        }
    }

    private static void removeByKeyword() {
        System.out.print("Удалить дело по ключевому слову: ");
        String keyword = scanner.nextLine();
        Iterator<String> item = tasks.iterator();

        while (item.hasNext()) {
            String task = item.next();
            if (task.contains(keyword)) {
                item.remove();
                System.out.println("Удалено!");
            }
        }
    }

    private static void removeByTask() {
        System.out.println("Удалить дело по названию: ");
        String task = scanner.nextLine();

        if (tasks.contains(task)) {
            tasks.remove(task);
            System.out.println("Удалено!");
        } else {
            System.out.println("Задачи нет");
        }
    }

    private static void removeByNum() {
        System.out.println("Удалить дело по номеру: ");
        int position = Integer.parseInt(scanner.nextLine()) - 1;

        if (position >= 0 && position < tasks.size()) {
            tasks.remove(position);
            System.out.println("Удалено!");
        } else {
            System.out.println("Задачи нет");
        }
    }

    private static void showMenu() {
        System.out.print("\nВыберите операцию:\n" +
                "\n" +
                "0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дело по ключевому слову\n" +
                "Ваш выбор: ");
    }

    private static void showTasks() {
        System.out.println("\nВаш список дел: ");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, tasks.get(i));
        }
    }

    private static void addTask() {
        System.out.println("Введите название задачи: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Добавлено!");
    }
}
