package com.leandroyabut.assignments.producerconsumer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Producer: Produces a random integer and pushes into a buffer
 * Consumer: Consumes the last integer in a buffer and prints the consumed integer
 *
 * Production and consumption is infinite
 */
public class ProducerConsumer {

    private static final int[] buffer = new int[7];

    public static void main(String[] args) {

        Random random = new Random(System.currentTimeMillis());


//      Producer produces a random integer and inputs into the buffer
//      when there is an empty space at the top of the buffer...
        Thread producer = new Thread(() -> {
                synchronized (buffer) {
                    Timer timer = new Timer("Producer Timer");
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            for (int i = 0; i < buffer.length; i++) {
                                if (buffer[i] == 0) { // Only if there is an empty slot
                                    buffer[i] = random.nextInt(100);
                                    System.out.println("Produced: " + buffer[i]);
                                }
                            }
                        }
                    }, 0, 1500); // Delay just for display
                }
        });

//      Consumer consumes the last element in the buffer
//      by printing the consumed element...
        Thread consumer = new Thread(() -> {
                synchronized (buffer) {
                    Timer timer = new Timer("Consumer Timer");
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            int consumed = buffer[buffer.length - 1]; // Get last element of buffer
                            if(consumed != 0) { // Make sure last element is not empty
                                int[] shifted = new int[buffer.length];
                                // Shift buffer so that the last element is "consumed"
                                System.arraycopy(buffer, 0, shifted, 1, buffer.length - 1);
                                System.arraycopy(shifted, 0, buffer, 0, buffer.length);
                                System.out.println("Consumed: " + consumed);
                            }
                        }
                    }, 0, 1500); // Delay just for display
                }
        });

        producer.start();
        consumer.start();

    }

}
