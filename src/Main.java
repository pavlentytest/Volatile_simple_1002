public class Main {
    public volatile static boolean flag;
    public static void main(String[] args) {
        // Игровое приложение
        // 1 поток GUI
        // 2 поток Logic
        new Main().doStart();
    }

    void doStart() {
        new Thread(gui).start();
        System.out.println("Start GUI!");
        new Thread(logic).start();
        System.out.println("Start Logic!");
    }

    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Stop GUI!");
            flag = true;
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {

            }
            System.out.println("Stop logic!");
        }
    };
}