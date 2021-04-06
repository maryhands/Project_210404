package login;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import calendar.CreateAccount;
import javazoom.jl.player.Player;

public class LoginView extends JFrame implements Runnable{
	// 로그인 창 관련 선언
	String nickName = null;
	JPanel jpl = new JPanel();
	JLabel jlb_id = new JLabel("ID :");
	JLabel jlb_pw = new JLabel("PW :");
	JTextField jtf_id = new JTextField();
	JPasswordField jpf_pw = new JPasswordField();
	JButton jbtn_add = new JButton("회원가입");
	JButton jbtn_login = new JButton("로그인");
	JButton jbtn_restart = new JButton("음악 재시작");
	JButton jbtn_stop = new JButton("음악 중지");
	Font font = new Font("맑은 고딕", Font.BOLD, 15);
	Font font2 = new Font("맑은 고딕", Font.CENTER_BASELINE, 13);

	// 배경화면 관련 선언
	String imgPath = "C:\\GithubDesktop_ImportArea\\Project_210404\\project_210404\\src\\login\\";
	ImageIcon imgIcon = new ImageIcon(imgPath + "Background.png");

	// 음악 관련 선언
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private Player player;
	private Thread thread;
	private boolean isLoop;

	class BackGroundPanel extends JPanel { // 배경화면을 위해서 내부에 클래스 지정
		public void paintComponent(Graphics g) {
			g.drawImage(imgIcon.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponent(g);

		}
	}

	public void start() {
		Display();
	}

	public void Display() {
		// 화면 표시 관련
		this.setContentPane(new BackGroundPanel());
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("로그인");
		this.setVisible(true);
		this.setSize(360, 760);
		this.setResizable(false);// 크기조정 불가
		this.setLocation(800, 250);

		// id 부분
		jlb_id.setBounds(48, 250, 100, 30);
		jlb_id.setFont(font);
		jtf_id.setBounds(108, 250, 190, 30);
		this.add(jlb_id);
		this.add(jtf_id);

		// pw 부분
		jlb_pw.setBounds(48, 300, 80, 30);
		jlb_pw.setFont(font);
		jpf_pw.setBounds(108, 300, 190, 30);
		this.add(jlb_pw);
		this.add(jpf_pw);

		// 로그인 + 버튼 효과음
		jbtn_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtn_login) {
					Runnable loginR1 = new LoginView();
					Thread th_login = new Thread(loginR1);
					th_login.start();
				}
			}
		});
		jbtn_login.setBounds(178, 350, 120, 40);
		jbtn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(jbtn_login);

		// 회원가입 + 버튼효과음
		jbtn_add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jbtn_add) {
					Runnable addR1 = new LoginView();
					Thread th_add = new Thread(addR1);
					th_add.start();
					CreateAccount ca = new CreateAccount();
				}				
			}
		});
		jbtn_add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jbtn_add.setBounds(48, 350, 120, 40);
		this.add(jbtn_add);

		// 음악 정지 이벤트
		jbtn_stop.addActionListener(action);
		jbtn_stop.setContentAreaFilled(false);
		jbtn_stop.setBorderPainted(false);
		jbtn_stop.setFocusPainted(false);
		jbtn_stop.setFont(font2);
		jbtn_stop.setBounds(125, 400, 100, 30);
		jbtn_stop.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.add(jbtn_stop);

		// 음악 재시작 이벤트
		jbtn_restart.addActionListener(action);

		////// thread 선정 - JFrame에 영향을 줄 수 있는 독립적인 작업을 한다고 생각하면 좋음.
		thread = new Thread(() -> {//ArrowFuntion(공부하기에는 안좋음)를 이용해 이 스레드는 이것만 플레이 하도록함.
			try {
				do { // 무조건 실행하는 곳.
					isLoop = true;
					file = new File(imgPath + "MapleLoginMusic.mp3");
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					player = new Player(bis);
					player.play();
				} while (isLoop); // 반복재생을 위해서 while문 사용
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		thread.start();
		
	}// end of Display();
	
	//버튼 효과음 부분(thread 받는 부분)
	public void run() {
		synchronized (jbtn_add) {
			try {
				file = new File(imgPath + "PaperSound.mp3");
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				player.play();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

	@SuppressWarnings("deprecation") // 인터페이스를 선언해서 사용하는 것 인스턴스화 1-5의 원리를 이용한 것.
	public ActionListener action = (ActionEvent e) -> { // ArrowFuntion - 파이선 등에서 사용하던 것을 자바에서 이용해 사용하는 것
														// new actionListener({})의 원리, 묵시적인 것이라서 되도록이면 쓰지 말자.
		if (e.getSource() == jbtn_stop) {
			thread.suspend();
			isLoop = false;
			this.remove(jbtn_stop);
			this.revalidate();
			this.repaint();
			jbtn_restart.setContentAreaFilled(false);
			jbtn_restart.setBorderPainted(false);
			jbtn_restart.setFocusPainted(false);
			jbtn_restart.setFont(font2);
			jbtn_restart.setBounds(118, 400, 120, 30);
			jbtn_restart.setCursor(new Cursor(Cursor.HAND_CURSOR));
			this.add(jbtn_restart);
		} else if (e.getSource() == jbtn_restart) {
			thread.resume();
			isLoop = true;
			this.remove(jbtn_restart);
			this.revalidate();
			this.repaint();
			jbtn_stop.setContentAreaFilled(false);
			jbtn_stop.setBorderPainted(false);
			jbtn_stop.setFocusPainted(false);
			jbtn_stop.setFont(font2);
			jbtn_stop.setBounds(125, 400, 100, 30);
			this.add(jbtn_stop);
		}
	};// end of actionListener

	public static void main(String[] args) {
		LoginView lv = new LoginView();
		lv.start();
	}
}
