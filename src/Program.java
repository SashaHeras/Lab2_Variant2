import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

class Commodity {
    public String name;
    public String producer;
    public LocalDate data;
    public float price;

    public Commodity(String name,String producer,LocalDate data,float price)
    {
        this.name=name;
        this.producer=producer;
        this.data=data;
        this.price=price;
    }

    public void ShowProduct()
    {
        System.out.println(" Name: "+name+"\n Producer: "+producer+"\n Data: "+data+"\n Price: "+price+"\n");
    }
}

class EatCommodity extends Commodity{
    public LocalDate shelfLife;
    public String eatGroup;

    public EatCommodity(String name,String producer,LocalDate data,float price,LocalDate dataOfLife,String eatGroup)
    {
        super(name,producer,data,price);
        this.shelfLife=dataOfLife;
        this.eatGroup=eatGroup;
    }

    @Override
    public void ShowProduct()
    {
        super.ShowProduct();
        System.out.println(" Shelf life: "+shelfLife+"\n Eat group: "+eatGroup+"\n");
    }
}

class RadioTech extends Commodity{
    public String typeElectroTech;
    public LocalDate garantDate;

    public RadioTech(String name,String producer,LocalDate data,float price,String typeElectroTech,LocalDate garantDate)
    {
        super(name,producer,data,price);
        this.typeElectroTech=typeElectroTech;
        this.garantDate=garantDate;
    }

    @Override
    public void ShowProduct() {
        super.ShowProduct();
        System.out.println(" Type of electronic: "+typeElectroTech+"\n Garant date: "+garantDate+"\n");

    }
}

class User
{
    public String login;
    private String pass;
    public String e_mail;
    public String phone_number;

    public User(String login,String pass,String e_mail,String phone_number)
    {
        if(login.length()==0||login.length()<4)
        {
            this.login="root";
        }
        else
        {
            this.login=login;
        }
        if(pass.length()<8)
        {
            this.pass="123456789";
        }
        else
        {
            this.pass=pass;
        }
        if(e_mail.length()==0||e_mail.indexOf('@')==-1)
        {
            this.e_mail="acseler@gmail.com";
        }
        else
        {
            this.e_mail=e_mail;
        }
        if(phone_number.length()<10||phone_number.length()>=11)
        {
            this.phone_number="0970001122";
        }
        else
        {
            this.phone_number=phone_number;
        }
    }

    public void ShowUser()
    {
        System.out.println(" Login: "+login+"\n Pass: "+pass+"\n E-mail: "+e_mail+"\n Phone number: "+phone_number+"\n");
    }
}

class Buyer extends User{
    public int valet;
    public String adress;

    public Buyer(String login,String pass,String e_mail,String phone_number,int valet,String adress)
    {
        super(login,pass,e_mail,phone_number);
        this.valet=valet;
        this.adress=adress;
    }

    @Override
    public void ShowUser() {
        super.ShowUser();
        System.out.println(" Valet: "+valet+"\n Adress: "+adress+"\n");
    }
}

class ShopAssistant extends User{
     public int group_number;
     public LocalDate start_work;
     public int sum_bonus;

     public ShopAssistant(String login,String pass,String e_mail,String phone_number,int group_number,LocalDate start_work,int sum_bonus)
     {
         super(login,pass,e_mail,phone_number);
         this.group_number=group_number;
         this.start_work=start_work;
         this.sum_bonus=sum_bonus;
     }

    @Override
    public void ShowUser() {
        super.ShowUser();
        System.out.println(" Number of group: " + group_number + "\n Day of start work: " + start_work + "\n Summa of bonus: " + sum_bonus+"\n");
    }
}

enum Positions{
    PROGRAMMER(2500,30),DISAINER(2400,30),ADMINISTRATOR(5000,42);
    public int salery;
    public int countOfHolidays;
    Positions(int salery,int count)
    {
        this.salery=salery;
        this.countOfHolidays=count;
    }
    public void SetSalery(int s)
    {
        this.salery=s;
    }
    public void SetCount(int c)
    {
        this.countOfHolidays=c;
    }
    public int GetSalery()
    {
        return salery;
    }
    public int GetCount() {
        return countOfHolidays;
    }
}

