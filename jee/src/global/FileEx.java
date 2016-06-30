package global;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEx {
	public static void main(String[] args) {
		File file =null;
		FileWriter fw = null;
		FileReader fr = null;
		BufferedWriter bw =null;
		BufferedReader br = null;
		String msg = "";
		try {
			while (true) {
				switch (JOptionPane.showInputDialog("1.생성 2.쓰기 3.읽기 4.수정 5.삭제 0.종료")) {
				case "1":
					String fileName=JOptionPane.showInputDialog("파일명");
					file = new File("C:\\Users\\hb2003\\workspace\\"+fileName+".txt");
					fw = new FileWriter(file,true);
					fr = new FileReader(file);
					bw = new BufferedWriter(fw);
					br = new BufferedReader(fr);
					break;
				case "2":
					msg = JOptionPane.showInputDialog("메시지?");
					bw.write(msg);
					bw.newLine();
					fw.flush();
					bw.flush();
					break;
				case "3":
					while((msg = br.readLine())!=null){
						JOptionPane.showMessageDialog(null, msg);
					}
					fr.close();
					br.close();
					
					break;
				case "4":
					String updateFileName = JOptionPane.showInputDialog("수정하려는 파일이름");
					File updateFile = new File("C:\\Users\\hb2003\\workspace\\"+updateFileName+".txt");
					bw = new BufferedWriter(new FileWriter(updateFile));
					String updateMsg = JOptionPane.showInputDialog("수정메시지");
					bw.write(updateMsg);
					bw.flush();
					break;
				case "5":
					String delFileName=JOptionPane.showInputDialog("삭제하려는 파일명?");
					File delFile = new File("C:\\Users\\hb2003\\workspace\\"+delFileName+".txt");
					delFile.delete();
					break;
				case "0":
					fw.close();
					bw.close();
					fr.close();
					br.close();
					return;
				default:
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.flush();
				bw.flush();
				fw.close();
				bw.close();
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}
}