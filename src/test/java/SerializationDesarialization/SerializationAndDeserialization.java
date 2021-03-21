package SerializationDesarialization;

import java.io.*;

class Test implements Serializable {  //bu implementi yapmazsan serialization yapamazsın

    int i=10, j=20;
}



public class SerializationAndDeserialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Test t1 = new Test();

        //Serialization
        FileOutputStream fos = new FileOutputStream("text.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(t1);

        //Deserialization
        FileInputStream fis =  new FileInputStream("text.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Test t2 = (Test) ois.readObject();  //burada ise text.txt'i okudun ve bu sefer bunu geldin object'e çevirdin. Serialization'da t1 object'ini text'e çevirmiştin.
        //ikisinin de test type'inde olduğuna dikkat edelim ama
        System.out.println(t2.i + "  " + t2.j);
        //yani bir object'i dosyaya atıp ordan geri alabiliyoruz. memory'de yer kaplama açısından karlı oluyoruz.



    }
}
