////////////////////////////////////////////////////////////////////////////////////////////
//
// File Name   : MarvellousPackerCUIStrater.java
// Description : This program serves as a CUI starter for the Marvellous Packer application. It accepts user input for the directory to be packed and the output packed file name. 
//               Then, it invokes the MarvellousPacker class to perform the packing activity.
// Author      : Kartik Ganesh Jare
// Date        : 24/09/2025
//
/////////////////////////////////////////////////////////////////////////////////////////////

import MarvellousPackerUnpacker.MarvellousPacker;
import java.util.*;
import java.io.*;

//////////////////////////////////////////////////////////////////////////////////////
//    
//  Function Name : main
//  Description   : Entry point of the application. Accepts directory name and 
//                  packed file name from the user and starts packing process.
//  Author        : Kartik Ganesh Jare
//  Date          : 24/09/2025
//  Prototype     : public static void main(String A[])
//  Input         : String array (command line arguments)
//  Output        : None (void)
//////////////////////////////////////////////////////////////////////////////////////

class MarvellousPackerCUIStrater
{

    public static void main(String A[])
    {
        try
        {
            Scanner sobj = new Scanner(System.in);

            System.out.println("Enter the name of Directory that you want to pack : ");
            String DirName = sobj.nextLine();

            System.out.println("Enter the name of file that you want to create for packing : ");
            String PackName = sobj.nextLine();
         
            MarvellousPacker mobj = new MarvellousPacker(PackName, DirName);

            mobj.PackingActiviy();
        }
        catch(Exception eobj)
        {}
    } // End of main
} // End of class MarvellousPackerCUIStrater
