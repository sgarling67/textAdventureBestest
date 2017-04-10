package csu.csci325;

/**
 * Created by Kaitlyn on 12/4/2016.
 */
public class Student {
    public int mSSN, nSSN1, nSSN2, nSSN3;
    public String mName, ssn1, ssn2, ssn3,stringSSN;

    public Student(String name, int SSN){
        mName = name;
        mSSN = SSN;
    }

    public int getSSN(){
        return mSSN;
    }

    public String getFirstName(){
        return mName;
    }

    public void setFirstName(){}


    public int hashCode(){
        stringSSN = Integer.toString(mSSN);
        ssn1 = stringSSN.substring(0,2);
        ssn2 = stringSSN.substring(3,5);
        ssn3 = stringSSN.substring(6,8);

        nSSN1 = Integer.parseInt(ssn1);
        nSSN2 = Integer.parseInt(ssn2);
        nSSN3 = Integer.parseInt(ssn3);

        return (nSSN1 + nSSN2 + nSSN3);
    }
}
