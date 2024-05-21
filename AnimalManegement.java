package animal_project;

import java.awt.*;

import javax.swing.*;

public class AnimalManegement extends JPanel {
	private JPanel panelTop;
	private JPanel panelBottom;
	private JPanel tablePanel;
	
	public AnimalManegement() {
				
				Animal animal = new Animal();
				animal.getCustomers();
				animal.createCustomer("호랑이과","호돌이",4,"건강함");
				initialize();
				
	}
	
	
	private void initialize() {
		panelTop = new JPanel();								// 상단 패널
		panelTop.setBounds(6, 6, 1012, 354);					// 패널 위치와 크기  -> (x좌표, y좌표, 넓이, 높이)
		panelTop.setLayout(null);								// 상단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute				// 프레임에 추가하기
		panelTop.setVisible(true);								// 패널 보이기

		panelBottom = new JPanel();								// 하단 패널
		panelBottom.setBounds(6, 372, 1012, 354);				// 패널 위치와 크기  -> (x좌표, y좌표, 넓이, 높이)
		panelBottom.setLayout(null);							// 하단 패널에 추가되는 컴포넌트 레이아웃 -> Absolute				// 프레임에 추가하기
		panelBottom.setVisible(false);  						// 하단 패널 가리기

		tablePanel = new JPanel();								// 테이블 패널 생성
		tablePanel.setBounds(20, 50, 972, 268);					// 테이블 패널 위치와 크기			// 테이블 패널 추가
		
		JButton btnInsert;
		btnInsert = new JButton("추가");
		btnInsert.setBounds(689, 318, 100, 30);
		panelTop.add(btnInsert);

	}
}
