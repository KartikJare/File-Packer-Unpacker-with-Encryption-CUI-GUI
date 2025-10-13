//////////////////////////////////////////////////////////////////////////////////////////
//
//  File Name   : MarvellousPackerCUI.java
//  Description : This program implements the packing functionality of the Marvellous Packer-Unpacker application. It creates a packed file by combining 
//                multiple files from a given directory along with their metadata headers.
//  Author      : Kartik Ganesh Jare
//  Date        : 24/09/2025
//
//////////////////////////////////////////////////////////////////////////////////////////

package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

///////////////////////////////////////////////////////////////////////////////////////////
//
//  Class Name  : MarvellousPackerCUI
//  Description : Responsible for performing the packing activity. 
//                It accepts directory and output file names, then packs all files from the directory into a single packed file.
//  Author      : Kartik Ganesh Jare
//  Date        : 24/09/2025
//
///////////////////////////////////////////////////////////////////////////////////////////

public class MarvellousPackerCUI
{   
    private String PackName;
    private String DirName;

    ///////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name : MarvellousPackerCUI (Constructor)
    //  Description   : Initializes PackName and DirName for packing.
    //  Author        : Kartik Ganesh Jare
    //  Date          : 24/09/2025
    //  Prototype     : public MarvellousPackerCUI(String A, String B)
    //  Input         : A -> String (Packed file name), B -> String (Directory name)
    //  Output        : None
    //
    ///////////////////////////////////////////////////////////////////////////////////////////

    public MarvellousPackerCUI(String A,String B)
    {
        this.PackName = A;
        this.DirName = B;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    //
    //  Function Name : PackingActiviy
    //  Description   : Performs the packing process by traversing the given directory,reading each file, creating a 100-byte header with metadata, 
    //                  and writing contents into a single packed file.
    //  Author        : Kartik Ganesh Jare
    //  Date          : 24/09/2025
    //  Prototype     : public void PackingActiviy()
    //  Input         : None
    //  Output        : None (Performs file I/O operations)
    //
    ///////////////////////////////////////////////////////////////////////////////////////////

    public void PackingActiviy()
    {
        try
        {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-------------------Marvellous Packer Unpacker--------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("----------------------Packing Activity---------------------------------");
            System.out.println("-----------------------------------------------------------------------");

            int i = 0,j = 0,iRet = 0,iCountfile = 0;

            File fobj = new File(DirName);

            // Check the existance of Directory
            if((fobj.exists()) && (fobj.isDirectory()))
            {
                System.out.println(DirName+ " is Succesfully opened"); 

                File Packobj = new File(PackName);

                // Create a packed file
                boolean bRet = Packobj.createNewFile();

                if (bRet == false)
                {
                    System.out.println("Unable to create pack file");
                    return;    
                }

                System.out.println("Packed file gets succesfully created with name : "+PackName);
            
                // Retive all file from directory
                File Arr[] = fobj.listFiles();

                // Packed file object
                FileOutputStream foobj = new FileOutputStream(Packobj);

                //Buffer for read and write activity
                byte Buffer[] = new byte[1024];

                String Header = null;

                //Directory traversal
                for(i = 0; i< Arr.length;i++)
                {
                    Header = Arr[i].getName() + " " +Arr[i].length();

                    //Loop to from 100 bytes header 
                    for(j = Header.length();j < 100;j++)
                    {
                        Header = Header + " ";
                    }

                    //write header into Packed file
                    foobj.write(Header.getBytes());

                    // Open file from directory for reading
                    FileInputStream fiobj = new FileInputStream(Arr[i]);

                    // Write contents of file into packed file
                    while((iRet = fiobj.read(Buffer)) != -1)
                    {
                        foobj.write(Buffer,0,iRet);
                        System.out.println("File name Scanned : "+Arr[i].getName());
                        System.out.println("File size read is : "+iRet);
                    }

                    fiobj.close();
                    iCountfile++;
                }

                System.out.println("Packing activity done");

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("-----------------------Statistical Report------------------------------");
                System.out.println("-----------------------------------------------------------------------");

                // to be add
                System.out.println("Total file packed :"+iCountfile);

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("------------------Thank you for using our application------------------");
                System.out.println("-----------------------------------------------------------------------");
            }
            else
            {
                System.out.println("There is no such Directory");
            }
        }// End of try
        catch(Exception eobj)
        {}
    } // End of PackingActivity Function
} //End of MarvellousPacker class