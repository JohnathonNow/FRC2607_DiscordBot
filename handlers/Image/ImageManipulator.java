package handlers.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.io.IOException;
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
        else if (m.getText().startswith("!imgcaption")){
            Scanner scanner = new Scanner(m.getText());
            Scanner.next();
            String name = scanner.next();
            String top_text = scanner.next();
            String bottom_text = scanner.next();
            captionImage(name, top_text, bottom_text);
            m.reply(new Message(null, "image", "captioned"));
        }
    }
    public void captionImage(String name, String top_text, String bottom_text) {
        BufferedImage src = (BufferedImage)ImageIO.read(new File(name));
        Graphics g = src.createGraphics();
        g.drawString(top_text, src.getWidth()/10, src.getHeight()/10);
        g.drawString(bottom_text, src.getWidth()/10, src.getHeight()*9/10);
        ImageIO.write(src, "png", new File(name));
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
