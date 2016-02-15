public class reconstructIntinerary {



    // TLE solution1 - brutal force scan
    public List<String> findItinerary(String[][] tickets) {
        String[] res = {""};
        find(tickets, "JFK", res);
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= res[0].length() - 3; i += 3) {
            result.add(res[0].substring(i, i + 3));
        }
        return result;
    }
    
    private void find(String[][] tickets, String curr, String[] res) {
        String dep = curr.substring(curr.length() - 3, curr.length());
        boolean isDest = true;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(dep)) {
                isDest = false;
                tickets[i][0] = "NONE";
                find(tickets, curr + tickets[i][1], res);
                tickets[i][0] = dep;
            }
        }
        
        if ((isDest && curr.compareTo(res[0]) < 0) || res[0].length() == 0) {
            res[0] = curr;
        }
    }


    // TLE solution 2 - HashMap pre-process
    public List<String> findItinerary2(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (!map.containsKey(tickets[i][0])) map.put(tickets[i][0], new ArrayList<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        
        String[] res = {""};
        find2(map, "JFK", res);
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= res[0].length() - 3; i += 3) {
            result.add(res[0].substring(i, i + 3));
        }
        return result;
    }
    
    private void find2(Map<String, List<String>> map, String curr, String[] res) {
        String dep = curr.substring(curr.length() - 3, curr.length());
        if (map.containsKey(dep) && map.get(dep).size() != 0) {
            List<String> list = map.get(dep);
            for (int i = 0; i < list.size(); i++) {           
                List<String> clone = new ArrayList<>(list);
                String next = clone.get(i);
                clone.remove(i);
                map.put(dep, clone);
                find(map, curr + next, res);
                map.put(dep, list);
            }
        } else if (curr.compareTo(res[0]) < 0 || res[0].length() == 0) {
            res[0] = curr;
        }
    }
}