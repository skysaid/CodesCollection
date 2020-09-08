package Algorithm;

import java.util.Stack;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
public class a155 {
    class MinStack {
        Stack<Integer> element;
        Stack<Integer> cur_min_element;
        /** initialize your data structure here. */
        public MinStack() {
            this.element = new Stack<>();
            this.cur_min_element =new Stack<>();
        }

        public void push(int x) {
            this.element.push(x);
            if (this.cur_min_element.isEmpty()){
                this.cur_min_element.push(x);
                return;
            }
            int cur = this.cur_min_element.peek();
            if (cur > x){
                this.cur_min_element.push(x);
            }else {
                this.cur_min_element.push(cur);
            }
        }

        public void pop() {
            this.element.pop();
            this.cur_min_element.pop();
        }

        public int top() {
            return this.element.peek();
        }

        public int getMin() {
            return this.cur_min_element.peek();
        }
    }
}
