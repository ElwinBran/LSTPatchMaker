/*
 * Copyright (c) 2020 Elwin Slokker
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.gitlab.elwinbran.tools.lstpatchmaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;


/**
 *
 * @author Elwin Slokker
 */
public class Program
{
    public static void main(String[] args)
    {
        final String helpOption = "-h";
        final String helpArgument = "help";
        
        
        String targetFile;
        String destinationFile;
        if (args.length > 0)
        {
            if (args[0].equals(helpOption) || args[0].equalsIgnoreCase(helpArgument))
            {
                //help messages
            }
            else
            {
                //commandline route
                targetFile = args[0];
                destinationFile = args[1];
                File target = new File(targetFile);
                File destination = new File(destination);
                BufferedWriter patchWriter = new BufferedWriter(new FileWriter(destination, true));
                //50 41 54 43 48 START
                // 3 byte OFFSET
                // 2 byte LENGHT of CHANGES
                // DATA
                //45 4F 46 END
            }
        }
        else
        {
            //FX route
        }
        //check if a file is given
        //bla bla line readers from files.
        {
            String line = "";
            List<Byte> location = null;
            Integer pureLocation = 0;
            List<Byte> location = null;
            //get line data pure and accept any space like characters to be the breaks.
        }
    }
}