class Line
{
    public String line;

    public Line(String l)
    {
        this.line=l;
    }

    public void GetLine()
    {
        System.out.println(" Line: "+line);
    }
}

class CompareLineLength implements Comparator<Line>
{
    @Override
    public int compare(Line a,Line b) {
        return a.line.length() - b.line.length();
    }
}

class CompareLineSym implements Comparator<Line>
{
    @Override
    public int compare(Line a,Line b)
    {
        char mass1[]=a.line.toCharArray();
        char mass2[]=b.line.toCharArray();
        return mass1[2]-mass2[2];
    }
}

class CompareLineLoudSymn implements Comparator<Line>
{
    @Override
    public int compare(Line a,Line b)
    {
        int count1 = 0,count2 = 0;
        char mass1[]=a.line.toLowerCase().toCharArray();
        char mass2[]=b.line.toLowerCase().toCharArray();
        for (char i: mass1) {
            if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u'||i=='y')
            {
                count1++;
            }
        }
        for (char i: mass2) {
            if(i=='a'||i=='e'||i=='i'||i=='o'||i=='u'||i=='y')
            {
                count2++;
            }
        }
        return count1-count2;
    }
}



public class Program {
    public interface NumberMaker{
        public int GetDouble(int n);
    }

    public NumberMaker GetDouble(int n)
    {
        NumberMaker f1=new NumberMaker() {
            @Override
            public int GetDouble(int n) {
                return n*2;
            }
        };
        return f1;
    }

    public int[] MakeNewArray(int[] arr,NumberMaker nM)
    {
        int[] tarr=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            tarr[i]= nM.GetDouble(arr[i]);
        }
        return tarr;
    }

    public int[] RandArray(int[] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=(int)(Math.random()*50);
        }

        return arr;
    }

    public static void main (String args[]){
        // Завдання 33
        Positions[] wokers=Positions.values();
        for (Positions s: wokers) {
            System.out.println(s+"\t Salery: "+s.GetSalery()+"\t Count if holidays: "+s.GetCount());
        }

        // Завдання 35
        Program p =new Program();
        int[] arr=new int[10];
        arr=p.RandArray(arr);
        NumberMaker m = p.GetDouble(0);
        arr=p.MakeNewArray(arr,m);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(" "+arr[i]);
        }
        System.out.println();

        // Завдання 45
        EatCommodity eat=new EatCommodity("Zvenigora","Our Line",LocalDate.of(2021,2,15),26,LocalDate.of(2021,2,27),"Milk");
        eat.ShowProduct();

        RadioTech rad=new RadioTech("Radio","Apple",LocalDate.of(2021,1,1),1200,"Electronic",LocalDate.of(2024,1,1));
        rad.ShowProduct();

        // Завдання 46
        User u=new User("acseler","Cthusq2010","acseler16@gmail.com","0688847856");
        u.ShowUser();

        ShopAssistant assis1=new ShopAssistant("acseler","Cthusq2010","acseler16@gmail.com","0688847856",2,LocalDate.of(2021,1,7),2500);
        assis1.ShowUser();

        // Завдання 54
        Set<Line>set1=new TreeSet<Line>(new CompareLineLength());
        set1.add(new Line("man"));
        set1.add(new Line("many"));
        set1.add(new Line("manyon"));
        set1.add(new Line("ma"));
        for (Line l: set1) {
            l.GetLine();
        }
        System.out.println();

        Set<Line>set2=new TreeSet<Line>(new CompareLineSym());
        set2.add(new Line("maa"));
        set2.add(new Line("mnb"));
        set2.add(new Line("mafyon"));
        set2.add(new Line("mac"));
        for (Line l: set2) {
            l.GetLine();
        }
        System.out.println();

        Set<Line>set3=new TreeSet<Line>(new CompareLineLoudSymn());
        set3.add(new Line("maa"));
        set3.add(new Line("mnb"));
        set3.add(new Line("mafyon"));
        set3.add(new Line("mac"));
        for (Line l: set3) {
            l.GetLine();
        }
        System.out.println();


    }
}
