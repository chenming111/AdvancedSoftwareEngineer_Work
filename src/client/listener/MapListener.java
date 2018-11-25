package client.listener;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.data.Data;
import client.manager.MessageManager;
import client.net.PlayChess;
import client.ui.ChessBoardCanvas;


public class MapListener extends MouseAdapter {
	/**
	 * ��������
	 */
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		ChessBoardCanvas canvas = (ChessBoardCanvas)e.getSource();
		
//		�ж��Ƿ��½
		if(Data.connected){
//			�ж��Ƿ�ѡ���˶���
			if(Data.oppoId != 0){
				if(Data.ready == true){
//					�ж��Ƿ��Ѿ���ʼ
					if(Data.started){
						if(!Data.wait){
//							�ж��Ƿ��ֵ��Լ�����
							if(Data.turn == Data.myChess){
//								�ж��Ƿ������̷�Χ��
								if(e.getX() < canvas.getMapWidth() - 6 && e.getY() < canvas.getHeight() - 7 ){
									
									int chessX;
									int chessY;
									
									chessX = e.getX() / 35;
									chessY = e.getY()/ 35;
									
//									�жϴ˴��Ƿ���������
									if(Data.chessBoard[chessX][chessY] == 0){
										
										new PlayChess().play(chessX, chessY , Data.myChess);

									}
									else{
										
										MessageManager.getInstance().addMessage("�������������");
									}
								}
								

							}
							else{
//								��Ϊ�Է�����
								if(Data.turn == Data.oppoChess){
									
									MessageManager.getInstance().addMessage("û�ֵ����¡�����");
								}
								else{
//									����Ϸ�Ѿ�����
									if(Data.turn == 0){
										MessageManager.getInstance().addMessage("�Ѿ���������");
									}
								}

							}
						}
						else{
							MessageManager.getInstance().addMessage("�ȴ��Է��ظ�������");
						}
					}
					else{
						MessageManager.getInstance().addMessage("�ȴ��Է�׼��������");
					}
				}
				else{
					MessageManager.getInstance().addMessage("�ȵ������ʼ���ɣ�");
				}
			}
			
			else{
				MessageManager.getInstance().addMessage("ѡ�����ְɣ�");
			}
		}
		
		
		else{
			
			MessageManager.getInstance().addMessage("���ȵ�½��");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e3) {
		
		ChessBoardCanvas canvas = (ChessBoardCanvas)e3.getSource();
		
		if(!Data.wait){
			
			canvas.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		else{
			canvas.setCursor(new Cursor(Cursor.WAIT_CURSOR));
		}
		
		
	}
	
	@Override
	public void mouseExited(MouseEvent e4) {
		ChessBoardCanvas canvas = (ChessBoardCanvas)e4.getSource();
		canvas.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		
	}
	
	
}
