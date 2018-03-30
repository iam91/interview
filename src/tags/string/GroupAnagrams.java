package tags.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    // https://leetcode.com/problems/group-anagrams/description/

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();

        if(strs == null || strs.length == 0) return ret;

        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String key = new String(curr);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                List<String> t = new ArrayList<>();
                t.add(strs[i]);
                map.put(key, t);
            }
        }

        for(String k: map.keySet()) {
            ret.add(map.get(k));
        }

        return ret;
    }
}
