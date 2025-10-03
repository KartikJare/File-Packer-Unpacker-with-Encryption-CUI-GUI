/////////////////////////////////////////////////////////////////////////////
//
//  File Name   : MarvellousUnpackerCUI.java
//  Description : This program performs the unpacking of packed files.
//                It reads the packed file, extracts file headers and data, and creates the original files.
//  Author      : Kartik Ganesh Jare
//  Date        : 23/09/2025
//
///////////////////////////////////////////////////////////////////////////

package MarvellousPackerUnpacker;

import java.util.*;
import java.io.*;

/////////////////////////////////////////////////////////////////////////
//
// Class Name : MarvellousUnpackerCUI
//  Description: Provides functionality to unpack packed files 
//               by reading file headers and data sequentially.
//  Author     : Kartik Ganesh Jare
//  Date       : 23/09/2025
//
/////////////////////////////////////////////////////////////////////////

public class MarvellousUnpackerCUI
{
    private String PackName;

    ///////////////////////////////////////////////////////////////////////////
    //
    //  Function Name : MarvellousUnpackerCUI (Constructor)
    //  Description   : Initializes the unpacker with the packed file name.
    //  Author        : Kartik Ganesh Jare
    //  Date          : 23/09/2025
    //  Prototype     : public MarvellousUnpackerCUI(String A)
    //  Input         : String A (Packed file name)
    //  Output        : None
    //
    ///////////////////////////////////////////////////////////////////////////

    public MarvellousUnpackerCUI(String A)
    {
        this.PackName = A;
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    //  Function Name : UnpackingActiviy
    //  Description   : Reads the packed file, extracts header and 
    //                  file data, and creates original unpacked files.
    //  Author        : Kartik Ganesh Jare
    //  Date          : 23/09/2025
    //  Prototype     : public void UnpackingActiviy()
    //  Input         : None
    //  Output        : Creates unpacked files on disk
    //
    ///////////////////////////////////////////////////////////////////////////
    
    public void UnpackingActiviy()
    {
        try
        {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-------------------Marvellous Packer Unpacker--------------------------");
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-----------------------UnPacking Activity------------------------------");
            System.out.println("-----------------------------------------------------------------------");

            String Header = null;
            File fobjnew = null;
            int FileSize = 0,iRet = 0,iCountFile = 0;

            File fobj = new File(PackName);

            // If packed file is not present
            if(! fobj.exists())
            {
                System.out.println("Unable to access Packed file");
                return;
            }

            System.out.println("Packed file succesfully opened");

            FileInputStream fiobj = new FileInputStream(fobj);

            // Buffer to read the header
            byte HeaderBuffer[] = new byte[100]; 

            // Scan the packed file extract the file from it
            while((iRet =fiobj.read(HeaderBuffer,0,100)) != -1)
            {
                // Covnert byte array to string
                Header = new String(HeaderBuffer);

                Header = Header.trim();

                // Tokenize the header into 2 parts
                String Tokens[] = Header.split(" ");
                
                fobjnew = new File(Tokens[0]);

                // Create new file to extract
                fobjnew.createNewFile();
                
                FileSize = Integer.parseInt(Tokens[1]);

                // Create new buffer to store file data
                byte Buffer[] = new byte[FileSize];

                FileOutputStream foobj = new FileOutputStream(fobjnew);

                // Read the data from packed file
                fiobj.read(Buffer,0,FileSize);

                // write the data into etracted file
                foobj.write(Buffer,0,FileSize);

                System.out.println("File unpack with name : "+Tokens[0]+" having size  " +FileSize);

                iCountFile++;

                foobj.close();
            }//End of while

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("-----------------------Statistical Report------------------------------");
            System.out.println("-----------------------------------------------------------------------");

            System.out.println("Total number of file unpacked : "+iCountFile);
            
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("------------------Thank you for using our application------------------");
            System.out.println("-----------------------------------------------------------------------");

            fiobj.close();    
        }
        catch(Exception eobj)
        {}
    }// Try End
} // End UnpackingActivity 