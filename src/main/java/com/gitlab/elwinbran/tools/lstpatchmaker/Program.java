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


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Full LST conversion program code. 
 * Invoked via commandline or produces a JavaFX window to select files.
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
                
            }
        }
        else
        {
            //FX route
        }
    }
    
    private static void conversion(File target, File destination, TextDisplay processOutput)
    {
        
        //make map step

        //apply map to IPS file step
        try {
            FileOutputStream patchWriter = new FileOutputStream(destination);
            patchWriter.write(new byte[]{0x50,0x41,0x54,0x43,0x48});
            //50 41 54 43 48 START 'PATCH'
            // 3 byte OFFSET
            // 2 byte LENGHT of CHANGES
            // DATA
            //45 4F 46 END
        } catch (FileNotFoundException ex) {
            processOutput.show("Conversion failed! The IPS file could not be found anymore: " + ex.getMessage());
        } catch (IOException ex) {
            processOutput.show("Conversion failed! Something happened during writing the patch: " + ex.getMessage());
            destination.delete();
        }
    }
    private static void add(Map<Integer, List<Byte>> objects, String location, String object)
    {
        Integer numberLocation = Integer.parseInt(location, 16);
        List data = new ArrayList<>();
        char[] hexDigits = object.toCharArray();
        for(int i = 0; i < hexDigits.length; i += 2)
        {
            String singleString = Character.toString(hexDigits[i]) + Character.toString(hexDigits[i + 1]);
            byte single = ((Integer)Integer.parseInt(singleString, 16)).byteValue();
            data.add(single);
        }
        if(data.size() > Short.MAX_VALUE)
        {
            throw new RuntimeException("The change at 0x" + location + "is too large and not supported by the IPS format.");
        }
        objects.put(numberLocation, data);
    }
    
    private static List<Record> records(Map<Integer, List<Byte>> objects)
    {
        List<Record> result = new LinkedList<>();
        for(Integer offset : objects.keySet())
        {
            List<Byte> data = objects.get(offset);
            if(result.isEmpty())
            {
                result.add(new Record(offset, data));
            }
            else
            {
                
            }
        }
        return result;
    }
    
    private static class Record
    {
        private final int offset;
        
        private final List<Byte> data;
        
        public Record(int offset, List<Byte> data)
        {
            this.offset = offset;
            this.data = data;
        }
        
        public int offset()
        {
            return this.offset;
        }
        
        public int end()
        {
            return this.data.size() + this.offset;
        }
        
        public List<Byte> data()
        {
            return this.data;
        }
                
    }
    
}
