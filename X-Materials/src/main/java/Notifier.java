import java.io.IOException;

public class Notifier implements Runnable{

    GUISimple gui = new GUISimple("kek", 100,100);
    private Thread thread;
    private Boolean flag;

    public Notifier() throws IOException {
        flag = false;
        thread = new Thread(this, "Thread Notifier");
        thread.start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        try{
            for (int i = 0; i < gui.fromMyFile.LineQuan(); i++) {
                gui.fromMyFile.setA(i);
                gui.textArea.append(gui.fromMyFile.read());
                if(flag == true){
                    mysuspend();
                    synchronized (this){
                        while(flag == true){
                            wait();
                        }
                    }
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "Ended in cycle");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void myresume(){
        flag = false;
        notify();
    }

    public synchronized void mysuspend(){
        flag = true;
    }
}
