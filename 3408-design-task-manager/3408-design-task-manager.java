class TaskManager {

    private static class Task {
        int userId;
        int taskId;
        int priority;

        Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }

    // Max-Heap: highest priority first, if tie -> higher taskId
    private PriorityQueue<int[]> maxHeap;
    private Map<Integer, Task> taskMap; // taskId -> Task

    public TaskManager(List<List<Integer>> tasks) {
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0]) return Integer.compare(b[0], a[0]); // compare priority
            return Integer.compare(b[1], a[1]); // tie -> higher taskId
        });
        taskMap = new HashMap<>();

        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task newTask = new Task(userId, taskId, priority);
        taskMap.put(taskId, newTask);
        maxHeap.offer(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            task.priority = newPriority;
            taskMap.put(taskId, task);
            maxHeap.offer(new int[]{newPriority, taskId});
        }
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int priority = top[0];
            int taskId = top[1];
            Task task = taskMap.get(taskId);

            if (task != null && task.priority == priority) {
                taskMap.remove(taskId);
                return task.userId;
            }
            // else stale entry → skip
        }
        return -1; // no tasks available
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */