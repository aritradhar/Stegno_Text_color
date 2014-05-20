import java.io.*;


public class BinRetrv 
{
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws Exception
	{
		FileInputStream bin_in=new FileInputStream("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\carr.rtf");
		File bin_ret=new File("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\bin_ret.txt");
		bin_ret.createNewFile();
		FileWriter bw=new FileWriter(bin_ret);
		BufferedReader b_carr=new BufferedReader(new InputStreamReader(new DataInputStream(bin_in)));
		FileReader bin_rin=new FileReader("C:\\work\\IIITD\\Monsoon 2012\\Foundation of Computer Security (CSE 545)\\Assignments\\3\\Stegno_col\\carr.rtf");
		char trv = 0,d,e,f,g;
		int one=0,zero=0;
		String patt,s = null;
		int flag = 0;
		/*while((patt=b_carr.readLine())!=null)
		{
			s=s+patt;
		}*/
		//System.out.println(s.length());
		while(trv!=(char)-1)
		{
			trv=(char)bin_rin.read();
			if(trv=='\\')
			{ //c++;
				if((d=(char)bin_rin.read())=='c')
				{
					if((e=(char)bin_rin.read())=='f')
					{
						if((f=(char)bin_rin.read())=='1')
						{
							one++;
							flag=2;
							//System.out.print(flag);
							//bw.append('1');
						}
						else
						{
							flag=1;
							zero++;
							//System.out.print(flag);
						}
					}
				}
			}
			//if(zero==0)
				//System.out.println(trv);
			if(flag==2)
			{
				bw.append('1');
				//System.out.print("A");
			}
			if(flag==1)
			{
				bw.append('0');
				//System.out.print("B");
			}
			//trv=(char) bin_rin.read();
			//bw.append("A");
		}
		bin_in.close();
		//System.out.println(one);
		System.out.print("----");
		
	}

}
