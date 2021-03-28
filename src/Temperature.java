import java.security.KeyStore;

public class Temperature
{
    private char c;
    private double temp;



    public Temperature(double temp, char c)
    {

        this.temp= temp;
        this.c= c;
    }

    public Temperature(int temp, char c)
    {

        this.temp= temp;
        this.c= c;
    }

    public Temperature()
    {
        this.temp=0;
        this.c= 'C';
    }

    Temperature toCelcius()
    {
        Temperature cel= new Temperature();
        cel.c= 'C';
        if (this.c=='F')
            cel.temp =  5 * (this.temp - 32)/9 ;
        if (this.c=='K')
            cel.temp = (this.temp- 273.15);
        return cel;
    }

    Temperature toKelvin()
    {
        Temperature kel= new Temperature();
        kel.c= 'K';
        if(this.c=='C')
            kel.temp= ((double) this.temp+273.15);
        if(this.c=='F')
            kel.temp= 5*(this.temp+459.67 )/9;
        return kel;
    }

    Temperature toFarenheit()
    {
        Temperature far= new Temperature();
        far.c='F';
        if(this.c=='C')
            far.temp= (double)(this.temp * 1.8) +32;

        if(this.c=='K')
            far.temp= ( this.temp* 1.8) - 459.67;


        return far;
    }

    Temperature add(Temperature obj)
    {
        char ch= this.c;
        Temperature obj1= new Temperature();


        switch(ch)
        {
            case 'C':   obj1= obj.toCelcius();
                        break;
            case 'F':   obj1= obj.toFarenheit();
                        break;
            case 'K':   obj1= obj.toKelvin();
                        break;
        }

        obj1.temp= obj1.temp+this.temp;

        return obj1;


    }

    double check(Temperature o1, Temperature o2)
    {
        Temperature obj1= new Temperature();
        switch(o1.c)
        {
            case 'C':   obj1= o2.toCelcius();
                break;
            case 'F':   obj1= o2.toFarenheit();
                break;
            case 'K':   obj1= o2.toKelvin();
                break;
        }

        return obj1.temp;
    }

    boolean equals(Temperature obj)
    {
        double val= check(this, obj);

        if (this.temp== val)
            return true;
        else
            return false;
    }

    boolean greaterThan(Temperature obj)
    {
        double val= check (this, obj);

        if (this.temp > val)
            return true;
        else
            return false;
    }

    public String toString()
    {
        return this.temp+" "+this.c;
    }

    public static void main(String[] args)
    {
        Temperature temp1 = new Temperature(100.0, 'C');
        Temperature temp2 = new Temperature(122, 'F');
        Temperature temp3 = new Temperature(32.0, 'F');
        Temperature temp4 = new Temperature(100.0, 'C');
        Temperature temp5 = new Temperature(212, 'F');

        System.out.println("temp1 is " + temp1);
        System.out.println("temp5 is " + temp5);
        Temperature sum = new Temperature();
        sum = temp5.add(temp1);
        System.out.println("The sum of temp1 and temp5 is " + sum);

        System.out.println("\nTemp2 is " + temp2 + " which is 50C.");
        System.out.println("temp2 to Celcius is " + temp2.toCelcius()+ ".");

        System.out.println("\nTemp1 is " + temp1 + " and the Kalvin value is 373.15 " );
        temp1 = temp1.toKelvin();
        System.out.println("Temp1 to Kalvin is " + temp1);
        System.out.println("\nThe temperature 122F and 50C are the same.");
        Temperature tempAve = new Temperature(50.0, 'C');
        System.out.println("temp2 is " + temp2);
        System.out.println("tempAve is " + tempAve);
        System.out.println("Are temp2 and tempAve the same?");
        if (temp2.equals(tempAve))
        {
            System.out.println("Yes, these two temperatures are equal.");
        }
        else
        {
            System.out.println("No, these two temperatures are not equal.");
        }


        System.out.println("The first temperature is temp4 and is " + temp4);
        System.out.println("The second temperature is temp2 and is " + temp2);
        System.out.println("Is temp4 greater than temp2?");
        if (temp4.greaterThan(temp2))
        {
            System.out.println("Yes, temp4 is greater then temp2.");
        }
        else
        {
            System.out.println("No, temp4 is not greater then temp2.");
        }

    }

}
