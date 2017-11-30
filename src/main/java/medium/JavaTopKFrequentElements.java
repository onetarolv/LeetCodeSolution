package medium;

import java.util.*;

/**
 * Created by engry on 2017/11/24.
 * 347. Top K Frequent Elements
 */
public class JavaTopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(count.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> res = new ArrayList<>();

//        for(Map.Entry<Integer, Integer> mapping:list) {
//            System.out.println(mapping.getKey() + ":" + mapping.getValue());
//        }

        Iterator iter = list.iterator();
        int i = 0;
        while(i < k && iter.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
            res.add(entry.getKey());
            i ++;
        }
        return res;
    }
}
class JavaTopKFrequentElementsTest{
    public static void main(String args[]){
        JavaTopKFrequentElements test = new JavaTopKFrequentElements();
        int[] nums = {1,1,1,1,2,2,33,3,3,3,4,4,4,4,4};
        List<Integer> res = test.topKFrequent(nums, 3);
        for(Integer num : res) {
            System.out.print(num + " ");
        }
    }
}
