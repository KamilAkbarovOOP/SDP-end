import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.LocalDate;

public class Main {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManagerFacade managerFacade = new TaskManagerFacade();

        TaskObserver observer1 = new TaskObserver("Observer");

        managerFacade.addObserver(observer1);

        while (true) {
            System.out.println("\n--------------- Task Manager ---------------");
            System.out.println("1. Add Task");
            System.out.println("2. Add Composite Task");
            System.out.println("3. Add External Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Set Task Sorting Strategy");
            System.out.println("6. Create User");
            System.out.println("7. Undo Last Command");
            System.out.println("8. Exit");
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
                    System.out.print("Enter deadline (dd-MM-yyyy) or leave empty: ");
                    String deadlineInput = scanner.nextLine();
                    Task task = TaskFactory.createTask(priority, description);

                    if (!deadlineInput.isEmpty()) {
                        try {
                            LocalDate deadline = LocalDate.parse(deadlineInput, dateFormatter);
                            task = new DeadlineDecorator(task, deadline.toString());
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format. No deadline set.");
                        }
                    }

                    managerFacade.addTask(description, priority, deadlineInput);
                    System.out.println("Task added successfully.");
                    break;

                case 2:

                    System.out.print("Enter composite task description: ");
                    String compositeDescription = scanner.nextLine();
                    CompositeTask compositeTask = new CompositeTask(compositeDescription);

                    while (true) {
                        System.out.print("Add subtask description (or type 'done' to finish): ");
                        String subtaskDescription = scanner.nextLine();
                        if (subtaskDescription.equalsIgnoreCase("done"))
                            break;

                        System.out.print("Enter subtask priority (High/Low): ");
                        String subtaskPriority = scanner.nextLine();
                        Task subtask = TaskFactory.createTask(subtaskPriority, subtaskDescription);
                        compositeTask.addSubtask(subtask);
                    }
                    managerFacade.addCompositeTask(compositeTask);
                    break;

                case 3:

                    System.out.print("Enter external task info: ");
                    String info = scanner.nextLine();
                    managerFacade.addExternalTask(info);
                    break;

                case 4:

                    System.out.println("\n--------------- Tasks ---------------");
                    managerFacade.listTasks();
                    break;

                case 5:

                    System.out.println("Choose a sorting strategy:");
                    System.out.println("1. Sort by Priority");
                    System.out.println("2. Sort by Deadline");
                    System.out.print("Choose an option: ");
                    int strategyChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (strategyChoice == 1) {
                        managerFacade.setSortStrategy(new SortByPriority());
                        System.out.println("Sorting by priority selected.");
                    } else if (strategyChoice == 2) {
                        managerFacade.setSortStrategy(new SortByDeadline());
                        System.out.println("Sorting by deadline selected.");
                    } else {
                        System.out.println("Invalid choice. No sorting strategy selected.");
                    }
                    break;

                case 6:

                    System.out.print("Enter user name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter user surname: ");
                    String surname = scanner.nextLine();
                    System.out.println("User created: " + name + " " + surname);
                    break;

                case 7:

                    managerFacade.undoLastCommand();
                    break;

                case 8:

                    System.out.println("Exit...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
