package Music;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music{

    static Clip clip;

    public void setfile(String musicFileName){
        try {
            File file = new File(musicFileName);
            AudioInputStream music = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(music);
            clip.start();
        } catch (Exception e) {
            
        }
    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public static void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stop(){
        clip.stop();
        clip.close();
    }
}
