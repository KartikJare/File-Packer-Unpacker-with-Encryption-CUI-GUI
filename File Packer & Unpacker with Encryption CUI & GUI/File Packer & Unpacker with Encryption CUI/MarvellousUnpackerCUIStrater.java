/////////////////////////////////////////////////////////////////
// 
// File Name   : MarvellousUnpackerCUIStrater.java
// Description : This program accepts the name of a packed file from the 
//               user and calls the unpacker class to perform the unpacking activity.
// Author      : Kartik Ganesh Jare
// Date        : 23/09/2025
//
/////////////////////////////////////////////////////////////////

import MarvellousPackerUnpacker.MarvellousUnpacker;

import java.util.*;
import java.io.*;

///////////////////////////////////////////////////////////////
//
//  Function Name : main
//  Description   : Entry point function that accepts file name 
//                  from user and invokes unpacking activity.
//  Author        : Kartik Ganesh Jare
//  Date          : 23/09/2025
//  Prototype     : public static void main(String A[])
//  Input         : String[] (Command line arguments)
//  Output        : None (Triggers unpacking activity)
//
////////////////////////////////////////////////////////////// 
class MarvellousUnpackerCUIStrater
{
    public static void main(String A[])
    {
        try
        {  
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of file which contains packed data : ");
            String PackName = sobj.nextLine();

            MarvellousUnpacker mobj = new MarvellousUnpacker(PackName);

            mobj.UnpackingActiviy();
        }
        catch(Exception eobj)
        {}
    } // End of main
}// End of MarvellousUnpackerCUIStrater