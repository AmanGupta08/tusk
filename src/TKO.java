class TKO {
 public static void main(String[] args) {
 String s = "-";
 Integer x = 343;
 long L343 = 343L;
 System.out.println(x);
 System.out.println(L343);
 if(x.equals(L343)) s += ".e1 ";
 if(x.equals(343)) s += ".e2 "; 
 

 Short s1 = (short) ((new Short((short)343)) / (new Short((short)49)));
 System.out.println(s1);
 if(s1 == 7) s += "=s "; 
 System.out.println();
 if(s1 < new Integer(7+1)) s += "fly ";
 System.out.println(s);
 }
}