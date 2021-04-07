package calendar;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import calendar.EastMessage.BackGroundPanel;

public class EastMessage extends JFrame {
	JLabel jlb_sen = new JLabel("보내는 사람");
	JLabel jlb_rec = new JLabel("받는 사람");
	JLabel jlb_title = new JLabel("제목");
	JTextField jtf_sen_mail = new JTextField(20);
	JTextField jtf_rec_mail = new JTextField(20);
	JTextField jtf_title = new JTextField(20);
	JTextArea jta = new JTextArea();
	JScrollPane jsp = new JScrollPane(jta);
	JButton send = new JButton("보내기");

	Font font = new Font("맑은 고딕", Font.BOLD, 15);
	
	String imgPath = "project_210404\\src\\calendar\\";
	ImageIcon imgIcon = new ImageIcon(imgPath + "blossom.jpg");

	class BackGroundPanel extends JPanel { // 배경화면을 위해서 내부에 클래스 지정
		public void paintComponent(Graphics g) {
			g.drawImage(imgIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);

		}
	}

	public EastMessage() {
		initDisplay();
	}

	public void initDisplay() {

		this.setContentPane(new BackGroundPanel());
		jta.setLineWrap(true);
		jsp.setBounds(70, 150, 440, 330);
		jlb_sen.setBounds(25, 20, 100, 50);
		jlb_sen.setFont(font);
		jlb_rec.setBounds(25, 50, 100, 50);
		jlb_rec.setFont(font);
		jlb_title.setBounds(25, 80, 100, 50);
		jlb_title.setFont(font);
		jtf_sen_mail.setBounds(120, 38, 300, 20);
		jtf_rec_mail.setBounds(120, 68, 300, 20);
		jtf_title.setBounds(120, 98, 300, 20);
		send.setBounds(440, 40, 100, 60);
		send.setFont(font);
		jlb_sen.setHorizontalAlignment(JLabel.CENTER);
		jlb_rec.setHorizontalAlignment(JLabel.CENTER);
		jlb_title.setHorizontalAlignment(JLabel.CENTER);
		this.add(jsp);
		this.add(send);
		this.add(jlb_sen);
		jtf_sen_mail.setEditable(false);
		this.add(jlb_rec);
		this.add(jlb_title);
		this.add(jtf_sen_mail);
		this.add(jtf_rec_mail);
		this.add(jtf_title);
		this.setLayout(null);
		this.setTitle("메일쓰기");
		this.setResizable(false);
		this.setSize(600, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}