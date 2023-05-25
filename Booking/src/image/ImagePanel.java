package image;
import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel
{
    protected Image loginImage;

    public ImagePanel()
    {
        this.loginImage =
                new ImageIcon(getClass().getResource("/img/back.jpg")).getImage();
        setLayout(new GridBagLayout());
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(loginImage, 0, 0, null);
    }
}
