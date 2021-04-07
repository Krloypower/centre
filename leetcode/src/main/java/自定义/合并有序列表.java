package 自定义;

import first.leetcode.editor.cn.ListNode;

/**
 * @ClassName 合并有序列表
 * @Description TODO
 * @Author ouyangkang
 * @Date 2021/4/6
 * @Version 1.0
 **/
public class 合并有序列表 {

    public ListNode marge(ListNode node1, ListNode node2){

        if (node1 == null){
            return node2;
        }
        if (node2 == null){
            return node1;
        }

        if (node1.val < node2.val){
            node1.next = marge(node1.next, node2);
            return node1;
        }else {
            node2.next = marge(node1, node2.next);
            return node2;
        }
    }
}
