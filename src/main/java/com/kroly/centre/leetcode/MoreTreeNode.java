package com.kroly.centre.leetcode;

import java.util.*;

/**
 * @ClassName MoreTreeNode
 * @Description 多叉树的操作
 * @Author kang.ouyang
 * @Date 2020-06-22 09:49
 **/
public class MoreTreeNode {
    static class Node {
        int value;
        int leven;
        List<Node> children = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "node value=" + value + " leven=" + leven;
        }
    }

    public static void addLeven(Node root) {
//        addLevenA(root);
//        addLevenB(root);
        addLevenC(root);
    }

    /***
     * @Author kang.ouyang
     * @Description 利用队列实现 迭代的层序遍历
     * @Date 09:56 2020-06-22
     * @param
     * @return void
     **/
    public static void addLevenA(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node);
            for (Node child : node.children) {
                child.leven = node.leven + 1;
                queue.add(child);
            }
        }
    }

    /***
     * @Author kang.ouyang
     * @Description 利用栈，迭代 进行前序遍历
     * @Date 10:07 2020-06-22
     * @param root
     * @return void
    **/
    public static void addLevenB(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop);
            List<Node> children = pop.children;
            for(int i = children.size() - 1; i >= 0; i--){
                Node node = children.get(i);
                node.leven = pop.leven + 1;
                stack.push(node);
            }
        }
    }

    /***
     * @Author kang.ouyang
     * @Description 利用栈，迭代 进行后续遍历
     * @Date 10:07 2020-06-22
     * @param root
     * @return void
     **/
    public static void addLevenC(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop);
            List<Node> children = pop.children;

            for (Node child: children){
                child.leven = pop.leven + 1;
                stack.push(child);
            }
        }
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        b.children.add(e);
        b.children.add(f);
        b.children.add(g);

        addLeven(a);
    }
}
