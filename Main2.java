package animal_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {
	public static final String PROGRAM_NAME = "동물 관리 프로그램";
	public static final String ANIMAL_MANEGEMENT = "동물 관리";
	public static final String KEEPER_MANEGEMENT = "사육사 관리";
	JPanel centerPanel;
	
	public Main() {
		setTitle(PROGRAM_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.setBackground(Color.WHITE);
		
		
			
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel(PROGRAM_NAME, SwingConstants.LEFT);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18f));
        
        topPanel.add(titleLabel, BorderLayout.WEST);
 
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        JButton animalManagementBtn = new JButton(ANIMAL_MANEGEMENT);
        animalManagementBtn.setPreferredSize(new Dimension(100,30));
        
        JButton keeperManagementBtn = new JButton(KEEPER_MANEGEMENT);
        keeperManagementBtn.setPreferredSize(new Dimension(100,30));

        JButton feederManagementBtn = new JButton("사육사 관리");
        feederManagementBtn.setPreferredSize(new Dimension(100,30));

        JButton eventManagementBtn = new JButton("일정 관리");
        eventManagementBtn.setPreferredSize(new Dimension(100,30));
        
        BtnActionListener topPanelBtnListener = new BtnActionListener();
        
        animalManagementBtn.addActionListener(topPanelBtnListener);
        keeperManagementBtn.addActionListener(topPanelBtnListener);
        feederManagementBtn.addActionListener(topPanelBtnListener);
        eventManagementBtn.addActionListener(topPanelBtnListener);

        buttonPanel.add(animalManagementBtn);
        buttonPanel.add(keeperManagementBtn);
        buttonPanel.add(feederManagementBtn);
        buttonPanel.add(eventManagementBtn);
 
        topPanel.add(buttonPanel, BorderLayout.EAST);

        cp.add(topPanel, BorderLayout.NORTH);
 
        centerPanel = new JPanel(new CardLayout());
        
        AnimalManegement animalManegement = new AnimalManegement();
        KeeperManegement keeperManegement = new KeeperManegement();
        
        centerPanel.add(animalManegement,ANIMAL_MANEGEMENT);
        centerPanel.add(keeperManegement,KEEPER_MANEGEMENT);
        

        cp.add(centerPanel, BorderLayout.CENTER);
        
        setSize(1024,768);
		setVisible(true); 
	}
	

	public static void main(String[] args) {
		 new Main();
	} //main End.
	
	public class BtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton btn = (JButton)e.getSource();
			CardLayout cl = (CardLayout)centerPanel.getLayout();
			String btnText = btn.getText();
			switch(btnText) {
			case ANIMAL_MANEGEMENT: cl.show(centerPanel, ANIMAL_MANEGEMENT); break; 
			case KEEPER_MANEGEMENT: cl.show(centerPanel, KEEPER_MANEGEMENT); break;
			case "��� ����": System.out.println("��� ����");break;
			case "�̺�Ʈ ����": System.out.println("�̺�Ʈ ����");break;
			}
		}
	}

}