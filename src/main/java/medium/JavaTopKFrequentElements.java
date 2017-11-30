package medium;

import java.util.*;

/**
 * Created by engry on 2017/11/24.
 * 347. Top K Frequent Elements
 */
public class JavaTopKFrequentElements {
    /**
     * my solution (36ms)
     */
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

    /**
     * other solution 1 (19ms):
     * use an array, the index of this array denotes the frequencies,
     * and the elem is a list which stores these numbers.
    */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for(int num : nums){
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        Set<Integer> keySet = countMap.keySet();
        for(Integer num : keySet) {
            int count = countMap.get(num);
            if(freq[count] == null)
                freq[count] = new ArrayList<Integer>();
            freq[count].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length; i > 0 && k > 0; i --) {
            if(freq[i] != null) {
                res.addAll(freq[i]);
                k -= freq[i].size();
            }
        }
        return res;
    }

    /**
     * other solution 2 (97ms):
     * use a PriorityQueue, an ordered list
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> sortedQueue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for(Map.Entry entry: entrySet) {
            sortedQueue.add(entry);
        }

        List<Integer> res = new ArrayList<Integer>();
        while(k > 0) {
            res.add(sortedQueue.poll().getKey());
            k --;
        }
        return res;
    }

    /**
     * other solution 3 (30ms):
     * use a TreeMap, an ordered map
     */
    public List<Integer> topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freq = new TreeMap<>();
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        for(Map.Entry<Integer, Integer> entry: entrySet) {
            int count = entry.getValue();
            if(!freq.containsKey(count))
                freq.put(count, new ArrayList<Integer>());
            freq.get(count).add(entry.getKey());
        }

        List<Integer> res = new ArrayList<Integer>();
        while(k > 0) {
            List<Integer> list = freq.pollLastEntry().getValue();
            res.addAll(list);
            k -= list.size();
        }
        return res;
    }
}
class JavaTopKFrequentElementsTest{
    public static void main(String args[]){
        JavaTopKFrequentElements test = new JavaTopKFrequentElements();
        int[] nums = {1,1,1,1,2,2,33,3,3,3,4,4,4,4,4};
        List<Integer> res = test.topKFrequent3(nums, 3);
        for(Integer num : res) {
            System.out.print(num + " ");
        }
    }
}
