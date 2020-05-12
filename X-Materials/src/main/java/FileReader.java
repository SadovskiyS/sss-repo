import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

import java.io.*;

class FileReaderClass {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Integer LineQuan() throws IOException {
        FileReader fr = new FileReader("e:/1.txt");
        int quantity = 0;
        LineNumberReader lineNumberReader = new LineNumberReader(fr);
        while (lineNumberReader.readLine() != null){
            quantity++;
        }
        lineNumberReader.close();
        return quantity;
    }

    public String read() {
        StringBuilder sb = new StringBuilder();
        try {
            StringBuffer buffer = new StringBuffer();
            FileReader fr = new FileReader("e:/1.txt");
            BufferedReader br = new BufferedReader(fr);
            LineIterator iterator = IOUtils.lineIterator(br);
            for(int lineNumber = 0; iterator.hasNext(); lineNumber++){
                buffer.append(iterator.next());
                if(lineNumber == getA()){
                    if(br.readLine() == null){
                        sb.append("Конец файла, блэт!");
                        break;
                    }
                    sb.append(buffer);
                    sb.append("\n");
                }
                buffer.setLength(0);
             }
        } catch (IOException  e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}
