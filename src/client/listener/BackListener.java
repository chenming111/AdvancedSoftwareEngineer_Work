package client.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.data.Data;
import client.manager.IOManager;
import client.manager.MessageManager;


public class BackListener implements ActionListener{
	/**
	 * �����������
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(Data.started){
			
			IOManager.getInstance().getPs().println("OPER:BACK:" + Data.myId);
			
			Data.wait = true;
			MessageManager.getInstance().addMessage("�ȴ��Է��ظ�������");
			
		}
		
	}

}
