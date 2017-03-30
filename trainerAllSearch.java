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
		
		trainerTable.getColumn("�г���").setPreferredWidth(1);
		trainerTable.getColumn("�г���").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("�г���").setResizable(false);
		trainerTable.getColumn("Ʈ���̳� �̸�").setPreferredWidth(50);
		trainerTable.getColumn("Ʈ���̳� �̸�").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("�������").setPreferredWidth(1);
		trainerTable.getColumn("�������").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("Ʈ���̳� ����").setPreferredWidth(1);
		trainerTable.getColumn("Ʈ���̳� ����").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("��ȭ��ȣ").setPreferredWidth(50);
		trainerTable.getColumn("��ȭ��ȣ").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("�ּ�").setPreferredWidth(400);
		trainerTable.getColumn("�ּ�").setCellRenderer(celAlignCenter);
		trainerTable.getColumn("�ڰ���").setPreferredWidth(400);
		trainerTable.getColumn("�ڰ���").setCellRenderer(celAlignCenter);
		
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
		
		//frame ����
		sub.setResizable(false);// frame ������ ���� �Ұ���
		sub.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//sub.pack();
		sub.setVisible(true);
	}

}
