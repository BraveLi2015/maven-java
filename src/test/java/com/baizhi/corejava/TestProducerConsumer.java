package com.baizhi.corejava;

public class TestProducerConsumer {
    public static void main(String[] args) {
        MyStack ms = new MyStack();

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (char c = 'A'; c <= 'Z'; c++) {
                    ms.push(c + "");
                }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 26; i++) {
                    ms.pop();
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }
}

class MyStack {
    private String[] data = {"", "", "", "", ""};

    private int index;

    public synchronized void push(String s) {
        while (index == data.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(s + " pushed");
        data[index] = s;
        printStack();
        index++;
        this.notifyAll();
    }

    public synchronized String pop() {
        while (index == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        index--;
        String result = data[index];
        System.out.println(result + " pop");
        data[index] = "";
        this.notifyAll();
        printStack();
        return result;
    }
    public void printStack() {

        for (String datum : data) {
            System.out.print(datum + " ");
        }
        System.out.println();
    }
}
