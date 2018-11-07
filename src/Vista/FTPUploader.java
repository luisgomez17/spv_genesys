/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FTPUploader {
    FTPClient ftp = null;
	
	public FTPUploader(String host, String user, String pwd, String localFileFullName, String fileName, String hostDir) throws Exception{
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		int reply;
		ftp.connect(host);
		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			throw new Exception("Exception in connecting to FTP Server");
		}
		ftp.login(user, pwd);
		ftp.setFileType(FTP.BINARY_FILE_TYPE);
		ftp.enterLocalPassiveMode();
                
                byte[] bytes1 = localFileFullName.getBytes("UTF-8");
                localFileFullName = new String(bytes1, "UTF-8");
                
                byte[] bytes2 = fileName.getBytes("UTF-8");
                fileName = new String(bytes2, "UTF-8");
                
                byte[] bytes3 = hostDir.getBytes("UTF-8");
                hostDir = new String(bytes3, "UTF-8");
                
                File direc = new File(hostDir);
                direc.mkdir();
                
                uploadFile( localFileFullName,  fileName,  hostDir);
                disconnect();
	}
	public void uploadFile(String localFileFullName, String fileName, String hostDir)
			throws Exception {
		try(InputStream input = new FileInputStream(new File(localFileFullName))){
		this.ftp.storeFile(hostDir + fileName, input);
		}
	}

	public void disconnect(){
		if (this.ftp.isConnected()) {
			try {
				this.ftp.logout();
				this.ftp.disconnect();
			} catch (IOException f) {
				// do nothing as file is already saved to server
			}
		}
	}
	public static void main(String[] args) throws Exception {
		/*
            System.out.println("Start");
		FTPUploader ftpUploader = new FTPUploader("www.genesysmi.com", "genesysmi@genesysmi.com", "65i1r3WqQd");
		//FTP server path is relative. So if FTP account HOME directory is "/home/pankaj/public_html/" and you need to upload 
		// files to "/home/pankaj/public_html/wp-content/uploads/image2/", you should pass directory parameter as "/wp-content/uploads/image2/"
		ftpUploader.uploadFile("C:\\Users\\luism\\Pictures\\images.jpg", "image.jpg", "/img/products/");
		ftpUploader.disconnect();
		System.out.println("Done");  */
	

}

}

