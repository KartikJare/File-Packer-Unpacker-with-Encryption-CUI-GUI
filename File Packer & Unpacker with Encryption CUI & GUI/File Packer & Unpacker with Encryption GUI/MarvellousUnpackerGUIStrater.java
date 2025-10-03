///////////////////////////////////////////////////////////////////////////////////////////////
//
//  File Name   : MarvellousUnpackerGUIStrater.java
//  Description : This program serves as a GUI starter for the Marvellous Unpacker application.
//                It launches the GUI window by creating an instance of the MarvellousUnpackerGUI class.
//  Author      : Kartik Ganesh Jare
//  Date        : 24/09/2025
//
///////////////////////////////////////////////////////////////////////////////////////////////

import MarvellousPackerUnpacker.MarvellousUnpackerX;

import java.io.*;

///////////////////////////////////////////////////////////////////////////////////////////////
//
//   Function Name : main
//   Description   : Entry point of the program. Creates and displays the GUI
//                   for Marvellous Unpacker by instantiating MarvellousUnpackerGUI.
//   Author        : Kartik Ganesh Jare
//   Date          : 24/09/2025
//   Prototype     : public static void main(String A[])
//   Input         : String array (command line arguments)
//   Output        : None (GUI window is launched)
//
///////////////////////////////////////////////////////////////////////////////////////////////

class MarvellousUnpackerGUIStrater
{
    public static void main(String A[])
    {

        MarvellousUnpackerGUI mobj = new MarvellousUnpackerGUI("Marvellous Unpacker",420,520);

    } // End of main
}// End of MarvellousUnpackerGUIStrater class