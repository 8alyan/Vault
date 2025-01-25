package labreport;

class MyThread extends Thread {
    private String threadName;
   public MyThread(String name) 
{ threadName = name; }
 public void run() {
        try {  for (int i = 1; i <= 5; i++) {
                  System.out.println(threadName + ": " + i);
                  Thread.sleep(500); 
            }
        }     catch (InterruptedException e) 
            {System.out.println(threadName + " interrupted."); }
    }
 public static void main(String[] args) {
        MyThread thread1 = new MyThread("Thread 1");
        MyThread thread2 = new MyThread("Thread 2");
        thread1.start();
        thread2.start();
    }
}