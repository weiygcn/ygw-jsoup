package Applet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by weiyg on 2017/9/20.
 */
public class HelloApplet extends Applet{
    public void paint(Graphics graphics){
        graphics.drawString("Hello Applet",25,50);
    }
}
