package SerializeTransient;


import java.io.*;
public class SerializeDog { 
	 public static void main(String[] args) {
		 Collar c = new Collar(3);
		 Dog d = new Dog(c, 5);
		 System.out.println("before: dog size is "  + d.getDogSize());
		 System.out.println("before: collar size is "  +d.getCollar().getCollarSize());
		 try {
			 FileOutputStream fs = new FileOutputStream("testSer.ser");
			 ObjectOutputStream os = new ObjectOutputStream(fs);
			 os.writeObject(d);
			 os.close();
		 } catch (Exception e) { e.printStackTrace(); }
		 try { 
			 FileInputStream fis = new FileInputStream("testSer.ser");
			 ObjectInputStream ois = new ObjectInputStream(fis);
			 d = (Dog) ois.readObject();
			 ois.close();
		 } catch (Exception e) { e.printStackTrace(); }
		 System.out.println("after: dog size is "  + d.getDogSize());
		 System.out.println("after: collar size is "  +d.getCollar().getCollarSize());
  }
}
class Dog implements Serializable { 
	 transient private Collar theCollar; // we can't serialize this
	 private int dogSize;
	 public Dog(Collar collar, int size) {
	 theCollar = collar;
	 dogSize = size;
	 }
	 public int getDogSize() {
		// TODO Auto-generated method stub
		return dogSize;
	}
	public Collar getCollar() { return theCollar; }
	 private void writeObject(ObjectOutputStream os) {
		 // throws IOException { // 1
		 try {
			
		 os.defaultWriteObject(); // 2
		 os.writeInt(theCollar.getCollarSize()); // 3 
		 } catch (Exception e) { e.printStackTrace(); }
		 }
		 private void readObject(ObjectInputStream is) {
		 // throws IOException, ClassNotFoundException { // 4 
		 try {
		 is.defaultReadObject(); // 5 
		 theCollar = new Collar(is.readInt()); // 6
		 } catch (Exception e) { e.printStackTrace(); }
		 }
		}
class Collar  {
 private int collarSize;
 public Collar(int size) { collarSize = size; }
 public int getCollarSize() { return collarSize; }
}
