class RandomizedSet {
    private ArrayList<Integer> list;
    private Map<Integer,Integer> map;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(search(val)) return false; // if found   
        // if not
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean search(int val) {
        return map.containsKey(val);
    }
    
    public boolean remove(int val) {
        if(!search(val)) return false; // for removing element, its better to exist

        int idx = map.get(val);
        list.set(idx,list.get(list.size()-1));
        map.put(list.get(idx), idx);
        list.remove(list.size()-1); // reduced
        map.remove(val); // removed
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */