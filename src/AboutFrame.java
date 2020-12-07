import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AboutFrame extends JFrame {
    static final int WIDTH=340;
    static final int HEIGHT=300;

    public AboutFrame(){
        super("О программе");
        setSize(WIDTH,HEIGHT);
        this.setResizable(false);
        Toolkit kit=Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH)/2,(kit.getScreenSize().height - HEIGHT)/2);

        Box hBoxClose=Box.createHorizontalBox();
        JButton btnClose= new JButton("Закрыть");
        btnClose.setBackground(Color.ORANGE);
        btnClose.addActionListener(new ActionListener(){
                                       @Override
                                       public void actionPerformed(ActionEvent arg0) {
                                           setVisible(false);
                                       }
                                   }
        );
        hBoxClose.add(Box.createHorizontalGlue());
        hBoxClose.add(btnClose);
        hBoxClose.add(Box.createHorizontalGlue());

        Box hBoxData=Box.createVerticalBox();
        hBoxData.add(Box.createVerticalGlue());
        JLabel lblname= new JLabel("Подоляко Юлия");
        JLabel lblgroup= new JLabel("10 группа, 2 курс");
        JLabel lblimage= new JLabel("");
        hBoxData.add(lblname);
        hBoxData.add(lblgroup);
        hBoxData.add(Box.createVerticalGlue());

        Box hBoxContent=Box.createVerticalBox();
        hBoxContent.add(hBoxData);
        hBoxContent.add(hBoxClose);
        getContentPane().add(hBoxContent, BorderLayout.CENTER);
    }
}