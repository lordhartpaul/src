//Written by: S.S. Ahmed
//email ss_ahmed1@hotmail.com
//April 2001
//====================================================================

//objects are passed by reference
class passbyref
{
        int a , b;
        passbyref(int i, int j)
        {
                a = i;
                b = j;
        }
        //pass an object
        void meth(passbyref o)
        {
                o.a *= 2;
                o.b /= 2;
        }
        //the main method is given below:
        public static void main(String args[])
        {
                passbyref ob= new passbyref(15,20);

                System.out.println(ob.a + " " + ob.b);

                ob.meth(ob);

                System.out.println(ob.a + " " + ob.b);
        }
}
