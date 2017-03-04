# Fileio by Issaree Srisomboon
## Description
Coparing the elapesed time in copying the InputStream to the OutputStream in different tasks in FileUtil methods by using TaskTimer and Stopwatch from the stopwatch lab to run these tasks and print the elapsed time.
## Results and Explanation
### Results
I ran the task by HP Pavilion 14, and got this result:
|Task|Elapesed Time (sec)|
|:--:|:-----------------:|
|Copy one byte at a time     |9.481917|
|Copy using a 1KB byte array |0.014477|
|Copy using a 4KB byte array |0.005027|
|Copy using a 64KB byte array |0.001452|
|Copy one line at a time     |0.080724|
### Explanation
`InputStream` is the raw method of getting information from a resource. It grabs the data byte by byte without performing any kind of translation.
- Its methods that used in FileUtil Class
    - `read()` returns an int **which contains the byte value of the byte read.**
    - `read(byte[])` returns an int **telling how many bytes were actually read.** 
        - This method will attempt to read as many bytes into the byte array given as parameter as the array has space for (`blocksize`). *It means the bigger of the blocksize you have, the faster you can get the copy.*

So reading an array of bytes at a time is much more faster than reading one byte at a time. And it can be even more faster depending on the `blocksize`'s size.

And Rather than read one character at a time, the `BufferedReader` reads a larger block at a time. One way to do that is using `readLine()` method to read a line of text at a time.

From this reason, it is typically faster than copying one byte a time but it is still slower than using a byte array as you can see in the table above. 