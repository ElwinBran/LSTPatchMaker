# LST Patch Maker
A commandline utility for turning LST source code files into IPS patches. It adheres to the specification given here (https://zerosoft.zophar.net/ips.php) and less so for the LST files from here (http://www.keil.com/support/man/docs/a51/a51_ap_listingfile.htm).
The tool will only extract the data and the address/offset/location of that data to form the patch. No commands can be used. LOC and OBJ MUST be separated by one or more space character(s) (0x20).
If the LST file cannot be converted due to the constraints of an IPS message, an error message will be returned. 

Additionally, if your system has JavaFX installed you can convert using FX dialogues when not providing any argument to the program.
