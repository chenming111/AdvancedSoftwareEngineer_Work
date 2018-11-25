package client.net;

import java.io.*;
import java.net.*;

import client.data.*;
import client.manager.IOManager;
import client.manager.MessageManager;
import client.ui.GameFrame;

public class Connect {
	/**
	 * ��½������
	 */
	public void connect(){

		try {
			
			String portStr = GameFrame.getInstance().getGamePanel().getPort().getText();
			String ipStr = GameFrame.getInstance().getGamePanel().getIp().getText();
			
			int portValue = Integer.parseInt(portStr);
			
			Socket socket = new Socket(ipStr,portValue);
			
			Data.connected = true;
			
			MessageManager.getInstance().addMessage("�����������ӣ�");
			GameFrame.getInstance().getGamePanel().getConnectInfo().setText("������״̬���ѵ�¼��");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			InputStreamReader isr = new InputStreamReader(is);
			
			IOManager.getInstance().setBr(isr);
			IOManager.getInstance().setPs(os);
						
		} catch (UnknownHostException e) {
			
			MessageManager.getInstance().addMessage("�Ҳ�����������");
			
		} catch (IOException e) {
			
			MessageManager.getInstance().addMessage("���������ӳ���");
		}

	}
}
