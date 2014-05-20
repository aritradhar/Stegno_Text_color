//author Aritra Dhar
//MT12004
//M.TECH CSE
//INFORMATION SECURITY
//IIIT-Delhi
//RTF Generator
//----------->Sender side tool<---------------------------
//Read the comments carefully for the successful deployment

import java.io.*;


public class rtfGen 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		
		File rtf=new File("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\carr.rtf");
		rtf.createNewFile();
		FileWriter rtf_writer=new FileWriter(rtf);
		
		FileReader bin_in=new FileReader("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\bin.txt");
		FileReader carr_in=new FileReader("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\c.txt");
		//header
		rtf_writer.append("{\\rtf1\\ansi\\ansicpg1252\\deff0\\deflang1033{\\fonttbl{\\f0\\fnil\\fcharset0 Calibri;}}\n");
		rtf_writer.append("{\\colortbl ;\\red255\\green1\\blue1;}\n");
		rtf_writer.append("{\\*\\generator Msftedit 5.41.21.2510;}\\viewkind4\\uc1\\pard\\sa200\\sl276\\slmult1\\lang9\\f0\\fs22");
		char bin_s = 0,carr_s;
		int flag=0;
		int a=0;
		//end of header
		
		//gen
					//rtf_writer.append("abcd");
		while(bin_s !='*')
		{
			bin_s=(char)bin_in.read();
			carr_s=(char)carr_in.read();
			
			if(bin_s=='1')
			{
				if(flag==0||flag==2)
				{
					rtf_writer.append("\\cf1 "+carr_s);
					flag=1;
				}
				else
				{
					rtf_writer.append(carr_s);
				}
				a++;
				
			}
			if(bin_s=='0')
			{
				if(flag==0||flag==1)
				{
					rtf_writer.append("\\cf0 "+carr_s);
					flag=2;
				}
				else if(flag==2)
				{
					rtf_writer.append(carr_s);
				}
				a++;
			}
		}
		
		System.out.print(a);
		//tail
		rtf_writer.append("\\par\n}");
		//end of tail
		/*char currentChar;
		FileReader inputStream = new FilterReader();
		while (currentChar != (char)-1)
		{
		currentChar = (char)inputStream.read();
		}*/
		
		rtf_writer.close();
		System.out.print("\nRTF GENERATED");
	}

}
