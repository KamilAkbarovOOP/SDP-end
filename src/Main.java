import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = TaskManager.getInstance();

        while (true) {
            System.out.println("\n--------------- Task Manager ---------------");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Create User");
            System.out.println("4. Exit");
            System.out.println("--------------------------------------------");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (High/Low): ");
                    String priority = scanner.nextLine();

                    try {
                        Task task = TaskFactory.createTask(priority, description);
                        manager.addTask(task);
                        System.out.println("Task added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("-------------------------------------");
                    break;

                case 2:
                    System.out.println("\n--------------- Tasks ---------------");
                    manager.listTasks();
                    System.out.println("-------------------------------------");
                    break;

                case 3:
                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user surname: ");
                    String surname = scanner.nextLine();

                    try {
                        User user = new User.Builder()
                                .setName(name)
                                .setSurname(surname)
                                .build();
                        System.out.println("User created: " + user.getName() + " " + user.getSurname());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("-------------------------------------");
                    break;

                case 4:
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Wrong choice. Try again.");
            }
        }
    }
}
