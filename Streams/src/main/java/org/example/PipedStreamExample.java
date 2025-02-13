package org.example;

import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create writer and reader threads
            Thread writerThread = new Thread(new Writer(pos));
            Thread readerThread = new Thread(new Reader(pis));

            // Start both threads
            writerThread.start();
            readerThread.start();

        } catch (IOException e) {
            System.err.println("Error creating piped streams: " + e.getMessage());
        }
    }
}

// Writer thread - writes data into PipedOutputStream
class Writer implements Runnable {
    private PipedOutputStream pos;

    public Writer(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try (DataOutputStream dos = new DataOutputStream(pos)) {
            String[] messages = {"Hello", "How are you?", "Goodbye"};
            for (String msg : messages) {
                dos.writeUTF(msg); // Write message
                dos.flush();
                System.out.println("Writer: Sent -> " + msg);
                Thread.sleep(1000); // Simulate delay
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Writer error: " + e.getMessage());
        }
    }
}

// Reader thread - reads data from PipedInputStream
class Reader implements Runnable {
    private PipedInputStream pis;

    public Reader(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try (DataInputStream dis = new DataInputStream(pis)) {
            while (true) {
                String receivedMessage = dis.readUTF(); // Read message
                System.out.println("Reader: Received -> " + receivedMessage);
            }
        } catch (EOFException e) {
            System.out.println("Reader: End of stream.");
        } catch (IOException e) {
            System.err.println("Reader error: " + e.getMessage());
        }
    }
}
