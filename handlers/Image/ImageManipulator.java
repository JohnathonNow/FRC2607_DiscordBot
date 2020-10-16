package handlers.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

import handlers.Handler;
import util.Message;

public class ImageManipulator implements Handler {

    @Override
    public void handleMessage(Message m) {
        if (m.getText().startsWith("!imgcrop")) {
            Scanner scanner = new Scanner(m.getText());
            scanner.next();
            String name = scanner.next();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            cropImage(name, x, y, width, height);
            m.reply(new Message(null, "image", "cropped"));
        }
    }

    public void cropImage(String name, int x, int y, int width, int height) {
        try {
            BufferedImage src = (BufferedImage) ImageIO.read(new File(name));
            BufferedImage dest = src.getSubimage(x, y, width, height);
            ImageIO.write(dest, "png", new File(name));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
