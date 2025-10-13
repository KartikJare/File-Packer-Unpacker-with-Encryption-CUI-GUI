///////////////////////////////////////////////////////////////////////////////////////////////
//
//  File Name   : MarvellousPackerGUIStrater.java
//  Description : This program serves as a GUI starter for the Marvellous Packer application.
//                It launches the GUI window by creating an instance of the MarvellousPackerGUI class.
//  Author      : Kartik Ganesh Jare
//  Date        : 24/09/2025
//
///////////////////////////////////////////////////////////////////////////////////////////////

import MarvellousPackerUnpacker.MarvellousPackerX;

import java.io.*;

///////////////////////////////////////////////////////////////////////////////////////////////
//
//   Function Name : main
//   Description   : Entry point of the program. Creates and displays the GUI 
//                   for Marvellous Packer by instantiating MarvellousPackerGUI.
//   Author        : Kartik Ganesh Jare
//   Date          : 24/09/2025
//   Prototype     : public static void main(String A[])
//   Input         : String array (command line arguments)
//   Output        : None (GUI window is launched)
//
///////////////////////////////////////////////////////////////////////////////////////////////

class MarvellousPackerGUIStrater
{
    public static void main(String A[])
    {

        MarvellousPackerGUI mobj = new MarvellousPackerGUI ("Marvellous Packer",420,520);

    } // End of main
}// End of MarvellousPackerGUIStrater class