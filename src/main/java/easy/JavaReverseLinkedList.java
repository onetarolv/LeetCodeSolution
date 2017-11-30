package easy;

import util.JavaListNode;

/**
 * Created by engry on 2017/9/22.
 */
public class JavaReverseLinkedList {
    public JavaListNode reverseList(JavaListNode head) {
        if(head == null)
            return null;
        JavaListNode p = head, q = head.next, r;
        p.next = null;
        while(q != null){
            r = q.next == null ? null : q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
}

class TestReverse{
    public static void main(String args[]){
        JavaListNode[] arr = new JavaListNode[4];
        for(int i = 0; i < 4; i ++){
            JavaListNode p = new JavaListNode(i + 1);
            arr[i] = p;
            if(i != 0){
                arr[i-1].next = p;
            }
        }
        arr[0].next = null;
        JavaReverseLinkedList test = new JavaReverseLinkedList();
        JavaListNode head = test.reverseList(arr[0]);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}
