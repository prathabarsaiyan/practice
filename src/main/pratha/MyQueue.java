package main.pratha;

/*
Implement a first in first out (FIFO) queue using stacks data structure. The implemented queue should support all the functions of a normal queue (offer, peek, poll, and empty).
Implement the MyQueue class:
void offer(int x) Pushes element x to the back of the queue.
int poll() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
*/

import java.util.Stack;

class MyQueue{
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    MyQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void offer(int x){
        s1.push(x);
    }

    Integer poll(){
        if(empty()){
            return null;
        }
        fillS2();
        return s2.pop();
    }

    Integer peek(){
        if(empty()){
            return null;
        }
        fillS2();
        return s2.peek();
    }

    private void fillS2(){
        if(s2.empty()){
            while(!s1.empty()){
                s2.push(s1.pop());
            }
        }
    }

    boolean empty(){
        return s2.empty() && s1.empty();
    }
}