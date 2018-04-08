package experiment;

public class MyThread1 extends Thread {
    private int cnt = 5;
    private String name;

    public MyThread1(String name) {
        this.name = name;
    }

    public void run() {
        while(this.cnt > 0) {
            System.out.println(this.name + ": " + this.cnt--);
        }
    }

    public static void main(String[] args) {
        MyThread1 c1 = new MyThread1("c1");
        MyThread1 c2 = new MyThread1("c2");
        MyThread1 c3 = new MyThread1("c3");

        c1.start();
        c2.start();
        c3.start();
    }
}
