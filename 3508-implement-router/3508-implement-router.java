public class Router {
    private final Deque<Packet> q;
    private final int memoryLimit;
    private final Set<Packet> usedPac;
    private int size;
    private final Map<Integer, List<Integer>> destMap;

    public Router(int memoryLimit) {
        this.q = new ArrayDeque<>();
        this.memoryLimit = memoryLimit;
        this.usedPac = new HashSet<>();
        this.size = 0;
        this.destMap = new HashMap<>();
    }

    public boolean addPacket(int s, int d, int t) {
        Packet p = new Packet(s, d, t);
        if (usedPac.contains(p)) {
            return false;
        }
        if (size >= memoryLimit) {
            Packet old = q.pollFirst();
            if (old != null) {
                usedPac.remove(old);
                removeTimestampFromDest(old.dest, old.time);
                size--;
            }
        }
        q.addLast(p);
        usedPac.add(p);
        List<Integer> timestamps = destMap.computeIfAbsent(d, k -> new ArrayList<>());
        int idx = lowerBound(timestamps, t);
        timestamps.add(idx, t);
        size++;
        return true;
    }

    public List<Object> forwardPacket() {
        if (size == 0) {
            return Collections.emptyList();
        }
        size--;
        Packet p = q.pollFirst();
        if (p == null) return Collections.emptyList();
        usedPac.remove(p);
        removeTimestampFromDest(p.dest, p.time);
        List<Object> out = new ArrayList<>(3);
        out.add(p.src);
        out.add(p.dest);
        out.add(p.time);
        return out;
    }

    public int getCount(int d, int s, int e) {
        List<Integer> list = destMap.get(d);
        if (list == null || list.isEmpty()) return 0;
        int left = lowerBound(list, s);
        int right = upperBound(list, e);
        return right - left;
    }

    private void removeTimestampFromDest(int dest, int time) {
        List<Integer> list = destMap.get(dest);
        if (list == null || list.isEmpty()) return;
        int idx = lowerBound(list, time);
        if (idx < list.size() && list.get(idx) == time) {
            list.remove(idx);
            if (list.isEmpty()) destMap.remove(dest);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == time) {
                    list.remove(i);
                    if (list.isEmpty()) destMap.remove(dest);
                    return;
                }
            }
        }
    }

    private int lowerBound(List<Integer> a, int key) {
        int lo = 0, hi = a.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a.get(mid) < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private int upperBound(List<Integer> a, int key) {
        int lo = 0, hi = a.size();
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a.get(mid) <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private static class Packet {
        final int src;
        final int dest;
        final int time;

        Packet(int src, int dest, int time) {
            this.src = src;
            this.dest = dest;
            this.time = time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Packet)) return false;
            Packet p = (Packet) o;
            return time == p.time && src == p.src && dest == p.dest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest, time);
        }

        @Override
        public String toString() {
            return "Packet{" + "src=" + src + ", dest=" + dest + ", time=" + time + '}';
        }
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */