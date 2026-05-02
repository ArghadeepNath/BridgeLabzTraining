package org.review.Review_A;

public class fileProcessing {

    static class FileProcessor {
        String fileName;
        int chunkSize;

        FileProcessor(String fileName, int chunkSize) {
            this.fileName = fileName;
            this.chunkSize = chunkSize;
        }
    }

    static class FileProcessingThread extends Thread {
        private FileProcessor file;

        FileProcessingThread(FileProcessor file) {
            this.file = file;
        }

        @Override
        public void run() {
            System.out.println("Processing file: " + file.fileName +
                    " | Chunk size: " + file.chunkSize);

            for (int i = 1; i <= 5; i++) {
                System.out.println(file.fileName + " -> Processing chunk " + i);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }
            }

            System.out.println(file.fileName + " processing completed.\n");
        }
    }

    public static void main(String[] args) {

        FileProcessor f1 = new FileProcessor("data.txt", 1024);
        FileProcessor f2 = new FileProcessor("config.xml", 512);

        FileProcessingThread t1 = new FileProcessingThread(f1);
        FileProcessingThread t2 = new FileProcessingThread(f2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
        System.out.println("All files processed.");
    }
}