package Database.design.build;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class trainerAllSearch extends Pannel{

	JFrame sub = new JFrame("");
	Container subContainer = new Container();
	boolean blank_once = true;
	JPanel south = new JPanel();
	JScrollPane scrollPane;
	
	trainerAllSearch(Control control, Model pMember) {
		super(control, pMember);
		
		sub.setLocation(200,200);
		sub.setMinimumSize(new Dimension(1400,400));
		subContainer = sub.getContentPane();
		
		subPanel.setLayout(null);
		south.setLayout(new GridLayout(1, 4));
		
		if(blank_once){
			blank[0] = new JLabel("");
			blank[1] = new JLabel("");
			blank[2] = new JLabel("");
			blank_once = false;
		}
		
		_control.getDBTrainer(_model.trainerInfoComboT.getText());
		
		trainerTable = new JTable(_model.TrainerData, _model.trainerColNames);
		scrollPane = new JScrollPane(trainerTable);
		trainerTable.setFillsViewportHeight(true);
		trainerTable.setAutoCreateRowSorter(true);
		
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		trainerTable.getColumn("닉네임").setPreferredWidth(1);
		trainerTable.getColumn("닉네임").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("닉네임").setResizable(false);
		trainerTable.getColumn("트레이너 이름").setPreferredWidth(50);
		trainerTable.getColumn("트레이너 이름").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("생년월일").setPreferredWidth(1);
		trainerTable.getColumn("생년월일").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("트레이너 성별").setPreferredWidth(1);
		trainerTable.getColumn("트레이너 성별").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("전화번호").setPreferredWidth(50);
		trainerTable.getColumn("전화번호").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("주소").setPreferredWidth(400);
		trainerTable.getColumn("주소").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("자격증").setPreferredWidth(400);
		trainerTable.getColumn("자격증").setCellRenderer(celAlignCenter);
		
		subContainer.add(scrollPane,BorderLayout.CENTER);
		
		south.add(blank[0]);
		south.add(blank[1]);
		south.add(blank[2]);
		south.add(check);
		
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub.dispose();
			}
		});

		subContainer.add(south,BorderLayout.SOUTH);
		
		//frame 설정
		sub.setResizable(false);// frame 사이즈 변경 불가능
		sub.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}

}
