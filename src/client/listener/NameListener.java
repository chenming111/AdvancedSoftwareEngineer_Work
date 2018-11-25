package client.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.data.Data;
import client.manager.IOManager;
import client.manager.MessageManager;
import client.ui.GameFrame;

public class NameListener implements ActionListener{
	/**
	 * �����޸���������
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if( Data.connected){
			
			GameFrame.getInstance().getGamePanel();
			
			String newName = GameFrame.getInstance().getGamePanel().getNameIn().getText();
			
			if(newName != null){
				
				if(newName.equals(Data.myName)){
					
					MessageManager.getInstance().addMessage("�Ѿ�������ǳ�����");
				}
				else{
					
					IOManager.getInstance().getPs().println("NAME:" + newName);
					
				}
			}
			else{
				MessageManager.getInstance().addMessage("������һ���ǳƣ�");
			}
		}
		else{
			MessageManager.getInstance().addMessage("���ȵ�½��������");
		}
	}
	
}