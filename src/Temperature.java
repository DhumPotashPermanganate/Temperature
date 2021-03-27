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

    }

}
