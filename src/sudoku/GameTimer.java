package sudoku;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {
    private Timer timer;
    private int secondsElapsed;
    private JLabel timerLabel;
    private boolean isPaused;

    public GameTimer(JLabel timerLabel) {
        this.timerLabel = timerLabel;
        this.secondsElapsed = 0;
        this.isPaused = false;

        // Inisialisasi timer yang akan berjalan setiap detik
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isPaused) {
                    secondsElapsed++;
                    updateTimerDisplay();
                }
            }
        });
    }

    public void start() {
        timer.start();
        isPaused = false;
    }

    public void pause() {
        isPaused = true;
    }

    public void resume() {
        isPaused = false;
    }

    public void reset() {
        secondsElapsed = 0;
        updateTimerDisplay();
    }

    private void updateTimerDisplay() {
        int hours = secondsElapsed / 3600;
        int minutes = (secondsElapsed % 3600) / 60;
        int seconds = secondsElapsed % 60;
        
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timerLabel.setText("Time: " + timeString);
    }

    public int getElapsedTime() {
        return secondsElapsed;
    }

    public void stop() {
        timer.stop();
    }
}
