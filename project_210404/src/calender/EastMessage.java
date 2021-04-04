package calender;

import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EastMessage extends JFrame {
   JLabel jlb_rec = new JLabel  ("받는 사람 ");
   JLabel jlb_title = new JLabel("제목");
   JTextField jtf_mail_ads = new JTextField(20);
   JTextField jtf_title = new JTextField(20);
   JTextArea jta    = new JTextArea();
   JScrollPane jsp = new JScrollPane(jta);
   JButton send = new JButton("보내기");
   
   public EastMessage() {
      initDisplay();
   }

   public void initDisplay() {
      jta.setLineWrap(true);
      jsp.setBounds(45, 100, 500, 300);
      jlb_rec.setBounds(25, 17, 100, 50);
      jlb_title.setBounds(25, 48, 100, 50);
      jtf_mail_ads.setBounds(120, 35, 300, 20);
      jtf_title.setBounds(120, 65, 300, 20);
      send.setBounds(440, 35, 100, 50);
      jlb_rec.setHorizontalAlignment(JLabel.CENTER);
      jlb_title.setHorizontalAlignment(JLabel.CENTER);
      this.add(jsp);
      this.add(send);
      this.add(jlb_rec);
      this.add(jlb_title);
      this.add(jtf_mail_ads);
      this.add(jtf_title);
      this.setLayout(null);
      this.setTitle("메일쓰기");
      this.setResizable(false);
      this.setSize(600, 500);
      this.setVisible(true);
      this.setLocationRelativeTo(null);
   }
}