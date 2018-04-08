package experiment;

public class MyThread2 implements Runnable {
    private int cnt = 5;
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    public void run() {
        while(this.cnt > 0) {
            System.out.println(this.name + ": " + this.cnt--);
        }
    }

    public static void main(String[] args) {
        MyThread2 c1 = new MyThread2("c1");
//        MyThread2 c2 = new MyThread2("c2");
//        MyThread2 c3 = new MyThread2("c3");

        new Thread(c1).start();
        new Thread(c1).start();
        new Thread(c1).start();

    }
}
