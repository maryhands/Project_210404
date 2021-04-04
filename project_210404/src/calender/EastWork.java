package calender;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EastWork extends JFrame {
   String cols[] = {"출근 시간", "퇴근 시간"};
   String data[][] = new String[17][2];
   DefaultTableModel dtm = new DefaultTableModel(data, cols) {
      public boolean isCellEditable(int d, int c) {
         return false;
      }
   };
   JTable jtb = new JTable(dtm);
   JScrollPane jsp = new JScrollPane(jtb);
   JButton work = new JButton("출근");
   JButton leave = new JButton("퇴근");
   
   public EastWork() {
      initDisplay();
   }

   public void initDisplay() {
      jsp.setBounds(50, 20, 300, 300);
      work.setBounds(50, 340, 140, 50);
      leave.setBounds(210, 340, 140, 50);
      jtb.getTableHeader().setReorderingAllowed(false); // 이동 불가
      jtb.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
      this.add(jsp);
      this.add(work);
      this.add(leave);
      this.setLayout(null);// 패널에 레이아웃 위치 설정 및 배치
      this.setTitle("근태관리");
      this.setResizable(false);// 크기조정 불가
      this.setSize(420, 450);
      this.setVisible(true);
      this.setLocationRelativeTo(null);// 가운데 띄우게하기
   }
}