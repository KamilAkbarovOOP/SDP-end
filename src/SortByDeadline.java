import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByDeadline implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        Collections.sort(tasks, (task1, task2) -> {
            if (task1 instanceof DeadlineDecorator && task2 instanceof DeadlineDecorator) {
                return ((DeadlineDecorator) task1).getDeadline().compareTo(((DeadlineDecorator) task2).getDeadline());
            }
            return 0;
        });
    }
}
