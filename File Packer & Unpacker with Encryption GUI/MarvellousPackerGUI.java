////////////////////////////////////////////////////////////////////
//
// File Name   :   MarvellousPackerX.java
// Description :   GUI-based folder packer using Java Swing (no console).
//                 Takes folder name and output file name as input,
//                 then packs all files inside the folder into one
//                 packed file with headers.
// Author      :   Kartik Ganesh Jare
// Date        :   23/07/2025
//
////////////////////////////////////////////////////////////////////

package MarvellousPackerUnpacker;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;

////////////////////////////////////////////////////////////////////
//
//  Class Name  : MarvellousPackerGUI
//  Description : Implements a Swing-based GUI for packing a directory into 
//                a single packed file. Provides fields for user input and a button to trigger the packing process.
//  Author      : Kartik Ganesh Jare
//  Date        : 23/07/2025
//
////////////////////////////////////////////////////////////////////

public class MarvellousPackerGUI implements ActionListener
{
    private String PackName;
    private String DirName;
    public JFrame frame;
    public JLabel folderlable;
    public JLabel filelable;
    public JButton button;
    public JTextField foltextfield;
    public JTextField filtextfield;

    ////////////////////////////////////////////////////////////////////
    //
    //    Function Name : MarvellousPackerGUI (Constructor)
    //    Description   : Initializes the GUI window with input fields and button 
    //                    for folder name and packed file name.
    //    Author        : Kartik Ganesh Jare
    //    Date          : 23/07/2025
    //    Prototype     : public MarvellousPackerGUI(String Title, int Width, int Height)
    //    Input         : Title (Window title), Width (Window width), Height (Window height)
    //    Output        : None
    //    
    ////////////////////////////////////////////////////////////////////

    public MarvellousPackerGUI(String Title, int Width, int Height)
    {
        frame = new JFrame();

        folderlable = new JLabel("Folder Name:");
        folderlable.setBounds(40, 60, 120, 30);

        foltextfield = new JTextField();
        foltextfield.setBounds(180, 60, 200, 30);

        filelable = new JLabel("File Name:");
        filelable.setBounds(40, 120, 120, 30);

        filtextfield = new JTextField();
        filtextfield.setBounds(180, 120, 200, 30);

        button = new JButton("PACK");
        button.setBounds(150, 200, 120, 40);
        button.addActionListener(this);

        frame.add(folderlable);
        frame.add(filelable);
        frame.add(filtextfield);
        frame.add(foltextfield);
        frame.add(button);

        frame.setLayout(null);
        frame.setTitle(Title);
        frame.setSize(Width, Height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    ////////////////////////////////////////////////////////////////////
    //
    //   Function Name : actionPerformed
    //   Description   : Event handler for the PACK button. Validates user inputs 
    //                   and calls the packing activity if valid.
    //   Author        : Kartik Ganesh Jare
    //   Date          : 23/07/2025
    //   Prototype     : public void actionPerformed(ActionEvent aobj)
    //   Input         : ActionEvent object (Button click event)
    //   Output        : None
    //
    ////////////////////////////////////////////////////////////////////
    
    public void actionPerformed(ActionEvent aobj)
    {
        DirName = foltextfield.getText().trim(); 
        PackName = filtextfield.getText().trim(); 

        if (DirName.equals("") || PackName.equals(""))
        {
            JOptionPane.showMessageDialog(frame, "Both fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PackingActivity();  
    }
    
    ////////////////////////////////////////////////////////////////////
    //
    //    Function Name : PackingActivity
    //    Description   : Performs the packing process. Reads all files in the 
    //                    directory, creates a packed file, writes 100-byte 
    //                    headers for each file, and appends file content.
    //    Author        : Kartik Ganesh Jare
    //    Date          : 23/07/2025
    //    Prototype     : public void PackingActivity()
    //    Input         : None
    //    Output        : None (Displays success/error via GUI)
    //
    ////////////////////////////////////////////////////////////////////
    
    public void PackingActivity()
    {
        try
        {
            File fobj = new File(DirName);

            if ((fobj.exists()) && (fobj.isDirectory()))
            {
                File Packobj = new File(PackName);
                boolean bRet = Packobj.createNewFile();

                if (!bRet)
                {
                    JOptionPane.showMessageDialog(frame, "File already exists. Please choose a different name.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                File[] Arr = fobj.listFiles();
                FileOutputStream foobj = new FileOutputStream(Packobj);
                byte Buffer[] = new byte[1024];
                String Header = null;
                int iRet = 0, iCountfile = 0;

                for (File file : Arr)
                {
                    if (file.isFile())
                    {
                        Header = file.getName() + " " + file.length();
                        while (Header.length() < 100)
                        {
                            Header += " ";
                        }

                        foobj.write(Header.getBytes());

                        FileInputStream fiobj = new FileInputStream(file);
                        while ((iRet = fiobj.read(Buffer)) != -1)
                        {
                            foobj.write(Buffer, 0, iRet);
                        }
                        fiobj.close();
                        iCountfile++;
                    }
                }

                foobj.close();

                JOptionPane.showMessageDialog(frame,
                "Packing complete!\n\nFolder: " + DirName +
                "\nPacked File: " + PackName +
                "\nTotal files packed: " + iCountfile,
                "Success",
                JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(frame, "Directory not found: " + DirName, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (Exception eobj)
        {
            JOptionPane.showMessageDialog(frame, "Exception: " + eobj.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}