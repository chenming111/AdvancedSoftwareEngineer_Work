package client.listener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.data.Data;
import client.manager.IOManager;
import client.manager.MessageManager;
import client.ui.GameFrame;


public class MessageListener implements ActionListener {
	/**
	 *������Ϣ������ 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {

		String message = GameFrame.getInstance().getFunctionPanel().getMessagePanel().getMessageIn().getText();
		
		int oppoId = Data.oppoId;
		
		if (oppoId != 0){
			
			IOManager.getInstance().getPs().println("CHAT:" + message + "&" + oppoId);
		}
		
		GameFrame.getInstance().getFunctionPanel().getMessagePanel().getMessageIn().setText("");

		MessageManager.getInstance().addMessage("��˵��"+ message);
	}
	
}
