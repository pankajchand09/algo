import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class generateData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
BufferedWriter writer=new BufferedWriter(new FileWriter("data.txt"));
		Random random=new Random(System.currentTimeMillis());
int n=10000;
	while(n-->0){System.out.println(n);
	
		writer.write(String.valueOf(random.nextInt(10000)));
		writer.write("\n");
	}
	writer.flush();
	writer.close();
	}

}
