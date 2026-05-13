class FooBar {
    private int n;
    private final Semaphore fooo = new Semaphore(1);
    private final Semaphore barr = new Semaphore(0);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooo.acquire();
        	printFoo.run();
            barr.release();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barr.acquire();
        	printBar.run();
            fooo.release();
        }
    }
}