import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> categoryOrder = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");
        Set<String> validCategories = new HashSet<>(categoryOrder);
        Map<String, List<String>> categoryMap = new HashMap<>();
        for (String category : categoryOrder) {
            categoryMap.put(category, new ArrayList<>());
        }
        String regex = "^[A-Za-z0-9_]+$";
        for (int i = 0; i < code.length; i++) {
            if (isActive[i] && validCategories.contains(businessLine[i]) 
                && code[i].length() > 0 && code[i].matches(regex)) {
                categoryMap.get(businessLine[i]).add(code[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String category : categoryOrder) {
            List<String> coupons = categoryMap.get(category);
            Collections.sort(coupons);
            result.addAll(coupons);
        }

        return result;
    }
}