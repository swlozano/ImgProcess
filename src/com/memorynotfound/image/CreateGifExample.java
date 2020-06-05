package com.memorynotfound.image;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateGifExample {

    public static void main(String[] args) throws Exception {
        BufferedImage first = ImageIO.read(new File("/Users/dev/eclipse-workspace/ImgProcess/in-img/IMG_1.jpg"));
        ImageOutputStream output = new FileImageOutputStream(new File("/Users/dev/eclipse-workspace/ImgProcess/out-img/example-4.gif"));

        GifSequenceWriter writer = new GifSequenceWriter(output, first.getType(), 100, true);
        writer.writeToSequence(first);
        

        File[] images = new File[]{
                new File("/Users/dev/eclipse-workspace/ImgProcess/in-img/IMG_1.jpg"),
                new File("/Users/dev/eclipse-workspace/ImgProcess/in-img/IMG_2.jpg"),
                new File("/Users/dev/eclipse-workspace/ImgProcess/in-img/IMG_3.jpg"),
                new File("/Users/dev/eclipse-workspace/ImgProcess/in-img/IMG_4.jpg")
        };

        for (File image : images) {
            BufferedImage next = ImageIO.read(image);
            writer.writeToSequence(next);
        }

        writer.close();
        output.close();
        System.out.println("this is the end!!!");
    }
}
